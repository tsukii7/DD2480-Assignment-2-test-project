package group6.util;

import group6.common.Constants;

public class ValidationUtil {

    /**
     * Checks if the given number of points is valid.
     *
     * @param numPoints the number of points
     * @return true if the number of points is valid, false otherwise
     */
    public static boolean isValidPointCount(int numPoints) {
        return numPoints >= Constants.MIN_NUM_POINTS && numPoints <= Constants.MAX_NUM_POINTS;
    }
}
