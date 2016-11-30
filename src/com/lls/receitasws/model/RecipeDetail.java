package com.lls.receitasws.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@Entity
@Table(name="recipe")
@XmlRootElement(name = "recipes")
@XmlType(propOrder = {"id", "name", "prepTime", "servings", "urlImage", "ingredients", "preparationSteps"})
public class RecipeDetail {
	private static int nextId = 1;
	
	@Id
	@GeneratedValue
	@Column(name="recipe_id", nullable=false)
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="preparation_time", nullable=false)
	private String prepTime;
	
	@Column(name="servings", nullable=false)
	private String servings;
	
	@Column(name="url_image", nullable=false)
	private String urlImage;
	
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "recipe")
	private List<IngredientDetail> ingredients;
	
	
	@Transient
	private List<String> lstIngredients = new ArrayList<String>();
	
	@Transient
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
	public List<String> getLstIngredients() {
		return lstIngredients;
	}

	public String getLstIngredientsString() {

		String output ="";
		for (String str: lstIngredients)
			output = output + " " + str;

		return output;
	}

	public void setLstIngredients(List<String> ingredients) {
		this.lstIngredients = ingredients;
	}

	public void addLstIngredient(String ingredient) {
		this.lstIngredients.add(ingredient);
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

	public List<IngredientDetail> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDetail> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
