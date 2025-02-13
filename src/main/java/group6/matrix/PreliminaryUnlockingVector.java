package group6.matrix;

/**
 * Represents the Preliminary Unlocking Vector (PUV),
 * an array of boolean values indicating conditions for unlocking.
 */
public class PreliminaryUnlockingVector {

    private boolean[] puv;

    /**
     * Constructs a Preliminary Unlocking Vector with the specified size.
     *
     * @param size the number of conditions in the vector
     */
    public PreliminaryUnlockingVector(int size) {
        this.puv = new boolean[size];
    }

    /**
     * Sets the value for a specific condition in the PUV.
     *
     * @param index the condition index
     * @param value the value to set (true = must be met, false = does not need to be met)
     */
    public void setCondition(int index, boolean value) {
        this.puv[index] = value;
    }

    /**
     * Gets the value of a specific condition in the PUV.
     *
     * @param index the condition index
     * @return the value of the condition
     */
    public boolean getCondition(int index) {
        return puv[index];
    }

    /**
     * Returns the entire PUV array.
     *
     * @return the PUV as a boolean array
     */
    public boolean[] getPuv() {
        return puv;
    }

    /**
     * Sets the entire PUV array.
     *
     * @param puv the PUV as a boolean array
     */
    public void setPuv(boolean[] puv) {
        this.puv = puv;
    }
}
