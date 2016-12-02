package com.lls.receitasws.controller;

import java.util.List;

import com.lls.receitasws.dao.HibernateRecipeDetailDao;
import com.lls.receitasws.dao.MockRecipeDao;
import com.lls.receitasws.dao.MockRecipeDetailDao;
import com.lls.receitasws.model.Recipe;
import com.lls.receitasws.model.RecipeDetail;

public class RecipeDetailController {

	private static HibernateRecipeDetailDao recipeDao; 

	public RecipeDetailController() {
		if(recipeDao == null) {
			recipeDao = new HibernateRecipeDetailDao();
		}
	}

	public List<Recipe> searchRecipeByIngredients(List<String> ingredients) {
//		recipeDao.openCurrentSession();
//		List<Recipe> recipes = recipeDao.findAll();
//		recipeDao.closeCurrentSession();
//		return recipes;
		return new MockRecipeDao().findAll();
	}

	public RecipeDetail findById(int id) {
		recipeDao.openCurrentSession();
		RecipeDetail r = recipeDao.findById(id);
		recipeDao.closeCurrentSession();
		return r;
//		return new MockRecipeDetailDao().findById(id);
	}
	
	
	public void persist(RecipeDetail r) {
		recipeDao.openCurrentSessionwithTransaction();
		recipeDao.persist(r);
		recipeDao.closeCurrentSessionwithTransaction();
	}
}
