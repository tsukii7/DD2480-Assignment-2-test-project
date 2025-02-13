package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC7Test {

    @Test
    void testCMV7_True() {
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

        assertTrue(licService.evaluateLICById(7, points, parameters), "cmv7 should return true when a pair of points separated by K_PTS exceeds LENGTH1");
    }

    @Test
    void testCMV7_False() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(5, 5)
        );
        Parameters parameters = new Parameters();
        parameters.setKPts(1);
        parameters.setLength1(10);

        assertFalse(licService.evaluateLICById(7, points, parameters), "cmv7 should return false when no pair of points separated by K_PTS exceeds LENGTH1");
    }

    // Test with invalid input: NUMPOINTS less than 3
    @Test
    void testCMV7__NumPointsLessThan3() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1)
        );
        Parameters parameters = new Parameters();
        parameters.setKPts(1);
        parameters.setLength1(10);

        assertFalse(licService.evaluateLICById(7, points, parameters), "cmv7 should return false when NUMPOINTS is less than 3");
    }

}