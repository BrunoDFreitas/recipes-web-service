package com.lls.receitasws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ingredient_detail")
public class IngredientDetail {
	
	@Id
	@GeneratedValue
	@Column(name="ingredient_detail_id", nullable=false)
	private int id;
	
	@Column(name="ingredient", nullable=false)
	private String ingredient;

	@ManyToOne
	@JoinColumn(name="recipe_id", nullable=false)
	private RecipeDetail recipe;
	
	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public int getId() {
		return id;
	}

	public RecipeDetail getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeDetail recipe) {
		this.recipe = recipe;
	}
}
