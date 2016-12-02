package com.lls.receitasws.dao;

import java.util.List;

import com.lls.receitasws.model.IngredientDetail;
import com.lls.receitasws.model.Recipe;
import com.lls.receitasws.model.RecipeDetail;

public class HibernateRecipeDetailDao extends SessionDao implements RecipeDetailDao<RecipeDetail, Integer>{

	@Override
	public void persist(RecipeDetail entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(RecipeDetail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RecipeDetail findById(Integer id) {
//		RecipeDetail r = (RecipeDetail) getCurrentSession().get(RecipeDetail.class, id);
		String hql = "select r from RecipeDetail r where r.id = :id";
		RecipeDetail r = (RecipeDetail) getCurrentSession()
				.createQuery(hql)
				.setParameter("id", id)
				.list().get(0);
		return r;
	}

	@Override
	public void delete(RecipeDetail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecipeDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
