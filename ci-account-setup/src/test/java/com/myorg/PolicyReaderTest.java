package com.myorg;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import software.amazon.awscdk.services.iam.PolicyDocument;

class PolicyReaderTest {
    @Test
    void test() {
        final PolicyDocument policyDocument = new PolicyReader().readPolicyFromResources("test-permissions.json");
        assertThat(policyDocument.getStatementCount(), equalTo(1));
    }
}