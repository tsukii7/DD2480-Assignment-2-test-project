package group6.matrix;

import group6.common.Constants.ConnectorType;

/**
 * Generates and represents the Preliminary Unlocking Matrix (PUM),
 * based on the Conditions Met Vector (CMV) and Logical Connector Matrix (LCM).
 */
public class PreliminaryUnlockingMatrix {
    private boolean[][] pum;

    /**
     * Constructs a PUM with the specified size.
     *
     * @param size the number of conditions (LICs)
     */
    public PreliminaryUnlockingMatrix(int size) {
        pum = new boolean[size][size];
    }

    /**
     * Generates the PUM using the given CMV and LCM.
     * <p>
     * - ANDD: True if both CMV[i] and CMV[j] are true.<br>
     * - ORR: True if either CMV[i] or CMV[j] is true.<br>
     * - NOTUSED: Always true.
     * </p>
     *
     * @param cmv the Conditions Met Vector
     * @param lcm the Logical Connector Matrix
     */
    public void generatePUM(ConditionsMetVector cmv, LogicalConnectorMatrix lcm) {
        for (int i = 0; i < pum.length; i++) {
            for (int j = 0; j < pum[i].length; j++) {
                ConnectorType connector = lcm.getConnector(i, j);
                pum[i][j] = switch (connector) {
                    case ANDD -> cmv.isConditionMet(i) && cmv.isConditionMet(j);
                    case ORR -> cmv.isConditionMet(i) || cmv.isConditionMet(j);
                    default -> true; // NOTUSED
                };
            }
        }
    }

    /**
     * Retrieves the value of a specific condition in the PUM.
     *
     * @param row the row index
     * @param col the column index
     * @return the value of the condition
     */
    public boolean getEntry(int row, int col) {
        return pum[row][col];
    }


    /**
     * Retrieves the size of the PUM.
     *
     * @return
     */
    public int getSize() {
        return pum.length;
    }
}
