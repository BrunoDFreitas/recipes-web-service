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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="recipe")
@XmlRootElement(name = "recipes")
@XmlType(propOrder = {"id", "name", "prepTime", "servings", "urlImage", "ingredients"})
public class Recipe {
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
	
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "recipe", fetch = FetchType.EAGER)
	private List<IngredientDetail> ingredientsDetail;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "recipe", fetch = FetchType.EAGER)
	private List<PreparationStep> preparationSteps;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name="recipe_ingredient"
		, joinColumns= {@JoinColumn(name="recipe_id")}, inverseJoinColumns=
		  {@JoinColumn(name="ingredient_id")})
	private List<Ingredient> ingredients;
	
	// GETTER AND SETTERS
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getServings() {
		return servings;
	}

	public void setServings(String servings) {
		this.servings = servings;
	}


	public void addIngredientDetail(String ingredient) {
		if(this.ingredientsDetail == null)
			this.ingredientsDetail = new ArrayList<IngredientDetail>();
		
		IngredientDetail i = new IngredientDetail();
		i.setIngredient(ingredient);
		i.setRecipe(this);
		this.ingredientsDetail.add(i);
	}
	
	
	public void addIngredient(String ingredient) {
		if(this.ingredients == null)
			this.ingredients = new ArrayList<Ingredient>();
		
		Ingredient i = new Ingredient();
		i.setName(ingredient);
		this.ingredients.add(i);
	}


	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}


	public List<PreparationStep> getPreparationSteps() {
		return preparationSteps;
	}

	public void setPreparationSteps(List<PreparationStep> preparationSteps) {
		this.preparationSteps = preparationSteps;
	}
	
	public int getId() {
		return id;
	}
	
	public void addPreparationSteps(String preparationStep) {
		if(this.preparationSteps == null)
			this.preparationSteps = new ArrayList<PreparationStep>();
		PreparationStep p = new PreparationStep();
		p.setStep(preparationStep);
		this.preparationSteps.add(p);
	}

	public List<IngredientDetail> getIngredientsDetail() {
		return ingredientsDetail;
	}

	public void setIngredientsDetail(List<IngredientDetail> ingredients) {
		this.ingredientsDetail = ingredients;
	}	
	
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	// END GETTER AND SETTERS
	@Override
	public String toString() {
		return "RecipeDetail [id=" + id + ", name=" + name + ", prepTime=" + prepTime + ", servings=" + servings
				+ ", urlImage=" + urlImage + "]";
	}

	public void setIngredientsDetailLstString(List<String> ingredients) {
		for(String i : ingredients) {
			this.addIngredientDetail(i);
		}		
	}

	public void setPreparationStepsLstString(List<String> instructions) {
		// TODO Auto-generated method stub
		
	}
}
