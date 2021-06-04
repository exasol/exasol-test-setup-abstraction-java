# Features of the AWS CI Account Setup

The AWS CI Account Setup provisions an AWS account for running tests from CI securely.

## Create AWS resources from GitHub Actions

`feat~create-aws-cresources-in-ci~1`

The AWS CI Account Setup can create AWS resources from CI builds in out GitHub Actions CI builds.

Rationale:

* We can not use a different CI system since [Release Droid](https://github.com/exasol/release-droid) is built using GitHub actions.
* Even so it's favorable to use local resources like local versions in docker containers for some integrations we need to test against the real cloud services. Possibles reasons are:
    * There is no adequate local version
    * Performance testing

Needs: dsn

## Damage Minimization on Hacking Attacks

`feat~damage-minimization-on-hacking-attacks~1`

The AWS CI Account Setup implements measurements to reduce the damage (costs, abuse) in case an attacker gains access to the CI account.

Rationale:
Since the credentials are exposed to the CI there is an increased risk that an attacker could gain access to them. For that case the damage should be as small as possible.

Needs: dsn

## Prevention of Costs Caused by CI Builds That Failed to Clean up

`feat~clean-up~1`

The AWS CI Account Setup handles resources that were created but not deleted by the CI.

Rationale:

Usually each CI build should delete the resources it created. It can, however, happen that the cleanup fails, for example since the CI server crashes. The remaining resources can then generate high costs.

