package implementation;

public class IntegerSet {
    private int minValue;
    private int maxValue;

    public IntegerSet(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}