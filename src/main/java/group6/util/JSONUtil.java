package group6.util;

import java.util.List;
import java.util.Arrays;

import group6.matrix.LogicalConnectorMatrix;
import group6.matrix.PreliminaryUnlockingVector;
import group6.model.Parameters;
import group6.model.Point;
import group6.common.Constants.ConnectorType;

import group6.service.DecideService;

import org.json.JSONObject;
import org.json.JSONArray;

public class JSONUtil {
    public static DecideService parseJSON(String file) {
        JSONObject jsonObject = new JSONObject(file);
        Parameters PARAMETERS = new Parameters();
        JSONObject jsonParam = jsonObject.getJSONObject("PARAMETERS");
        
        PARAMETERS.setLength1(jsonParam.getDouble("LENGTH1"));
        PARAMETERS.setRadius1(jsonParam.getDouble("RADIUS1"));
        PARAMETERS.setEpsilon(jsonParam.getDouble("EPSILON"));
        PARAMETERS.setArea1(jsonParam.getDouble("AREA1"));
        PARAMETERS.setQPts(jsonParam.getInt("Q_PTS"));
        PARAMETERS.setQuads(jsonParam.getInt("QUADS"));
        PARAMETERS.setDist(jsonParam.getDouble("DIST"));
        PARAMETERS.setNPts(jsonParam.getInt("N_PTS"));
        PARAMETERS.setKPts(jsonParam.getInt("K_PTS"));
        PARAMETERS.setAPts(jsonParam.getInt("A_PTS"));
        PARAMETERS.setBPts(jsonParam.getInt("B_PTS"));
        PARAMETERS.setCPts(jsonParam.getInt("C_PTS"));
        PARAMETERS.setDPts(jsonParam.getInt("D_PTS"));
        PARAMETERS.setEPts(jsonParam.getInt("E_PTS"));
        PARAMETERS.setFPts(jsonParam.getInt("F_PTS"));
        PARAMETERS.setGPts(jsonParam.getInt("G_PTS"));
        PARAMETERS.setLength2(jsonParam.getDouble("LENGTH2"));
        PARAMETERS.setRadius2(jsonParam.getDouble("RADIUS2"));
        PARAMETERS.setArea2(jsonParam.getDouble("AREA2"));
        
        PreliminaryUnlockingVector PUV = new PreliminaryUnlockingVector(15);
        JSONArray PUVJson = jsonObject.getJSONArray("PUV");

        for ( int i = 0; i < 15; ++i ) {
            PUV.setCondition(i, PUVJson.getBoolean(i));
        }
        
        int NUMPOINTS = jsonObject.getInt("NUMPOINTS");
        JSONArray POINTSJson = jsonObject.getJSONArray("POINTS");
        
        Point pointsArr[] = new Point[NUMPOINTS];
        
        for ( int i = 0; i < NUMPOINTS; ++i ) {
            JSONArray coord = POINTSJson.getJSONArray(i);
            pointsArr[i] = new Point(
                coord.getDouble(0),
                coord.getDouble(1)
            );
        }
        
        List<Point> POINTS = Arrays.asList(pointsArr);

        JSONArray LCMObject = jsonObject.getJSONArray("LCM");
        LogicalConnectorMatrix LCM = new LogicalConnectorMatrix(15);
        for ( int i = 0; i < 15; ++i ) {
            JSONArray row = LCMObject.getJSONArray(i);
            for ( int j = 0; i < 15; ++i ) {
                String val = row.getString(j);
                ConnectorType connector = switch(val) {
                    case "ANDD" -> ConnectorType.ANDD;
                    case "NOTUSED" -> ConnectorType.NOTUSED;
                    case "ORR" -> ConnectorType.ORR;
                    default -> ConnectorType.NOTUSED;
                };
                LCM.setConnector(i, j, connector);
            }
        }
        
        DecideService decide = new DecideService(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);
        return decide;
    }
}
