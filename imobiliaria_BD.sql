
CREATE DATABASE imobiliaria_BD;
 
 CREATE TABLE `imobiliaria_BD`.`imovel` (
  `codImovel` INT NOT NULL AUTO_INCREMENT,
  `tipoImovel` VARCHAR(20) NOT NULL,
  `titulo` VARCHAR(70) NOT NULL,
  `pretensao` VARCHAR(45) NOT NULL,
  `detalhes` VARCHAR(150) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `quartos` INT NOT NULL,
  PRIMARY KEY (`codImovel`));
  
  CREATE TABLE `imobiliaria_BD`.`interesse` (
  `nomeInteressado` VARCHAR(70) NOT NULL,
  `emailInteressado` VARCHAR (50) NOT NULL,
  `titulo` VARCHAR (70) NOT NULL);
  
  CREATE TABLE `imobiliaria_BD`.`interessado` (
  `nomeInteressado` VARCHAR(70) NOT NULL,
  `emailInteressado` VARCHAR (50) NOT NULL);
  
  INSERT INTO `imobiliaria_BD`.`imovel`(
  `codImovel`,`tipoImovel`,`titulo`, `pretensao`, `detalhes`, `valor`, `quartos`) VALUES
  (null, 'casa','temporada joão pessoa', 'aluguel', 'apenas para casal, aluguel mensal.', 800.00, 3);
  
  INSERT INTO `imobiliaria_BD`.`imovel`(
  `codImovel`,`tipoImovel`,`titulo`, `pretensao`, `detalhes`, `valor`, `quartos`) VALUES
  (null, 'apartamento','apartamento bancários', 'venda', 'imóvel novo, primeira venda, próximo ao habibs.', 160000.00, 3);
  
  INSERT INTO `imobiliaria_BD`.`imovel`(
  `codImovel`,`tipoImovel`,`titulo`, `pretensao`, `detalhes`, `valor`, `quartos`) VALUES
  (null, 'casa','casa universitários', 'aluguel', 'procura-se menina para dividir aluguel, quarto individual.', 650.00, 2);
  
  INSERT INTO `imobiliaria_BD`.`imovel`(
  `codImovel`,`tipoImovel`,`titulo`, `pretensao`, `detalhes`, `valor`, `quartos`) VALUES
  (null, 'apartamento','apartamento mangabeira', 'venda', 'imóvel novo, primeira venda, próximo ao shopping.', 120000.00, 3);
  
  INSERT INTO `imobiliaria_BD`.`imovel`(
  `codImovel`,`tipoImovel`,`titulo`, `pretensao`, `detalhes`, `valor`, `quartos`) VALUES
  (null, 'terreno','ilha bela 40x50m', 'venda', 'próximo à praia.', 50000.00, 0);
  
  INSERT INTO `imobiliaria_BD`.`imovel`(
  `codImovel`,`tipoImovel`,`titulo`, `pretensao`, `detalhes`, `valor`, `quartos`) VALUES
  (null, 'loja','loja nova', 'aluguel', 'primeiro aluguel.', 600.00, 0);
  
  INSERT INTO `imobiliaria_BD`.`interesse`(
  `nomeInteressado`, `emailInteressado`, `titulo`) VALUES
  ('karine sales', 'karine.sales@gmail.com', 'apartamento bancários');
  
  INSERT INTO `imobiliaria_BD`.`interesse`(
  `nomeInteressado`, `emailInteressado`, `titulo`) VALUES
  ('william daybson', 'will@gmail.com', 'loja nova');
  
  INSERT INTO `imobiliaria_BD`.`interesse`(
  `nomeInteressado`, `emailInteressado`, `titulo`) VALUES
  ('karine sales', 'karine.sales@gmail.com', 'casa universitários');
  
  INSERT INTO `imobiliaria_BD`.`interessado`(
  `nomeInteressado`, `emailInteressado`) VALUES
  ('karine sales', 'karine.sales@gmail.com');
  
  INSERT INTO `imobiliaria_BD`.`interessado`(
  `nomeInteressado`, `emailInteressado`) VALUES
  ('william daybson', 'will@gmail.com');
  
  
  