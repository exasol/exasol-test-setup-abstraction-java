provider "aws" {
  region = "eu-central-1"
  profile = "c1-etsa"
}

module "exasol_setup" {
  source = "../../terraform-aws-exasol-test-setup"
  owner = var.owner
  deputy = var.deputy
  datanode_count = 1
  project = "ETSA"
}