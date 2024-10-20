-- CRIAÇÃO DO BANCO DE DADOS E USO DO MESMO -----------------------------------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS edusyst;
CREATE DATABASE edusyst;
USE edusyst;
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Criação da tabela Administradores
CREATE TABLE Administradores (
    Id_Adm INT(11) NOT NULL AUTO_INCREMENT,
    CPF CHAR(11) UNIQUE NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Senha VARCHAR(255) NOT NULL DEFAULT '1234',
    Data_Nasc DATE NOT NULL,
    Endereco VARCHAR(255) NOT NULL,
    Telefone CHAR(13) NOT NULL,
    Genero VARCHAR(255) NOT NULL,
    PRIMARY KEY (Id_Adm)
);

-- Criação da tabela Responsaveis
CREATE TABLE Responsaveis (
    Id_Responsavel INT(10) UNIQUE NOT NULL AUTO_INCREMENT,
    CPF CHAR(11) UNIQUE NOT NULL,
    Nome VARCHAR(255) NOT NULL,
	Email VARCHAR(255) NOT NULL,
    Senha VARCHAR(255) NOT NULL DEFAULT '1234',
    Data_Nasc DATE NOT NULL,
    Endereco VARCHAR(255) NOT NULL,
    Telefone CHAR(13) NOT NULL,
    Genero VARCHAR(255) NOT NULL,
    PRIMARY KEY (Id_Responsavel)
);

-- Criação da tabela Alunos
CREATE TABLE Alunos (
    Id_Aluno INT(10) UNIQUE NOT NULL AUTO_INCREMENT,
    CPF CHAR(11) UNIQUE NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Senha VARCHAR(255) NOT NULL DEFAULT '1234',
    Data_Nasc DATE NOT NULL,
    Endereco VARCHAR(255) NOT NULL,
    Telefone CHAR(13) NOT NULL,
    Genero VARCHAR(255) NOT NULL,
    Responsavel_ID INT(10) NOT NULL,
    PRIMARY KEY (Id_Aluno),
    CONSTRAINT FK_Aluno_Responsavel FOREIGN KEY (Responsavel_ID)
        REFERENCES Responsaveis (Id_Responsavel)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Criação da tabela Turmas
CREATE TABLE Turmas (
    Id_Turma INT(10) UNIQUE NOT NULL AUTO_INCREMENT,
    Ano INT(4) NOT NULL,
    Classe INT(4) NOT NULL,
    Etapa VARCHAR(255) NOT NULL,
    PRIMARY KEY (Id_Turma)
);

-- Criação da tabela Turmas_Alunos (Enturmação)
CREATE TABLE Turmas_Alunos (
	Turma_ID INT(10) NOT NULL,
	Aluno_ID INT(10) NOT NULL,
    PRIMARY KEY (Turma_ID, Aluno_ID),
    CONSTRAINT FK_Turma_Aluno_Turma FOREIGN KEY (Turma_ID)
        REFERENCES Turmas(Id_Turma)
         ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Turma_Aluno_Aluno FOREIGN KEY (Aluno_ID)
        REFERENCES Alunos(Id_Aluno)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Criação da tabela Professores
CREATE TABLE Professores (
    Id_Professor INT(10) NOT NULL AUTO_INCREMENT,
    CPF CHAR(11) UNIQUE NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Senha VARCHAR(255) NOT NULL DEFAULT '1234',
    Data_Nasc DATE NOT NULL,
    Endereco VARCHAR(255) NOT NULL,
    Telefone CHAR(13) NOT NULL,
    Genero VARCHAR(255) NOT NULL,
    PRIMARY KEY (Id_Professor)
);

-- Criação da tabela Materias
CREATE TABLE Materias (
    Id_Materia INT(10) NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(25) NOT NULL,
    PRIMARY KEY (Id_Materia)
);

-- Criação da tabela Horarios
CREATE TABLE Horarios (
    Id_Horario INT(10) UNIQUE NOT NULL AUTO_INCREMENT,
    Turno VARCHAR(255) NOT NULL,
    Inicio TIME NOT NULL,
    Fim TIME NOT NULL,
    Dia_Semana VARCHAR(255) NOT NULL,
    PRIMARY KEY (Id_Horario)
);

-- Criação da tabela Professores_Horarios
CREATE TABLE Professores_Horarios (
    Horario_ID INT(10) NOT NULL,
    Professor_ID INT(10) NOT NULL,
    PRIMARY KEY (Horario_ID, Professor_ID),
    CONSTRAINT FK_Professores_Horarios_Horario FOREIGN KEY (Horario_ID)
        REFERENCES Horarios(Id_Horario)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Professores_Horarios_Professor FOREIGN KEY (Professor_ID)
        REFERENCES Professores(Id_Professor)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Criação da tabela Horarios_Materias
CREATE TABLE Horarios_Materias (
    Horario_ID INT(10) NOT NULL,
    Materia_ID INT(10) NOT NULL,
    Turma_ID INT(10) NOT NULL,
    PRIMARY KEY (Horario_ID, Materia_ID),
    CONSTRAINT FK_Horario_Materia_Horario FOREIGN KEY (Horario_ID)
        REFERENCES Horarios(Id_Horario)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Horario_Materia_Materia FOREIGN KEY (Materia_ID)
        REFERENCES Materias(Id_Materia)
        ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_Horario_Materia_Turma FOREIGN KEY (Turma_ID)
        REFERENCES Turmas(Id_Turma)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Criação da tabela Notas
CREATE TABLE Notas (
    Id_Nota INT(10) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (Id_Nota),
    
    Aluno_ID INT(10) NOT NULL,
    CONSTRAINT FK_Notas_Aluno FOREIGN KEY (Aluno_Id)
        REFERENCES Alunos(Id_Aluno)
        ON DELETE CASCADE ON UPDATE CASCADE,
	
    Professor_ID INT(10) NOT NULL,
    CONSTRAINT FK_Notas_Professor FOREIGN KEY (Professor_ID)
        REFERENCES Professores(Id_Professor)
		ON DELETE CASCADE ON UPDATE CASCADE,
        
    Primeira_Etapa decimal DEFAULT null,
    Segunda_Etapa decimal DEFAULT null,
    Terceira_Etapa decimal DEFAULT null,
    Quarta_Etapa decimal DEFAULT null,
    
    Nome_Materia VARCHAR(255) DEFAULT NULL
);

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------
