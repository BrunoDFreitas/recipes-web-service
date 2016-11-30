package com.lls.receitasws.dao;

import java.util.ArrayList;
import java.util.List;

import com.lls.receitasws.model.Recipe;

public class MockRecipeDao implements RecipeDao<Recipe, Integer> {
	private static List<Recipe> lstRecipe;

	public MockRecipeDao() {
		if (lstRecipe == null) {
			lstRecipe = new ArrayList<Recipe>();

			Recipe r;
			r = new Recipe();
			r.setName("Costela na Press�o com Lingui�a");
			r.setPrepTime("60 min");
			r.setServings("8 por��es");
			r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg");
			r.addLstIngredient("costela");
			r.addLstIngredient("lingui�a");
			r.addLstIngredient("cebola");
			lstRecipe.add(r);

			r = new Recipe();
			r.setName("Lingui�a ao Forno com Batatas");
			r.setPrepTime("50 min");
			r.setServings("4 por��es");
			r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
			r.addLstIngredient("lingui�a");
			r.addLstIngredient("batata");
			r.addLstIngredient("piment�o");
			r.addLstIngredient("+");
			lstRecipe.add(r);
		}
		
	}
	
	@Override
	public List<Recipe> findAll() {
		return lstRecipe;
	}

	@Override
	public void persist(Recipe entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Recipe entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Recipe findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Recipe entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}	

}
