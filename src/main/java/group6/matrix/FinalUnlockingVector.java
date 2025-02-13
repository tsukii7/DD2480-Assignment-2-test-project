package group6.matrix;

/**
 * Generates and represents the Final Unlocking Vector (FUV),
 * which determines the final decision for each condition.
 */
public class FinalUnlockingVector {
    private boolean[] fuv;

    /**
     * Constructs a Final Unlocking Vector with the specified size.
     *
     * @param size the number of conditions (LICs)
     */
    public FinalUnlockingVector(int size) {
        fuv = new boolean[size];
    }

    /**
     * Generates the Final Unlocking Vector (FUV) based on the Preliminary Unlocking
     * Matrix (PUM) and the Preliminary Unlocking Vector (PUV).
     * <p>
     * For each condition:
     * <ul>
     *   <li>If PUV[i] is false, FUV[i] is true.</li>
     *   <li>If PUV[i] is true, FUV[i] is true only if all values in PUM[i] are true.</li>
     * </ul>
     * </p>
     *
     * @param pum the Preliminary Unlocking Matrix
     * @param puv the Preliminary Unlocking Vector
     */
    public void generateFUV(PreliminaryUnlockingMatrix pum, PreliminaryUnlockingVector puv) {
        for (int i = 0; i < fuv.length; i++) {
            if (!puv.getCondition(i)) {
                fuv[i] = true;
            } else {
                boolean allTrue = true;
                for (int j = 0; j < pum.getSize(); j++) {
                    if (!pum.getEntry(i, j)) {
                        allTrue = false;
                        break;
                    }
                }
                fuv[i] = allTrue;
            }
        }
    }

    /**
     * Checks if the launch decision is approved.
     *
     * @return true if the launch decision is approved, false otherwise
     */
    public boolean isLaunchDecisionApproved() {
        for (boolean b : fuv) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retrieves the value of a specific condition in the FUV.
     *
     * @param index the condition index
     * @return the value of the condition
     */
    public boolean getCondition(int index) {
        return fuv[index];
    }
}
