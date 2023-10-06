package implementation;

import java.util.*;

public class ModifiedArcConsistency {
    private List<Constraint> constraints;
    private Map<String, Domain> domains;

    public ModifiedArcConsistency(List<Constraint> constraints, Map<String, Domain> domains) {
        this.constraints = constraints;
        this.domains = domains;
    }

    public void ac3() {
        Queue<Constraint> queue = new LinkedList<>(constraints);

        while (!queue.isEmpty()) {
            Constraint constraint = queue.poll();
            if (revise(constraint)) {
                if (domains.get(constraint.getSource()).getValues().isEmpty()) {
                    return;  // Failure detected
                }

                // Add constraints involving both source and target nodes
                for (Constraint otherConstraint : constraints) {
                    if (otherConstraint.getTarget().equals(constraint.getSource())
                            || otherConstraint.getTarget().equals(constraint.getTarget())) {
                        queue.add(otherConstraint);
                    }
                }
            }
        }
    }

    private boolean revise(Constraint constraint) {
        boolean revised = false;

        Domain sourceDomain = domains.get(constraint.getSource());
        Set<Object> sourceValues = new HashSet<>(sourceDomain.getValues());

        for (Object sourceValue : sourceValues) {
            boolean satisfy = false;

            for (MappingItem mappingItem : constraint.getMapping()) {
                if (mappingItem.getSource().contains(sourceValue)
                        && !Collections.disjoint(mappingItem.getTarget(), domains.get(constraint.getTarget()).getValues())) {
                    satisfy = true;
                    break;
                }
            }

            if (!satisfy) {
                sourceDomain.getValues().remove(sourceValue);
                revised = true;
            }
        }

        return revised;
    }

    public Map<String, Domain> getDomains() {
        return domains;
    }
}