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

@Entity
@Table(name="recipe")
@XmlRootElement(name = "recipes")
@XmlType(propOrder = {"id", "name", "prepTime", "servings", "urlImage", "ingredients"})
public class Recipe {
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
	
//	@Transient
//	private List<String> lstIngredients = new ArrayList<String>();
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name="recipe_ingredient"
		, joinColumns= {@JoinColumn(name="recipe_id")}, inverseJoinColumns=
		  {@JoinColumn(name="ingredient_id")})
	private List<Ingredient> ingredients;
	
	public Recipe(){
		id = nextId;
		nextId++;
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
	
	
//	public List<String> getLstIngredients() {
//		return lstIngredients;
//	}
//	public void setLstIngredients(List<String> ingredients) {
//		this.lstIngredients = ingredients;
//	}
	
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
		if(this.ingredients == null)
			this.ingredients = new ArrayList<Ingredient>();
		Ingredient i = new Ingredient();
		i.setName(ingredient);
		this.ingredients.add(i);
	}
}
