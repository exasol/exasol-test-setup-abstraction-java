package com.myorg;

import java.util.List;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

import software.amazon.awscdk.core.*;
import software.amazon.awscdk.services.iam.*;

public class CiUserStack extends Stack {
    public static final List<String> POLICY_RESOURCES = List.of("exasol-policy.json", "terraform-policy.json");
    private final CfnParameter exaProject;
    private final CfnParameter exaOwner;

    public CiUserStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CiUserStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);
        this.exaProject = CfnParameter.Builder.create(this, "exaProject").type("String")
                .description("Exasol project tag.").build();
        this.exaOwner = CfnParameter.Builder.create(this, "exaOwner").type("String")
                .description("Exasol project owner e-mail address.").build();
        final User ciUser = new User(this, "ci-user", UserProps.builder().userName("ci-user").build());
        tagResource(ciUser);
        final List<ManagedPolicy> policies = POLICY_RESOURCES.stream().map(this::readPolicyFromResource)
                .collect(Collectors.toList());
        addPolicies(ciUser, policies);
        addPolicies(ciUser, List.of(getAwsNukePolicy(policies)));

        final CfnAccessKey ciUserKey = new CfnAccessKey(this, "ci-access-key",
                CfnAccessKeyProps.builder().userName(ciUser.getUserName()).build());
        CfnOutput.Builder.create(this, "accessKeyRef").value(ciUserKey.getRef()).build();
        CfnOutput.Builder.create(this, "accessKeySecret").value(ciUserKey.getAttrSecretAccessKey()).build();
    }

    private ManagedPolicy getAwsNukePolicy(final List<ManagedPolicy> policies) {
        final List<String> usedServices = new PolicyServiceExtractor()
                .getUsedServices(policies.stream().map(ManagedPolicy::getDocument).collect(Collectors.toList()));
        final PolicyStatement policyStatement = new PolicyStatement();
        policyStatement.addAllResources();
        for (final String usedService : usedServices) {
            policyStatement.addActions(usedService + ":List*", usedService + ":Delete*");
        }
        return new ManagedPolicy(this, "aws-nuke-policy", ManagedPolicyProps.builder()
                .managedPolicyName("aws-nuke-policy").statements(List.of(policyStatement)).build());
    }

    private void addPolicies(final User ciUser, final List<ManagedPolicy> policies) {
        for (final ManagedPolicy policy : policies) {
            tagResource(policy);
            ciUser.addManagedPolicy(policy);
        }
    }

    @NotNull
    private ManagedPolicy readPolicyFromResource(final String resourceName) {
        final PolicyDocument policyDocument = new PolicyReader().readPolicyFromResources(resourceName);
        final String policyName = resourceName.replace(".json", "");
        final ManagedPolicy policy = new ManagedPolicy(this, policyName,
                ManagedPolicyProps.builder().document(policyDocument).managedPolicyName(policyName).build());
        return policy;
    }

    private void tagResource(final IConstruct resource) {
        Tags.of(resource).add("exa:project", this.exaProject.getValueAsString());
        Tags.of(resource).add("exa:owner", this.exaOwner.getValueAsString());
    }
}
