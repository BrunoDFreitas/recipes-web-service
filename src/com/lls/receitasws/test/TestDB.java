package com.lls.receitasws.test;

import java.util.ArrayList;
import java.util.List;

import com.lls.receitasws.controller.RecipeController;
import com.lls.receitasws.controller.RecipeDetailController;
import com.lls.receitasws.model.IngredientDetail;
import com.lls.receitasws.model.PreparationStep;
import com.lls.receitasws.model.Ingredient;
import com.lls.receitasws.model.Recipe;
import com.lls.receitasws.model.RecipeDetail;

public class TestDB {
	public static void main(String[] args) {
		
		
		

		// Find Recipe
		

//		List<Recipe> recipes = new RecipeController().findAll();
//
//		int count = 1;
//		for (Recipe r : recipes) {
//			System.out.println("BEGIN RECIPE " + count);
//			System.out.println(r.toString());
//			for (Ingredient i : r.getIngredients()) {
//				System.out.println(i.toString());
//			}
//			System.out.println("END RECIPE " + count);
//		}
	}
	
	public static void testRecipeInsert() {
		Ingredient i1 = new Ingredient();
		i1.setName("Ingrediente 1");

		Ingredient i2 = new Ingredient();
		i2.setName("Ingrediente 2");

		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(i1);
		ingredients.add(i2);

		Recipe r = new Recipe();
		r.setName("Receita 1");
		r.setPrepTime("5 min");
		r.setServings("10 pratos");
		r.setUrlImage("url 2");
		r.setIngredients(ingredients);

		new RecipeController().persist(r);
	}
	
	private static void testRecipeFind(int id) {
		// Find Recipe
		Recipe recipeFound = new RecipeController().findById(id);
		System.out.println(recipeFound.toString());
		for (Ingredient ing : recipeFound.getIngredients()) {
			System.out.println(ing.toString());
		}
	}
	

	
	private static void testRecipeDetailInsert() {
		IngredientDetail id1 = new IngredientDetail();
		id1.setIngredient("Ingrediente detalhado 3");
		IngredientDetail id2 = new IngredientDetail();
		id2.setIngredient("Ingrediente detalhado 4");
		List<IngredientDetail> lstIngDetail = new ArrayList<IngredientDetail>();
		lstIngDetail.add(id1);
		lstIngDetail.add(id2);
		
		PreparationStep p1 = new PreparationStep();
		p1.setStep("Passo 1");
		PreparationStep p2 = new PreparationStep();
		p2.setStep("Passo 2");
		List<PreparationStep> lstStep = new ArrayList<PreparationStep>();
		lstStep.add(p1);
		lstStep.add(p2);
		
		RecipeDetail rd = new RecipeDetail();
		rd.setName("Receita com ingredientes detalhados 2");
		rd.setPrepTime("5 min");
		rd.setServings("10 pratos");
		rd.setUrlImage("url 2");
		rd.setIngredients(lstIngDetail);
		rd.setPreparationSteps(lstStep);
		
		id1.setRecipe(rd);
		id2.setRecipe(rd);
		p1.setRecipe(rd);
		p2.setRecipe(rd);
		
		new RecipeDetailController().persist(rd);
	}
	
	
	private static void testRecipeInserUsingExistIngredient(int idIngredient) {
		Recipe recipeFound = new RecipeController().findById(1);
		System.out.println(recipeFound.toString());
		for (Ingredient ing : recipeFound.getIngredients()) {
			System.out.println(ing.toString());
		}

		
		// Create Recipe using exist ingredient		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient i1 = new Ingredient();
		i1.setName("Ingrediente 3");
		Ingredient i2 = null;
		for(Ingredient ing : recipeFound.getIngredients()) {
			if(ing.getId() == idIngredient)
				i2 = ing;
		}
		
		ingredients.add(i1);
		ingredients.add(i2);
		
		Recipe newRecipe = new Recipe();
		newRecipe.setName("Receita 3");
		newRecipe.setPrepTime("5 min");
		newRecipe.setServings("10 pratos");
		newRecipe.setUrlImage("url 2");
		newRecipe.setIngredients(ingredients);

		new RecipeController().persist(newRecipe);
	}
}