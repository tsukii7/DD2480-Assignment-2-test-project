package group6.model;

/**
 * Stores configuration parameters for evaluating Launch Interceptor Conditions (LICs).
 * <p>
 * Each parameter corresponds to a specific input required for LIC evaluations.
 * These parameters include lengths, radii, angles, areas, and other constraints.
 * </p>
 */
public class Parameters {

    // Fields corresponding to LIC input parameters
    private double LENGTH1;  // Length in LICs 0, 7, 12
    private double RADIUS1;  // Radius in LICs 1, 8, 13
    private double EPSILON;  // Deviation from PI in LICs 2, 9
    private double AREA1;    // Area in LICs 3, 10, 14
    private int Q_PTS;       // Number of consecutive points in LIC 4
    private int QUADS;       // Number of quadrants in LIC 4
    private double DIST;     // Distance in LIC 6
    private int N_PTS;       // Number of consecutive points in LIC 6
    private int K_PTS;       // Number of interval points in LICs 7, 12
    private int A_PTS;       // Number of interval points in LICs 8, 13
    private int B_PTS;       // Number of interval points in LICs 8, 13
    private int C_PTS;       // Number of interval points in LIC 9
    private int D_PTS;       // Number of interval points in LIC 9
    private int E_PTS;       // Number of interval points in LICs 10, 14
    private int F_PTS;       // Number of interval points in LICs 10, 14
    private int G_PTS;       // Number of interval points in LIC 11
    private double LENGTH2;  // Maximum length in LIC 12
    private double RADIUS2;  // Maximum radius in LIC 13
    private double AREA2;    // Maximum area in LIC 14

    /**
     * Constructs a Parameters object with the specified values for all parameters.
     *
     * @param LENGTH1  Length parameter for LICs 0, 7, 12
     * @param RADIUS1  Radius parameter for LICs 1, 8, 13
     * @param EPSILON  Deviation from PI in LICs 2, 9
     * @param AREA1    Area parameter for LICs 3, 10, 14
     * @param Q_PTS    Number of consecutive points in LIC 4
     * @param QUADS    Number of quadrants in LIC 4
     * @param DIST     Distance parameter for LIC 6
     * @param N_PTS    Number of consecutive points in LIC 6
     * @param K_PTS    Number of interval points in LICs 7, 12
     * @param A_PTS    Number of interval points in LICs 8, 13
     * @param B_PTS    Number of interval points in LICs 8, 13
     * @param C_PTS    Number of interval points in LIC 9
     * @param D_PTS    Number of interval points in LIC 9
     * @param E_PTS    Number of interval points in LICs 10, 14
     * @param F_PTS    Number of interval points in LICs 10, 14
     * @param G_PTS    Number of interval points in LIC 11
     * @param LENGTH2  Maximum length in LIC 12
     * @param RADIUS2  Maximum radius in LIC 13
     * @param AREA2    Maximum area in LIC 14
     */
    public Parameters(double LENGTH1, double RADIUS1, double EPSILON, double AREA1, int Q_PTS, int QUADS,
                      double DIST, int N_PTS, int K_PTS, int A_PTS, int B_PTS, int C_PTS, int D_PTS, int E_PTS,
                      int F_PTS, int G_PTS, double LENGTH2, double RADIUS2, double AREA2) {
        this.LENGTH1 = LENGTH1;
        this.RADIUS1 = RADIUS1;
        this.EPSILON = EPSILON;
        this.AREA1 = AREA1;
        this.Q_PTS = Q_PTS;
        this.QUADS = QUADS;
        this.DIST = DIST;
        this.N_PTS = N_PTS;
        this.K_PTS = K_PTS;
        this.A_PTS = A_PTS;
        this.B_PTS = B_PTS;
        this.C_PTS = C_PTS;
        this.D_PTS = D_PTS;
        this.E_PTS = E_PTS;
        this.F_PTS = F_PTS;
        this.G_PTS = G_PTS;
        this.LENGTH2 = LENGTH2;
        this.RADIUS2 = RADIUS2;
        this.AREA2 = AREA2;
    }

    public Parameters() {
        this.LENGTH1 = 0;
        this.RADIUS1 = 0;
        this.EPSILON = 0;
        this.AREA1 = 0;
        this.Q_PTS = 0;
        this.QUADS = 0;
        this.DIST = 0;
        this.N_PTS = 0;
        this.K_PTS = 0;
        this.A_PTS = 0;
        this.B_PTS = 0;
        this.C_PTS = 0;
        this.D_PTS = 0;
        this.E_PTS = 0;
        this.F_PTS = 0;
        this.G_PTS = 0;
        this.LENGTH2 = 0;
        this.RADIUS2 = 0;
        this.AREA2 = 0;
    }

    // Getters
    public double getLength1() { return LENGTH1; }
    public double getRadius1() { return RADIUS1; }
    public double getEpsilon() { return EPSILON; }
    public double getArea1() { return AREA1; }
    public int getQPts() { return Q_PTS; }
    public int getQuads() { return QUADS; }
    public double getDist() { return DIST; }
    public int getNPts() { return N_PTS; }
    public int getKPts() { return K_PTS; }
    public int getAPts() { return A_PTS; }
    public int getBPts() { return B_PTS; }
    public int getCPts() { return C_PTS; }
    public int getDPts() { return D_PTS; }
    public int getEPts() { return E_PTS; }
    public int getFPts() { return F_PTS; }
    public int getGPts() { return G_PTS; }
    public double getLength2() { return LENGTH2; }
    public double getRadius2() { return RADIUS2; }
    public double getArea2() { return AREA2; }

    // Setters
    public void setLength1(double LENGTH1) { this.LENGTH1 = LENGTH1; }
    public void setRadius1(double RADIUS1) { this.RADIUS1 = RADIUS1; }
    public void setEpsilon(double EPSILON) { this.EPSILON = EPSILON; }
    public void setArea1(double AREA1) { this.AREA1 = AREA1; }
    public void setQPts(int Q_PTS) { this.Q_PTS = Q_PTS; }
    public void setQuads(int QUADS) { this.QUADS = QUADS; }
    public void setDist(double DIST) { this.DIST = DIST; }
    public void setNPts(int N_PTS) { this.N_PTS = N_PTS; }
    public void setKPts(int K_PTS) { this.K_PTS = K_PTS; }
    public void setAPts(int A_PTS) { this.A_PTS = A_PTS; }
    public void setBPts(int B_PTS) { this.B_PTS = B_PTS; }
    public void setCPts(int C_PTS) { this.C_PTS = C_PTS; }
    public void setDPts(int D_PTS) { this.D_PTS = D_PTS; }
    public void setEPts(int E_PTS) { this.E_PTS = E_PTS; }
    public void setFPts(int F_PTS) { this.F_PTS = F_PTS; }
    public void setGPts(int G_PTS) { this.G_PTS = G_PTS; }
    public void setLength2(double LENGTH2) { this.LENGTH2 = LENGTH2; }
    public void setRadius2(double RADIUS2) { this.RADIUS2 = RADIUS2; }
    public void setArea2(double AREA2) { this.AREA2 = AREA2; }
}
