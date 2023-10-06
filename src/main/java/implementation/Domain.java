package implementation;

import java.util.Set;

public class Domain {
    private String name;
    private Set<Object> values;

    public Domain(String name, Set<Object> values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public Set<Object> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "name='" + name + '\'' +
                ", values=" + values +
                '}';
    }
}
