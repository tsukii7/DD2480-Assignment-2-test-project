package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC11Test {

    @Test
    public void LIC11TestNotEnoughPoints(){
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 0)
        );
        Parameters parameters = new Parameters();
        parameters.setGPts(1);
        assertFalse(licService.evaluateLICById(11, points, parameters));
    }

    @Test
    public void LIC11Test1(){
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, 0)
        );
        Parameters parameters = new Parameters();
        parameters.setGPts(1);
        assertFalse(licService.evaluateLICById(11, points, parameters));
    }

    @Test
    public void LIC11Test2(){
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0.1, 0),
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(0, 0)
        );
        Parameters parameters = new Parameters();
        parameters.setGPts(2);
        assertFalse(licService.evaluateLICById(11, points, parameters));
        parameters.setGPts(3);
        assertTrue(licService.evaluateLICById(11, points, parameters));
    }
}
