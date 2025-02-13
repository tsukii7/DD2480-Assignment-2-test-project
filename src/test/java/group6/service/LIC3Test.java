package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC3Test {
    @Test
    void cmv3Test1() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(0.0, 0.0),
            new Point(1.0, 1.0),
            new Point(2.0, 2.0),
            new Point(3.0, 3.0),
            new Point(4.0, 4.0)
        );
        
        Parameters parameters = new Parameters();
        parameters.setArea1(-3);
        // assertFalse(Decide.cmv3(X, Y, NUMPOINTS, AREA1));
        assertFalse(licService.evaluateLICById(3, points, parameters), "cmv3 should return false when AREA1 is negative");
    }
    
    @Test
    void cmv3Test2() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(0.0, 0.0),
            new Point(2.0, 0.0),
            new Point(1.0, 2.0)
        );

        Parameters parameters = new Parameters();
        parameters.setArea1(1.99);
        
        assertFalse(licService.evaluateLICById(3, points, parameters), "cmv3 should return true when there exists a triangle made up of three consuectuive points that have an area larger than AREA1");
    }
    
    @Test
    void cmv3Test3() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(4.920, 3.722),
            new Point(4.768, 4.082),
            new Point(3.694, 3.947),
            new Point(4.663, 4.405),
            new Point(4.294, 4.265),
            new Point(4.713, 4.834),
            new Point(3.742, 4.850),
            new Point(3.883, 3.723),
            new Point(3.292, 4.547),
            new Point(3.566, 3.017)
        );
        
        Parameters parameters = new Parameters();
        parameters.setArea1(2.0);
        assertFalse(licService.evaluateLICById(3, points, parameters), "cmv3 should return false when no three consecutive points form a triangle with area larger than AREA1");
    }
}
