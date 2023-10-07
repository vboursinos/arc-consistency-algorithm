package implementation;

import java.util.*;

public class ModifiedArcConsistency {
    private List<Constraint> constraints;
    private Map<String, Domain> domains;

    public ModifiedArcConsistency(List<Constraint> constraints, Map<String, Domain> domains) {
        this.constraints = constraints;
        this.domains = domains;
    }

    public void ac3_bidirectional() {
        Queue<Constraint> queue = new LinkedList<>(constraints);

        while (!queue.isEmpty()) {
            Constraint constraint = queue.poll();

            String source = constraint.getSource();
            String target = constraint.getTarget();

            if (revise(source, target, constraint)) {
                if (domains.get(source).getValues().isEmpty()) {
                    return;  // Failure detected
                }

                // Only add constraints where source is target of current constraint
                for (Constraint otherConstraint : constraints) {
                    if (otherConstraint.getTarget().equals(source)) {
                        queue.add(otherConstraint);
                    }
                }
            }

            // Now go in the opposite direction, target -> source
            Constraint reversedConstraint = new Constraint(target, source, reverseMapping(constraint.getMapping()));
            if (revise(target, source, reversedConstraint)) {
                if (domains.get(target).getValues().isEmpty()) {
                    return;  // Failure detected
                }
            }
        }
    }

    private List<MappingItem> reverseMapping(List<MappingItem> originalMapping) {
        // Create a new list of MappingItems with the source and target swapped
        List<MappingItem> reversedMapping = new ArrayList<>();
        for (MappingItem item : originalMapping) {
            MappingItem reversedItem = new MappingItem(item.getTarget(), item.getSource());
            reversedMapping.add(reversedItem);
        }
        return reversedMapping;
    }

    private boolean revise(String source, String target, Constraint constraint) {
        boolean revised = false;
        Domain sourceDomain = domains.get(source);
        Set<Object> sourceValues = new HashSet<>(sourceDomain.getValues());

        for (Object sourceValue : sourceValues) {
            boolean satisfy = false;
            for (MappingItem mappingItem : constraint.getMapping()) {
                if (mappingItem.getSource().contains(sourceValue) &&
                        !Collections.disjoint(mappingItem.getTarget(), domains.get(target).getValues())) {
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