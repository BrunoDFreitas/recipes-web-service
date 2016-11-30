USE recipes;

DROP TABLE IF EXISTS `recipe`;

CREATE TABLE `recipe` (
  `recipe_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `preparation_time` VARCHAR(45) NOT NULL,
  `servings` VARCHAR(45) NOT NULL,
  `url_image` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`recipe_id`),
  UNIQUE INDEX `recipe_id_UNIQUE` (`recipe_id` ASC));

INSERT INTO `recipe` (`name`, `preparation_time`, `servings`, `url_image`) VALUES
('Costela na Pressão com Linguiça', '60 min', '8 porções', 'http://img.itdg.com.br/tdg/images/recipes/000/014/222/174697/174697_original.jpg'),
('Linguiça ao Forno com Batatas', '50 min', '4 porções', 'http://img.itdg.com.br/tdg/images/recipes/000/135/316/61218/61218_original.jpg');