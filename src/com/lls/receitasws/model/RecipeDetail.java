package com.lls.receitasws.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "recipes")
@XmlType(propOrder = {"id", "name", "prepTime", "servings", "urlImage", "ingredients", "preparationSteps"})
public class RecipeDetail {
	
	private int id;
	
	private String name;
	
	private String prepTime;
	
	private String servings;
	
	private String urlImage;
	
	private List<IngredientDetail> ingredients;
	
	private List<PreparationStep> preparationSteps;
	
	public RecipeDetail(){
		
	}
	
	public RecipeDetail(Recipe recipe){
		if(recipe != null) {
			this.id = recipe.getId();
			this.name = recipe.getName();
			this.prepTime = recipe.getPrepTime();
			this.servings = recipe.getServings();
			this.urlImage = recipe.getUrlImage();
			
			this.ingredients = new ArrayList<IngredientDetail>();
			for(IngredientDetail id : recipe.getIngredientsDetail())
				if(!this.ingredients.stream().anyMatch(a -> a.getIngredient().compareTo(id.getIngredient()) == 0))
					this.ingredients.add(id);
			
			this.preparationSteps = new ArrayList<PreparationStep>();
			for(PreparationStep p : recipe.getPreparationSteps())
				if(!this.preparationSteps.stream().anyMatch(a -> a.getStep().compareTo(p.getStep()) == 0))
					this.preparationSteps.add(p);
		}
	}

	
	
	// GETTER AND SETTERS
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

//	@XmlElement(name = "ingredients")
//	public List<String> getLstIngredients() {
//		return lstIngredients;
//	}

//	public String getLstIngredientsString() {
//
//		String output ="";
//		for (String str: lstIngredients)
//			output = output + " " + str;
//
//		return output;
//	}

//	public void setLstIngredients(List<String> ingredients) {
//		this.lstIngredients = ingredients;
//	}

	public void addIngredient(String ingredient) {
		if(this.ingredients == null)
			this.ingredients = new ArrayList<IngredientDetail>();
		IngredientDetail i = new IngredientDetail();
		i.setIngredient(ingredient);
		this.ingredients.add(i);
	}

	@XmlElement(name = "urlImage")
	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@XmlElement(name = "preparationSteps")
	public List<PreparationStep> getPreparationSteps() {
		return preparationSteps;
	}

	public void setPreparationSteps(List<PreparationStep> preparationSteps) {
		this.preparationSteps = preparationSteps;
	}
	
	public void addPreparationSteps(String preparationStep) {
		if(this.preparationSteps == null)
			this.preparationSteps = new ArrayList<PreparationStep>();
		PreparationStep p = new PreparationStep();
		p.setStep(preparationStep);
		this.preparationSteps.add(p);
	}
	
	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@XmlElement(name = "ingredients")
	public List<IngredientDetail> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDetail> ingredients) {
		this.ingredients = ingredients;
	}	
	
	// END GETTER AND SETTERS
	@Override
	public String toString() {
		return "RecipeDetail [id=" + id + ", name=" + name + ", prepTime=" + prepTime + ", servings=" + servings
				+ ", urlImage=" + urlImage + "]";
	}	
}
