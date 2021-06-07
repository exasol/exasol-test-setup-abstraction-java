# AWS CI Account Setup

This AWS CDK Stack provisions an empty AWS account with a user for automated CI testing.

[Features](doc/features.md)

## Usage

You can use this code to generate a Cloud Formation template that sets up the user for CI.

For that run `cdk synthesize > target/ci-user-template.yml` in this folder. Next login into the AWS Console and change role into the CI account. Now, go to Cloud Formation and deploy the generated `target/ci-user-template.yml`.

## Update Minimal Permissions

In order to keep the impact of a hacking attack low, we want to only grant the required permissions to the CI user.

This stack reads the minimal permissions from [`src/main/resources/minnimal-permissions.json`](src/main/resources/minnimal-permissions.json).

Determining the minimal set of permissions by hand is quite a lot of work. To make our lives easier we use the tool [iamlive](https://github.com/iann0036/iamlive). This tool spies on the local AWS CLI and terraform and reports the used permissions. These permissions are not complete in case Terraform uses CloudFormation under the hood, but it's a lot better than having nothing.

To extract the minimal permissions do the following steps:

* Set your AWS credential environment variables for a user set has lots of permissions on AWS (usually using `. aws_get_session_token`).
* Run iamlive:

  ```shell
  ./iamlive --set-ini --mode proxy --force-wildcard-resource
  ```
* In another terminal run:

  ```shell
  export HTTP_PROXY=http://127.0.0.1:10080
  export HTTPS_PROXY=http://127.0.0.1:10080
  ```
* Run everything your CI runs in the 2nd terminal. Typically:
    * Create infrastructure (e.g. using Terraform)
    * Run tests
    * Destroy infrastructure
* Copy the last output from iamlive in the first terminal to into [`src/main/resources/minnimal-permissions.json`](src/main/resources/minnimal-permissions.json).

### Exasol Cloud Formation Template

The Exasol database is usually created using a Cloud Formation template. The steps from this template are not recorded by iamlive since the Cloud fomration template is evaluated in the cloud and by that, the request don't pass the proxy.

So we have to find out the required permissions by hand. Luckily Exasol offers a [policy for running an Exasol cluster](https://s3.eu-central-1.amazonaws.com/cloudtools.exasol.com/iam_policy.json). We simply downloaded this one and added it as resource. In the future it might be required to update this resource.

## Additional Tasks for Setting up CI Account

* Visit https://aws.amazon.com/marketplace/pp?sku=ctqmztsepbuk7e9f2ks9nlwj1 and accept license (subscribe)
* Configure account alias
    * Open AWS Console
    * Go to `IAM` / `Dashboard`
    * On the top of the page edit the alias 