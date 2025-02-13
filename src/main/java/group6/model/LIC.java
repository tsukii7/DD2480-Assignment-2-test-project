
package group6.model;
import java.util.List;
import java.lang.Math;
import java.util.function.Predicate;
import group6.util.MathUtil;
import static group6.util.MathUtil.computeAngle;

/**
 * Implements logic for all Launch Interceptor Conditions (LICs).
 */
public class LIC {
    /**
     * todo: Evaluates LIC0: Checks if any two points are farther apart than LENGTH1.
     *
     * @param points     the list of points
     * @param parameters the configuration parameters
     * @return true if the condition is satisfied, false otherwise
     */
    public boolean evaluateLIC0(List<Point> points, Parameters parameters) {
        for (int i = 0; i < points.size() - 1; i++) {
            double distance = Math.sqrt(Math.pow(points.get(i+1).getX() - points.get(i).getX(), 2) + Math.pow(points.get(i+1).getY() - points.get(i).getY(), 2));
            if (distance > parameters.getLength1()) {
                return true;
            }
        }
        return false;
    }

    /**
     * There exists at least one set of three consecutive data points that cannot all be contained
     * within or on a circle of radius RADIUS1
     * 
     * @param points the list of points
     * @param parameters the configuration parameters
     * @return true if requirement LIC 1 is satisfied
     */
    public static boolean evaluateLIC1(List<Point> points, Parameters parameters){
        

        //Checks for every set of three consequtive datapoints
        for(int i=0; i<points.size()-2;i++){

            double[] Xpoints ={points.get(i).getX(), points.get(i+1).getX(), points.get(i+2).getX()};
            double[] Ypoints ={points.get(i).getY(), points.get(i+1).getY(), points.get(i+2).getY()};

            if (MathUtil.pointsDontFitInCircle(Xpoints, Ypoints, parameters.getRadius1())){
                return true;
            }
        }
        return false;

    }



    /**
     * There exists at least one set of two consecutive data points
     * (X[i],Y[i]) and (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1) 
     * 
     * @param points the list of points
     * @param parameters the configuration parameters
     * @return true if requirement LIC 5 is satisfied
     */
    public boolean evaluateLIC5(List<Point> points, Parameters parameters){

        //checks for two consecutive datapoints
        for(int i=0; i<points.size()-1;i++){

            // checks X[i+1] - X[i] < 0
            if(points.get(i+1).getX()-points.get(i).getX()<0){
                return true;
            }           
        }
        return false;
    }

    public boolean evaluateLIC7(List<Point> points, Parameters parameters) {
        if (points.size() < 3) {
            return false;
        }
        for (int i = 0; i < points.size() - parameters.getKPts() - 1; i++) {
            double distance = Math.sqrt(Math.pow(points.get(i + parameters.getKPts() + 1).getX() - points.get(i).getX(), 2) + Math.pow(points.get(i + parameters.getKPts() + 1).getY() - points.get(i).getY(), 2));
            if (distance > parameters.getLength1()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean evaluateLIC3(List<Point> points, Parameters parameters) {
        double AREA1 = parameters.getArea1();

        if ( AREA1 < 0 ) {
            return false;
        }
        Predicate<Double> condition = a -> (a > AREA1);
        return MathUtil.existsTriangleWithCondition(points, 0, 0, condition);
    }
    
    public boolean evaluateLIC10(List<Point> points, Parameters parameters) {
        int E_PTS = parameters.getEPts();
        int F_PTS = parameters.getFPts();
        int NUMPOINTS = points.size();
        double AREA1 = parameters.getArea1();

        if ( NUMPOINTS < 5 || E_PTS < 1 || F_PTS < 1 || NUMPOINTS - 3 < E_PTS + F_PTS) {
            return false;
        }
        Predicate<Double> condition = a -> (a > AREA1);
        return MathUtil.existsTriangleWithCondition(points, E_PTS, F_PTS, condition);
    }
    
    public boolean evaluateLIC14(List<Point> points, Parameters parameters) {
        int E_PTS = parameters.getEPts();
        int F_PTS = parameters.getFPts();
        int NUMPOINTS = points.size();
        double AREA1 = parameters.getArea1();
        double AREA2 = parameters.getArea2();

        if ( NUMPOINTS < 5 || AREA2 < 0 ) {
            return false;
        }
        Predicate<Double> condition1 = a -> (a > AREA1);
        Predicate<Double> condition2 = a -> (a < AREA2);
        
        return MathUtil.existsTriangleWithCondition(points, E_PTS, F_PTS, condition1) && MathUtil.existsTriangleWithCondition(points, E_PTS, F_PTS, condition2);
    }

    public boolean evaluateLIC12(List<Point> points, Parameters parameters) {
        if (points.size() < 3) {
            return false;
        }
        boolean con1 = false;
        boolean con2 = false;

        for (int i = 0; i < points.size() - parameters.getKPts() - 1; i++) {
            double distance = Math.sqrt(Math.pow(points.get(i + parameters.getKPts() + 1).getX() - points.get(i).getX(), 2) + Math.pow(points.get(i + parameters.getKPts() + 1).getY() - points.get(i).getY(), 2));
            if (distance > parameters.getLength1()) con1 = true;
            if (distance < parameters.getLength2()) con2 = true;
            if (con1 && con2) return true;
        }
        return false;
    }

    public boolean evaluateLIC4(List<Point> points, Parameters parameters) {
        if (points.size() < parameters.getQPts()) {
            return false;
        }
        int count = 0;
        boolean[] quadrants = new boolean[4];
        
        for (int i = 0; i <= points.size() - parameters.getQPts(); i++) {
            for (int j = 0; j < parameters.getQPts(); j++) {
                double x = points.get(i+j).getX();
                double y = points.get(i+j).getY();

                if (x >= 0 && y >= 0) quadrants[0] = true; // Quadrant I
                if (x < 0 && y >= 0) quadrants[1] = true; // Quadrant II
                if (x <= 0 && y < 0) quadrants[2] = true; // Quadrant III
                if (x > 0 && y < 0) quadrants[3] = true; // Quadrant IV
            }
        }
        for (int k = 0; k < quadrants.length; k++) {
            if (quadrants[k]) {
                count++;
                if (count > parameters.getQuads()) return true;
            }
        }
        return false;
    }


    public boolean evaluateLIC2(List<Point> points, Parameters parameters){
        int numpoints = points.size();
        double EPSILON = parameters.getEpsilon();
        int index = 0;
        while (index+2 < numpoints){
            double angle = computeAngle(points.get(index).getX(), points.get(index).getY(),
                    points.get(index+1).getX(), points.get(index+1).getY(),
                    points.get(index+2).getX(), points.get(index+2).getY());
            if(angle < (Math.PI - EPSILON) || angle > (Math.PI + EPSILON)) {
                return true;
            }
            else{
                index += 1;
            }
        }
        return false;
    }

    public boolean evaluateLIC6(List<Point> points, Parameters parameters){
        int numpoints = points.size();
        int N_PTS = parameters.getNPts();
        double DIST = parameters.getDist();
        if(numpoints < 3){
            return false;
        }
        int index = 0;
        while (index+N_PTS < numpoints+1){

            double[] p0 = {points.get(index).getX(), points.get(index).getY()};
            double[] pn = {points.get(index+N_PTS-1).getX(), points.get(index+N_PTS-1).getY()};
            //to avoid repeated computation calculate the factors of the equation of the line P0-Pn
            double a = pn[1] - p0[1];
            double b = p0[0] - pn[0];
            double c = pn[0] * p0[1] - pn[1] * p0[0];
            //overlapping points case
            if(a == 0 && b == 0){
                for(int i = 1; i < numpoints -1; i++){
                    double distance = Math.sqrt(points.get(i).getX()*points.get(i).getX() + points.get(i).getY()*points.get(i).getY());
                    if(distance > DIST){
                        return true;
                    }
                }
            } else {
                for(int i = 1; i < numpoints -1; i++){
                    double distance = Math.abs(a*points.get(i).getX() + b*points.get(i).getY() + c) / Math.sqrt(a*a + b*b);
                    if(distance > DIST){
                        return true;
                    }
                }
            }
            index += 1;

        }
        return false;
    }

    /**
     * There exists at least one set of three data points separated by exactly A PTS and B PTS
     * consecutive intervening points, respectively, that cannot be contained within or on a circle of
     * radius RADIUS1. The condition is not met when NUMPOINTS < 5
     * 
     * @param points the list of points
     * @param parameters the configuration parameters
     * @return true if requirement LIC 8 is satisfied
     */
    public static boolean evaluateLIC8(List<Point> points, Parameters parameters){
        int A_PTS=parameters.getAPts();
        int B_PTS=parameters.getBPts();


        if (!(1<=A_PTS && 1<=B_PTS && A_PTS+B_PTS<=(points.size()-3))){
            return false;
        }

        for(int i=0; i<points.size()-(A_PTS+B_PTS+2);i++){
            double[] Xpoints ={points.get(i).getX(), points.get(i+A_PTS+1).getX(), points.get(i+A_PTS+B_PTS+2).getX()};
            double[] Ypoints ={points.get(i).getY(), points.get(i+A_PTS+1).getY(), points.get(i+A_PTS+B_PTS+2).getY()};

            if (MathUtil.pointsDontFitInCircle(Xpoints, Ypoints, parameters.getRadius1())){
                return true;
            }

        }
        return false;

    }

    public boolean evaluateLIC9(List<Point> points, Parameters parameters){
        int numpoints = points.size();
        int C_PTS = parameters.getCPts();
        int D_PTS = parameters.getDPts();
        double EPSILON = parameters.getEpsilon();
        if(numpoints < 5){
            return false;
        }
        int index = 0;
        while (index+C_PTS+D_PTS+2 < numpoints){
            double angle = computeAngle(points.get(index).getX(), points.get(index).getY(),
                    points.get(index+C_PTS+1).getX(), points.get(index+C_PTS+1).getY(),
                    points.get(index+C_PTS+D_PTS+2).getX(), points.get(index+C_PTS+D_PTS+2).getY());
            if(angle < (Math.PI - EPSILON) || angle > (Math.PI + EPSILON)) {
                return true;
            }
            else{
                index += 1;
            }
        }
        return false;
    }
    public boolean evaluateLIC11(List<Point> points, Parameters parameters){
        int numpoints = points.size();
        int G_PTS = parameters.getGPts();
        if(numpoints < 3){
            return false;
        }
        int index = 0;
        while (index+G_PTS +1< numpoints){
            if((points.get(index+G_PTS+1).getX() - points.get(index).getX()) < 0){
                return true;
            }
            index += 1;
        }
        return false;
    }

     /**
     * There exists at least one set of three data points, separated by exactly A PTS and B PTS
     * consecutive intervening points, respectively, that cannot be contained within or on a circle of
     * radius RADIUS1. In addition, there exists at least one set of three data points (which can be
     * the same or different from the three data points just mentioned) separated by exactly A PTS
     * and B PTS consecutive intervening points, respectively, that can be contained in or on a
     * circle of radius RADIUS2. Both parts must be true for the LIC to be true. The condition is not met when NUMPOINTS < 5.
     * 
     * @param points the list of points
     * @param parameters the configuration parameters
     * @return true if requirement LIC 13 is satisfied
     */
    public static boolean evaluateLIC13(List<Point> points, Parameters parameters){
        int A_PTS=parameters.getAPts();
        int B_PTS=parameters.getBPts();

        if (!(1<=A_PTS && 1<=B_PTS && A_PTS+B_PTS<=(points.size()-3))){
            return false;
        }
        
        boolean circle1=false;
        boolean circle2=false;

        for(int i=0; i<points.size()-(A_PTS+B_PTS+2);i++){
            double[] Xpoints ={points.get(i).getX(), points.get(i+A_PTS+1).getX(), points.get(i+A_PTS+B_PTS+2).getX()};
            double[] Ypoints ={points.get(i).getY(), points.get(i+A_PTS+1).getY(), points.get(i+A_PTS+B_PTS+2).getY()};

            if (MathUtil.pointsDontFitInCircle(Xpoints, Ypoints, parameters.getRadius1())){
                circle1=true;
            }
            if (!MathUtil.pointsDontFitInCircle(Xpoints, Ypoints, parameters.getRadius2())){
                circle2=true;
            }
            if (circle1 && circle2){
                return true;
            }

        }
        return false;

    }

}









    


   