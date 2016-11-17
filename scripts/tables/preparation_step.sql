USE `recipes`;

DROP TABLE IF EXISTS `preparation_step`;

CREATE TABLE `preparation_step` (
  `preparation_step_id` INT NOT NULL AUTO_INCREMENT,
  `preparation_step_txt` VARCHAR(255) NOT NULL,
  `recipe_id` INT NOT NULL,
  PRIMARY KEY (`preparation_step_id`),
  UNIQUE INDEX `preparation_step_id_UNIQUE` (`preparation_step_id` ASC),
  INDEX `fk_recipe_idx` (`recipe_id` ASC),
  CONSTRAINT `preparation_step_recipe_fk`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe` (`recipe_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    
INSERT INTO `preparation_step` (`recipe_id`, `preparation_step_txt`) VALUES
(1, 'Coloque toda a cebola cebola no fundo da panela de pressão'),
(1, 'Corte a costela em pedaços e coloque metade sobre a cebola (a parte que tem mais osso para baixo)'),
(1, 'Coloque metade da lingüiça por cima e faça alguns furos nos gomos'),
(1, 'Repita a operação e leve no fogo médio alto por mais ou menos 40 a 45 minutos contados a partir do momento que a panela começar a chiar'),
(1, 'Não adicione água, nem óleo'),
(1, 'Tire a pressão e saboreie uma deliciosa costela temperada apenas com a lingüiça'),
(1, 'Deliciosa'),
(2, 'Lave bem as batatas bolinhas, cozinhe-as em água e sal por aproximadamente 5 minutos'),
(2, 'Unte um refratário com óleo e disponha a linguiça, as batatas e o pimentão'),
(2, 'Salpique pimenta nas batatas e no pimentão, leve ao forno médio por aproximadamente 30 minutos ou até dourar a linguiça e as batatas'),
(2, 'Retite do forno e acrescente folhas de manjericão (acrescenta um sabor e um aroma maravilhoso ao prato)');
