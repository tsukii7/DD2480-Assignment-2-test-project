package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC6Test {

    @Test
    public void LIC6TestNotEnoughPoints() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1)
        );
        Parameters parameters = new Parameters();
        parameters.setDist(5);
        parameters.setNPts(3);
        assertFalse(licService.evaluateLICById(6, points, parameters));
    }

    @Test
    public void LIC6TestOverlappingPoints() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(0, 5),
                new Point(0, 0)
        );
        Parameters parameters = new Parameters();
        parameters.setDist(4);
        parameters.setNPts(3);
        assertTrue(licService.evaluateLICById(6, points, parameters));
        parameters.setNPts(5);
        assertFalse(licService.evaluateLICById(6, points, parameters));

    }

    @Test
    public void LIC6Test1() {
        //Distance calculated with Geogebra: 4.242...
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(7, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4)

        );
        Parameters parameters = new Parameters();
        parameters.setDist(4);
        parameters.setNPts(3);
        assertTrue(licService.evaluateLICById(6, points, parameters));
        parameters.setDist(5);
        assertFalse(licService.evaluateLICById(6, points, parameters));
    }
}
