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
			rd.setName("Costela na Pressão com Linguiça - Detalhe");
			rd.setPrepTime("60 min");
			rd.setServings("8 porções");
			rd.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg");
			rd.addLstIngredient("1 kg e 1/2 de costela");
			rd.addLstIngredient("800 g de lingüiça toscana");
			rd.addLstIngredient("1 cebola grande cortada em rodelas");
			rd.addPreparationSteps("Coloque toda a cebola cebola no fundo da panela de pressão");
			rd.addPreparationSteps("Corte a costela em pedaços e coloque metade sobre a cebola (a parte que tem mais osso para baixo)");
			rd.addPreparationSteps("Coloque metade da lingüiça por cima e faça alguns furos nos gomos");
			rd.addPreparationSteps("Repita a operação e leve no fogo médio alto por mais ou menos 40 a 45 minutos contados a partir do momento que a panela começar a chiar");
			rd.addPreparationSteps("Não adicione água, nem óleo");
			rd.addPreparationSteps("Tire a pressão e saboreie uma deliciosa costela temperada apenas com a lingüiça");
			rd.addPreparationSteps("Deliciosa");

			lstRecipeDetail.add(rd);

			rd = new RecipeDetail();
			rd.setName("Linguiça ao Forno com Batatas - Detalhe");
			rd.setPrepTime("50 min");
			rd.setServings("4 porções");
			rd.setUrlImage("http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg");
			rd.addLstIngredient("1/2 kg de linguiça toscana");
			rd.addLstIngredient("1/2 kg de batata bolinha");
			rd.addLstIngredient("1 pimentão grande cortado");
			rd.addLstIngredient("sal e pimenta a gosto");
			rd.addLstIngredient("Manjericão para decorar");
			rd.addPreparationSteps("Lave bem as batatas bolinhas, cozinhe-as em água e sal por aproximadamente 5 minutos");
			rd.addPreparationSteps("Unte um refratário com óleo e disponha a linguiça, as batatas e o pimentão");
			rd.addPreparationSteps("Salpique pimenta nas batatas e no pimentão, leve ao forno médio por aproximadamente 30 minutos ou até dourar a linguiça e as batatas");
			rd.addPreparationSteps("Retite do forno e acrescente folhas de manjericão (acrescenta um sabor e um aroma maravilhoso ao prato)");

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
