package group6.model;

/**
 * Represents a 2D data point with x and y coordinates.
 */
public class Point {
    private final double x;
    private final double y;

    /**
     * Constructs a Point with the given coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of this point.
     *
     * @return the x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of this point.
     *
     * @return the y-coordinate
     */
    public double getY() {
        return y;
    }
}
