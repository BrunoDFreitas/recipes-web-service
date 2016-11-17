package com.lls.receitasws.controller;

import java.util.ArrayList;
import java.util.List;

import com.lls.receitasws.model.RecipeDetail;
import com.lls.receitasws.model.Recipe;

public class RecipeController {

	private static List<Recipe> lstRecipe;
	private static List<RecipeDetail> lstRecipeDetail;

	public RecipeController() {
		if (lstRecipe == null) {
			lstRecipe = new ArrayList<Recipe>();

			Recipe r;
			r = new Recipe();
			r.setName("Costela na Press�o com Lingui�a");
			r.setPrepTime("60 min");
			r.setServings("8 por��es");
			r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg");
			r.addIngredient("costela");
			r.addIngredient("lingui�a");
			r.addIngredient("cebola");
			lstRecipe.add(r);

			r = new Recipe();
			r.setName("Lingui�a ao Forno com Batatas");
			r.setPrepTime("50 min");
			r.setServings("4 por��es");
			r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
			r.addIngredient("lingui�a");
			r.addIngredient("batata");
			r.addIngredient("piment�o");
			r.addIngredient("+");
			lstRecipe.add(r);
		}
		if (lstRecipeDetail == null) {
			lstRecipeDetail = new ArrayList<RecipeDetail>();
			RecipeDetail rd;
			
			rd = new RecipeDetail();
			rd.setName("Costela na Press�o com Lingui�a - Detalhe");
			rd.setPrepTime("60 min");
			rd.setServings("8 por��es");
			rd.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg");
			rd.addIngredient("1 kg e 1/2 de costela");
			rd.addIngredient("800 g de ling�i�a toscana");
			rd.addIngredient("1 cebola grande cortada em rodelas");
			rd.addPreparationSteps("Coloque toda a cebola cebola no fundo da panela de press�o");
			rd.addPreparationSteps("Corte a costela em peda�os e coloque metade sobre a cebola (a parte que tem mais osso para baixo)");
			rd.addPreparationSteps("Coloque metade da ling�i�a por cima e fa�a alguns furos nos gomos");
			rd.addPreparationSteps("Repita a opera��o e leve no fogo m�dio alto por mais ou menos 40 a 45 minutos contados a partir do momento que a panela come�ar a chiar");
			rd.addPreparationSteps("N�o adicione �gua, nem �leo");
			rd.addPreparationSteps("Tire a press�o e saboreie uma deliciosa costela temperada apenas com a ling�i�a");
			rd.addPreparationSteps("Deliciosa");

			lstRecipeDetail.add(rd);

			rd = new RecipeDetail();
			rd.setName("Lingui�a ao Forno com Batatas - Detalhe");
			rd.setPrepTime("50 min");
			rd.setServings("4 por��es");
			rd.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
			rd.addIngredient("1/2 kg de lingui�a toscana");
			rd.addIngredient("1/2 kg de batata bolinha");
			rd.addIngredient("1 piment�o grande cortado");
			rd.addIngredient("sal e pimenta a gosto");
			rd.addIngredient("Manjeric�o para decorar");
			rd.addPreparationSteps("Lave bem as batatas bolinhas, cozinhe-as em �gua e sal por aproximadamente 5 minutos");
			rd.addPreparationSteps("Unte um refrat�rio com �leo e disponha a lingui�a, as batatas e o piment�o");
			rd.addPreparationSteps("Salpique pimenta nas batatas e no piment�o, leve ao forno m�dio por aproximadamente 30 minutos ou at� dourar a lingui�a e as batatas");
			rd.addPreparationSteps("Retite do forno e acrescente folhas de manjeric�o (acrescenta um sabor e um aroma maravilhoso ao prato)");

			lstRecipeDetail.add(rd);
		}

	}

	public List<Recipe> searchRecipeByIngredients(List<String> ingredients) {
		return lstRecipe;
	}

	public RecipeDetail findById(int id) {
		return lstRecipeDetail.stream().filter(p -> p.getId() == id).findAny().orElse(null);
	}
}
