package com.lls.receitasws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

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
	private Recipe recipe;
	
	// GETTERS AND SETTERS
	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	@XmlTransient
	public int getId() {
		return id;
	}

	@XmlTransient
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	// END GETTERS AND SETTERS
	
	@Override
	public String toString() {
		return "IngredientDetail [id=" + id + ", ingredient=" + ingredient + "]";
	}
	
}
