package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC0Test {
    @Test
    void testLIC0ValidInput() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(11, 0)
        );
        Parameters parameters = new Parameters();
        parameters.setLength1(10);

        assertTrue(licService.evaluateLICById(0, points, parameters), "cmv0 should return true when two consecutive points have a distance greater than LENGTH1");
    }

    @Test
    void testCmv0_False() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(5, 5)
        );
        Parameters parameters = new Parameters();
        parameters.setLength1(10);

        assertFalse(licService.evaluateLICById(0, points, parameters), "cmv0 should return false when no two consecutive points have a distance greater than LENGTH1");
    }
}
