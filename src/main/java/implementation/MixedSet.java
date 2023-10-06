package implementation;


import java.util.Set;

public class MixedSet {
    private FloatSet floatSet;
    private IntegerSet integerSet;
    private Set<String> categoricalSet;

    public MixedSet(FloatSet floatSet, IntegerSet integerSet, Set<String> categoricalSet) {
        this.floatSet = floatSet;
        this.integerSet = integerSet;
        this.categoricalSet = categoricalSet;
    }

    public FloatSet getFloatSet() {
        return floatSet;
    }

    public IntegerSet getIntegerSet() {
        return integerSet;
    }

    public Set<String> getCategoricalSet() {
        return categoricalSet;
    }
}