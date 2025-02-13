package group6.matrix;

import group6.common.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FUVTest {

    @Test
    void testValidFUV() {
        int size = 15;

        // Initialize objects(false/NOTUSED as default)
        ConditionsMetVector cmv = new ConditionsMetVector(size);
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix(size);
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(size);
        PreliminaryUnlockingVector puv = new PreliminaryUnlockingVector(size);
        FinalUnlockingVector fuv = new FinalUnlockingVector(size);

        // Set CMV: Some conditions are met
        for (int i = 0; i < size; i++) {
            if (i != 1 && i != 3 && i != 9) {
                cmv.setConditionMet(i, true);
            }else {
                cmv.setConditionMet(i, false);
            }
        }

        // Set LCM to all ORR
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                lcm.setConnector(i, j, Constants.ConnectorType.ORR);
            }
        }

        // Generate PUM: only row 1, 3, and 9 are false, others are all true while corresponding rows of LCM are NOTUSED
        pum.generatePUM(cmv, lcm);

        // Set PUV: False leads to FUV[i] be true
        puv.setCondition(3, true);
        puv.setCondition(5, true);
        puv.setCondition(9, true);

        // Generate FUV
        fuv.generateFUV(pum, puv);

        // Validate FUV
        for (int i = 0; i < size; i++) {
            if (i == 3 || i == 9) {
                assertFalse(fuv.getCondition(i), "FUV[" + i + "] should be false as PUV[" + i + "] is false and corresponding row in PUM is all false.");
            } else {
                assertTrue(fuv.getCondition(i), "FUV[" + i + "] should be true as PUV[" + i + "] is true and corresponding row in PUM is all true.");
            }
        }
    }

    @Test
    void testInvalidFUV() {
        int size = 15;

        // Initialize objects(false/NOTUSED as default)
        ConditionsMetVector cmv = new ConditionsMetVector(size);
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix(size);
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(size);
        PreliminaryUnlockingVector puv = new PreliminaryUnlockingVector(size);
        FinalUnlockingVector fuv = new FinalUnlockingVector(size);

        // Set LCM to all ANDD
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                lcm.setConnector(i, j, Constants.ConnectorType.ANDD);
            }
        }

        // Generate PUM: All false
        pum.generatePUM(cmv, lcm);

        // Set PUV to all true
        for (int i = 0; i < size; i++) {
            puv.setCondition(i, true);
        }

        // Generate FUV
        fuv.generateFUV(pum, puv);

        // Validate FUV: Should be false since PUM has all false values
        for (int i = 0; i < size; i++) {
            assertFalse(fuv.getCondition(i), "FUV[" + i + "] should be false as PUV[" + i + "] is true but corresponding row in PUM is all false.");
        }
    }

    @Test
    void testEdgeCaseFUV() {
        int size = 15;

        // Initialize objects(false/NOTUSED as default)
        ConditionsMetVector cmv = new ConditionsMetVector(size);
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix(size);
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(size);
        PreliminaryUnlockingVector puv = new PreliminaryUnlockingVector(size);
        FinalUnlockingVector fuv = new FinalUnlockingVector(size);


        // Set LCM: Only some entries are used
        lcm.setConnector(2, 3, Constants.ConnectorType.ANDD);
        lcm.setConnector(11, 12, Constants.ConnectorType.ORR);

        // Generate PUM: Only some entries are false
        pum.generatePUM(cmv, lcm);

        // Set PUV: Mix of true and false
        puv.setCondition(2, true);
        puv.setCondition(11, true);

        // Generate FUV
        fuv.generateFUV(pum, puv);

        // Validate FUV
        for (int i = 0; i < size; i++) {
            if (i == 2 || i == 11) {
                assertFalse(fuv.getCondition(i), "FUV[" + i + "] should be false as PUM[" + i + "] has false value.");
            } else {
                assertTrue(fuv.getCondition(i), "FUV[" + i + "] should be true as PUV[" + i + "] is false.");
            }
        }
    }
}
