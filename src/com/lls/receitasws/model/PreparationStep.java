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
@Table(name="preparation_step")
public class PreparationStep {
	@Id
	@GeneratedValue
	@Column(name="preparation_step_id", nullable=false)
	private int id;
	
	@Column(name="step", nullable=false)
	private String step;
	
	@ManyToOne
	@JoinColumn(name="recipe_id", nullable=false)
	private Recipe recipe;
	
	// GETTERS AND SETTERS
	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	@XmlTransient
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@XmlTransient
	public int getId() {
		return id;
	}	
	// END GETTERS AND SETTERS
	
	@Override
	public String toString() {
		return "PreparationStep [id=" + id + ", step=" + step + "]";
	}
}
