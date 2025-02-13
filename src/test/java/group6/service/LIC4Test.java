package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC4Test {

    @Test
    void testCMV4_True() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(-1, 1),
                new Point(-1, -1),
                new Point(1, -1)
        );
        Parameters parameters = new Parameters();
        parameters.setQPts(3);
        parameters.setQuads(2);

        assertTrue(licService.evaluateLICById(4, points, parameters), "cmv4 should return true when Q_PTS points span more than QUADS quadrants");
    }

    @Test
    void testCMV4_False() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4)
        );
        Parameters parameters = new Parameters();
        parameters.setQPts(3);
        parameters.setQuads(2);

        assertFalse(licService.evaluateLICById(4, points, parameters), "cmv4 should return false when Q_PTS points do not span more than QUADS quadrants");
    }

    // Test with invalid input: NUMPOINTS less than Q_PTS
    @Test
    void testCMV4_NumPointsLessThanQPTS() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(2, 2)
        );
        Parameters parameters = new Parameters();
        parameters.setQPts(3);
        parameters.setQuads(2);

        assertFalse(licService.evaluateLICById(4, points, parameters), "cmv4 should return false when NUMPOINTS is less than Q_PTS");
    }

    // Test with edge case: Q_PTS equals NUMPOINTS
    @Test
    void testCMV4_EdgeCase_QPTSEqualsNumPoints() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(-1, 1),
                new Point(-1, -1),
                new Point(1, -1)
        );
        Parameters parameters = new Parameters();
        parameters.setQPts(4);
        parameters.setQuads(3);

        assertTrue(licService.evaluateLICById(4, points, parameters), "cmv4 should return true when all NUMPOINTS span more than QUADS quadrants");
    }

    // Test with edge case: Points exactly on axes
    @Test
    void testCMV4_PointsOnAxes() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 1),
                new Point(-1, 0),
                new Point(0, -1),
                new Point(1, 0)
        );
        Parameters parameters = new Parameters();
        parameters.setQPts(3);
        parameters.setQuads(2);

        assertTrue(licService.evaluateLICById(4, points, parameters), "cmv4 should return true when points lie exactly on span more than QUADS quadrants");
    }
}