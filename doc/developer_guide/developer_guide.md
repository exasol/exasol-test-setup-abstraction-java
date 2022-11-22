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

Then run integration tests with `mvn verify`.

After tests are completed, delete the cloud setup with

```
cd cloudSetup/
terraform destroy
```

## CI Build

### Approving the AWS Deployment

The CI build job that runs the actual integration tests needs to deploy a test environment on Amazon AWS. To prevent wasting AWS resources, deploying this environment needs explicit approval by the repository owner or deputy.

![AWS deployment approval](images/aws_deployment_approval.png)