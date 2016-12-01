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
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.lls.receitasws.model.RecipeDetail;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestApp {
	private static String baseUrl = "http://localhost:8888/recipes-web-service/";
	public static void main(String[] args) {
		try {
			recipeSearchTest();
			recipeSearchIdTest(1);
			recipeSearchIdTest(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void recipeSearchTest() throws ClientProtocolException, IOException {
		List<String> ingredients = new ArrayList<String>();
		ingredients.add("linguiça");
		ingredients.add("batata");

		JSONArray ingrAsJson = new JSONArray(ingredients);
		Map<String, JSONArray> map = new HashMap<String, JSONArray>();
		map.put("ingredients", ingrAsJson);
		JSONObject jsonObj = new JSONObject(map);
		String s = jsonObj.toString();

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(baseUrl + "recipe/search");

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
	}

	public static void recipeSearchIdTest(int id) throws JSONException, JsonParseException, JsonMappingException, IOException {
		Client client = new Client();
		
		WebResource webResource = client.resource(baseUrl + "recipe/search/" + id);

		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON + ";charset=utf-8")
				.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed: HTTP error code : " + response.getStatus());
		}

		String stringJson = response.getEntity(String.class);
		System.out.println("\n\nGET REQUEST - Output from Server...");
		System.out.println(stringJson + "\n");
		
		System.out.println("Get Objects");
		JSONObject jobj = new JSONObject(stringJson);
		RecipeDetail rf = new ObjectMapper().readValue(jobj.toString(), RecipeDetail.class);
		System.out.println("Id param: " + id);
		System.out.println("Object - id: " + rf.getId() + ", title: " + rf.getName());
	}
}
