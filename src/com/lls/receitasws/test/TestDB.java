package com.lls.receitasws.test;

import java.util.ArrayList;
import java.util.List;

import com.lls.receitasws.controller.RecipeController;
import com.lls.receitasws.controller.RecipeDetailController;
import com.lls.receitasws.model.IngredientDetail;
import com.lls.receitasws.model.Ingredient;
import com.lls.receitasws.model.Recipe;
import com.lls.receitasws.model.RecipeDetail;

public class TestDB {
	public static void main(String[] args) {
		Ingredient i1 = new Ingredient();
		i1.setName("Ingrediente 1");
		
		Ingredient i2 = new Ingredient();
		i2.setName("Ingrediente 2");
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(i1);
		ingredients.add(i2);
		
		Recipe r = new Recipe();
		r.setName("Receita 2");
		r.setPrepTime("5 min");
		r.setServings("10 pratos");
		r.setUrlImage("url 2");
		r.setIngredients(ingredients);
		
		new RecipeController().persist(r);
		
		IngredientDetail id1 = new IngredientDetail();
		id1.setIngredient("Ingrediente detalhado 1");
		IngredientDetail id2 = new IngredientDetail();
		id2.setIngredient("Ingrediente detalhado 2");
		List<IngredientDetail> lstIngDetail = new ArrayList<IngredientDetail>();
		lstIngDetail.add(id1);
		lstIngDetail.add(id2);
		
		
		RecipeDetail rd = new RecipeDetail();
		rd.setName("Receita com ingredientes detalhados");
		rd.setPrepTime("5 min");
		rd.setServings("10 pratos");
		rd.setUrlImage("url 2");
		rd.setIngredients(lstIngDetail);
	
		id1.setRecipe(rd);
		id2.setRecipe(rd);
		
		new RecipeDetailController().persist(rd);
	}
}
