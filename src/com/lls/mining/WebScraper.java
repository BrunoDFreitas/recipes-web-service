package com.lls.mining;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.lls.receitasws.model.Ingredient;
import com.lls.receitasws.model.Recipe;

import java.util.*;

public class WebScraper {
	private static final String mainLink = "http://tudogostoso.com.br/";
	private static final String popularRecipesLink = mainLink + "receitas-populares/";
	
	public static void main(String[] args) {
			int numberOfPages = 1;
//			List<RecipeScrap> recipesScrap = scrap(numberOfPages);
			List<RecipeScrap> recipesScrap = scrapMock();
			List<Recipe> recipes = new ArrayList<Recipe>();
			List<String> ingredients = new ArrayList<String>();
			if(recipesScrap != null && recipesScrap.size() > 0) {
				for(RecipeScrap rs : recipesScrap) {
					Recipe r = new Recipe();
					r.setName(rs.name);
					r.setPrepTime(rs.time);
					r.setServings(rs.yield);
					r.setIngredientsDetailLstString(rs.ingredients);
					ingredients.addAll(rs.ingredients);
					r.setPreparationStepsLstString(rs.instructions);
				}
			}
			List<String> ingrsIndex = new ArrayList<String>();  
			
			for(String i : ingredients) {
				String ingr = i.replaceAll("[1-9]|\\(.*\\)| e |/| de ", " ").toLowerCase().trim();
				
				for(String ingrIndex : ingr.split(" ")) {
					if(ingrIndex.compareTo("") != 0 && !ingrsIndex.contains(ingrIndex))
						ingrsIndex.add(ingrIndex);		
					
				}
				
				
				System.out.println(i);
			}
			
			return;
	}

	public static List<RecipeScrap> scrap(int numberOfPages) {
		int linksPerPages = 10;

		int page = 1;
		List<String> photos_url = new ArrayList<String>();
		List<RecipeScrap> recipesList = new ArrayList<RecipeScrap>();

		try {
			while (page <= numberOfPages) {
				String pagePopularRecipe = popularRecipesLink + page + "/";
//				String pagePopularRecipe = "http://www.tudogostoso.com.br/busca.php?q=";
				Document docPesq = Jsoup.connect(pagePopularRecipe).userAgent("Chrome").timeout(5000).get();
				Elements contents = (Elements) docPesq.getElementsByClass("box-hover");
				Elements photos = (Elements) docPesq.getElementsByClass("photo");
				int i = 0;
				String href;
				String urlImage;
	
				while (i < linksPerPages) {
					Elements tag = contents.get(i).getElementsByTag("a");
					href = tag.get(0).attr("href");
					urlImage = photos.get(i).attr("src").split("\\?")[0];
					Document doc = Jsoup.connect(mainLink + href).userAgent("Chrome").timeout(5000).get();
	
					String temp = doc.getElementsByClass("recipe-title").get(0).text();
					String name = temp.replaceAll("[\n0-9]+", "");
	
					String time = doc.getElementsByClass("dt-duration").get(0).text().toLowerCase();
	
					String yield = doc.getElementsByClass("p-yield num yield").get(0).val() + " por��es";
					//int yield = Integer.parseInt(temp);
	
					Elements ingredients_class = doc.getElementsByClass("p-ingredient");
					List<String> ingredients = new ArrayList<String>();
					int j = 0;
					while (j < ingredients_class.size()) {
						ingredients.add(ingredients_class.get(j).text());
						j = j + 1;
					}
	
					Elements instructions_class = doc.getElementsByClass("instructions e-instructions");
					List<String> instructions = new ArrayList<String>();
	
					Element e = instructions_class.get(0);
					for (Node n : e.childNodes()) {
						if (n.toString().contains("part-title gray-box")) {
							String title = n.toString().replaceAll("<h3 class=\"part-title gray-box\">", "")
									.replaceAll("</h3>", "");
							instructions.add(title);
						} else if (n.toString().startsWith("<ol>")) {
							for (Node subN : n.childNodes()) {
								if (subN.toString().contains("<li><span>")) {
									String ingr = subN.toString()
											.replaceAll("<li><span>", "").replaceAll("</span></li>","");
									instructions.add(ingr);
								}
							}
						}
					}
					RecipeScrap newRecipe = new RecipeScrap();
					newRecipe.setName(name);
					newRecipe.setTime(time);
					newRecipe.setYield(yield);
					newRecipe.setUrlImage(urlImage);
					newRecipe.setIngredients(ingredients);
					newRecipe.setInstructions(instructions);
	
					recipesList.add(newRecipe);
					i++;
				}
				page++;
			}
		}
		catch (IOException e) {
			System.out.println("Ocorreram erros durante a minera��o. N�o foi poss�vel minerar todos os dados.");
			e.printStackTrace();
		}
		return recipesList;
	}	
	
	
	public static List<RecipeScrap> scrapMock(){
		List<RecipeScrap> recipes = new ArrayList<RecipeScrap>();
		RecipeScrap r;
		r = new RecipeScrap();
		r.setName("PANQUECA DE CARNE MO�DA");
		r.setTime("40 min");
		r.setYield("10 por��es");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/000/760/38777/38777_original.jpg");
		r.addIngredient("1 e 1/2 x�cara (ch�) de farinha de trigo");
		r.addIngredient("1 x�cara (ch�) de leite");
		r.addIngredient("3 ovos");
		r.addIngredient("4 colheres (sopa) de �leo");
		r.addIngredient("sal");
		r.addInstruction("Frite bem o bacon, at� ficar crocante (pode-se adicionar salame picado)");
		r.addInstruction("Coloque o macarr�o para cozinhar em �gua e sal");
		r.addInstruction("No refrat�rio onde ser� servido o macarr�o, bata bem os ovos com um garfo");
		r.addInstruction("Tempere com sal e pimenta a gosto, e junte o queijo ralado, tamb�m a gosto");
		recipes.add(r);
		
		r = new RecipeScrap();
		r.setName("MACARR�O DE PANELA DE PRESS�O");
		r.setTime("30 min");
		r.setYield("8 por��es");
		r.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/065/022/38779/38779_original.jpg");
		r.addIngredient("1 x�cara de leite integral");
		r.addIngredient("1 x�cara de farinha de trigo");
		r.addIngredient("1 ovo");
		r.addIngredient("1 pitada de sal");
		r.addIngredient("Manteiga");
		r.addIngredient("2 colheres (sopa) de margarina");
		r.addInstruction("Na panela de press�o coloque o macarr�o, molho de tomate, atum, caldo de galinha, margarina e sal");
		r.addInstruction("Coloque �gua at� cobrir e misture bem todos os ingredientes");
		r.addInstruction("Leve ao fogo alto e quando a panela pegar a press�o, conte 4 minutos");
		r.addInstruction("Abra a panela e coloque o presunto, o creme de leite e por �ltimo a mussarela, misture bem e sirva em seguida");
		recipes.add(r);
		
		return recipes;		
	}
}