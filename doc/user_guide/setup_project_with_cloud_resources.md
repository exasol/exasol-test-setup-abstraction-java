# Setting up a Project With AWS Resources

In this guide I will explain how to configure a project to run tests with resources on AWS.

## CI Isolation

First we need to create a secure environment. That includes two aspects:

* The user created by the CI has minimal permissions (to reduce damage if it's hacked)
* In case the CI fails to clean up its resources, a scheduled task deletes them (to save us from cost explosion)

We will use the [ci-isolation-aws](https://github.com/exasol/ci-isolation-aws) for this purpose. To set it up, copy the [ci-isolation](../../ci-isolation) folder from this repository to your project. Then change the project name in `ci-isolation/src/.../CiIsolationApp.java`.

In this file you can also see that we read the required permissions from a json file from the projects resources. This configuration defines the required permissions for starting an Exasol cluster. If you need a different setup or additional resources, just add another file.

When you're done, deploy the CI user to AWS using the AWS CDK:

```shell
cdk --profile <ADMIN PROFILE IN THE CI ACCOUNT> deploy
```

For details check the [ci-isolation-aws user-guide](https://github.com/exasol/ci-isolation-aws).

Now login to the AWS console, go to the newly created user in the IAM section and generate an access key.

Next, go to the GitHub admin section of the repository of your project, create and environment called `aws`, add protection that requires an approval by someone and add the AWS credentials there as `AWS_ACCESS_KEY_ID` and `AWS_SECRET_ACCESS_KEY`.

I recommend to also store the credentials as a profile in your local `~/.aws/credentilas`.

In addition, create the two secrets `AWS_TAG_OWNER` and `AWS_TAG_DEPUTY` with the e-mail addresses with you and the deputy of this project. They will be used to tag the resources.

## Create Terraform File

Now we define the infrastructure we need for testing our project.

As a starting point, copy the [cloudSetup](../../cloudSetup) folder from this project. It contains a terraform file that defines an Exasol cluster.

You can add additional resources you need for testing here.

Now you can try out to create the setup by

* Change the profile in `cloudSetup/cloudSetup.tf` to the profile of the user we created earlier
* run:
    ```shell
    terraform init
    terraform apply
    #check the setup
    terraform destroy # IMPORTANT otherwise you'll pay for the running resources
  ```

## Set Up CI Build

Now copy the [CI build](../../.github/workflows/ci-build.yml) from this project. The build uses the `aws` environment we created earlier. By that it requires an approval before each run. That is very handy since you probably don't want to create the resources for each commit that just fixed a typo but only before merging a pull request.

The CI build creates the setup using Terraform and writes connection details for the Exasol cluster to `cloudSetup/generated/testConfig.json`. In your test you can use the exasol-test-setup-abstraction-java (ETAJ) to create a connection to the Exasol database. The ETAJ will retrieve the credentials from the config file. When you do local testing you can create the cluster using Terraform as showed above and use it for all your test runs. That will save you a lot of time.
