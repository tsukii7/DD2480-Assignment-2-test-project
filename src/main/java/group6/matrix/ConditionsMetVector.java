package group6.matrix;

public class ConditionsMetVector {
    private boolean[] cmv;

    /**
     * Constructs a Conditions Met Vector with the specified size.
     *
     * @param size the number of LICs
     */
    public ConditionsMetVector(int size) {
        this.cmv = new boolean[size];
    }

    /**
     * Sets the value for a specific LIC condition in the CMV.
     *
     * @param index the LIC index
     * @param value the value to set (true = condition met, false = not met)
     */
    public void setConditionMet(int index, boolean value) {
        if (index < 0 || index >= cmv.length) {
            throw new IndexOutOfBoundsException("Invalid CMV index: " + index);
        }
        this.cmv[index] = value;
    }

    /**
     * Gets the value of a specific LIC condition in the CMV.
     *
     * @param index the LIC index
     * @return the value of the condition (true if met, false otherwise)
     */
    public boolean isConditionMet(int index) {
        if (index < 0 || index >= cmv.length) {
            throw new IndexOutOfBoundsException("Invalid CMV index: " + index);
        }
        return cmv[index];
    }
}