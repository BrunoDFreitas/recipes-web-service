package com.lls.receitasws.controller;

import java.util.ArrayList;
import java.util.List;

import com.lls.receitasws.model.Recipe;
import com.lls.receitasws.model.RecipeFragment;

public class RecipeController {
	
	public RecipeController() {
		
	}
	
	public List<RecipeFragment> searchRecipeByIngredients(List<String> ingredients){
		RecipeFragment rf; 
		List<RecipeFragment> ls = new ArrayList<RecipeFragment>();
		
		rf = new RecipeFragment();
		rf.setTitle("Costela na Pressão com Linguiça");
		rf.setPrepTime("60 min");
		rf.setServings("8 porções");
		rf.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg");
		rf.addIngredient("costela");
		rf.addIngredient("linguiça");
		rf.addIngredient("cebola");
		ls.add(rf);
		
		rf = new RecipeFragment();
		rf.setTitle("Linguiça ao Forno com Batatas");
		rf.setPrepTime("50 min");
		rf.setServings("4 porções");
		rf.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
		rf.addIngredient("linguiça");
		rf.addIngredient("batata");
		rf.addIngredient("pimentão");
		rf.addIngredient("+");
		ls.add(rf);		
		
		return ls;
	}
	
	public Recipe findById(int id) {
		Recipe r = new Recipe();
		
		r.setTitle("Linguiça ao Forno com Batatas");
		r.setPrepTime("50 min");
		r.setServings("4 porções");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
		r.addIngredient("1/2 kg de linguiça toscana");
		r.addIngredient("1/2 kg de batata bolinha");
		r.addIngredient("1 pimentão grande cortado");
		r.addIngredient("sal e pimenta a gosto");
		r.addIngredient("Manjericão para decorar");
		r.addDirection("Lave bem as batatas bolinhas, cozinhe-as em água e sal por aproximadamente 5 minutos");
		r.addDirection("Unte um refratário com óleo e disponha a linguiça, as batatas e o pimentão");
		r.addDirection("Salpique pimenta nas batatas e no pimentão, leve ao forno médio por aproximadamente 30 minutos ou até dourar a linguiça e as batatas");
		r.addDirection("Retite do forno e acrescente folhas de manjericão (acrescenta um sabor e um aroma maravilhoso ao prato)");
		
		return r;
	}
}
