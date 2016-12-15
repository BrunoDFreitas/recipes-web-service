package com.lls.receitasws.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lls.receitasws.controller.RecipeController;
import com.lls.receitasws.dao.MockRecipeDao;
import com.lls.receitasws.model.RecipeDetail;
import com.lls.receitasws.model.RecipeSearch;
import com.lls.receitasws.model.Recipe;

@Path("/")
public class RecipeResource {
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String testService() {
		return "Service OK!";
	}

	@GET
	@Path("/recipe/search/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public RecipeDetail recipeDetails(@PathParam("id") int id) {
		//RecipeDetail r = new RecipeDetailController().findById(id);
//		RecipeDetail r = new MockRecipeDetailDao().findById(id);
//		RecipeDetail r = new RecipeDetailController().findById(id);
		Recipe recipeResult = new RecipeController().findById(id);
		RecipeDetail r = new RecipeDetail(recipeResult);
		return r;
	}

	@POST
	@Path("/recipe/search")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<RecipeSearch> recipeSearch(String json) {
		List<String> ingredients = new ArrayList<String>();
		
		try {
			JsonParser parser = new JsonParser();
			JsonObject jo = (JsonObject)parser.parse(json);
//			JsonArray ingredientsJson = jo.getAsJsonArray("ingredients"); 
//			JsonArray ingredientsJson = jo.getAsJsonPrimitive("ingredients").getAsJsonArray();
			JsonArray ingredientsJson = (JsonArray)parser.parse(json).getAsJsonObject().get("ingredients");
			for (int i = 0; i < ingredientsJson.size(); i++) {
				ingredients.add((String)ingredientsJson.get(i).toString().replaceAll("\"", ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		List<Recipe> recipes = new RecipeController().searchRecipeByIngredients(lstIngredients);		
//		List<Recipe> recipes  = new MockRecipeDao().findAll();	
		
//		List<Recipe> recipesResult = new RecipeController().findAll();
		List<Recipe> recipesResult = new RecipeController().findByIngredients(ingredients);
		List<RecipeSearch> recipes = new ArrayList<RecipeSearch>();
		for(Recipe r : recipesResult) {
			recipes.add(new RecipeSearch(r));
		}
		
//		Gson gson = new Gson();
//		String j = gson.toJson(recipes);
		if(recipes.size() < 2)
			recipes.add(new RecipeSearch(0));
		
		return recipes;		
	}
}
