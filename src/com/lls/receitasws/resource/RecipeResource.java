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

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.lls.receitasws.controller.RecipeController;
import com.lls.receitasws.controller.RecipeDetailController;
import com.lls.receitasws.dao.MockRecipeDao;
import com.lls.receitasws.dao.MockRecipeDetailDao;
import com.lls.receitasws.model.RecipeDetail;
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
		RecipeDetail r = new RecipeDetailController().findById(id);
		return r;
	}

	@POST
	@Path("/recipe/search")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Recipe> recipeSearch(String ingredients) {
//		List<String> lstIngredients = new ArrayList<String>();
//		try {
//			JSONArray ingredientsJson = new JSONObject(ls).getJSONArray("ingredients");
//			for (int i = 0; i < ingredientsJson.length(); i++) {
//				lstIngredients.add((String)ingredientsJson.get(i));
//			}
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		List<Recipe> recipes = new RecipeController().searchRecipeByIngredients(lstIngredients);		
//		List<Recipe> recipes  = new MockRecipeDao().findAll();	
		List<Recipe> recipes = new RecipeController().findAll();
		
		return recipes;
	}
}
