package implementation;

import java.util.*;

public class AlgorithmValidationRun {
    public static void main(String[] args) {
        Map<String, Domain> domains = new HashMap<>();
        domains.put("A", new Domain("A", new HashSet<>(Arrays.asList("rf", "goss", "gbdt", "dart"))));
        domains.put("B", new Domain("B", new HashSet<>(Arrays.asList(10, 11, 12, 13))));
        domains.put("C", new Domain("C", new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
        domains.put("D", new Domain("D", new HashSet<>(Arrays.asList(true, false))));
        domains.put("E", new Domain("E", new HashSet<>(Arrays.asList("a","b"))));

        List<MappingItem> mappingAtoB = Arrays.asList(
                new MappingItem(new HashSet<>(Arrays.asList("rf")),
                        new HashSet<>(Arrays.asList(9))),
                new MappingItem(new HashSet<>(Arrays.asList("goss")),
                        new HashSet<>(Arrays.asList(1))),
                new MappingItem(new HashSet<>(Arrays.asList("gbdt", "dart")),
                        new HashSet<>(Arrays.asList(13)))
        );
        Constraint constraintAtoB = new Constraint("A", "B", mappingAtoB);

        List<MappingItem> mappingAtoC = Arrays.asList(
                new MappingItem(new HashSet<>(Arrays.asList("rf")),
                        new HashSet<>(Arrays.asList(1, 2, 3))),
                new MappingItem(new HashSet<>(Arrays.asList("goss","gbdt")),
                        new HashSet<>(Arrays.asList(4,5))),
                new MappingItem(new HashSet<>(Arrays.asList("dart")),
                        new HashSet<>(Arrays.asList(11)))
        );
        Constraint constraintAtoC = new Constraint("A", "C", mappingAtoC);

        List<MappingItem> mappingDtoE = Arrays.asList(
                new MappingItem(new HashSet<>(Arrays.asList(true)),
                        new HashSet<>(Arrays.asList("b"))),
                new MappingItem(new HashSet<>(Arrays.asList(false)),
                        new HashSet<>(Arrays.asList("c")))
        );


        Constraint constraintDtoE = new Constraint("D", "E", mappingDtoE);

        List<Constraint> constraints = Arrays.asList(constraintAtoB, constraintAtoC, constraintDtoE);

        ModifiedArcConsistency ac = new ModifiedArcConsistency(constraints, domains);
        System.out.println("Before AC3: " + ac.getDomains());

        ac.ac3();

        System.out.println("After AC3: " + ac.getDomains());
    }
}