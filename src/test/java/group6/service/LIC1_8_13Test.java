package group6.service;

import group6.util.MathUtil;
import group6.model.Parameters;
import group6.model.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LIC1_8_13Test{


    /**
     * Test case checking whether distance() returns correct computed answers 
     * test1: p1=(0,0), p2=(0,0)-> 0
     * test2: p1=(3,4), p2=(0,0)-> 5
     * test3: p1=(-3,-4), p2=(0,0)-> 5
     * @Test: Verfies that the function returns expected distanced for points  
     */
    @Test
    public void testCorrectDistance(){
        
        assertEquals(0.0, MathUtil.distance(0.0, 0.0, 0.0, 0.0));
        assertEquals(5.0, MathUtil.distance(3.0, 4.0, 0.0, 0.0));
        assertEquals(5.0, MathUtil.distance(-3.0, -4.0, 0.0, 0.0));
  
    }  

    /**
     * Test case checking wether evaluateLIC1 returns false since points fit in circle
     * test1: p1=(0,0), p2=(1,0), p3=(0,1), r=1 -> false
     * test2: p1=(0,0), p2=(1,0), p3=(0,1), r=1 -> false
     * @Test: Verfies that the function returns false
     */
    @Test
    public void testLIC1False(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        Parameters parameters2 = new Parameters();
        List<Point> points1 = Arrays.asList(
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        ); 
        List<Point> points2 = Arrays.asList(
            new Point(0, 0),
            new Point(2, 0),
            new Point(0, 2),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)

        );
        parameters.setRadius1(1);
        parameters2.setRadius1(2);
        
        //Assert
        assertFalse(licService.evaluateLICById(1, points1, parameters));
        assertFalse(licService.evaluateLICById(1, points2, parameters2));


    }

    /**
     * Test case checking wether evaluateLIC1 returns true since points don't fit in circle
     * test1: p1=(0,0), p2=(1,0), p3=(0,1), r=0.5 -> true
     * test2: p1=(0,0), p2=(3,0), p3=(0,3), r=1 -> true
     * @Test: Verfies that the function returns  true
     */
    @Test
    public void testLIC1True(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        Parameters parameters2 = new Parameters();
        List<Point> points1 = Arrays.asList(
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        ); 
        List<Point> points2 = Arrays.asList(
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 3),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)

        );
        parameters.setRadius1(0.5);
        parameters2.setRadius1(1);
        
        //Assert
        assertTrue(licService.evaluateLICById(1, points1, parameters));
        assertTrue(licService.evaluateLICById(1, points2, parameters2));

    }

    /**
     * Test case checking wether evaluateLIC8 returns false
     * and there exist sets of three consequtive points intervened by A_PTS and B_PTS that fit in a circle
     * test: p1=(0,2), p2=(3,0), p3=(-2,-1), r=3 -> false
     * @Test: Verfies that the function returns false
     */
    @Test
    public void testLIC8False(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(0, 2),
            new Point(2, 0),
            new Point(3, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(-2, -1)

        );
        parameters.setRadius1(3);
        parameters.setAPts(1);
        parameters.setBPts(2);
 
        
        //Assert
        assertFalse(licService.evaluateLICById(8, points, parameters));

    }

    /**
     * Test case checking wether evaluateLIC8 returns true
     * and there exist at least a set of three consequtive points intervened by A_PTS and B_PTS that don't fit in a circle
     * test: p1=(0,4), p2=(-5,0), p3=(3,3), r=3 -> true
     * @Test: Verfies that the function returns true
     */
    @Test
    public void testLIC8True(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(0, 4),
            new Point(0, 0),
            new Point(-5, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(3, 3)

        );
        parameters.setRadius1(3);
        parameters.setAPts(1);
        parameters.setBPts(2);

        //Assert
        assertTrue(licService.evaluateLICById(8, points, parameters));
    }

     /**
     * Test case checking wether evaluateLIC8 returns false
     * since number of points is < 5
     * @Test: Verfies that the function returns false
     */
    @Test
    public void notEnoughPointsLIC8(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(2, 2),
            new Point(3, 0),
            new Point(-2, -1)

        );
        parameters.setRadius1(3);
        parameters.setAPts(1);
        parameters.setBPts(1);
        
        //Assert
        assertFalse(licService.evaluateLICById(8, points, parameters));

    }


    /**
     * Test case checking wether evaluateLIC13 returns false
     * and there exist three consequtive points intervened by A_PTS and B_PTS that fit two circles respectivley
     * @Test: Verfies that the function returns false
     */
    @Test
    public void testLIC13False(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(3, 2),
            new Point(Double.NaN, Double.NaN),
            new Point(-2, 3),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(0, -4)

        );
        parameters.setRadius1(4);
        parameters.setRadius2(5);
        parameters.setAPts(1);
        parameters.setBPts(2);

        //Assert
        assertFalse(licService.evaluateLICById(13, points, parameters));

    }

     /**
     * Test case checking wether evaluateLIC13 returns true
     * and there exist set of three consequtive points intervened by A_PTS and B_PTS that dont fit radius 1 and fit radius 2
     * @Test: Verfies that the function returns true
     */
    @Test
    public void testLIC13TrueOneRadius(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(2, 2),
            new Point(Double.NaN, Double.NaN),
            new Point(3, 0),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-2, -1)

        );
        parameters.setRadius1(1);
        parameters.setRadius2(3);
        parameters.setAPts(1);
        parameters.setBPts(2);
        //Assert
        assertTrue(licService.evaluateLICById(13, points, parameters));

    }

     /**
     * Test case checking wether evaluateLIC13 returns false
     * and there exist set of three consequtive points intervened by A_PTS and B_PTS that fit radius 1 and not radius 2
     * @Test: Verfies that the function returns false
     */
    @Test
    public void testLIC13FalseOneRadius(){
        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(2, 2),
            new Point(Double.NaN, Double.NaN),
            new Point(3, 0),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-2, -1)

        );
        parameters.setRadius1(3);
        parameters.setRadius2(1);
        parameters.setAPts(1);
        parameters.setBPts(2);
        //Assert
        assertFalse(licService.evaluateLICById(13, points, parameters));

    }

     /**
     * Test case checking wether evaluateLIC13 returns true
     * and there exist at least a set of three consequtive points intervened by A_PTS and B_PTS that don't fit in the two circles 
     * @Test: Verfies that the function returns true
     */
    @Test
    public void testLIC13FalseNoRadius(){

        //Act
        LICService licService = new LICService();
        Parameters parameters = new Parameters();
        List<Point> points = Arrays.asList(
            new Point(2, 2),
            new Point(Double.NaN, Double.NaN),
            new Point(3, 0),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-2, -1),
            new Point(0.5, 0.5),
            new Point(Double.NaN, Double.NaN),
            new Point(0.2, -1),
            new Point(Double.NaN, Double.NaN),
            new Point(Double.NaN, Double.NaN),
            new Point(-2, 0)

        );
        parameters.setRadius1(0.5);
        parameters.setRadius2(1);
        parameters.setAPts(1);
        parameters.setBPts(2);

        //Assert
        assertFalse(licService.evaluateLICById(13, points, parameters));


    }


}
