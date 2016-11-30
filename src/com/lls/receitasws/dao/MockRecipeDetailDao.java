package com.lls.receitasws.dao;

import java.util.ArrayList;
import java.util.List;

import com.lls.receitasws.model.RecipeDetail;

public class MockRecipeDetailDao implements RecipeDetailDao<RecipeDetail, Integer> {
	
	private static List<RecipeDetail> lstRecipeDetail;

	public MockRecipeDetailDao() {
		if (lstRecipeDetail == null) {
			lstRecipeDetail = new ArrayList<RecipeDetail>();
			RecipeDetail rd;
			
			rd = new RecipeDetail();
			rd.setName("Costela na Press�o com Lingui�a - Detalhe");
			rd.setPrepTime("60 min");
			rd.setServings("8 por��es");
			rd.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg");
			rd.addLstIngredient("1 kg e 1/2 de costela");
			rd.addLstIngredient("800 g de ling�i�a toscana");
			rd.addLstIngredient("1 cebola grande cortada em rodelas");
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
			rd.addLstIngredient("1/2 kg de lingui�a toscana");
			rd.addLstIngredient("1/2 kg de batata bolinha");
			rd.addLstIngredient("1 piment�o grande cortado");
			rd.addLstIngredient("sal e pimenta a gosto");
			rd.addLstIngredient("Manjeric�o para decorar");
			rd.addPreparationSteps("Lave bem as batatas bolinhas, cozinhe-as em �gua e sal por aproximadamente 5 minutos");
			rd.addPreparationSteps("Unte um refrat�rio com �leo e disponha a lingui�a, as batatas e o piment�o");
			rd.addPreparationSteps("Salpique pimenta nas batatas e no piment�o, leve ao forno m�dio por aproximadamente 30 minutos ou at� dourar a lingui�a e as batatas");
			rd.addPreparationSteps("Retite do forno e acrescente folhas de manjeric�o (acrescenta um sabor e um aroma maravilhoso ao prato)");

			lstRecipeDetail.add(rd);
		}
	}
	

	@Override
	public void persist(RecipeDetail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RecipeDetail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RecipeDetail findById(Integer id) {
		return lstRecipeDetail.stream().filter(p -> p.getId() == id).findAny().orElse(null);
	}

	@Override
	public void delete(RecipeDetail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecipeDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
