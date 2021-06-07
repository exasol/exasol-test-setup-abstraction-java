package com.myorg;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import software.amazon.awscdk.services.iam.PolicyDocument;

public class PolicyServiceExtractor {
    List<String> getUsedServices(final List<PolicyDocument> policyDocuments) {
        final Stream<String> actions = policyDocuments.stream()
                .flatMap(policyDocument -> findActions(policyDocument.toJSON()).stream());
        return actions.map(action -> action.split(":")[0])
                .filter(action -> action != null && !action.isEmpty() && !action.equals("*")).distinct()
                .collect(Collectors.toList());
    }

    private List<String> findActions(final Object json) {
        final List<String> result = new ArrayList<>();
        if (json instanceof List) {
            final List<?> list = (List<?>) json;
            for (final Object nested : list) {
                result.addAll(findActions(nested));
            }
        } else if (json instanceof Map) {
            final Map<?, ?> map = (Map<?, ?>) json;
            for (final Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey().equals("Action")) {
                    parseAction(result, entry);
                } else {
                    result.addAll(findActions(entry.getValue()));
                }
            }
        }
        return result;
    }

    private void parseAction(final List<String> result, final Map.Entry<?, ?> entry) {
        if (entry.getValue() instanceof String) {
            result.add((String) entry.getValue());
        } else if (entry.getValue() instanceof List) {
            final List<?> list = (List<?>) entry.getValue();
            for (final Object action : list) {
                result.add((String) action);
            }
        } else {
            throw new IllegalStateException("Unknown action type.");
        }
    }
}
