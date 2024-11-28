package com.RestAssured.Collection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONReader {

	 public static List<Map<String, String>> getTestData(String filePath) {
	        List<Map<String, String>> testDataList = new ArrayList<>();

	        JSONParser parser = new JSONParser();
	        try (FileReader reader = new FileReader(filePath)) {
	            // Parse the JSON file
	            JSONArray jsonArray = (JSONArray) parser.parse(reader);

	            for (Object obj : jsonArray) {
	                JSONObject jsonObject = (JSONObject) obj;
	                Map<String, String> dataMap = new HashMap<>();
	                for (Object key : jsonObject.keySet()) {
	                    dataMap.put(key.toString(), jsonObject.get(key).toString());
	                }
	                testDataList.add(dataMap);
	            }

	        } catch (IOException | ParseException e) {
	            e.printStackTrace();
	        }

	      
	        return testDataList;
	    }
}
