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
//		ingredients.add("linguiça");
//		testRecipeFindByIngredients(ingredients);
//		
//		List<String> ingredients2 = new ArrayList<String>();
//		ingredients2.add("batata");
//		testRecipeFindByIngredients(ingredients2);
//		
//		List<String> ingredients3 = new ArrayList<String>();
//		ingredients3.add("costela");
//		ingredients3.add("pimentão");
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
		r.setName("Costela na Pressão com Linguiça");
		r.setPrepTime("60 min");
		r.setServings("8 porções");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg");
		r.addIngredient("costela");
		r.addIngredient("linguiça");
		r.addIngredient("cebola");
		r.addIngredientDetail("1 kg e 1/2 de costela");
		r.addIngredientDetail("800 g de lingüiça toscana");
		r.addIngredientDetail("1 cebola grande cortada em rodelas");
		r.addPreparationSteps("Coloque toda a cebola cebola no fundo da panela de pressão");
		r.addPreparationSteps("Corte a costela em pedaços e coloque metade sobre a cebola (a parte que tem mais osso para baixo)");
		r.addPreparationSteps("Coloque metade da lingüiça por cima e faça alguns furos nos gomos");
		r.addPreparationSteps("Repita a operação e leve no fogo médio alto por mais ou menos 40 a 45 minutos contados a partir do momento que a panela começar a chiar");
		r.addPreparationSteps("Não adicione água, nem óleo");
		r.addPreparationSteps("Tire a pressão e saboreie uma deliciosa costela temperada apenas com a lingüiça");
		r.addPreparationSteps("Deliciosa");
		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);
		
		r = new Recipe();
		r.setName("Linguiça ao Forno com Batatas");
		r.setPrepTime("50 min");
		r.setServings("4 porções");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
		r.setIngredients(new ArrayList<Ingredient>());
		r.addIngredient("linguiça");
		r.addIngredient("batata");
		r.addIngredient("pimentão");
		r.addIngredient("+");
		r.addIngredientDetail("1/2 kg de linguiça toscana");
		r.addIngredientDetail("1/2 kg de batata bolinha");
		r.addIngredientDetail("1 pimentão grande cortado");
		r.addIngredientDetail("sal e pimenta a gosto");
		r.addIngredientDetail("Manjericão para decorar");
		r.addPreparationSteps("Lave bem as batatas bolinhas, cozinhe-as em água e sal por aproximadamente 5 minutos");
		r.addPreparationSteps("Unte um refratário com óleo e disponha a linguiça, as batatas e o pimentão");
		r.addPreparationSteps("Salpique pimenta nas batatas e no pimentão, leve ao forno médio por aproximadamente 30 minutos ou até dourar a linguiça e as batatas");
		r.addPreparationSteps("Retite do forno e acrescente folhas de manjericão (acrescenta um sabor e um aroma maravilhoso ao prato)");	


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
		r.setName("MACARRÃO DE PANELA DE PRESSÃO");
		r.setPrepTime("30 min");
		r.setServings("8 porções");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/000/742/126535/126535_original.jpg");
		r.addIngredient("macarrão");
		r.addIngredient("tomate");
		r.addIngredient("atum");
		r.addIngredient("margarina");
		r.addIngredient("presunto");
		r.addIngredientDetail("500 g de macarrão parafuso");
		r.addIngredientDetail("1 lata de atum ralado");
		r.addIngredientDetail("1 lata de molho de tomate");
		r.addIngredientDetail("2 cubos de caldo de galinha picados");
		r.addIngredientDetail("2 cubos de caldo de galinha picados");
		r.addIngredientDetail("2 colheres (sopa) de margarina");
		r.addPreparationSteps("Na panela de pressão coloque o macarrão, molho de tomate, atum, caldo de galinha, margarina e sal");
		r.addPreparationSteps("Coloque água até cobrir e misture bem todos os ingredientes");
		r.addPreparationSteps("Leve ao fogo alto e quando a panela pegar a pressão, conte 4 minutos");
		r.addPreparationSteps("Abra a panela e coloque o presunto, o creme de leite e por último a mussarela, misture bem e sirva em seguida");
		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);
		
		r = new Recipe();
		r.setName("MACARRÃO À CARBONARA");
		r.setPrepTime("15 min");
		r.setServings("6 porções");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/001/624/38726/38726_original.jpg");
		r.setIngredients(new ArrayList<Ingredient>());
		r.addIngredient("macarrão");
		r.addIngredient("sal");
		r.addIngredient("pimenta");
		r.addIngredient("queijo");
		r.addIngredientDetail("bacon picado a gosto");
		r.addIngredientDetail("queijo ralado a gosto");
		r.addIngredientDetail("3 ovos");
		r.addIngredientDetail("sal");
		r.addIngredientDetail("pimenta");
		r.addPreparationSteps("Frite bem o bacon, até ficar crocante (pode-se adicionar salame picado)");
		r.addPreparationSteps("Coloque o macarrão para cozinhar em água e sal");
		r.addPreparationSteps("No refratário onde será servido o macarrão, bata bem os ovos com um garfo");
		r.addPreparationSteps("Tempere com sal e pimenta a gosto, e junte o queijo ralado, também a gosto");	
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
		r.setName("MACARRÃO DE PANELA DE PRESSÃO");
		r.setPrepTime("30 min");
		r.setServings("8 porções");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/065/022/38779/38779_original.jpg");
		r.addIngredient("ovo");
		r.addIngredient("farinha");
		r.addIngredient("sal");
		r.addIngredient("manteiga");
		r.addIngredient("leite");
		r.addIngredientDetail("1 xícara de leite integral");
		r.addIngredientDetail("1 xícara de farinha de trigo");
		r.addIngredientDetail("1 ovo");
		r.addIngredientDetail("1 pitada de sal");
		r.addIngredientDetail("Manteiga");
		r.addIngredientDetail("2 colheres (sopa) de margarina");
		r.addPreparationSteps("Na panela de pressão coloque o macarrão, molho de tomate, atum, caldo de galinha, margarina e sal");
		r.addPreparationSteps("Coloque água até cobrir e misture bem todos os ingredientes");
		r.addPreparationSteps("Leve ao fogo alto e quando a panela pegar a pressão, conte 4 minutos");
		r.addPreparationSteps("Abra a panela e coloque o presunto, o creme de leite e por último a mussarela, misture bem e sirva em seguida");
		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);
		
		r = new Recipe();
		r.setName("PANQUECA DE CARNE MOÍDA");
		r.setPrepTime("40 min");
		r.setServings("10 porções");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/000/760/38777/38777_original.jpg");
		r.setIngredients(new ArrayList<Ingredient>());
		r.addIngredient("ovo");
		r.addIngredient("farinha");
		r.addIngredient("leite");
		r.addIngredient("óleo");
		r.addIngredientDetail("1 e 1/2 xícara (chá) de farinha de trigo");
		r.addIngredientDetail("1 xícara (chá) de leite");
		r.addIngredientDetail("3 ovos");
		r.addIngredientDetail("4 colheres (sopa) de óleo");
		r.addIngredientDetail("sal");
		r.addPreparationSteps("Frite bem o bacon, até ficar crocante (pode-se adicionar salame picado)");
		r.addPreparationSteps("Coloque o macarrão para cozinhar em água e sal");
		r.addPreparationSteps("No refratário onde será servido o macarrão, bata bem os ovos com um garfo");
		r.addPreparationSteps("Tempere com sal e pimenta a gosto, e junte o queijo ralado, também a gosto");	
		for(IngredientDetail id : r.getIngredientsDetail()){
			id.setRecipe(r);
		}
		for(PreparationStep p : r.getPreparationSteps()){
			p.setRecipe(r);
		}
		
		new RecipeController().persist(r);		
	}
}
