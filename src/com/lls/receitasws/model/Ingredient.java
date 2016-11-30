package com.lls.receitasws.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue
	@Column(name="ingredient_id", nullable=false)
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;

	@ManyToMany(mappedBy="ingredients")
	private List<Recipe> recipes;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
}
