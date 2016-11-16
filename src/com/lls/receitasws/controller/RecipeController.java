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
		rf.setTitle("Costela na Press�o com Lingui�a");
		rf.setPrepTime("60 min");
		rf.setServings("8 por��es");
		rf.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg");
		rf.addIngredient("costela");
		rf.addIngredient("lingui�a");
		rf.addIngredient("cebola");
		ls.add(rf);
		
		rf = new RecipeFragment();
		rf.setTitle("Lingui�a ao Forno com Batatas");
		rf.setPrepTime("50 min");
		rf.setServings("4 por��es");
		rf.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
		rf.addIngredient("lingui�a");
		rf.addIngredient("batata");
		rf.addIngredient("piment�o");
		rf.addIngredient("+");
		ls.add(rf);		
		
		return ls;
	}
	
	public Recipe findById(int id) {
		Recipe r = new Recipe();
		
		r.setTitle("Lingui�a ao Forno com Batatas");
		r.setPrepTime("50 min");
		r.setServings("4 por��es");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
		r.addIngredient("1/2 kg de lingui�a toscana");
		r.addIngredient("1/2 kg de batata bolinha");
		r.addIngredient("1 piment�o grande cortado");
		r.addIngredient("sal e pimenta a gosto");
		r.addIngredient("Manjeric�o para decorar");
		r.addDirection("Lave bem as batatas bolinhas, cozinhe-as em �gua e sal por aproximadamente 5 minutos");
		r.addDirection("Unte um refrat�rio com �leo e disponha a lingui�a, as batatas e o piment�o");
		r.addDirection("Salpique pimenta nas batatas e no piment�o, leve ao forno m�dio por aproximadamente 30 minutos ou at� dourar a lingui�a e as batatas");
		r.addDirection("Retite do forno e acrescente folhas de manjeric�o (acrescenta um sabor e um aroma maravilhoso ao prato)");
		
		return r;
	}
}
