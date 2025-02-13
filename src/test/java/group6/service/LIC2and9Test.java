package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC2and9Test {

//    @Test
//    public void computeAngleOverlappingPointsTest() {
//        assertEquals(Double.NaN, Decide.computeAngle(0,0,0,0,0,0), "Error when computing same point angle");
//    }
//    @Test
//    public void computesAngleTest() {
//        assertEquals(Math.PI/2,Decide.computeAngle(0,-2,0,4,4,4), "Error on 90 deg angle");
//        assertEquals(Math.PI, Decide.computeAngle(0,0,0,1,0,2), "Error on 180 deg angle");
//        assertEquals(Math.PI*3/4,Decide.computeAngle(3,7,0,4,0,-2), "Error on 135 deg angle");
//        assertEquals(Math.PI/4,Decide.computeAngle(0,-2,0,4,3,1), "Error on 45 deg angle");
//    }
    @Test
    public void LIC2Test1() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4)
                );
        Parameters parameters = new Parameters();
        parameters.setEpsilon(0.002);

        assertFalse(licService.evaluateLICById(2, points, parameters));
    }

    @Test
    public void LIC2Test2() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(2, 0),
                new Point(1, 2)
        );
        Parameters parameters = new Parameters();
        parameters.setEpsilon(2);
      
        assertTrue(licService.evaluateLICById(2, points, parameters));
    }

    @Test
    public void LIC2Test3() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(3.694, 3.947),
                new Point(4.663, 4.405),
                new Point(4.294, 4.265)
        );
        Parameters parameters = new Parameters();
        parameters.setEpsilon(3.06);

        assertTrue(licService.evaluateLICById(2, points, parameters));
        parameters.setEpsilon(3.07);
        assertFalse(licService.evaluateLICById(2, points, parameters));
    }

    @Test
    public void LIC9Test1() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(3.694, 3.947),
                new Point(Double.NaN,Double.NaN),
                new Point(Double.NaN,Double.NaN),
                new Point(4.663, 4.405),
                new Point(Double.NaN,Double.NaN),
                new Point(4.294, 4.265)
        );
        Parameters parameters = new Parameters();
        parameters.setEpsilon(3.06);
        parameters.setCPts(2);
        parameters.setDPts(1);

        assertTrue(licService.evaluateLICById(9, points, parameters));
        parameters.setEpsilon(3.07);
        assertFalse(licService.evaluateLICById(9, points, parameters));
    }

    @Test
    public void LIC9TestNotEnoughPoints() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(2, 0),
                new Point(1, 2)
        );
        Parameters parameters = new Parameters();
        parameters.setEpsilon(2);
        parameters.setCPts(0);
        parameters.setDPts(0);

        assertFalse(licService.evaluateLICById(9, points, parameters));
    }

}
