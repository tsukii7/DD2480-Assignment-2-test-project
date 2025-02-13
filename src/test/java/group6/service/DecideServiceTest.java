package group6.service;
import group6.util.JSONUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DecideServiceTest {
    
    @Test
    void TestTrueInstance1() throws IOException {
        String jsonFile = Files.readString(Path.of("test_instances/1.json"));
        DecideService service = JSONUtil.parseJSON(jsonFile);
        // All LIC's are true and applicable
        assertTrue(service.makeLaunchDecision(), "For instance 1.json, LaunchDecision should be true");
    }

    @Test
    void TestTrueInstance2() throws IOException {
        String jsonFile = Files.readString(Path.of("test_instances/3.json"));
        DecideService service = JSONUtil.parseJSON(jsonFile);
        // false LIC's are not applicable
        assertTrue(service.makeLaunchDecision(), "For instance 3.json, LaunchDecision should be true");
    }
    
    @Test
    void TestFalseInstance1() throws IOException {
        String jsonFile = Files.readString(Path.of("test_instances/2.json"));
        DecideService service = JSONUtil.parseJSON(jsonFile);
        // all but a few LIC's are true
        assertFalse(service.makeLaunchDecision(), "For instance 2.json, LaunchDecision should be false");
    }
}
