package group6.common;

/**
 * This class defines global constants used across the application.
 */
public class Constants {

    /**
     * Math-related constants
     */
    public static final double PI = 3.1415926535;

    /**
     * Default values
     */
    public static final int DEFAULT_MATRIX_SIZE = 15;
    public static final int MAX_NUM_POINTS = 100;
    public static final int MIN_NUM_POINTS = 2;

    /**
     * Enum representing the logical connector types.
     */
    public enum ConnectorType {
        NOTUSED, ORR, ANDD
    }

    /**
     * Enum representing the comparison types.
     */
    public enum ComparisonType {
        LT, EQ, GT
    }

    /**
     * Error messages
     */
    public static final String ERROR_INVALID_INPUT = "Input data is invalid.";
}
