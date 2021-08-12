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
  license = "./docker-db.lic"
}