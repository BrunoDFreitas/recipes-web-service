package com.recipeapp.ws.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.recipeapp.ws.model.RecipeFragment;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestApp {
	public static void main(String[] args) {
		try {
			
			// POST REQUEST //
			Client client = Client.create();
			
			List<String> ingredients = new ArrayList<String>();
			ingredients.add("linguiça");
			ingredients.add("batata");
			
			JSONArray ingrAsJson = new JSONArray(ingredients);
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost("http://localhost:8080/RecipesWebService/recipe/search");
			
			StringEntity input = new StringEntity(ingrAsJson.toString(), Charsets.UTF_8);
			input.setContentType(MediaType.APPLICATION_JSON);
			postRequest.setEntity(input);
			
			
			HttpResponse postResponse = httpClient.execute(postRequest);
			if(postResponse.getStatusLine().getStatusCode() != 200 ) {
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

			// GET REQUEST //
			WebResource webResource = client.resource("http://localhost:8080/RecipesWebService/recipe/oldsearch");

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON + ";charset=utf-8")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed: HTTP error code : " + response.getStatus());
			}

			String stringJson = response.getEntity(String.class);
			JSONArray recipes = new JSONObject(stringJson).getJSONArray("recipes");

			System.out.println("\n\nGET REQUEST - Output from Server ... \n");
			for (int i = 0; i < recipes.length(); i++) {
				JSONObject jobj = recipes.getJSONObject(i);
				RecipeFragment rf = new ObjectMapper().readValue(jobj.toString(), RecipeFragment.class);
				System.out.println("Objeto " + i);
				System.out.println("id: " + rf.getId() + ", title: " + rf.getTitle());
			}
			// END GET REQUEST //
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
