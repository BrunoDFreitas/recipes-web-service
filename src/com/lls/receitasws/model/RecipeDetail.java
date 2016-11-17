package com.lls.receitasws.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "recipes")
@XmlType(propOrder = {"id", "name", "prepTime", "servings", "urlImage", "ingredients", "preparationSteps"})
public class RecipeDetail {
	private static int nextId = 1;
	
	private int id;
	private String name;
	private String prepTime;
	private String servings;
	private String urlImage;
	private List<String> ingredients = new ArrayList<String>();
	private List<String> preparationSteps = new ArrayList<String>();

	public RecipeDetail(){
		id = nextId;
		nextId++;
	}
	
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

	@XmlElement(name = "preparationSteps")
	public List<String> getPreparationSteps() {
		return preparationSteps;
	}

	public void setPreparationSteps(List<String> preparationSteps) {
		this.preparationSteps = preparationSteps;
	}
	
	public void addPreparationSteps(String preparationStep) {
		this.preparationSteps.add(preparationStep);
	}
	
	@XmlElement(name = "id")
	public int getId() {
		return id;
	}
}
