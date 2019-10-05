-- Criando o Schema
CREATE SCHEMA `meu_banco`;
USE `meu_banco`;

-- Criando tabela usuario
CREATE TABLE `usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `ativo` INT(1) NULL,
  PRIMARY KEY (`id`)
);


-- Criando tabela tarefa
CREATE TABLE `tarefa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(70) NOT NULL,
  `descricao` VARCHAR(200) NULL,
  `realizada` INT(1) NULL,
  `data` DATE NOT NULL,
  `prioridade` INT(2) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_usuario_tarefa` (`usuario_id` ASC),
  CONSTRAINT `FK_tarefa_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `meu_banco`.`usuario` (`id`)
);
