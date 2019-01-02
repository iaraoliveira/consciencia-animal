CREATE DATABASE IF NOT EXISTS consciencia_animal;

USE consciencia_animal;

CREATE TABLE IF NOT EXISTS tipo_veiculo (
    idTipoVeiculo INT PRIMARY KEY AUTO_INCREMENT,
    nomeTipoVeiculo VARCHAR (45)
);


CREATE TABLE IF NOT EXISTS veiculo (
    idVeiculo INT PRIMARY KEY AUTO_INCREMENT,
    modeloVeiculo VARCHAR(45) NULL,
    placaVeiculo VARCHAR(45) NULL,
    fabricanteVeiculo VARCHAR(45) NULL,
    estaDisponivel TINYINT(1) NULL,
    FKTipoVeiculo INT NOT NULL,
    FOREIGN KEY (FKTipoVeiculo) REFERENCES tipo_veiculo(idTipoVeiculo)
);


CREATE TABLE IF NOT EXISTS ocorrencia (
    idOcorrencia INT PRIMARY KEY AUTO_INCREMENT,
    descricaoOcorrencia VARCHAR(150) NULL,
    dataOcorrencia VARCHAR(45) ,
    localOcorrencia VARCHAR(45) NULL,
    horaOcorrencia VARCHAR(45) NULL,
	atendido BOOLEAN NULL
);


CREATE TABLE IF NOT EXISTS salvamento (
   idSalvamento INT PRIMARY KEY AUTO_INCREMENT,
   FKVeiculo INT NOT NULL,
   FKOcorrencia INT,
   horaSalvamento VARCHAR(45) NULL,
   dataSalvamento VARCHAR(45) NULL,
   localSalvamento VARCHAR(45) NULL,
   jesusSalvador VARCHAR(45) NULL,
    FOREIGN KEY (FKVeiculo) REFERENCES veiculo(idVeiculo),
    FOREIGN KEY (FKOcorrencia) REFERENCES ocorrencia(idOcorrencia)
);


CREATE TABLE IF NOT EXISTS abrigo (
   idAbrigo  INT PRIMARY KEY AUTO_INCREMENT,
   nomeAbrigo VARCHAR(45) NULL,
   localAbrigo VARCHAR(45) NULL,
   responsavelAbrigo VARCHAR(45) NULL,
   lotacaoAbrigo INT NULL
);


CREATE TABLE IF NOT EXISTS porte_animal(
   idPorteAnimal INT PRIMARY KEY AUTO_INCREMENT,
   nomePorteAnimal VARCHAR(45)
);


CREATE TABLE IF NOT EXISTS tipo_animal (
    idTipoAnimal INT PRIMARY KEY AUTO_INCREMENT,
    nomeTipoAnimal VARCHAR(45) NOT NULL
);


CREATE TABLE IF NOT EXISTS animal (
   idAnimal INT PRIMARY KEY AUTO_INCREMENT,
   FKSalvamento INT NOT NULL,
   FKAbrigo INT NOT NULL,
   FKPorteAnimal INT NOT NULL,
   FKTipoAnimal INT NOT NULL,
   nomeAnimal VARCHAR(45) NULL,
   sexoAnimal VARCHAR(45) NULL,
   racaAnimal VARCHAR(45) NULL,
   pesoAnimal VARCHAR(45) NULL,
   ehCastrado TINYINT(1) NULL,
   estaSaudavel TINYINT(1) NULL,
   FOREIGN KEY (FKSalvamento) REFERENCES salvamento(idSalvamento),
   FOREIGN KEY (FKAbrigo) REFERENCES abrigo(idAbrigo),
   FOREIGN KEY (FKPorteAnimal) REFERENCES porte_animal(idPorteAnimal),
   FOREIGN KEY (FKTipoAnimal) REFERENCES tipo_animal(idTipoAnimal)
);


# INSERTS



INSERT INTO tipo_veiculo(nomeTipoVeiculo) VALUES ("Carro"), ("Caminhão"), ("Van");

INSERT INTO ocorrencia(descricaoOcorrencia, dataOcorrencia, localOcorrencia, horaOcorrencia, atendido) VALUES 
("Capivara Perdida", "2017-05-20", "Velha", "09:30", true), 
("Gato Atropelado", "2017-05-20", "Velha", "10:30", false),
("Cachorro Maltratado", "2017-05-21", "Velha", "14:30", true),
("Cachorro Atropelado", "2017-05-21", "Velha", "16:30", false),
("Gato Perdido", "2017-05-22", "Centro", "09:30", false),
("Cachorro Perdido", "2017-05-22", "Centro", "10:30", true),
("Gato Perdido", "2017-05-23", "Centro", "14:35", false),
("Cachorro Maltratado", "2017-05-23", "Vorstadt", "09:30", true),
("Gato perdido", "2017-06-23", "Vorstadt", "11:30", false),
("Cadela Prenha Gringa", "2017-06-23", "Fidélis", "17:00", true),
("Gata Prenha Persa", "2017-06-24", "Velha", "18:15", false),
("Capivara Prenha Cearense", "2017-06-28", "Velha", "09:30", true),
("Cadela Barriga Verde", "2017-06-28", "Velha", "09:30", true);


INSERT INTO tipo_animal(nomeTipoAnimal) VALUES 
("Gato"),
("Cachorro"),
("Capivara"),
("Piriquito"),
("vinicius deprimente"),
("Giancarlo Floriano SAD"),
("Furão"),
("Rato");


INSERT INTO porte_animal(nomePorteAnimal) VALUES
("Pequeno"),
("Médio"),
("Grande");


INSERT INTO abrigo(nomeAbrigo, localAbrigo, responsavelAbrigo, lotacaoAbrigo) VALUES
("Abrigo A", "Centro", "Pedro", 50),
("Abrigo B", "Velha", "Joana", 20),
("Abrigo C", "Vorstadt", "José", 75),
("Abrigo D", "Velha", "Letícia", 100),
("Abrigo F", "Água Verde", "Giancarlo Floriano Peixoto", 50),
("Abrigo G", "Centro", "Koga", 20);


INSERT INTO veiculo(modeloVeiculo, placaVeiculo, fabricanteVeiculo, estaDisponivel, FKTipoVeiculo) VALUES
("Modelo 1", "MJK-999", "Honda", true, 1),
("Modelo 2", "JDK-123", "Fiat", false, 3),
("Modelo 3", "DSJ-456", "Honda", true, 2),
("Modelo 4", "FGT-789", "Fiat", false, 1),
("Modelo 5", "VBM-147", "Fiat", true, 3),
("Modelo 6", "XYW-987", "Honda", true, 1);


INSERT INTO salvamento(FKVeiculo, FKOcorrencia, horaSalvamento, dataSalvamento, localSalvamento, jesusSalvador) VALUES
(1, 1, "10:00", "2017-05-22", "Velha", "José"),
(2, 2, "11:00", "2017-05-20", "Velha", "Fábio"),
(3, 3, "15:00", "2017-05-20", "Velha", "João"),
(4, 4, "17:00", "2017-05-21", "Velha", "Joana"),
(5, 5, "10:00", "2017-05-22", "Centro", "José"),
(6, 6, "11:00", "2017-05-22", "Centro", "Júlia"),
(1, 7, "15:00", "2017-05-23", "Centro", "Maria"),
(2, 8, "11:00", "2017-05-23", "Vorstadt", "Gian"),
(3, 9, "12:00", "2017-06-23", "Vorstadt", "Vinicius"),
(4, 10, "18:00", "2017-06-23", "Fidélis", "José"),
(5, 11, "18:30", "2017-06-24", "Velha", "Maria"),
(6, 12, "10:00", "2017-06-28", "Velha", "Gian"),
(1, 13, "10:00", "2017-06-28", "Velha", "José");


INSERT INTO animal(FKSalvamento, FKAbrigo, FKPorteAnimal, FKTipoAnimal, nomeAnimal, sexoAnimal, racaAnimal, pesoAnimal, ehCastrado, estaSaudavel) VALUES
(6, 1, 3, 2, "Juca", "Macho", "Labrador", "20KG", false, true),
(4, 2, 2, 2, "Rex", "Macho", "Vira-Lata", "8KG", false, false),
(5, 3, 1, 1, "Miau", "Fêmea", "Persa", "5KG", false, true),
(1, 4, 3, 3, "Capivara Gorda", "Fêmea", "Não se Sabe", "25kg", false, true),
(3, 1, 2, 2, "Jaime", "Macho", "Vira-Lata", "12KG", false, false);

SELECT COUNT(idSalvamento), localSalvamento, MONTH(dataSalvamento) FROM salvamento GROUP BY localSalvamento, MONTH(dataSalvamento);
