package implementation;

public class Node {
    private String name;
    private String label;
    private String description;
    private boolean enabled;
    private Object defaultValue;
    private boolean constraint;
    private String constraintInformation;
    private Object domain; // You can use an appropriate data structure for domain

    public Node(String name, String label, String description, boolean enabled, Object defaultValue, boolean constraint, String constraintInformation, Object domain) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.enabled = enabled;
        this.defaultValue = defaultValue;
        this.constraint = constraint;
        this.constraintInformation = constraintInformation;
        this.domain = domain;
    }

    public Node() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isConstraint() {
        return constraint;
    }

    public void setConstraint(boolean constraint) {
        this.constraint = constraint;
    }

    public String getConstraintInformation() {
        return constraintInformation;
    }

    public void setConstraintInformation(String constraintInformation) {
        this.constraintInformation = constraintInformation;
    }

    public Object getDomain() {
        return domain;
    }

    public void setDomain(Object domain) {
        this.domain = domain;
    }
}
