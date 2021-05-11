package com.exasol.exasoltestsetup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.exasol.errorreporting.ExaError;

import software.amazon.awssdk.services.cloudformation.CloudFormationClient;
import software.amazon.awssdk.services.cloudformation.model.*;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;

public class CloudFormationExasolTestSetupFactory {
    private final Ec2Client ec2;

    public CloudFormationExasolTestSetupFactory() {
        this.ec2 = Ec2Client.builder().build();
    }

    public ExasolTestSetup readTestSetup(final String cloudFormationStackName) {
        final CloudFormationClient cloudFormation = CloudFormationClient.builder().build();
        final DescribeStacksResponse stacksResponse = cloudFormation
                .describeStacks(DescribeStacksRequest.builder().stackName(cloudFormationStackName).build());
        final Stack stack = stacksResponse.stacks().get(0);
        final String managementNodeId = getManagementNodeId(stack);
        final List<String> dataNodeIds = getDataNodeIds(stack);
        final List<String> dataNodeIps = dataNodeIds.stream().map(this::getEc2InstanceIp).collect(Collectors.toList());
        final String managementNodeIp = getEc2InstanceIp(managementNodeId);
        return new StandaloneExasolTestSetup(managementNodeIp, dataNodeIps.get(0));
    }

    private String getManagementNodeId(final Stack stack) {
        return stack.outputs().stream().filter(output -> output.outputKey().equals("ManagementServer")).findAny()
                .orElseThrow(() -> new IllegalStateException(ExaError.messageBuilder("E-VSAJ-13")
                        .message("The given stack had no 'ManagementServer' output.").toString()))
                .outputValue();
    }

    private List<String> getDataNodeIds(final Stack stack) {
        final String dataNodesOutput = stack.outputs().stream().filter(output -> output.outputKey().equals("Datanodes"))
                .findAny().orElseThrow(() -> new IllegalStateException(ExaError.messageBuilder("E-VSAJ-12")
                        .message("The given stack had no 'Datanodes' output.").toString()))
                .outputValue();
        return Arrays.asList(dataNodesOutput.split(","));
    }

    private String getEc2InstanceIp(final String managementServerId) {
        final DescribeInstancesResponse describeInstancesResponse = this.ec2
                .describeInstances(DescribeInstancesRequest.builder().instanceIds(List.of(managementServerId)).build());
        return describeInstancesResponse.reservations().get(0).instances().get(0).publicIpAddress();
    }
}
