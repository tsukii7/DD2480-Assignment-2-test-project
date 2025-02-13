package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC10Test {
    @Test
    void cmv10Test1() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(0.0, 0.0),
            new Point(0.0, 0.0),
            new Point(0.0, 0.0),
            new Point(2.0, 0.0),
            new Point(0.0, 0.0),
            new Point(0.0, 0.0),
            new Point(0.0, 0.0),
            new Point(1.0, 2.0)
        );

        Parameters parameters = new Parameters();
        parameters.setArea1(1.99);
        parameters.setEPts(2);
        parameters.setFPts(3);
        
        assertTrue(licService.evaluateLICById(10, points, parameters), "cmv10 should return true when three points separated by E_PTS and F_PTS respectively form a triangle with area larger than AREA1");
    }

    @Test
    public void cmv10Test2() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(675.299, 675.299),
            new Point(649.155, 649.155),
            new Point(787.103, 787.103),
            new Point(30.356, 30.356),
            new Point(518.131, 518.131),
            new Point(306.236, 306.236),
            new Point(466.805, 466.805),
            new Point(643.529, 643.529),
            new Point(356.091, 356.091),
            new Point(853.476, 853.476)
        );

        Parameters parameters = new Parameters();
        parameters.setArea1(0.0);
        parameters.setEPts(5);
        parameters.setFPts(3);
        
        assertFalse(licService.evaluateLICById(10, points, parameters), "cmv10 should return false when E_PTS + F_PTS are larger than NUMPOINTS - 3");
    }
    
    @Test
    public void cmv10Test3() {
        LICService licService = new LICService();
        List<Point> points = Arrays.asList(
            new Point(0.0, 0.0),
            new Point(1.0, 1.0),
            new Point(2.0, 2.0),
            new Point(3.0, 3.0),
            new Point(4.0, 4.0)
        );

        Parameters parameters = new Parameters();
        parameters.setArea1(0.0);
        parameters.setEPts(0);
        parameters.setFPts(1);

        assertFalse(licService.evaluateLICById(10, points, parameters), "cmv10 should return false when E_PTS or F_PTS is smaller than 1");
    }
}
