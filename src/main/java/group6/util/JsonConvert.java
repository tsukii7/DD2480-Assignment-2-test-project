package group6.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//        "parameters": {
//            "length1": 87.0,
//                    "radius1": 22.0,
//                    "epsilon": 2.5899557065929524,
//                    "area1": 34.0,
//                    "qPoints": 49,
//                    "quads": 3,
//                    "nPoints": 95,
//                    "dist": 98.0,
//                    "kPoints": 82,
//                    "aPoints": 5,
//                    "bPoints": 3,
//                    "cPoints": 83,
//                    "dPoints": 14,
//                    "ePoints": 31,
//                    "fPoints": 66,
//                    "gPoints": 4,
//                    "length2": -1.0,
//                    "radius2": -1.0,
//                    "area2": -1.0
//        },

//        "PARAMETERS": {
//            "LENGTH1": 0.0,
//                    "RADIUS1": 0.1,
//                    "EPSILON": 3.07,
//                    "AREA1": 0.0,
//                    "Q_PTS": 2,
//                    "QUADS": 1,
//                    "DIST": 0.0,
//                    "N_PTS": 3,
//                    "K_PTS": 1,
//                    "A_PTS": 1,
//                    "B_PTS": 1,
//                    "C_PTS": 1,
//                    "D_PTS": 1,
//                    "E_PTS": 1,
//                    "F_PTS": 1,
//                    "G_PTS": 1,
//                    "LENGTH2": 100.0,
//                    "RADIUS2": 100.0,
//                    "AREA2": 100.0
//        },
public class JsonConvert {
    public static void main(String[] args) throws IOException {
        String jsonFile = Files.readString(Path.of("test_instances/random-input.json"));
        JSONObject oldObject = new JSONObject(jsonFile);
        JSONObject newObject = new JSONObject();
        newObject.put("NUMPOINTS", oldObject.getInt("numPoints"));
        JSONArray jsonArray = oldObject.getJSONArray("coordinates");
        JSONArray pointArray = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            double x = jsonArray.getJSONObject(i).getDouble("x");
            double y = jsonArray.getJSONObject(i).getDouble("y");
            pointArray.put(new JSONArray().put(x).put(y));
        }
        newObject.put("POINTS", pointArray);
        JSONObject parameters = (JSONObject) oldObject.get("parameters");
        JSONObject newParameters = new JSONObject();
        newParameters.put("LENGTH1", parameters.getDouble("length1"));
        newParameters.put("RADIUS1", parameters.getDouble("radius1"));
        newParameters.put("EPSILON", parameters.getDouble("epsilon"));
        newParameters.put("AREA1", parameters.getDouble("area1"));
        newParameters.put("Q_PTS", parameters.getInt("qPoints"));
        newParameters.put("QUADS", parameters.getInt("quads"));
        newParameters.put("DIST", parameters.getDouble("dist"));
        newParameters.put("N_PTS", parameters.getInt("nPoints"));
        newParameters.put("K_PTS", parameters.getInt("kPoints"));
        newParameters.put("A_PTS", parameters.getInt("aPoints"));
        newParameters.put("B_PTS", parameters.getInt("bPoints"));
        newParameters.put("C_PTS", parameters.getInt("cPoints"));
        newParameters.put("D_PTS", parameters.getInt("dPoints"));
        newParameters.put("E_PTS", parameters.getInt("ePoints"));
        newParameters.put("F_PTS", parameters.getInt("fPoints"));
        newParameters.put("G_PTS", parameters.getInt("gPoints"));
        newParameters.put("LENGTH2", parameters.getDouble("length2"));
        newParameters.put("RADIUS2", parameters.getDouble("radius2"));
        newParameters.put("AREA2", parameters.getDouble("area2"));
        newObject.put("PARAMETERS", newParameters);
        newObject.put("LCM", oldObject.get("lcm"));
        newObject.put("PUV", oldObject.get("puv"));
        String filePath = "test_instances/new-input.json";
        FileWriter newFile = new FileWriter(filePath);
        newFile.write(newObject.toString(4)); // Pretty print with indentation
        newFile.flush();

    }
}
