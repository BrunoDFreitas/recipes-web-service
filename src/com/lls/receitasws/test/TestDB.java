package com.lls.receitasws.test;

import java.util.ArrayList;
import java.util.List;

import com.lls.receitasws.controller.RecipeController;
import com.lls.receitasws.model.IngredientDetail;
import com.lls.receitasws.model.PreparationStep;
import com.lls.receitasws.model.Ingredient;
import com.lls.receitasws.model.Recipe;
import com.lls.receitasws.model.RecipeDetail;

public class TestDB {
	public static void main(String[] args) {
		// TEST RECIPE
//		testRecipeInsert();
//		testRecipeFind(1);
//		testRecipeInserUsingExistIngredient(1);
//		testRecipeFind(2);		
//		testRecipeFindAll();
		
//		List<String> ingredients = new ArrayList<String>();
//		ingredients.add("lingui�a");
//		testRecipeFindByIngredients(ingredients);
//		
//		List<String> ingredients2 = new ArrayList<String>();
//		ingredients2.add("batata");
//		testRecipeFindByIngredients(ingredients2);
//		
//		List<String> ingredients3 = new ArrayList<String>();
//		ingredients3.add("costela");
//		ingredients3.add("piment�o");
//		testRecipeFindByIngredients(ingredients3);

		
//		initDataBase();
//		initDataBase2();
		initDataBase3();
	}
	
	
	private static void testRecipeFindById(int id) {
		System.out.println("\nTESTE RECIPE FIND BY ID");
		Recipe recipeFound = new RecipeController().findById(id);
		System.out.println(recipeFound.toString());
		for (Ingredient ing : recipeFound.getIngredients()) {
			System.out.println(ing.toString());
		}
	}
	
	
	private static void testRecipeInserUsingExistIngredient(int idIngredient) {
		System.out.println("\nTESTE RECIPE INSERT USING EXIST INGREDIENT");
		// find recipe
		Recipe recipeFound = new RecipeController().findById(1);
		System.out.println(recipeFound.toString());
		for (Ingredient ing : recipeFound.getIngredients()) {
			System.out.println(ing.toString());
		}

		// Create Recipe using exist ingredient		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient i1 = new Ingredient();
		i1.setName("Ingrediente 3");
		Ingredient i2 = null;
		for(Ingredient ing : recipeFound.getIngredients()) {
			if(ing.getId() == idIngredient)
				i2 = ing;
		}
		
		ingredients.add(i1);
		ingredients.add(i2);
		
		Recipe newRecipe = new Recipe();
		newRecipe.setName("Receita 3");
		newRecipe.setPrepTime("5 min");
		newRecipe.setServings("10 pratos");
		newRecipe.setUrlImage("url 2");
		newRecipe.setIngredients(ingredients);

		new RecipeController().persist(newRecipe);
	}
	
	private static void testRecipeFindByIngredients(List<String> ingredients) {
		System.out.println("\nTESTE RECIPE FIND BY INGREDIENT LIST");
		List<Recipe> recipes = new RecipeController().findByIngredients(ingredients);
		
		int count = 1;
		for (Recipe r : recipes) {
			System.out.println("BEGIN RECIPE " + count);
			System.out.println(r.toString());
			for (Ingredient i : r.getIngredients()) {
				System.out.println(i.toString());
			}
			System.out.println("END RECIPE " + count);
		}
	}
	
	
	private static void testRecipeFindAll() {
		System.out.println("\nTESTE RECIPE FIND ALL");
		List<Recipe> recipes = new RecipeController().findAll();
		
		int count = 1;
		for (Recipe r : recipes) {
			System.out.println("BEGIN RECIPE " + count);
			System.out.println(r.toString());
			for (Ingredient i : r.getIngredients()) {
				System.out.println(i.toString());
			}
			for (IngredientDetail ing : r.getIngredientsDetail()) {
				System.out.println(ing.toString());
			}
			for (PreparationStep p : r.getPreparationSteps()) {
				System.out.println(p.toString());
			}
			
			System.out.println("END RECIPE " + count);
		}
	}

	
	
	private static void initDataBase() {
		Recipe r = new Recipe();
		r.setName("Costela na Press�o com Lingui�a");
		r.setPrepTime("60 min");
		r.setServings("8 por��es");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg");
		r.addIngredient("costela");
		r.addIngredient("lingui�a");
		r.addIngredient("cebola");
		r.addIngredientDetail("1 kg e 1/2 de costela");
		r.addIngredientDetail("800 g de ling�i�a toscana");
		r.addIngredientDetail("1 cebola grande cortada em rodelas");
		r.addPreparationSteps("Coloque toda a cebola cebola no fundo da panela de press�o");
		r.addPreparationSteps("Corte a costela em peda�os e coloque metade sobre a cebola (a parte que tem mais osso para baixo)");
		r.addPreparationSteps("Coloque metade da ling�i�a por cima e fa�a alguns furos nos gomos");
		r.addPreparationSteps("Repita a opera��o e leve no fogo m�dio alto por mais ou menos 40 a 45 minutos contados a partir do momento que a panela come�ar a chiar");
		r.addPreparationSteps("N�o adicione �gua, nem �leo");
		r.addPreparationSteps("Tire a press�o e saboreie uma deliciosa costela temperada apenas com a ling�i�a");
		r.addPreparationSteps("Deliciosa");
		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);
		
		r = new Recipe();
		r.setName("Lingui�a ao Forno com Batatas");
		r.setPrepTime("50 min");
		r.setServings("4 por��es");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
		r.setIngredients(new ArrayList<Ingredient>());
		r.addIngredient("lingui�a");
		r.addIngredient("batata");
		r.addIngredient("piment�o");
		r.addIngredient("+");
		r.addIngredientDetail("1/2 kg de lingui�a toscana");
		r.addIngredientDetail("1/2 kg de batata bolinha");
		r.addIngredientDetail("1 piment�o grande cortado");
		r.addIngredientDetail("sal e pimenta a gosto");
		r.addIngredientDetail("Manjeric�o para decorar");
		r.addPreparationSteps("Lave bem as batatas bolinhas, cozinhe-as em �gua e sal por aproximadamente 5 minutos");
		r.addPreparationSteps("Unte um refrat�rio com �leo e disponha a lingui�a, as batatas e o piment�o");
		r.addPreparationSteps("Salpique pimenta nas batatas e no piment�o, leve ao forno m�dio por aproximadamente 30 minutos ou at� dourar a lingui�a e as batatas");
		r.addPreparationSteps("Retite do forno e acrescente folhas de manjeric�o (acrescenta um sabor e um aroma maravilhoso ao prato)");	


		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);
	}
	
	private static void initDataBase2() {
		Recipe r = new Recipe();
		r.setName("MACARR�O DE PANELA DE PRESS�O");
		r.setPrepTime("30 min");
		r.setServings("8 por��es");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/000/742/126535/126535_original.jpg");
		r.addIngredient("macarr�o");
		r.addIngredient("tomate");
		r.addIngredient("atum");
		r.addIngredient("margarina");
		r.addIngredient("presunto");
		r.addIngredientDetail("500 g de macarr�o parafuso");
		r.addIngredientDetail("1 lata de atum ralado");
		r.addIngredientDetail("1 lata de molho de tomate");
		r.addIngredientDetail("2 cubos de caldo de galinha picados");
		r.addIngredientDetail("2 cubos de caldo de galinha picados");
		r.addIngredientDetail("2 colheres (sopa) de margarina");
		r.addPreparationSteps("Na panela de press�o coloque o macarr�o, molho de tomate, atum, caldo de galinha, margarina e sal");
		r.addPreparationSteps("Coloque �gua at� cobrir e misture bem todos os ingredientes");
		r.addPreparationSteps("Leve ao fogo alto e quando a panela pegar a press�o, conte 4 minutos");
		r.addPreparationSteps("Abra a panela e coloque o presunto, o creme de leite e por �ltimo a mussarela, misture bem e sirva em seguida");
		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);
		
		r = new Recipe();
		r.setName("MACARR�O � CARBONARA");
		r.setPrepTime("15 min");
		r.setServings("6 por��es");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/001/624/38726/38726_original.jpg");
		r.setIngredients(new ArrayList<Ingredient>());
		r.addIngredient("macarr�o");
		r.addIngredient("sal");
		r.addIngredient("pimenta");
		r.addIngredient("queijo");
		r.addIngredientDetail("bacon picado a gosto");
		r.addIngredientDetail("queijo ralado a gosto");
		r.addIngredientDetail("3 ovos");
		r.addIngredientDetail("sal");
		r.addIngredientDetail("pimenta");
		r.addPreparationSteps("Frite bem o bacon, at� ficar crocante (pode-se adicionar salame picado)");
		r.addPreparationSteps("Coloque o macarr�o para cozinhar em �gua e sal");
		r.addPreparationSteps("No refrat�rio onde ser� servido o macarr�o, bata bem os ovos com um garfo");
		r.addPreparationSteps("Tempere com sal e pimenta a gosto, e junte o queijo ralado, tamb�m a gosto");	
		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);		
	}
	
	private static void initDataBase3() {
		Recipe r = new Recipe();
		r.setName("MACARR�O DE PANELA DE PRESS�O");
		r.setPrepTime("30 min");
		r.setServings("8 por��es");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/065/022/38779/38779_original.jpg");
		r.addIngredient("ovo");
		r.addIngredient("farinha");
		r.addIngredient("sal");
		r.addIngredient("manteiga");
		r.addIngredient("leite");
		r.addIngredientDetail("1 x�cara de leite integral");
		r.addIngredientDetail("1 x�cara de farinha de trigo");
		r.addIngredientDetail("1 ovo");
		r.addIngredientDetail("1 pitada de sal");
		r.addIngredientDetail("Manteiga");
		r.addIngredientDetail("2 colheres (sopa) de margarina");
		r.addPreparationSteps("Na panela de press�o coloque o macarr�o, molho de tomate, atum, caldo de galinha, margarina e sal");
		r.addPreparationSteps("Coloque �gua at� cobrir e misture bem todos os ingredientes");
		r.addPreparationSteps("Leve ao fogo alto e quando a panela pegar a press�o, conte 4 minutos");
		r.addPreparationSteps("Abra a panela e coloque o presunto, o creme de leite e por �ltimo a mussarela, misture bem e sirva em seguida");
		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);
		
		r = new Recipe();
		r.setName("PANQUECA DE CARNE MO�DA");
		r.setPrepTime("40 min");
		r.setServings("10 por��es");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/000/760/38777/38777_original.jpg");
		r.setIngredients(new ArrayList<Ingredient>());
		r.addIngredient("ovo");
		r.addIngredient("farinha");
		r.addIngredient("leite");
		r.addIngredient("�leo");
		r.addIngredientDetail("1 e 1/2 x�cara (ch�) de farinha de trigo");
		r.addIngredientDetail("1 x�cara (ch�) de leite");
		r.addIngredientDetail("3 ovos");
		r.addIngredientDetail("4 colheres (sopa) de �leo");
		r.addIngredientDetail("sal");
		r.addPreparationSteps("Frite bem o bacon, at� ficar crocante (pode-se adicionar salame picado)");
		r.addPreparationSteps("Coloque o macarr�o para cozinhar em �gua e sal");
		r.addPreparationSteps("No refrat�rio onde ser� servido o macarr�o, bata bem os ovos com um garfo");
		r.addPreparationSteps("Tempere com sal e pimenta a gosto, e junte o queijo ralado, tamb�m a gosto");	
		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);		
	}
}
