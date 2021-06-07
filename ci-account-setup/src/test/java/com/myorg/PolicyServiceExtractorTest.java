package com.myorg;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;

import org.junit.jupiter.api.Test;

import software.amazon.awscdk.services.iam.*;

class PolicyServiceExtractorTest {

    @Test
    void test() {
        final PolicyStatement policyStatement = new PolicyStatement(
                PolicyStatementProps.builder().actions(List.of("s3:ListBuckets")).build());
        final PolicyDocument policyDocument = new PolicyDocument(
                PolicyDocumentProps.builder().statements(List.of(policyStatement)).build());
        assertThat(new PolicyServiceExtractor().getUsedServices(List.of(policyDocument)), containsInAnyOrder("s3"));
    }
}