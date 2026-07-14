# Exasol Test Setup Abstraction Java 3.0.0, released 2026-07-14

Code name: Removed XML RPC

## Summary

This release brings a breaking change. We removed the XML RPC and with that the option to deploy on AWS.
Due to the lack of a terraform deployment option ETSAJ did not really support AWS anymore anyway.

Future versions will probably add Exasol SaaS support instead.

## Features

* ISSUE_NUMBER: description

## Dependency Updates

### Compile Dependency Updates

* Removed `fr.turri:aXMLRPC:1.17.0`
