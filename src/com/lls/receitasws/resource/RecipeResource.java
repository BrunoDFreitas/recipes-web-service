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
import com.lls.receitasws.model.Recipe;
import com.lls.receitasws.model.RecipeFragment;

@Path("/")
public class RecipeResource {
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String testService() {
		return "Service OK! Serviço funcionando!";
	}

	@GET
	@Path("/recipe/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Recipe recipeDetails(@PathParam("id") int id) {
		return new RecipeController().findById(id);
	}

	@POST
	@Path("/recipe/search")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<RecipeFragment> recipeSearch(String ls) {
		List<String> lstIngredients = new ArrayList<String>();
		try {
			JSONArray ingredientsJson = new JSONObject(ls).getJSONArray("ingredients");
			for (int i = 0; i < ingredientsJson.length(); i++) {
				lstIngredients.add((String)ingredientsJson.get(i));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		List<RecipeFragment> recipes = new RecipeController().searchRecipeByIngredients(lstIngredients);		
		
		return recipes;
	}
}
