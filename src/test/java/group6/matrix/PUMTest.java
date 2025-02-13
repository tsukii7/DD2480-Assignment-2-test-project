package group6.matrix;

import group6.common.Constants.ConnectorType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PUMTest {

    @Test
    void testValidPUM() {
        int size = 15;
        ConditionsMetVector cmv = new ConditionsMetVector(size);
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix(size);
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(size);

        // Set CMV: some conditions met, some not
        cmv.setConditionMet(0, true);
        cmv.setConditionMet(1, false);
        cmv.setConditionMet(2, true);
        cmv.setConditionMet(3, false);
        cmv.setConditionMet(4, true);

        // Define LCM with logical operators
        lcm.setConnector(0, 1, ConnectorType.ANDD);
        lcm.setConnector(0, 2, ConnectorType.ORR);
        lcm.setConnector(1, 3, ConnectorType.NOTUSED);
        lcm.setConnector(2, 3, ConnectorType.ANDD);
        lcm.setConnector(3, 4, ConnectorType.ORR);

        // Generate PUM
        pum.generatePUM(cmv, lcm);

        // Valid PUM checks
        assertFalse(pum.getEntry(0, 1), "PUM(0,1) should be false (ANDD, but CMV[1] is false).");
        assertTrue(pum.getEntry(0, 2), "PUM(0,2) should be true (ORR, at least one is true).");
        assertTrue(pum.getEntry(1, 3), "PUM(1,3) should be true (NOTUSED always true).");
        assertFalse(pum.getEntry(2, 3), "PUM(2,3) should be false (ANDD but CMV[3] is false).");
        assertTrue(pum.getEntry(3, 4), "PUM(3,4) should be true (ORR, at least one is true).");
    }

    @Test
    void testInvalidPUM() {
        int size = 15;
        ConditionsMetVector cmv = new ConditionsMetVector(size);
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix(size);
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(size);

        // Invalid CMV (all false)
        cmv.setConditionMet(0, false);
        cmv.setConditionMet(1, false);
        cmv.setConditionMet(2, false);

        // Define LCM with logical operators
        lcm.setConnector(0, 1, ConnectorType.ANDD);
        lcm.setConnector(1, 2, ConnectorType.ORR);
        lcm.setConnector(0, 2, ConnectorType.ANDD);

        // Generate PUM
        pum.generatePUM(cmv, lcm);

        // Invalid PUM checks
        assertFalse(pum.getEntry(0, 1), "PUM(0,1) should be false (ANDD, both are false).");
        assertFalse(pum.getEntry(1, 2), "PUM(1,2) should be false (ORR, both are false).");
        assertFalse(pum.getEntry(0, 2), "PUM(0,2) should be false (ANDD, both are false).");
    }

    @Test
    void testPUMSymmetry() {
        int size = 15;
        ConditionsMetVector cmv = new ConditionsMetVector(size);
        LogicalConnectorMatrix lcm = new LogicalConnectorMatrix(size);
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(size);

        // Set CMV values
        cmv.setConditionMet(0, true);
        cmv.setConditionMet(1, false);
        cmv.setConditionMet(2, true);
        cmv.setConditionMet(3, true);

        // Define LCM with symmetric logical operators
        lcm.setConnector(0, 1, ConnectorType.ANDD);
        lcm.setConnector(1, 2, ConnectorType.ORR);
        lcm.setConnector(2, 3, ConnectorType.NOTUSED);

        // Generate PUM
        pum.generatePUM(cmv, lcm);

        // Symmetry checks
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertEquals(pum.getEntry(i, j), pum.getEntry(j, i), "PUM should be symmetric at (" + i + "," + j + ").");
            }
        }
    }
}
