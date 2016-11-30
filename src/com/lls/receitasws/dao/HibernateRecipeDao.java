package com.lls.receitasws.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.lls.receitasws.model.Recipe;

public class HibernateRecipeDao extends SessionDao implements RecipeDao<Recipe, Integer> {
	
	public HibernateRecipeDao() {
	}
	
	@Override
	public List<Recipe> findAll() {
//		//List<Recipe> recipes = (List<Recipe>) getCurrentSession().createQuery("from recipe").getResultList();
//		List<Recipe> recipes = new ArrayList<Recipe>();
//		Recipe recipe = getCurrentSession().find(Recipe.class, 1);
//		recipes.add(recipe);
//		return recipes;
		return null;
	}

	@Override
	public void persist(Recipe entity) {
		getCurrentSession().save(entity);		
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
