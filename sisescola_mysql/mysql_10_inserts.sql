-- POPULAÇÃO DA TABELA COM INFORMAÇÕES  ---------------------------------------------------------------------------------------------------------------------
USE edusyst;
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Inserindo dados na tabela Administradores ----------------------------------------------------------------------------------------------------------------
INSERT INTO Administradores (CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero)
VALUES 
('11111111111', 'Admin Gabriel Henrique', 'Gabriel.admin@escola.com', 'admin1111', '1981-04-20', 'Rua Principal, 123',    '11987654321', 'Masculino'),
('22222222222', 'Admin Gabriel Casanova', 'Casanova.admin@escola.com','admin2222', '1981-09-10', 'Av.Getúlio Vargas,124', '12984654725', 'Masculino'),
('33333333333', 'Admin Gabriel Ferreira', 'Ferreira.admin@escola.com','admin3333', '1984-07-19', 'Av.Nilo Peçanha,6',     '15974554925', 'Masculino'),
('44444444444', 'Admin Matheus Ferreira', 'Matheus.admin@escola.com', 'admin4444', '1980-08-29', 'Av.Brasil,140',         '15974565050', 'Masculino');

-- Inserindo dados na tabela Responsaveis -------------------------------------------------------------------------------------------------------------------
INSERT INTO Responsaveis (Id_Responsavel, CPF, Senha, Nome, Email, Data_Nasc, Endereco, Telefone, Genero)
VALUES 
('1', '11222222222', 'resp1000',  'Maria da Silva',    'Maria.silva@dominio.com',       '1970-05-14', 'Rua Secundária, 456',       '11987654322', 'Feminino'),
('2', '11333333333', 'resp1001',  'Carlos Souza',      'Carlos.souza@dominio.com',      '1976-09-04', 'Rua Tertiária, 789',        '11986654324', 'Masculino'),
('3', '11444444444', 'resp1002',  'Mario Jorge',       'Mario.souza@dominio.com',       '1980-08-01', 'Rua Vagner Mourão, 89',     '11986654325', 'Masculino'),
('4', '11555555555', 'senha1003', 'Ricardo Martins',   'Ricardo.martins@dominio.com',   '1981-04-18', 'São José , 606',            '11990123456', 'Masculino'),
('5', '11666666666', 'resp1004',  'Larissa Fernandes', 'Larissa.fernandes@dominio.com', '1996-09-22', 'Rua Getúlio Vargas, 707',   '11901234567', 'Feminino'),
('6', '11777777777', 'resp1005',  'Patrícia Rocha',    'Patricia.rocha@dominio.com',    '1986-09-22', 'Rua Santo Antônio, 507',    '11901235568', 'Feminino'),
('7', '11888888888', 'resp1006',  'Jorge Filho ',      'Jorge.filho@dominio.com',       '1981-08-30', 'Rua Tiradentes, 88',        '11986654329', 'Masculino'),
('8', '11999999999', 'resp1007',  'Carlos Pereira',    'Carlos.Pereira@dominio.com',    '1985-07-15', 'Rua Sete de Setembro, 100', '12986654321', 'Masculino'),
('9', '12111111111', 'resp1008',  'Pedro Santos',      'Pedro.Santos@dominio.com',      '1987-09-05', 'Rua Aracaju, 102',          '12986654322', 'Masculino'),
('10','12222222222', 'resp1009',  'Maria Oliveira',     'Maria.Oliveira@dominio.com',   '1982-02-24', 'Rua Gaspar Dutra, 102',     '12986654323', 'Feminino');

-- Inserindo dados na tabela Alunos -------------------------------------------------------------------------------------------------------------------------
INSERT INTO Alunos (Id_Aluno, CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero, Responsavel_ID)
VALUES 
('1', '45454545454', 'Pedro Silva',    'pedro.silva@escola.com',    'aluno1000', '2010-03-10', 'Rua Secundária, 456',       '11912345678', 'Masculino', 1),
('2', '55555555555', 'Ana Souza',      'ana.souza@escola.com',      'aluno1001', '2011-07-19', 'Rua Tertiária, 789',        '11923456789', 'Feminino',  2),
('3', '54545454545', 'Felipe Lima',    'felipe.lima@escola.com',    'aluno1002', '2010-03-14', 'Rua Vagner Mourão, 89',     '11934567890', 'Masculino', 3),
('4', '78945612300', 'João Pereira',   'joao.pereira@escola.com',   'aluno1003', '2011-08-15', 'São José , 606',            '11945678901', 'Masculino',  4),
('5', '34567890123', 'Isabela Santos', 'isabela.santos@escola.com', 'aluno1004', '2010-03-14', 'Rua Getúlio Vargas, 707',   '11956789012', 'Masculino', 5),
('6', '44444444441', 'Rafael Almeida', 'rafael.almeida@escola.com', 'aluno1005', '2010-05-14', 'Rua Santo Antônio, 507',    '11967890123', 'Masculino', 6),
('7', '44444444442', 'Beatriz Rocha',  'beatriz.rocha@escola.com',  'aluno1006', '2010-06-20', 'Rua Tiradentes, 88',        '11978901234', 'Masculino', 7),
('8', '44444444443', 'Lucas Ferreira', 'lucas.ferreira@escola.com', 'aluno1007', '2010-07-14', 'Rua Sete de Setembro, 100', '11989012345', 'Masculino', 8),
('9', '44444444444', 'Mariana Souza',  'mariana.souza@escola.com',  'aluno1008', '2010-10-14', 'Rua Aracaju, 102',          '11990123456', 'Masculino', 9),
('10','44444444445', 'Ana Costa',      'ana.costa@escola.com',      'aluno1009', '2011-11-18', 'Rua Gaspar Dutra, 102',     '11901234567', 'Masculino',  10);

-- Inserindo dados na tabela Turmas -------------------------------------------------------------------------------------------------------------------------
INSERT INTO Turmas (Id_Turma, Ano, Classe, Etapa)
VALUES 
(1, 2024, 901,  'Ensino Fundamental'),
(2, 2024, 1101, 'Ensino Médio');

-- ENTURMAÇÃO (Definir qual aluno participa de qual turma) --------------------------------------------------------------------------------------------------
INSERT INTO Turmas_Alunos (Turma_ID, Aluno_ID)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(2, 10);

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Inserindo dados na tabela Professores --------------------------------------------------------------------------------------------------------------------
INSERT INTO Professores (Id_Professor,CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero)
VALUES 
(1, '66666666661', 'Prof. Alberto',        'alberto.prof@escola.com',       'prof1001', '1970-02-10', 'Rua das Palmeiras, 123',   '11987654366', 'Masculino'),
(2, '77777777771', 'Prof. Fernanda',       'fernanda.prof@escola.com',      'prof1002', '1972-06-27', 'Avenida Central, 456',     '11987654349', 'Feminino'),
(3, '77777777772', 'Prof. Marcos Oliver',  'marcosoliv.prof@escola.com',    'prof1003', '1970-07-25', 'Rua dos Lírios, 789',      '11987654347', 'Masculino'),
(4, '77777777773', 'Prof. João Lima',      'joaoima.prof@escola.com',       'prof1004', '1980-08-22', 'Praça da Alegria, 101',    '11987654355', 'Masculino'),
(5, '77777777774', 'Prof. Maria Santos',   'mariasantos.prof@escola.com',   'prof1005', '1979-02-21', 'Rua do Sol, 202',          '11987654325', 'Feminino'),
(6, '77777777775', 'Prof. Roberto Alves',  'robertoalves.prof@escola.com',  'prof1006', '1982-05-15', 'Avenida das Flores, 303',  '11987654324', 'Masculino'),
(7, '77777777776', 'Prof. Ana Paula',      'anapaula.prof@escola.com',      'prof1007', '1981-04-18', 'Rua da Esperança, 404',    '11987654323', 'Feminino'),
(8, '77777777777', 'Prof. Carlos Pereira', 'carlospereira.prof@escola.com', 'prof1008', '1983-03-10', 'Rua das Orquídeas, 505',   '11987654322', 'Masculino'),
(9, '77777777778', 'Prof. José',           'jose.prof@escola.com',          'prof1009', '1984-02-09', 'Avenida dos Saberes, 606', '11987654321', 'Masculino'),
(10,'77777777779', 'Prof. Aline',          'aline.prof@escola.com',         'prof1010', '1986-01-08', 'Rua da Harmonia, 707',     '11987654319', 'Feminino');

-- Inserindo dados na tabela Materias -----------------------------------------------------------------------------------------------------------------------
INSERT INTO Materias (Id_Materia, Nome)
VALUES 
(1,  'Matemática'),
(2,  'Português'),
(3,  'História'),
(4,  'Geografia'),
(5,  'Projeto de Vida'),
(6,  'Filosofia'),
(7,  'Fisíca'),
(8,  'Sociologia'),
(9,  'Inglês'),
(10, 'Biologia');

-- Criação de Horários --------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Horarios (Id_Horario, Turno, Inicio, Fim, Dia_Semana)
VALUES 
 -- Turno da Manhã --
(1,  'Manhã', '07:00:00', '08:40:00', 'Segunda'), -- Segunda-Feira
(2,  'Manhã', '08:40:00', '12:00:00', 'Segunda'),
(3,  'Manhã', '07:00:00', '08:40:00', 'Terça'),   -- Terça-Feira
(4,  'Manhã', '08:40:00', '12:00:00', 'Terça'),
(5,  'Manhã', '07:00:00', '08:40:00', 'Quarta'),  -- Quarta-Feira
(6,  'Manhã', '08:40:00', '12:00:00', 'Quarta'),
(7,  'Manhã', '07:00:00', '08:40:00', 'Quinta'),  -- Quinta-Feira
(8,  'Manhã', '08:40:00', '12:00:00', 'Quinta'),
(9,  'Manhã', '07:00:00', '08:40:00', 'Sexta'),   -- Sexta-Feira
(10, 'Manhã', '08:40:00', '12:00:00', 'Sexta');

-- Associar cada Professor com seu respectivo Horário (que horário esse professor dará aula) ----------------------------------------------------------------
INSERT INTO Professores_Horarios (Horario_ID, Professor_ID) VALUES
(1,  1),                      -- Ex: manhã 07:00, segunda, Prof. Alberto
(2,  1),                      -- Ex: manhã 07:00, segunda, Prof. Alberto
(2,  2),                      -- Ex: manhã 08:40, segunda, Prof. Fernanda
(3,  3),
(4,  8),
(5,  5),
(6,  9),
(7,  7),
(8,  4),
(9,  6),
(10, 10);

-- Associar cada turma com suas matérias (e em qual horário ela terá aula dessa matéria) --------------------------------------------------------------------
INSERT INTO Horarios_Materias (Horario_ID, Materia_ID, Turma_ID)
VALUES 
(1,  1,  1),                 -- Ex: manhã 07:00, segunda, Matemática, Turma 901
(2,  2,  1),                 -- Ex: manhã 08:40, segunda, Português,  Turma 901
(3,  3,  1),
(4,  4,  1),
(5,  5,  1),
(6,  6,  1),
(7,  7,  1),
(8,  8,  1),
(9,  9,  1),
(10, 10, 1),

(2,  7,  2),                 -- Ex: manhã 07:00, segunda, Física,     Turma 1101
(2,  8,  2),                 -- Ex: manhã 08:40, segunda, sociologia, Turma 1101
(3,  9,  2),
(4,  1,  2),
(5,  2,  2),
(6,  3,  2),
(7,  10, 2),
(8,  4,  2),
(9,  5,  2),
(10, 6,  2);
