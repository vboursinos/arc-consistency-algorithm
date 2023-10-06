package implementation;

import java.util.*;

public class CategoricalSet {
    private Set<String> categories;

    public CategoricalSet(Set<String> categories) {
        this.categories = categories;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public boolean contains(String value) {
        return categories.contains(value);
    }

    @Override
    public String toString() {
        return "CategoricalSet{" +
                "categories=" + categories +
                '}';
    }
}