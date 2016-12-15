package com.lls.receitasws.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "recipes")
@XmlType(propOrder = { "id", "name", "prepTime", "servings", "urlImage", "ingredients" })
public class RecipeSearch {

	private int id;

	private String name;

	private String prepTime;

	private String servings;

	private String urlImage;

	private List<Ingredient> ingredients;
	
	public RecipeSearch(){
		
	}

	public RecipeSearch(Recipe recipe) {
		if(recipe != null) {
			this.id = recipe.getId();
			this.name = recipe.getName();
			this.prepTime = recipe.getPrepTime();
			this.servings = recipe.getServings();
			this.urlImage = recipe.getUrlImage();
			this.ingredients = recipe.getIngredients();
		}
	}
	
	public RecipeSearch(int id) {
		this.id = id;
		this.name = "";
		this.prepTime = "";
		this.servings = "";
		this.urlImage = "";
		this.ingredients = new ArrayList<>();
	}

	// GETTERS AND SETTERS

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "prepTime")
	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	@XmlElement(name = "servings")
	public String getServings() {
		return servings;
	}

	public void setServings(String servings) {
		this.servings = servings;
	}

	@XmlElement(name = "urlImage")
	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@XmlElement(name = "ingredients")
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", prepTime=" + prepTime + ", servings=" + servings
				+ ", urlImage=" + urlImage + "]";
	}
	// END GETTERS AND SETTERS

	public void addIngredient(String ingredient) {
		if (this.ingredients == null)
			this.ingredients = new ArrayList<Ingredient>();
		Ingredient i = new Ingredient();
		i.setName(ingredient);
		this.ingredients.add(i);
	}
}
