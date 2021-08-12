provider "aws" {
  region = "eu-central-1"
  profile = "c1-etsa"
}

module "exasol_setup" {
  source = "exasol/exasol-test-setup/aws"
  version = "0.1.1"
  owner = var.owner
  deputy = var.deputy
  datanode_count = 1
  project = "ETSA"
}