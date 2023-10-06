package implementation;

public class FloatSet {
    private float minValue;
    private float maxValue;

    public FloatSet(float minValue, float maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public float getMinValue() {
        return minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }
}