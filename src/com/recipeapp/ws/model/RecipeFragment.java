package com.recipeapp.ws.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "recipes")
@XmlType(propOrder = {"id", "title", "prepTime", "servings", "urlImage", "ingredients"})
public class RecipeFragment {
	private static int nextId = 1;
	private int id;
	private String title;
	private String prepTime;
	private String servings;
	private List<String> ingredients = new ArrayList<String>();
	private String urlImage;
	
	public RecipeFragment(){
		id = nextId;
		nextId++;
	}
	
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
	@XmlElement(name = "ingredients")
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
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
	public void addIngredient(String ingredient) {
		this.ingredients.add(ingredient);
	}
}
