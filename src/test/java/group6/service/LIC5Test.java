package group6.service;

import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC5Test {

    /**
     * Test case checking wether evaluateLIC5 evalutes to true
     * @Test: Verfies that function returns true, since X[2]<X[0] 
     */
    @Test
    public void evaluateLIC5True(){
        //Act 
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(4, 0),
                new Point(2, 0)
        );
        
        //Assert
        assertTrue(licService.evaluateLICById(5, points, parameters));
    }


    /**
     * Test case checking wether evaluateLIC5 evalutes to false
     * @Test: Verfies that function returns true, since X[0]<X[1]<X[2] 
     */
    @Test 
    public void evaluateLIC5False(){
        //Act 
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
                new Point(-2, 0),
                new Point(4, 0),
                new Point(5, 0)
        );

        //Assert
        assertFalse(licService.evaluateLICById(5, points, parameters));
    }
}
