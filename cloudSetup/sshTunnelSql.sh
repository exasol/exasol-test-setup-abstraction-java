#!/bin/bash
ssh "ec2-user@$EXASOL_MANAGEMENT_IP" -L 8563:n11:8563
