# This file use you ssh key stored in ~/.ssh/id_rsa.pub. Please make sure that you generated this file via ssh-keygen -m PEM.
# Keys generated without the -m PEM will lead to login fails.

provider "aws" {
  region = "eu-central-1"
  profile = "c1"
}

resource "aws_vpc" "vpc" {
  cidr_block = "10.0.0.0/16"
  tags = {
    "exa:owner" : var.owner,
    "exa:deputy" : var.deputy
    "exa:project" : var.project,
    "exa:project.name" : var.project_name
    "exa:stage" : var.stage
    "Name" : "VPC for ${var.project}"
  }
}

resource "aws_subnet" "subnet" {
  vpc_id = aws_vpc.vpc.id
  cidr_block = "10.0.0.0/24"

  tags = {
    "exa:owner" : var.owner,
    "exa:deputy" : var.deputy
    "exa:project" : var.project
    "exa:project.name" : var.project_name
    "exa:stage" : var.stage
    "Name" : "Subnet for ${var.project}"
  }
}


resource "aws_default_route_table" "my_routing_table" {
  default_route_table_id = aws_vpc.vpc.default_route_table_id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.gw.id
  }
  tags = {
    "exa:owner" : var.owner,
    "exa:deputy" : var.deputy
    "exa:project" : var.project
    "exa:project.name" : var.project_name
    "exa:stage" : var.stage
    "Name" : "Route Table for ${var.project}"
  }
}

resource "aws_security_group" "exasol_db_security_group" {
  name = "allow_tls"
  description = "Allow TLS inbound traffic"
  vpc_id = aws_vpc.vpc.id

  ingress {
    description = "SSH from the internet"
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = [
      "0.0.0.0/0"]
  }

  ingress {
    from_port = 0
    protocol = "-1"
    to_port = 0
    self = true
  }

  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = [
      "0.0.0.0/0"]
  }

  tags = {
    "exa:owner" : var.owner,
    "exa:deputy" : var.deputy
    "exa:project" : var.project
    "exa:project.name" : var.project_name
    "exa:stage" : var.stage
    "Name" : "Security Group for Exasol cluster for ${var.project}"
  }
}

resource "aws_key_pair" "test_pc_key_pair" {
  key_name = "exasol-test-setup-abstraction-test-pc-key"
  public_key = file("~/.ssh/id_rsa.pub")
}

resource "aws_internet_gateway" "gw" {
  vpc_id = aws_vpc.vpc.id

  tags = {
    "exa:owner" : var.owner,
    "exa:deputy" : var.deputy
    "exa:project" : var.project
    "exa:project.name" : var.project_name
    "exa:stage" : var.stage
    "Name" : "Gateway for Exasol cluster for ${var.project}"
  }
}

resource "random_password" "exasol_sys_password" {
  length = 16
  min_upper = 1
  min_lower = 1
  min_numeric = 1
  # with some special chars login does not work
  special = false
}

resource "random_password" "exasol_admin_password" {
  length = 20
  number = true
  special = true
  min_special = 1
  min_numeric = 1
}

module "exasol" {
  source = "../../terraform-aws-exasol"
  cluster_name = "jakobs-exasol"
  database_name = "exadb"
  ami_image_name = "Exasol-R7.0.8-BYOL"
  sys_user_password = random_password.exasol_sys_password.result
  admin_user_password = random_password.exasol_admin_password.result
  management_server_instance_type = "m5.large"
  datanode_instance_type = "m5.large"
  datanode_count = "1"
  standbynode_count = "0"
  public_ip = true

  # These values can be obtained from other modules.
  key_pair_name = aws_key_pair.test_pc_key_pair.key_name
  subnet_id = aws_subnet.subnet.id
  security_group_id = aws_security_group.exasol_db_security_group.id

  # Variables used in tags.
  project = var.project
  project_name = var.project_name
  owner = var.owner
  environment = "dev"
  license = "./exasolution.lic"
}


output "exasol_sys_pw" {
  value = random_password.exasol_sys_password.result
  sensitive = true
}

output "exasol_admin_pw" {
  value = random_password.exasol_admin_password.result
  sensitive = true
}

output "exasol_ip" {
  value = module.exasol.management_server_ip
}

output "exasol_datanode_ip" {
  value = module.exasol.first_datanode_ip
}

resource "local_file" "foo" {
  content = <<EOT
export EXASOL_DATANODE_IP="${module.exasol.first_datanode_ip}"
export EXASOL_MANAGEMENT_IP="${module.exasol.management_server_ip}"
export EXASOL_SSH_PORT=22
export EXASOL_USER="sys"
export EXASOL_PASS="${random_password.exasol_sys_password.result}"
export EXASOL_ADMIN_USER="admin"
export EXASOL_ADMIN_PASS="${random_password.exasol_admin_password.result}"
  EOT
  filename = "${path.module}/../setEnv.sh"
}