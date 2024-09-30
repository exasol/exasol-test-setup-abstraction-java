provider "aws" {
  region  = "eu-central-1"
  profile = var.aws_profile
}

module "exasol_setup" {
  source         = "exasol/exasol-test-setup/aws"
  version        = "2.0.0"
  owner          = var.owner
  deputy         = var.deputy
  datanode_count = 1
  project        = "ETSA"
  exasol_image   = "Exasol-R7.1.26-PAYG"
}
