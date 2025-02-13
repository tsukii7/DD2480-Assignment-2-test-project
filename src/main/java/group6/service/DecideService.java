package group6.service;

import group6.common.Constants;
import group6.matrix.*;
import group6.model.Parameters;
import group6.model.Point;
import group6.util.ValidationUtil;

import java.util.List;


/**
 * Orchestrates the DECIDE program by integrating LIC evaluations,
 * matrix operations, and decision-making logic.
 */
public class DecideService {

    private final LICService licService = new LICService();

    private final int numPoints;
    private final List<Point> points;
    private final Parameters parameters;

    private final ConditionsMetVector cmv;
    private final LogicalConnectorMatrix lcm;
    private final PreliminaryUnlockingVector puv;

    private final PreliminaryUnlockingMatrix pum;
    private final FinalUnlockingVector fuv;

    private boolean lancuch;

    /**
     * Constructs a DecideService with the specified parameters.
     *
     * @param numPoints   the number of points
     * @param points      the list of points
     * @param parameters  the configuration parameters
     * @param lcm         the Logical Connector Matrix
     * @param puv         the Preliminary Unlocking Vector
     */
    public DecideService(int numPoints, List<Point> points, Parameters parameters, LogicalConnectorMatrix lcm, PreliminaryUnlockingVector puv) {
        if (!ValidationUtil.isValidPointCount(numPoints)) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_INPUT);
        }

        this.numPoints = numPoints;
        this.points = points;
        this.parameters = parameters;

        this.lcm = lcm;
        this.puv = puv;

        this.cmv = new ConditionsMetVector(Constants.DEFAULT_MATRIX_SIZE);
        this.pum = new PreliminaryUnlockingMatrix(Constants.DEFAULT_MATRIX_SIZE);
        this.fuv = new FinalUnlockingVector(Constants.DEFAULT_MATRIX_SIZE);
    }

    /**
     * Runs the DECIDE program to evaluate if a launch decision is true or false.
     *
     * @return true if the launch is approved, false otherwise
     */
    public boolean makeLaunchDecision() {
        // Step 1: Evaluate all LIC conditions
        licService.evaluateAllLICs(cmv, points, parameters);

        // Step 2: Generate the Preliminary Unlocking Matrix (PUM)
        pum.generatePUM(cmv, lcm);

        // Step 3: Generate the Final Unlocking Vector (FUV)
        fuv.generateFUV(pum, puv);

        // Step 4: Make the final decision based on the FUV
        lancuch = fuv.isLaunchDecisionApproved();

        return lancuch;
    }
}
