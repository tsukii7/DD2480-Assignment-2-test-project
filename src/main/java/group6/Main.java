package group6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import group6.util.JSONUtil;

import group6.service.DecideService;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String jsonString = reader.lines().collect(Collectors.joining("\n"));
        DecideService decide = JSONUtil.parseJSON(jsonString); 
        if ( decide.makeLaunchDecision() ) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
