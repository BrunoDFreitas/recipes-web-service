package com.lls.receitasws.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;


public class TestApp {
	public static void main(String[] args) {
		try {
			recipeSearchTest();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void recipeSearchTest() throws ClientProtocolException, IOException {
		// POST REQUEST //		
		List<String> ingredients = new ArrayList<String>();
		ingredients.add("linguiça");
		ingredients.add("batata");

		JSONArray ingrAsJson = new JSONArray(ingredients);
		Map<String, JSONArray> map = new HashMap<String, JSONArray>();
		map.put("ingredients", ingrAsJson);
		JSONObject jsonObj = new JSONObject(map);
		String s = jsonObj.toString();
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost("http://192.168.1.2:8080/recipes-web-service/recipe/search");

		StringEntity input = new StringEntity(s, Charsets.UTF_8);
		input.setContentType(MediaType.APPLICATION_JSON);
		postRequest.setEntity(input);

		HttpResponse postResponse = httpClient.execute(postRequest);
		if (postResponse.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + postResponse.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
				new InputStreamReader(postResponse.getEntity().getContent(), Charsets.UTF_8));

		String output;
		System.out.println("POST REQUEST - Output from Server.... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		// END POST REQUEST //
	}
}
