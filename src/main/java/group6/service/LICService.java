package group6.service;

import group6.matrix.ConditionsMetVector;
import group6.model.LIC;
import group6.model.Parameters;
import group6.model.Point;

import java.util.List;

/**
 * Provides services for evaluating individual Launch Interceptor Conditions (LICs).
 */
public class LICService {

    private final LIC lic;

    /**
     * Constructs a new LIC service.
     */
    public LICService() {
        this.lic = new LIC();
    }

    /**
     * Evaluates a specific LIC by ID.
     *
     * @param licId      the ID of the LIC to evaluate (0-14)
     * @param points     the list of points
     * @param parameters the parameters for the evaluation
     * @return true if the condition is satisfied, false otherwise
     */
    public boolean evaluateLICById(int licId, List<Point> points, Parameters parameters) {
        switch (licId) {
            case 0:
                return lic.evaluateLIC0(points, parameters);
            case 1: 
                return lic.evaluateLIC1(points, parameters);
            case 8:
                return lic.evaluateLIC8(points, parameters);
            case 13:
                return lic.evaluateLIC13(points, parameters);
            case 3:
                return lic.evaluateLIC3(points, parameters);
            case 10:
                return lic.evaluateLIC10(points, parameters);
            case 14:
                return lic.evaluateLIC14(points, parameters);
            case 4:
                return lic.evaluateLIC4(points, parameters);
            case 5: 
                return lic.evaluateLIC5(points, parameters);
            case 7:
                return lic.evaluateLIC7(points, parameters);
            case 12:
                return lic.evaluateLIC12(points, parameters);
            case 2:
                return lic.evaluateLIC2(points, parameters);
            case 6:
                return lic.evaluateLIC6(points, parameters);
            case 9:
                return lic.evaluateLIC9(points, parameters);
            case 11:
                return lic.evaluateLIC11(points, parameters);
            default:
                throw new IllegalArgumentException("Invalid LIC ID: " + licId);
        }
    }


    /**
     * Validates the parameter bounds according to the requirements.
     *
     * @param parameters the parameters to validate
     * @param numPoints  the number of points in the input
     */
    private void validateParameters(Parameters parameters, int numPoints) {
        if (numPoints < 2 || numPoints > 100) {
            throw new IllegalArgumentException("NUMPOINTS must be between 2 and 100.");
        }
        
        if (parameters.getLength1() < 0 || parameters.getLength2() < 0) {
            throw new IllegalArgumentException("LENGTH1 and LENGTH2 must be non-negative.");
        }
        
        if (parameters.getRadius1() < 0 || parameters.getRadius2() < 0) {
            throw new IllegalArgumentException("RADIUS1 and RADIUS2 must be non-negative.");
        }
        
        if (parameters.getEpsilon() < 0 || parameters.getEpsilon() >= Math.PI) {
            throw new IllegalArgumentException("EPSILON must be in the range [0, PI).");
        }
        
        if (parameters.getArea1() < 0 || parameters.getArea2() < 0) {
            throw new IllegalArgumentException("AREA1 and AREA2 must be non-negative.");
        }
        
        if (parameters.getQPts() < 2 || parameters.getQPts() > numPoints) {
            throw new IllegalArgumentException("Q_PTS must be between 2 and NUMPOINTS.");
        }
        
        if (parameters.getQuads() < 1 || parameters.getQuads() > 3) {
            throw new IllegalArgumentException("QUADS must be between 1 and 3.");
        }
        
        if (parameters.getDist() < 0) {
            throw new IllegalArgumentException("DIST must be non-negative.");
        }
        
        if (parameters.getNPts() < 3 || parameters.getNPts() > numPoints) {
            throw new IllegalArgumentException("N_PTS must be between 3 and NUMPOINTS.");
        }
        
        if (parameters.getKPts() < 1 || parameters.getKPts() > (numPoints - 2)) {
            throw new IllegalArgumentException("K_PTS must be between 1 and NUMPOINTS - 2.");
        }
        
        if (parameters.getAPts() < 1 || parameters.getBPts() < 1 || parameters.getAPts() + parameters.getBPts() > numPoints - 3) {
            throw new IllegalArgumentException("A_PTS and B_PTS must be at least 1 and their sum must be at most NUMPOINTS - 3.");
        }
        
        if (parameters.getCPts() < 1 || parameters.getDPts() < 1 || parameters.getCPts() + parameters.getDPts() > numPoints - 3) {
            throw new IllegalArgumentException("C_PTS and D_PTS must be at least 1 and their sum must be at most NUMPOINTS - 3.");
        }
        
        if (parameters.getEPts() < 1 || parameters.getFPts() < 1 || parameters.getEPts() + parameters.getFPts() > numPoints - 3) {
            throw new IllegalArgumentException("E_PTS and F_PTS must be at least 1 and their sum must be at most NUMPOINTS - 3.");
        }
        
        if (parameters.getGPts() < 1 || parameters.getGPts() > numPoints - 2) {
            throw new IllegalArgumentException("G_PTS must be between 1 and NUMPOINTS - 2.");
        }
    }

    /**
     * Evaluates all LICs and sets the results in the Conditions Met Vector (CMV).
     *
     * @param cmv        the Conditions Met Vector
     * @param points     the list of points
     * @param parameters the parameters for the evaluation
     */
    public void evaluateAllLICs(ConditionsMetVector cmv, List<Point> points, Parameters parameters) {
        validateParameters(parameters, points.size());

        for (int i = 0; i < 15; i++) {
            cmv.setConditionMet(i, evaluateLICById(i, points, parameters));
        }
    }
}
