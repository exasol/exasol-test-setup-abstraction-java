variable "owner" {}

variable "deputy" {
  default = ""
}

variable "project" {
  default = "exasol-test-setup-abstraction ci"
}

variable "additional_tags" {
  default = {}
  description = "Additional resource tags"
  type = map(string)
}