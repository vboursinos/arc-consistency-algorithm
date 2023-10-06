package implementation;

import java.util.Set;

public class MappingItem {
    private Set<Object> source;
    private Set<Object> target;

    public MappingItem(Set<Object> source, Set<Object> target) {
        this.source = source;
        this.target = target;
    }

    public Set<Object> getSource() {
        return source;
    }

    public Set<Object> getTarget() {
        return target;
    }
}