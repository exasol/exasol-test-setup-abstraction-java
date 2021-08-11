# This file use you ssh key stored in ~/.ssh/id_rsa.pub. Please make sure that you generated this file via ssh-keygen -m PEM.
# Keys generated without the -m PEM will lead to login fails.

provider "aws" {
  region = "eu-central-1"
  profile = "c1-admin"
}

module "exasol_setup" {
  source = "../../terraform-aws-test-setup"
  owner = var.owner
  deputy = var.deputy
  datanode_count = 1
  project = "ETSA"
}