USE `recipes`;

DROP TABLE IF EXISTS `ingredient`;

CREATE TABLE `ingredient` (
  `ingredient_id` INT NOT NULL AUTO_INCREMENT,
  `ingredient_text` VARCHAR(255) NOT NULL,
  `recipe_id` INT NOT NULL,
  PRIMARY KEY (`ingredient_id`),
  UNIQUE INDEX `ingredient_id_UNIQUE` (`ingredient_id` ASC),
  INDEX `recipe_id_idx` (`recipe_id` ASC),
  CONSTRAINT `ingredient_recipe_fk`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe` (`recipe_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `ingredient` (`ingredient_text`, `recipe_id`) VALUES
('1 kg e 1/2 de costela', 1),
('800 g de lingüiça toscana', 1),
('1 cebola grande cortada em rodelas', 1),
('1/2 kg de linguiça toscana', 2),
('1/2 kg de batata bolinha', 2),
('1 pimentão grande cortado', 2),
('sal e pimenta a gosto', 2),
('Manjericão para decorar', 2);