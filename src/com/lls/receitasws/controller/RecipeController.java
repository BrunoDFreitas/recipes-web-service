package com.lls.receitasws.controller;

import java.util.ArrayList;
import java.util.List;

import com.lls.receitasws.model.RecipeDetail;
import com.lls.receitasws.dao.HibernateRecipeDao;
import com.lls.receitasws.dao.MockRecipeDao;
import com.lls.receitasws.dao.MockRecipeDetailDao;
import com.lls.receitasws.dao.RecipeDao;
import com.lls.receitasws.model.Recipe;

public class RecipeController {

	private static HibernateRecipeDao recipeDao; 

	public RecipeController() {
		if(recipeDao == null) {
			recipeDao = new HibernateRecipeDao();
		}
	}

//	public List<Recipe> searchRecipeByIngredients(List<String> ingredients) {
////		recipeDao.openCurrentSession();
////		List<Recipe> recipes = recipeDao.listAll();
////		recipeDao.closeCurrentSession();
//		return new MockRecipeDao().findAll();
//	}

	public Recipe findById(int id) {
		recipeDao.openCurrentSession();
		Recipe r = recipeDao.findById(id);
		recipeDao.closeCurrentSession();
		return r;
	}
	
	
	public void persist(Recipe r) {
		recipeDao.openCurrentSessionwithTransaction();
		recipeDao.persist(r);
		recipeDao.closeCurrentSessionwithTransaction();
	}
	
	
	public List<Recipe> findAll() {
		recipeDao.openCurrentSession();
		List<Recipe> recipes =  recipeDao.findAll();
		recipeDao.closeCurrentSession();
		return recipes;
	}
	
	
	public List<Recipe> findByIngredients(List<String> ingredients) {
		recipeDao.openCurrentSession();
		List<Recipe> recipes =  recipeDao.findByIngredients(ingredients);
		recipeDao.closeCurrentSession();
		return recipes;
	}
}
