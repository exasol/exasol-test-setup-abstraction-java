# Developer Guide

## Setting Up AWS Tests

To run tests using the AWS setup, follow these steps:

Create file `cloudSetup/terraform.tfvars` with the following content:

```
owner = "<email>"
deputy = "<email>"
aws_profile = "<profile>"
```

The run the following commands:

```sh
cd cloudSetup/
terraform init
terraform plan
terraform apply
```
