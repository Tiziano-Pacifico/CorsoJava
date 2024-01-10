CREATE SCHEMA `libray` ;

CREATE TABLE `libray`.`autori` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cognome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
  --id_autore FK su id di autori
  CREATE TABLE `libray`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_autore` INT NOT NULL,
  `titolo` VARCHAR(45) NOT NULL,
  `anno_pubblicazione` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `libri_autore_idx` (`id_autore` ASC) VISIBLE,
  CONSTRAINT `libri_autore`
    FOREIGN KEY (`id_autore`)
    REFERENCES `libraydb`.`autori` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
	CREATE TABLE `libray`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cognome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
  --id_libro è settata come Unique in modo da non poter dare in prestito lo stesso libro due volte finchè il prestito non viene restituito(ovvero il record cancellato)
  CREATE TABLE `libraydb`.`prestiti` (
  `id_persona` INT NOT NULL,
  `id_libro` INT NOT NULL,
  PRIMARY KEY (`id_persona`, `id_libro`),
  UNIQUE INDEX `id_libro_UNIQUE` (`id_libro` ASC) VISIBLE,
  CONSTRAINT `prestito_persona`
    FOREIGN KEY (`id_persona`)
    REFERENCES `libraydb`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `prestito_libro`
    FOREIGN KEY (`id_libro`)
    REFERENCES `libraydb`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);