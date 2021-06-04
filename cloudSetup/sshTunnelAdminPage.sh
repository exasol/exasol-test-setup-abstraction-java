#!/bin/bash
ssh "ec2-user@$EXASOL_MANAGEMENT_IP" -L 443:localhost:443
