package com.lls.mining;

import java.util.ArrayList;
import java.util.List;

public class RecipeScrap {
	public String name;
	public List<String> ingredients = new ArrayList<String>();
	public List<String> instructions = new ArrayList<String>();
	public String yield;
	public String time;
	public String urlImage;	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public List<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
	public String getYield() {
		return yield;
	}
	public void setYield(String yield) {
		this.yield = yield;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String url) {
		this.urlImage = url;
	}
	public void addIngredient(String ingredient) {
		if(this.ingredients == null)
			this.ingredients = new ArrayList<String>();
		
		this.ingredients.add(ingredient);
	}
	public void addInstruction(String instruction) {
		if(this.instructions == null)
			this.instructions = new ArrayList<String>();
		
		this.instructions.add(instruction);		
	}	
}
