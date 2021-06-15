#!/bin/bash
ssh -i generated/exasol_cluster_ssh_key "ec2-user@$EXASOL_MANAGEMENT_IP" -L 443:localhost:443
