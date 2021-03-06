package com.lls.receitasws.dao;

import java.io.Serializable;
import java.util.List;

public interface RecipeDao<T, Id extends Serializable> {

	public void persist(T entity);
	
	public void update(T entity);
	
	public T findById(Id id);
	
	public void delete(T entity);
	
	public List<T> findAll();
	
	public void deleteAll();	

	public List<T> findByIngredients(List<String> ingredients);
}
