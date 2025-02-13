package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC12Test {

    // Test with valid input where both conditions are met
    @Test
    void testCMV12_BothConditionsMet() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(15, 15)
        );
        Parameters parameters = new Parameters();
        parameters.setKPts(1);
        parameters.setLength1(10);
        parameters.setLength2(5);

        assertTrue(licService.evaluateLICById(12, points, parameters), "cmv12 should return true when both conditions are met: distance > LENGTH1 and distance < LENGTH2");
    }

    // Test with valid input where only the first condition is met
    @Test
    void testCMV12_OnlyFirstConditionMet() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(15, 15)
        );
        Parameters parameters = new Parameters();
        parameters.setKPts(1);
        parameters.setLength1(10);
        parameters.setLength2(2);

        assertFalse(licService.evaluateLICById(12, points, parameters), "cmv12 should return false when only the first condition (distance > LENGTH1) is met");
    }

    // Test with valid input where only the second condition is met
    @Test
    void testCMV12_OnlySecondConditionMet() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3)
        );
        Parameters parameters = new Parameters();
        parameters.setKPts(1);
        parameters.setLength1(10);
        parameters.setLength2(5);

        assertFalse(licService.evaluateLICById(12, points, parameters), "cmv12 should return false when only the second condition (distance < LENGTH2) is met");
    }

    // Test with valid input where neither condition is met
    @Test
    void testCMV12_NoConditionMet() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3)
        );
        Parameters parameters = new Parameters();
        parameters.setKPts(1);
        parameters.setLength1(10);
        parameters.setLength2(2);

        assertFalse(licService.evaluateLICById(12, points, parameters), "cmv12 should return false when neither condition is met");
    }

    // Test with invalid input: NUMPOINTS less than 3
    @Test
    void testCMV12_NumPointsLessThan3() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1)
        );
        Parameters parameters = new Parameters();
        parameters.setKPts(1);
        parameters.setLength1(10);
        parameters.setLength2(5);

        assertFalse(licService.evaluateLICById(12, points, parameters), "cmv12 should return false when NUMPOINTS is less than 3");
    }
    
}