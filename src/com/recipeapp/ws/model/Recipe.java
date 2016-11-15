package com.recipeapp.ws.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "recipes")
@XmlType(propOrder = {"id", "title", "prepTime", "servings", "urlImage", "ingredients", "directions"})
public class Recipe {
	private static int nextId = 1;
	
	private int id;
	private String title;
	private String prepTime;
	private String servings;
	private String urlImage;
	private List<String> ingredients = new ArrayList<String>();
	private List<String> directions = new ArrayList<String>();

	public Recipe(){
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

	public String getIngredientsString() {

		String output ="";
		for (String str: ingredients)
			output = output + " " + str;

		return output;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredient(String ingredient) {
		this.ingredients.add(ingredient);
	}

	@XmlElement(name = "urlImage")
	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@XmlElement(name = "directions")
	public List<String> getDirections() {
		return directions;
	}

	public void setDirections(List<String> directions) {
		this.directions = directions;
	}
	
	public void addDirection(String direction) {
		this.directions.add(direction);
	}
	
	@XmlElement(name = "id")
	public int getId() {
		return id;
	}
}
