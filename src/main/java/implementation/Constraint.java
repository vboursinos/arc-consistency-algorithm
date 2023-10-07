package implementation;

import java.util.List;

public class Constraint {
    private String source;
    private String target;
    private List<MappingItem> mapping;

    public Constraint(String source, String target, List<MappingItem> mapping) {
        this.source = source;
        this.target = target;
        this.mapping = mapping;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<MappingItem> getMapping() {
        return mapping;
    }
}