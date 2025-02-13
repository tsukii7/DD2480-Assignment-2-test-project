package group6.service;

import group6.matrix.ConditionsMetVector;
import group6.model.Parameters;
import group6.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for LICService.
 */
class LICServiceTest {

    private LICService licService;
    private Parameters parameters;
    private List<Point> points;

    @BeforeEach
    void setUp() {
        licService = new LICService();
        parameters = new Parameters();
        points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4)
        );

        parameters.setLength1(1.0);
        parameters.setLength2(1.0);
        parameters.setRadius1(1.0);
        parameters.setRadius2(1.0);
        parameters.setEpsilon(Math.PI / 4);
        parameters.setArea1(1.0);
        parameters.setArea2(1.0);
        parameters.setQPts(3);
        parameters.setQuads(2);
        parameters.setDist(1.0);
        parameters.setNPts(4);
        parameters.setKPts(1);
        parameters.setAPts(1);
        parameters.setBPts(1);
        parameters.setCPts(1);
        parameters.setDPts(1);
        parameters.setEPts(1);
        parameters.setFPts(1);
        parameters.setGPts(1);
    }

    @Test
    void testValidParameters() {        
        assertDoesNotThrow(() -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidNUMPOINTS() {
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), List.of(new Point(0, 0)), parameters));
    }

    @Test
    void testInvalidLength1() {
        parameters.setLength1(-1.0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidLength2() {
        parameters.setLength2(-1.0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidRadius1() {
        parameters.setRadius1(-1.0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidRadius2() {
        parameters.setRadius2(-1.0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidEpsilon() {
        parameters.setEpsilon(Math.PI);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidArea1() {
        parameters.setArea1(-1.0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidArea2() {
        parameters.setArea2(-1.0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidQPts() {
        parameters.setQPts(1);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidQuads() {
        parameters.setQuads(4);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidDist() {
        parameters.setDist(-1.0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidNPts() {
        parameters.setNPts(2);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidKPts() {
        parameters.setKPts(0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidAPts() {
        parameters.setAPts(0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidBPts() {
        parameters.setBPts(0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidAPtsPlusBPts() {
        parameters.setAPts(2);
        parameters.setBPts(2);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidCPts() {
        parameters.setCPts(0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidDPts() {
        parameters.setDPts(0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidCPtsPlusDPts() {
        parameters.setCPts(2);
        parameters.setDPts(2);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidEPts() {
        parameters.setEPts(0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidFPts() {
        parameters.setFPts(0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidEPtsPlusFPts() {
        parameters.setEPts(2);
        parameters.setFPts(2);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }

    @Test
    void testInvalidGPts() {
        parameters.setGPts(0);
        assertThrows(IllegalArgumentException.class, () -> licService.evaluateAllLICs(new ConditionsMetVector(15), points, parameters));
    }
}