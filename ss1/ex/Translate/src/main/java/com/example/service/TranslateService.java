package com.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class TranslateService {
    static Map<String, String> translateMap = new HashMap<>();

    static {
        translateMap.put("blue", "xanh duong");
        translateMap.put("red", "do ");
        translateMap.put("yellow", "vang ");
        translateMap.put("green", "xanh la cay");
    }
    public String translate(String english) {
        String result = "không tim thấy";
        for (Map.Entry<String, String> entry : translateMap.entrySet()) {
            if (entry.getKey().equals(english)) {
               result= entry.getValue();
               break;
            }
        }

        return  result;
    }
}
