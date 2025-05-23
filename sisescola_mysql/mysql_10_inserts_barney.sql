-- POPULAÇÃO DA TABELA COM INFORMAÇÕES  ---------------------------------------------------------------------------------------------------------------------
USE edusyst;
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Inserindo dados na tabela Administradores ----------------------------------------------------------------------------------------------------------------
INSERT INTO Administradores (CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero)
VALUES 
('15189896730', 'Admin Gabriel Henrique', 'Gabriel.admin@escola.com', 'admin1111', '1981-04-20', 'Rua Principal, 123',    '11987654321', 'Masculino'),
('20395148752', 'Admin Gabriel Casanova', 'Casanova.admin@escola.com','admin2222', '1981-09-10', 'Av.Getúlio Vargas,124', '12984654725', 'Masculino'),
('03544795101', 'Admin Gabriel Ferreira', 'Ferreira.admin@escola.com','admin3333', '1984-07-19', 'Av.Nilo Peçanha,6',     '15974554925', 'Masculino'),
('10456207845', 'Admin Matheus Ferreira', 'Matheus.admin@escola.com', 'admin4444', '1980-08-29', 'Av.Brasil,140',         '15974565050', 'Masculino');

-- Inserindo dados na tabela Responsaveis -------------------------------------------------------------------------------------------------------------------
INSERT INTO Responsaveis (Id_Responsavel, CPF, Senha, Nome, Email, Data_Nasc, Endereco, Telefone, Genero)
VALUES 
('1', '01234567890', 'resp1000',  'Maria da Silva',    'maria.silva@dominio.com',       '1970-05-14', 'Rua Secundária, 456',       '11987654322', 'Feminino'),
('2', '02345678901', 'resp1001',  'Carlos Souza',      'carlos.souza@dominio.com',      '1976-09-04', 'Rua Tertiária, 789',        '11986654324', 'Masculino'),
('3', '03456789012', 'resp1002',  'Mario Jorge',       'mario.jorge@dominio.com',       '1980-08-01', 'Rua Vagner Mourão, 89',     '11986654325', 'Masculino'),
('4', '04567890123', 'senha1003', 'Ricardo Martins',   'ricardo.martins@dominio.com',   '1981-04-18', 'São José, 606',            '11990123456', 'Masculino'),
('5', '05678901234', 'resp1004',  'Larissa Fernandes', 'larissa.fernandes@dominio.com', '1996-09-22', 'Rua Getúlio Vargas, 707',   '11901234567', 'Feminino'),
('6', '06789012345', 'resp1005',  'Patrícia Rocha',   'patricia.rocha@dominio.com',    '1986-09-22', 'Rua Santo Antônio, 507',    '11901235568', 'Feminino'),
('7', '07890123456', 'resp1006',  'Jorge Filho',      'jorge.filho@dominio.com',       '1981-08-30', 'Rua Tiradentes, 88',        '11986654329', 'Masculino'),
('8', '08901234567', 'resp1007',  'Carlos Pereira',   'carlos.pereira@dominio.com',    '1985-07-15', 'Rua Sete de Setembro, 100', '12986654321', 'Masculino'),
('9', '09012345678', 'resp1008',  'Pedro Santos',     'pedro.santos@dominio.com',      '1987-09-05', 'Rua Aracaju, 102',          '12986654322', 'Masculino'),
('10', '10123456789', 'resp1009',  'Maria Oliveira',   'maria.oliveira@dominio.com',    '1982-02-24', 'Rua Gaspar Dutra, 102',     '12986654323', 'Feminino'),
('11', '11234567890', 'resp1010',  'Felipe Lima',      'felipe.lima@dominio.com',       '1988-11-30', 'Rua do Sol, 100',           '12987654324', 'Masculino'),
('12', '12345678901', 'resp1011',  'Beatriz Almeida',  'beatriz.almeida@dominio.com',   '1985-12-01', 'Rua da Luz, 200',           '12987654325', 'Feminino'),
('13', '13456789012', 'resp1012',  'João Ferreira',    'joao.ferreira@dominio.com',     '1992-06-15', 'Rua da Paz, 300',           '12987654326', 'Masculino'),
('14', '14567890123', 'resp1013',  'Mariana Costa',    'mariana.costa@dominio.com',     '1989-03-20', 'Rua das Flores, 400',       '12987654327', 'Feminino'),
('15', '15678901234', 'resp1014',  'Roberto Santos',   'roberto.santos@dominio.com',    '1983-10-10', 'Rua do Campo, 500',         '12987654328', 'Masculino'),
('16', '16789012345', 'resp1015',  'Isabela Rodrigues', 'isabela.rodrigues@dominio.com', '1995-02-14', 'Rua da Liberdade, 600',     '12987654329', 'Feminino'),
('17', '17890123456', 'resp1016',  'Lucas Alves',       'lucas.alves@dominio.com',       '1986-07-12', 'Rua das Palmeiras, 700',    '12987654330', 'Masculino'),
('18', '18901234567', 'resp1017',  'Aline Martins',     'aline.martins@dominio.com',     '1991-11-25', 'Rua do Amor, 800',          '12987654331', 'Feminino'),
('19', '19012345678', 'resp1018',  'Fernando Silva',   'fernando.silva@dominio.com',    '1984-04-21', 'Rua do Horizonte, 900',     '12987654332', 'Masculino'),
('20', '20123456789', 'resp1019',  'Sofia Mendes',     'sofia.mendes@dominio.com',      '1990-05-30', 'Rua da Alegria, 1000',      '12987654333', 'Feminino'),
('21', '21234567890', 'resp1020',  'Ricardo Lima',     'ricardo.lima@dominio.com',       '1985-08-18', 'Rua da Esperança, 1100',    '12987654334', 'Masculino'),
('22', '22345678901', 'resp1021',  'Tatiane Rocha',    'tatiane.rocha@dominio.com',     '1987-09-15', 'Rua da Vitória, 1200',      '12987654335', 'Feminino'),
('23', '23456789012', 'resp1022',  'Vinícius Pereira', 'vinicius.pereira@dominio.com',  '1992-12-05', 'Rua da Felicidade, 1300',   '12987654336', 'Masculino'),
('24', '24567890123', 'resp1023',  'Larissa Nascimento','larissa.nascimento@dominio.com', '1993-03-10', 'Rua do Pôr do Sol, 1400',   '12987654337', 'Feminino'),
('25', '25678901234', 'resp1024',  'Thiago Almeida',   'thiago.almeida@dominio.com',    '1988-01-25', 'Rua das Estrelas, 1500',     '12987654338', 'Masculino'),
('26', '26789012345', 'resp1025',  'Fernanda Gomes',   'fernanda.gomes@dominio.com',    '1987-10-30', 'Rua das Borboletas, 1600',   '12987654339', 'Feminino'),
('27', '27890123456', 'resp1026',  'Gustavo Costa',    'gustavo.costa@dominio.com',     '1990-11-15', 'Rua do Vento, 1700',        '12987654340', 'Masculino'),
('28', '28901234567', 'resp1027',  'Tatiane Dias',     'tatiane.dias@dominio.com',      '1989-02-08', 'Rua do Mar, 1800',           '12987654341', 'Feminino'),
('29', '29012345678', 'resp1028',  'Ricardo Alves',    'ricardo.alves@dominio.com',     '1986-07-22', 'Rua da Água, 1900',         '12987654342', 'Masculino'),
('30', '30123456789', 'resp1029',  'Sabrina Almeida',  'sabrina.almeida@dominio.com',   '1995-03-19', 'Rua das Árvores, 2000',     '12987654343', 'Feminino'),
('31', '31234567890', 'resp1030',  'Felipe Mendes',    'felipe.mendes@dominio.com',     '1984-01-30', 'Rua do Lago, 2100',        '12987654344', 'Masculino'),
('32', '32345678901', 'resp1031',  'Jéssica Souza',    'jessica.souza@dominio.com',      '1993-05-05', 'Rua do Sol Nascente, 2200', '12987654345', 'Feminino'),
('33', '33456789012', 'resp1032',  'Eduardo Ferreira',  'eduardo.ferreira@dominio.com',   '1985-08-12', 'Rua do Coração, 2300',     '12987654346', 'Masculino'),
('34', '34567890123', 'resp1033',  'Amanda Martins',   'amanda.martins@dominio.com',    '1991-06-18', 'Rua do Céu, 2400',         '12987654347', 'Feminino'),
('35', '35678901234', 'resp1034',  'Rafael Gomes',     'rafael.gomes@dominio.com',       '1987-09-14', 'Rua da Lua, 2500',         '12987654348', 'Masculino'),
('36', '36789012345', 'resp1035',  'Viviane Costa',    'viviane.costa@dominio.com',      '1983-12-30', 'Rua das Flores do Campo, 2600', '12987654349', 'Feminino'),
('37', '37890123456', 'resp1036',  'Lucas Andrade',    'lucas.andrade@dominio.com',     '1990-02-10', 'Rua da Montanha, 2700',    '12987654350', 'Masculino'),
('38', '38901234567', 'resp1037',  'Elaine Nascimento', 'elaine.nascimento@dominio.com', '1986-07-28', 'Rua do Rio, 2800',       '12987654351', 'Feminino'),
('39', '39012345678', 'resp1038',  'Bruno Lima',       'bruno.lima@dominio.com',         '1988-04-17', 'Rua da Primavera, 2900',   '12987654352', 'Masculino'),
('40', '40123456789', 'resp1039',  'Natália Santos',   'natalia.santos@dominio.com',     '1985-05-16', 'Rua das Orquídeas, 3000',   '12987654353', 'Feminino'),
('41', '41234567890', 'resp1040',  'Marcos Silva',     'marcos.silva@dominio.com',       '1991-08-01', 'Rua do Farol, 3100',       '12987654354', 'Masculino'),
('42', '42345678901', 'resp1041',  'Fernanda Alves',   'fernanda.alves@dominio.com',     '1984-02-22', 'Rua da Brisa, 3200',       '12987654355', 'Feminino'),
('43', '43456789012', 'resp1042',  'Fábio Costa',      'fabio.costa@dominio.com',        '1987-06-12', 'Rua da Tradição, 3300',    '12987654356', 'Masculino'),
('44', '44567890123', 'resp1043',  'Camila Pereira',   'camila.pereira@dominio.com',     '1992-03-09', 'Rua da Sabedoria, 3400',   '12987654357', 'Feminino'),
('45', '45678901234', 'resp1044',  'Ricardo Almeida',  'ricardo.almeida@dominio.com',    '1989-05-14', 'Rua do Encanto, 3500',     '12987654358', 'Masculino'),
('46', '46789012345', 'resp1045',  'Tatiane Lopes',    'tatiane.lopes@dominio.com',      '1990-07-17', 'Rua do Sonho, 3600',       '12987654359', 'Feminino'),
('47', '47890123456', 'resp1046',  'Diego Martins',    'diego.martins@dominio.com',      '1988-11-28', 'Rua da Luz do Dia, 3700',   '12987654360', 'Masculino'),
('48', '48901234567', 'resp1047',  'Aline Dias',       'aline.dias@dominio.com',         '1991-01-22', 'Rua do Sorriso, 3800',      '12987654361', 'Feminino'),
('49', '49012345678', 'resp1048',  'Leandro Silva',    'leandro.silva@dominio.com',      '1983-09-02', 'Rua da Conquista, 3900',   '12987654362', 'Masculino'),
('50', '50123456789', 'resp1049',  'Vanessa Costa',    'vanessa.costa@dominio.com',      '1985-03-12', 'Rua da Esperança, 4000',    '12987654363', 'Feminino'),
('51', '51234567890', 'resp1050',  'Gabriel Ferreira',  'gabriel.ferreira@dominio.com',   '1987-04-19', 'Rua do Trabalho, 4100',    '12987654364', 'Masculino'),
('52', '52345678901', 'resp1051',  'Tatiane Mendes',   'tatiane.mendes@dominio.com',    '1991-06-29', 'Rua do Mar, 4200',          '12987654365', 'Feminino'),
('53', '53456789012', 'resp1052',  'Fernando Gomes',   'fernando.gomes@dominio.com',    '1986-10-11', 'Rua do Vento, 4300',        '12987654366', 'Masculino'),
('54', '54567890123', 'resp1053',  'Larissa Santos',   'larissa.santos@dominio.com',    '1990-02-14', 'Rua do Horizonte, 4400',   '12987654367', 'Feminino'),
('55', '55678901234', 'resp1054',  'Pedro Almeida',    'pedro.almeida@dominio.com',     '1989-11-30', 'Rua da Alegria, 4500',      '12987654368', 'Masculino'),
('56', '56789012345', 'resp1055',  'Camila Nascimento', 'camila.nascimento@dominio.com', '1988-05-16', 'Rua da Paz, 4600',          '12987654369', 'Feminino'),
('57', '57890123456', 'resp1056',  'Roberto Costa',    'roberto.costa@dominio.com',     '1987-09-02', 'Rua da Luz, 4700',          '12987654370', 'Masculino'),
('58', '58901234567', 'resp1057',  'Sofia Lima',       'sofia.lima@dominio.com',        '1992-04-21', 'Rua da Esperança, 4800',   '12987654371', 'Feminino'),
('59', '59012345678', 'resp1058',  'Rafael Santos',    'rafael.santos@dominio.com',     '1986-12-15', 'Rua do Amor, 4900',        '12987654372', 'Masculino'),
('60', '60123456789', 'resp1059',  'Mariana Mendes',   'mariana.mendes@dominio.com',    '1995-03-09', 'Rua do Encanto, 5000',      '12987654373', 'Feminino'),
('61', '61234567890', 'resp1060',  'Lucas Costa',      'lucas.costa@dominio.com',       '1991-02-12', 'Rua da Liberdade, 5100',    '12987654374', 'Masculino'),
('62', '62345678901', 'resp1061',  'Bruna Almeida',    'bruna.almeida@dominio.com',     '1994-05-15', 'Rua da Paz, 5200',         '12987654375', 'Feminino'),
('63', '63456789012', 'resp1062',  'Gabriel Dias',     'gabriel.dias@dominio.com',      '1986-01-19', 'Rua do Vento, 5300',       '12987654376', 'Masculino'),
('64', '64567890123', 'resp1063',  'Tatiane Lopes',    'tatiane.lopes@dominio.com',     '1995-06-20', 'Rua do Sol, 5400',         '12987654377', 'Feminino'),
('65', '65678901234', 'resp1064',  'Marcos Ferreira',  'marcos.ferreira@dominio.com',   '1993-08-14', 'Rua da Estrela, 5500',     '12987654378', 'Masculino'),
('66', '66789012345', 'resp1065',  'Carla Santos',     'carla.santos@dominio.com',      '1988-10-28', 'Rua do Céu, 5600',        '12987654379', 'Feminino'),
('67', '67890123456', 'resp1066',  'Eduardo Mendes',   'eduardo.mendes@dominio.com',    '1990-02-12', 'Rua da Brisa, 5700',       '12987654380', 'Masculino'),
('68', '68901234567', 'resp1067',  'Luciana Silva',    'luciana.silva@dominio.com',     '1992-03-13', 'Rua do Sol Nascente, 5800', '12987654381', 'Feminino'),
('69', '69012345678', 'resp1068',  'Felipe Almeida',   'felipe.almeida@dominio.com',    '1984-11-25', 'Rua da Luz do Dia, 5900',  '12987654382', 'Masculino'),
('70', '70123456789', 'resp1069',  'Tatiane Ferreira',  'tatiane.ferreira@dominio.com',   '1989-07-09', 'Rua da Alegria, 6000',      '12987654383', 'Feminino'),
('71', '71234567890', 'resp1070',  'Juliana Santos',   'juliana.santos@dominio.com',    '1986-08-20', 'Rua da Tradição, 6100',    '12987654384', 'Feminino'),
('72', '72345678901', 'resp1071',  'Thiago Lima',      'thiago.lima@dominio.com',       '1993-10-11', 'Rua do Céu, 6200',         '12987654385', 'Masculino'),
('73', '73456789012', 'resp1072',  'Marcos Costa',     'marcos.costa@dominio.com',      '1992-01-15', 'Rua do Sorriso, 6300',      '12987654386', 'Masculino'),
('74', '74567890123', 'resp1073',  'Beatriz Almeida',  'beatriz.almeida@dominio.com',   '1990-11-18', 'Rua do Sol, 6400',          '12987654387', 'Feminino'),
('75', '75678901234', 'resp1074',  'Carlos Andrade',   'carlos.andrade@dominio.com',    '1988-06-22', 'Rua da Esperança, 6500',   '12987654388', 'Masculino'),
('76', '76789012345', 'resp1075',  'Fernanda Nascimento', 'fernanda.nascimento@dominio.com', '1991-12-29', 'Rua da Luz, 6600',          '12987654389', 'Feminino'),
('77', '77890123456', 'resp1076',  'Lucas Pereira',    'lucas.pereira@dominio.com',     '1985-10-03', 'Rua do Amor, 6700',        '12987654390', 'Masculino'),
('78', '78901234567', 'resp1077',  'Roberta Mendes',   'roberta.mendes@dominio.com',    '1994-09-29', 'Rua do Farol, 6800',       '12987654391', 'Feminino'),
('79', '79012345678', 'resp1078',  'Ricardo Silva',    'ricardo.silva@dominio.com',     '1983-07-12', 'Rua do Encanto, 6900',    '12987654392', 'Masculino'),
('80', '80123456789', 'resp1079',  'Patrícia Costa',   'patricia.costa@dominio.com',    '1986-05-22', 'Rua da Felicidade, 7000',   '12987654393', 'Feminino'),
('81', '81234567890', 'resp1080',  'Tatiane Ferreira',  'tatiane.ferreira@dominio.com',  '1988-02-25', 'Rua da Lua, 7100',         '12987654394', 'Feminino'),
('82', '82345678901', 'resp1081',  'Fábio Mendes',     'fabio.mendes@dominio.com',      '1992-06-13', 'Rua do Lago, 7200',        '12987654395', 'Masculino'),
('83', '83456789012', 'resp1082',  'Mariana Lopes',    'mariana.lopes@dominio.com',     '1990-01-01', 'Rua da Brisa, 7300',      '12987654396', 'Feminino'),
('84', '84567890123', 'resp1083',  'Felipe Costa',     'felipe.costa@dominio.com',      '1989-03-18', 'Rua da Tradição, 7400',    '12987654397', 'Masculino'),
('85', '85678901234', 'resp1084',  'Gabriela Silva',   'gabriela.silva@dominio.com',    '1984-12-30', 'Rua do Horizonte, 7500',   '12987654398', 'Feminino'),
('86', '86789012345', 'resp1085',  'Leonardo Nascimento','leonardo.nascimento@dominio.com','1993-09-14', 'Rua da Luz do Dia, 7600',  '12987654399', 'Masculino'),
('87', '87890123456', 'resp1086',  'Isabella Ferreira', 'isabella.ferreira@dominio.com', '1987-08-11', 'Rua da Felicidade, 7700',  '12987654400', 'Feminino'),
('88', '88901234567', 'resp1087',  'Eduardo Lima',     'eduardo.lima@dominio.com',      '1991-04-05', 'Rua da Esperança, 7800',   '12987654401', 'Masculino'),
('89', '89012345678', 'resp1088',  'Carla Mendes',     'carla.mendes@dominio.com',      '1986-01-20', 'Rua da Paz, 7900',        '12987654402', 'Feminino'),
('90', '93123456789', 'resp1089',  'Lucas Andrade',    'lucas.andrade@dominio.com',     '1992-11-10', 'Rua do Amor, 8000',        '12987654403', 'Masculino'),
('91', '91234567890', 'resp1090',  'Juliana Costa',    'juliana.costa@dominio.com',     '1983-06-15', 'Rua da Luz, 8100',        '12987654404', 'Feminino'),
('92', '92345678901', 'resp1091',  'Marcos Ferreira',  'marcos.ferreira@dominio.com',   '1995-02-22', 'Rua da Brisa, 8200',      '12987654405', 'Masculino'),
('93', '93456789012', 'resp1092',  'Patrícia Almeida', 'patricia.almeida@dominio.com',  '1988-09-30', 'Rua do Céu, 8300',       '12987654406', 'Feminino'),
('94', '94567890123', 'resp1093',  'Roberto Silva',    'roberto.silva@dominio.com',     '1992-03-09', 'Rua do Encanto, 8400',    '12987654407', 'Masculino'),
('95', '95678901234', 'resp1094',  'Gabriela Mendes',  'gabriela.mendes@dominio.com',   '1994-06-12', 'Rua da Alegria, 8500',      '12987654408', 'Feminino'),
('96', '96789012345', 'resp1095',  'Felipe Santos',    'felipe.santos@dominio.com',     '1983-04-07', 'Rua da Luz do Dia, 8600',  '12987654409', 'Masculino'),
('97', '97890123456', 'resp1096',  'Tatiane Costa',    'tatiane.costa@dominio.com',     '1990-12-01', 'Rua da Esperança, 8700',   '12987654410', 'Feminino'),
('98', '98901234567', 'resp1097',  'Jorge Almeida',    'jorge.almeida@dominio.com',     '1986-10-20', 'Rua da Brisa, 8800',      '12987654411', 'Masculino'),
('99', '99012345678', 'resp1098',  'Renata Silva',     'renata.silva@dominio.com',      '1991-05-30', 'Rua do Sol, 8900',         '12987654412', 'Feminino'),
('100', '90123456789', 'resp1099',  'Gustavo Nascimento', 'gustavo.nascimento@dominio.com', '1994-02-11', 'Rua do Horizonte, 9000', '12987654413', 'Masculino');

-- Inserindo dados na tabela Alunos -------------------------------------------------------------------------------------------------------------------------
INSERT INTO Alunos (Id_Aluno, CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero, Responsavel_ID)
VALUES 
('1', '05090785811', 'Pedro Silva',    'pedro.silva@escola.com',    'aluno1000', '2010-03-10', 'Rua Secundária, 456',       '11912345678', 'Masculino', 1),
('2', '00789865402', 'Ana Souza',      'ana.souza@escola.com',      'aluno1001', '2011-07-19', 'Rua Tertiária, 789',        '11923456789', 'Feminino', 2),
('3', '00176981205', 'Felipe Lima',    'felipe.lima@escola.com',    'aluno1002', '2010-03-14', 'Rua Vagner Mourão, 89',     '11934567890', 'Masculino', 3),
('4', '10587898911', 'João Pereira',   'joao.pereira@escola.com',   'aluno1003', '2011-08-15', 'São José, 606',             '11945678901', 'Masculino', 4),
('5', '11076852504', 'Isabela Santos', 'isabela.santos@escola.com', 'aluno1004', '2010-03-14', 'Rua Getúlio Vargas, 707',   '11956789012', 'Feminino', 5),
('6', '10264119011', 'Rafael Almeida', 'rafael.almeida@escola.com', 'aluno1005', '2010-05-14', 'Rua Santo Antônio, 507',    '11967890123', 'Masculino', 6),
('7', '15415968236', 'Beatriz Rocha',  'beatriz.rocha@escola.com',  'aluno1006', '2010-06-20', 'Rua Tiradentes, 88',        '11978901234', 'Feminino', 7),
('8', '16225578991', 'Lucas Ferreira', 'lucas.ferreira@escola.com', 'aluno1007', '2010-07-14', 'Rua Sete de Setembro, 100', '11989012345', 'Masculino', 8),
('9', '20228834110', 'Mariana Souza',  'mariana.souza@escola.com',  'aluno1008', '2010-10-14', 'Rua Aracaju, 102',          '11990123456', 'Feminino', 9),
('10','00102535022', 'Ana Costa',      'ana.costa@escola.com',      'aluno1009', '2011-11-18', 'Rua Gaspar Dutra, 102',     '11901234567', 'Feminino', 10),
('11', '31045821931', 'Carlos Almeida', 'carlos.almeida@escola.com', 'aluno1010', '2012-01-25', 'Rua da Esperança, 45', '11901234568', 'Masculino', 11),
('12', '21876543211', 'Julia Martins', 'julia.martins@escola.com', 'aluno1011', '2010-03-30', 'Rua da Alegria, 11', '11901234569', 'Feminino', 12),
('13', '10987654322', 'Marcos Dias', 'marcos.dias@escola.com', 'aluno1012', '2012-06-15', 'Rua da Paz, 20', '11901234570', 'Masculino', 13),
('14', '30098765433', 'Larissa Nunes', 'larissa.nunes@escola.com', 'aluno1013', '2013-04-22', 'Rua do Sol, 90', '11901234571', 'Feminino', 14),
('15', '21076852504', 'Gustavo Ribeiro', 'gustavo.ribeiro@escola.com', 'aluno1014', '2010-07-17', 'Rua do Lago, 33', '11901234572', 'Masculino', 15),
('16', '12364119011', 'Roberta Lima', 'roberta.lima@escola.com', 'aluno1015', '2011-05-19', 'Rua das Flores, 55', '11901234573', 'Feminino', 16),
('17', '32415968236', 'Thiago Santos', 'thiago.santos@escola.com', 'aluno1016', '2012-08-24', 'Rua da Montanha, 78', '11901234574', 'Masculino', 17),
('18', '21345678901', 'Sofia Costa', 'sofia.costa@escola.com', 'aluno1017', '2011-02-10', 'Rua da Lua, 66', '11901234575', 'Feminino', 18),
('19', '31456789013', 'Felipe Almeida', 'felipe.almeida@escola.com', 'aluno1018', '2013-03-03', 'Rua do Vento, 22', '11901234576', 'Masculino', 19),
('20', '40567890124', 'Vanessa Ferreira', 'vanessa.ferreira@escola.com', 'aluno1019', '2010-11-11', 'Rua do Rio, 10', '11901234577', 'Feminino', 20),
('21', '50678901235', 'Eduardo Gomes', 'eduardo.gomes@escola.com', 'aluno1020', '2012-09-09', 'Rua da Serra, 12', '11901234578', 'Masculino', 21),
('22', '60789012346', 'Clara Martins', 'clara.martins@escola.com', 'aluno1021', '2013-05-14', 'Rua do Mar, 34', '11901234579', 'Feminino', 22),
('23', '70890123457', 'Nicolas Lima', 'nicolas.lima@escola.com', 'aluno1022', '2010-06-05', 'Rua do Sol Nascente, 56', '11901234580', 'Masculino', 23),
('24', '80901234568', 'Marina Costa', 'marina.costa@escola.com', 'aluno1023', '2011-01-12', 'Rua do Horizonte, 88', '11901234581', 'Feminino', 24),
('25', '90112345679', 'Leonardo Oliveira', 'leonardo.oliveira@escola.com', 'aluno1024', '2012-03-15', 'Rua das Estrelas, 20', '11901234582', 'Masculino', 25),
('26', '01223456780', 'Isadora Santos', 'isadora.santos@escola.com', 'aluno1025', '2013-02-20', 'Rua da Esperança, 12', '11901234583', 'Feminino', 26),
('27', '12334567891', 'Bruno Almeida', 'bruno.almeida@escola.com', 'aluno1026', '2010-04-04', 'Rua do Saber, 42', '11901234584', 'Masculino', 27),
('28', '23445678902', 'Miriam Rocha', 'miriam.rocha@escola.com', 'aluno1027', '2012-10-30', 'Rua da Cultura, 73', '11901234585', 'Feminino', 28),
('29', '34556789013', 'Rodrigo Silva', 'rodrigo.silva@escola.com', 'aluno1028', '2013-07-27', 'Rua do Conhecimento, 90', '11901234586', 'Masculino', 29),
('30', '45667890124', 'Paula Ferreira', 'paula.ferreira@escola.com', 'aluno1029', '2010-05-21', 'Rua da Compreensão, 19', '11901234587', 'Feminino', 30),
('31', '56778901235', 'Gabriel Nunes', 'gabriel.nunes@escola.com', 'aluno1030', '2011-11-29', 'Rua da Sabedoria, 27', '11901234588', 'Masculino', 31),
('32', '67889012346', 'Lívia Almeida', 'livia.almeida@escola.com', 'aluno1031', '2012-01-19', 'Rua da Autonomia, 82', '11901234589', 'Feminino', 32),
('33', '78990123457', 'Daniel Ferreira', 'daniel.ferreira@escola.com', 'aluno1032', '2013-03-04', 'Rua da Libertação, 94', '11901234590', 'Masculino', 33),
('34', '89001234568', 'Tânia Ribeiro', 'tania.ribeiro@escola.com', 'aluno1033', '2010-04-09', 'Rua da Renovação, 55', '11901234591', 'Feminino', 34),
('35', '90312345679', 'Felipe Costa', 'felipe.costa@escola.com', 'aluno1034', '2011-02-11', 'Rua da Integração, 29', '11901234592', 'Masculino', 35),
('36', '02223456780', 'Bianca Martins', 'bianca.martins@escola.com', 'aluno1035', '2012-06-15', 'Rua do Horizonte, 84', '11901234593', 'Feminino', 36),
('37', '11334567891', 'André Lima', 'andre.lima@escola.com', 'aluno1036', '2013-08-20', 'Rua da Interação, 60', '11901234594', 'Masculino', 37),
('38', '24445678902', 'Cíntia Nunes', 'cintia.nunes@escola.com', 'aluno1037', '2010-09-21', 'Rua do Compromisso, 11', '11901234595', 'Feminino', 38),
('39', '35556789013', 'Igor Silva', 'igor.silva@escola.com', 'aluno1038', '2011-12-05', 'Rua do Destino, 53', '11901234596', 'Masculino', 39),
('40', '45567890124', 'Nadia Costa', 'nadia.costa@escola.com', 'aluno1039', '2012-05-19', 'Rua do Conforto, 76', '11901234597', 'Feminino', 40),
('41', '56878901235', 'Cláudio Mendes', 'claudio.mendes@escola.com', 'aluno1040', '2013-02-14', 'Rua do Futuro, 58', '11901234598', 'Masculino', 41),
('42', '67989012346', 'Tatiane Carvalho', 'tatiane.carvalho@escola.com', 'aluno1041', '2010-09-05', 'Rua das Flores, 21', '11901234599', 'Feminino', 42),
('43', '78190123457', 'Victor Hugo', 'victor.hugo@escola.com', 'aluno1042', '2012-04-12', 'Rua da Luz, 44', '11901234600', 'Masculino', 43),
('44', '89101234568', 'Lara Almeida', 'lara.almeida@escola.com', 'aluno1043', '2011-03-25', 'Rua da Verdade, 25', '11901234601', 'Feminino', 44),
('45', '90212345679', 'Sérgio Lopes', 'sergio.lopes@escola.com', 'aluno1044', '2013-01-10', 'Rua da Liberdade, 88', '11901234602', 'Masculino', 45),
('46', '01323456780', 'Camila Martins', 'camila.martins@escola.com', 'aluno1045', '2010-11-19', 'Rua da Esperança, 66', '11901234603', 'Feminino', 46),
('47', '12534567891', 'Rafael Costa', 'rafael.costa@escola.com', 'aluno1046', '2011-07-30', 'Rua da Vitória, 19', '11901234604', 'Masculino', 47),
('48', '23145678902', 'Mônica Ferreira', 'monica.ferreira@escola.com', 'aluno1047', '2012-03-12', 'Rua do Amanhã, 12', '11901234605', 'Feminino', 48),
('49', '34656789013', 'Felipe Rocha', 'felipe.rocha@escola.com', 'aluno1048', '2010-10-15', 'Rua da Esperança, 20', '11901234606', 'Masculino', 49),
('50', '45767890124', 'Débora Lima', 'debora.lima@escola.com', 'aluno1049', '2013-05-23', 'Rua do Amanhã, 33', '11901234607', 'Feminino', 50),
('51', '56178901235', 'João Paulo', 'joao.paulo@escola.com', 'aluno1050', '2011-12-20', 'Rua das Flores, 45', '11901234608', 'Masculino', 51),
('52', '67089012346', 'Luísa Rocha', 'luisa.rocha@escola.com', 'aluno1051', '2012-09-10', 'Rua da Luz, 89', '11901234609', 'Feminino', 52),
('53', '78090123457', 'Fernando Dias', 'fernando.dias@escola.com', 'aluno1052', '2013-08-05', 'Rua da Esperança, 23', '11901234610', 'Masculino', 53),
('54', '09001234568', 'Pamela Alves', 'pamela.alves@escola.com', 'aluno1053', '2010-02-18', 'Rua da Felicidade, 67', '11901234611', 'Feminino', 54),
('55', '90012345679', 'Maurício Santos', 'mauricio.santos@escola.com', 'aluno1054', '2011-05-01', 'Rua do Sonho, 92', '11901234612', 'Masculino', 55),
('56', '01203456780', 'Aline Martins', 'aline.martins@escola.com', 'aluno1055', '2012-01-12', 'Rua do Progresso, 44', '11901234613', 'Feminino', 56),
('57', '12304567891', 'Ricardo Oliveira', 'ricardo.oliveira@escola.com', 'aluno1056', '2013-06-27', 'Rua da Esperança, 11', '11901234614', 'Masculino', 57),
('58', '23405678902', 'Vanessa Ribeiro', 'vanessa.ribeiro@escola.com', 'aluno1057', '2010-07-10', 'Rua da Alegria, 28', '11901234615', 'Feminino', 58),
('59', '34506789013', 'Matheus Costa', 'matheus.costa@escola.com', 'aluno1058', '2011-02-16', 'Rua do Amanhã, 53', '11901234616', 'Masculino', 59),
('60', '45607890124', 'Eliane Mendes', 'eliane.mendes@escola.com', 'aluno1059', '2013-09-30', 'Rua da Vida, 20', '11901234617', 'Feminino', 60),
('61', '50778901235', 'Robson Lima', 'robson.lima@escola.com', 'aluno1060', '2012-04-19', 'Rua da Esperança, 78', '11901234618', 'Masculino', 61),
('62', '67080012346', 'Cynthia Costa', 'cynthia.costa@escola.com', 'aluno1061', '2010-05-24', 'Rua da Luz, 90', '11901234619', 'Feminino', 62),
('63', '78990023457', 'Sérgio Ribeiro', 'sergio.ribeiro@escola.com', 'aluno1062', '2011-06-15', 'Rua do Progresso, 77', '11901234620', 'Masculino', 63),
('64', '89001234548', 'Tania Nunes', 'tania.nunes@escola.com', 'aluno1063', '2012-10-10', 'Rua da Alegria, 43', '11901234621', 'Feminino', 64),
('65', '90102345679', 'Júlio Santos', 'julio.santos@escola.com', 'aluno1064', '2013-02-14', 'Rua da Vitória, 11', '11901234622', 'Masculino', 65),
('66', '01293456780', 'Fernanda Lima', 'fernanda.lima@escola.com', 'aluno1065', '2010-09-28', 'Rua da Compreensão, 29', '11901234623', 'Feminino', 66),
('67', '12394567891', 'Caio Martins', 'caio.martins@escola.com', 'aluno1066', '2011-03-05', 'Rua do Futuro, 45', '11901234624', 'Masculino', 67),
('68', '23495678902', 'Tatiane Ferreira', 'tatiane.ferreira@escola.com', 'aluno1067', '2012-08-18', 'Rua da Amizade, 34', '11901234625', 'Feminino', 68),
('69', '34056789013', 'Lucas Almeida', 'lucas.almeida@escola.com', 'aluno1068', '2013-10-22', 'Rua do Sonho, 23', '11901234626', 'Masculino', 69),
('70', '45967890124', 'Samara Costa', 'samara.costa@escola.com', 'aluno1069', '2010-11-03', 'Rua da Luz, 16', '11901234627', 'Feminino', 70),
('71', '56678901235', 'Marcos Paulo', 'marcos.paulo@escola.com', 'aluno1070', '2012-09-08', 'Rua da Vitória, 55', '11901234628', 'Masculino', 71),
('72', '64889012346', 'Julia Rocha', 'julia.rocha@escola.com', 'aluno1071', '2011-07-19', 'Rua da Esperança, 98', '11901234629', 'Feminino', 72),
('73', '78590123457', 'Gustavo Ferreira', 'gustavo.ferreira@escola.com', 'aluno1072', '2013-04-15', 'Rua da Alegria, 30', '11901234630', 'Masculino', 73),
('74', '84001234568', 'Gabriela Santos', 'gabriela.santos@escola.com', 'aluno1073', '2010-06-27', 'Rua da Luz, 78', '11901234631', 'Feminino', 74),
('75', '90812345679', 'Danilo Silva', 'danilo.silva@escola.com', 'aluno1074', '2011-05-15', 'Rua do Progresso, 99', '11901234632', 'Masculino', 75),
('76', '01423456780', 'Bianca Almeida', 'bianca.almeida@escola.com', 'aluno1075', '2012-04-21', 'Rua da Alegria, 44', '11901234633', 'Feminino', 76),
('77', '14334567891', 'Jorge Ferreira', 'jorge.ferreira@escola.com', 'aluno1076', '2013-03-13', 'Rua do Amanhã, 31', '11901234634', 'Masculino', 77),
('78', '25445678902', 'Luana Costa', 'luana.costa@escola.com', 'aluno1077', '2010-08-10', 'Rua da Luz, 11', '11901234635', 'Feminino', 78),
('79', '34256789013', 'Thiago Mendes', 'thiago.mendes@escola.com', 'aluno1078', '2011-09-04', 'Rua da Vitória, 13', '11901234636', 'Masculino', 79),
('80', '40667890124', 'Renata Lima', 'renata.lima@escola.com', 'aluno1079', '2012-12-25', 'Rua do Progresso, 22', '11901234637', 'Feminino', 80),
('81', '56078901235', 'Bruno Costa', 'bruno.costa@escola.com', 'aluno1080', '2013-06-17', 'Rua da Amizade, 99', '11901234638', 'Masculino', 81),
('82', '67809012346', 'Patrícia Silva', 'patricia.silva@escola.com', 'aluno1081', '2010-03-10', 'Rua do Sonho, 88', '11901234639', 'Feminino', 82),
('83', '78900123457', 'Fábio Almeida', 'fabio.almeida@escola.com', 'aluno1082', '2011-07-29', 'Rua do Amanhã, 44', '11901234640', 'Masculino', 83),
('84', '01001234568', 'Sara Costa', 'sara.costa@escola.com', 'aluno1083', '2012-08-08', 'Rua da Esperança, 66', '11901234641', 'Feminino', 84),
('85', '70112345679', 'Paulo Souza', 'paulo.souza@escola.com', 'aluno1084', '2013-01-01', 'Rua da Luz, 70', '11901234642', 'Masculino', 85),
('86', '01523456780', 'Marcelina Silva', 'marcelina.silva@escola.com', 'aluno1085', '2010-10-25', 'Rua do Vento, 10', '11901234643', 'Feminino', 86),
('87', '12734567891', 'Lucas Mendes', 'lucas.mendes@escola.com', 'aluno1086', '2011-11-16', 'Rua da Alegria, 27', '11901234644', 'Masculino', 87),
('88', '23945678902', 'Renan Ferreira', 'renan.ferreira@escola.com', 'aluno1087', '2012-03-05', 'Rua do Sol, 90', '11901234645', 'Masculino', 88),
('89', '34356789013', 'Carla Lima', 'carla.lima@escola.com', 'aluno1088', '2013-07-22', 'Rua da Luz, 15', '11901234646', 'Feminino', 89),
('90', '41667890124', 'Gustavo Silva', 'gustavo.silva@escola.com', 'aluno1089', '2010-12-10', 'Rua da Vitória, 30', '11901234647', 'Masculino', 90),
('91', '53778901235', 'Juliana Santos', 'juliana.santos@escola.com', 'aluno1090', '2011-06-14', 'Rua da Amizade, 32', '11901234648', 'Feminino', 91),
('92', '67789012346', 'Victor Ferreira', 'victor.ferreira@escola.com', 'aluno1091', '2012-05-20', 'Rua do Amanhã, 42', '11901234649', 'Masculino', 92),
('93', '78690123457', 'Brenda Lima', 'brenda.lima@escola.com', 'aluno1092', '2013-09-23', 'Rua da Esperança, 59', '11901234650', 'Feminino', 93),
('94', '89041234568', 'Henrique Costa', 'henrique.costa@escola.com', 'aluno1093', '2010-03-10', 'Rua da Luz, 20', '11901234651', 'Masculino', 94),
('95', '90332345679', 'Danielle Ribeiro', 'danielle.ribeiro@escola.com', 'aluno1094', '2011-01-30', 'Rua da Alegria, 81', '11901234652', 'Feminino', 95),
('96', '01723456780', 'Tatiane Alves', 'tatiane.alves@escola.com', 'aluno1095', '2012-07-07', 'Rua da Luz, 77', '11901234653', 'Feminino', 96),
('97', '18534567891', 'Henrique Silva', 'henrique.silva@escola.com', 'aluno1096', '2013-06-29', 'Rua da Vitória, 60', '11901234654', 'Masculino', 97),
('98', '26445678902', 'Patrícia Almeida', 'patricia.almeida@escola.com', 'aluno1097', '2010-04-18', 'Rua do Amanhã, 90', '11901234655', 'Feminino', 98),
('99', '34956789013', 'Vinícius Ferreira', 'vinicius.ferreira@escola.com', 'aluno1098', '2011-09-22', 'Rua do Vento, 23', '11901234656', 'Masculino', 99),
('100', '42667890124', 'Fernanda Costa', 'fernanda.costa@escola.com', 'aluno1099', '2012-08-04', 'Rua da Compreensão, 12', '11901234657', 'Feminino', 100);

-- Inserindo dados na tabela Turmas -------------------------------------------------------------------------------------------------------------------------
INSERT INTO Turmas (Id_Turma, Ano, Classe, Etapa)
VALUES 
(1, 2024, 801,  'Ensino Fundamental'),
(2, 2024, 901,  'Ensino Fundamental'),
(3, 2024, 1101, 'Ensino Médio'),
(4, 2024, 1201, 'Ensino Médio'),
(5, 2024, 1301, 'Ensino Médio');

-- ENTURMAÇÃO (Definir qual aluno participa de qual turma) --------------------------------------------------------------------------------------------------
INSERT INTO Turmas_Alunos (Turma_ID, Aluno_ID)
VALUES
-- Turma 1
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),

-- Turma 2
(2, 21),
(2, 22),
(2, 23),
(2, 24),
(2, 25),
(2, 26),
(2, 27),
(2, 28),
(2, 29),
(2, 30),
(2, 31),
(2, 32),
(2, 33),
(2, 34),
(2, 35),
(2, 36),
(2, 37),
(2, 38),
(2, 39),
(2, 40),

-- Turma 3
(3, 41),
(3, 42),
(3, 43),
(3, 44),
(3, 45),
(3, 46),
(3, 47),
(3, 48),
(3, 49),
(3, 50),
(3, 51),
(3, 52),
(3, 53),
(3, 54),
(3, 55),
(3, 56),
(3, 57),
(3, 58),
(3, 59),
(3, 60),

-- Turma 4
(4, 61),
(4, 62),
(4, 63),
(4, 64),
(4, 65),
(4, 66),
(4, 67),
(4, 68),
(4, 69),
(4, 70),
(4, 71),
(4, 72),
(4, 73),
(4, 74),
(4, 75),
(4, 76),
(4, 77),
(4, 78),
(4, 79),
(4, 80),

-- Turma 5
(5, 81),
(5, 82),
(5, 83),
(5, 84),
(5, 85),
(5, 86),
(5, 87),
(5, 88),
(5, 89),
(5, 90),
(5, 91),
(5, 92),
(5, 93),
(5, 94),
(5, 95),
(5, 96),
(5, 97),
(5, 98),
(5, 99),
(5, 100);

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Inserindo dados na tabela Professores --------------------------------------------------------------------------------------------------------------------
INSERT INTO Professores (Id_Professor,CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero)
VALUES 
(1, '10135431224', 'Prof. Alberto',        'alberto.prof@escola.com',       'prof1001', '1970-02-10', 'Rua das Palmeiras, 123',   '11987654366', 'Masculino'),
(2, '24420124563', 'Prof. Fernanda',       'fernanda.prof@escola.com',      'prof1002', '1972-06-27', 'Avenida Central, 456',     '11987654349', 'Feminino'),
(3, '42145211252', 'Prof. Marcos Oliver',  'marcosoliv.prof@escola.com',    'prof1003', '1970-07-25', 'Rua dos Lírios, 789',      '11987654347', 'Masculino'),
(4, '30147859521', 'Prof. João Lima',      'joaoima.prof@escola.com',       'prof1004', '1980-08-22', 'Praça da Alegria, 101',    '11987654355', 'Masculino'),
(5, '25410214578', 'Prof. Maria Santos',   'mariasantos.prof@escola.com',   'prof1005', '1979-02-21', 'Rua do Sol, 202',          '11987654325', 'Feminino'),
(6, '03214569784', 'Prof. Roberto Alves',  'robertoalves.prof@escola.com',  'prof1006', '1982-05-15', 'Avenida das Flores, 303',  '11987654324', 'Masculino'),
(7, '02136549874', 'Prof. Ana Paula',      'anapaula.prof@escola.com',      'prof1007', '1981-04-18', 'Rua da Esperança, 404',    '11987654323', 'Feminino'),
(8, '02145874415', 'Prof. Carlos Pereira', 'carlospereira.prof@escola.com', 'prof1008', '1983-03-10', 'Rua das Orquídeas, 505',   '11987654322', 'Masculino'),
(9, '20123654102', 'Prof. José',           'jose.prof@escola.com',          'prof1009', '1984-02-09', 'Avenida dos Saberes, 606', '11987654321', 'Masculino'),
(10,'20120130123', 'Prof. Aline',          'aline.prof@escola.com',         'prof1010', '1986-01-08', 'Rua da Harmonia, 707',     '11987654319', 'Feminino'),
(11,'20234567890', 'Prof. Carla',          'carla.prof@escola.com',         'prof1011', '1988-12-01', 'Rua do Coração, 808',      '11987654318', 'Feminino'),
(12,'30098765432', 'Prof. Daniel',         'daniel.prof@escola.com',        'prof1012', '1975-11-30', 'Avenida do Lazer, 909',    '11987654317', 'Masculino'),
(13,'20198765431', 'Prof. Beatriz',        'beatriz.prof@escola.com',       'prof1013', '1990-03-15', 'Rua da Paz, 111',          '11987654316', 'Feminino'),
(14,'20223456789', 'Prof. Tiago',          'tiago.prof@escola.com',         'prof1014', '1985-09-23', 'Rua do Saber, 222',        '11987654315', 'Masculino'),
(15,'20345678901', 'Prof. Larissa',        'larissa.prof@escola.com',       'prof1015', '1992-07-18', 'Rua das Flores, 333',      '11987654314', 'Feminino'),
(16,'21234567890', 'Prof. Felipe',         'felipe.prof@escola.com',        'prof1016', '1989-05-25', 'Avenida Brasil, 444',      '11987654313', 'Masculino'),
(17,'21456789012', 'Prof. Luana',          'luana.prof@escola.com',         'prof1017', '1987-08-12', 'Rua da Alegria, 555',      '11987654312', 'Feminino'),
(18,'22134567890', 'Prof. Rodrigo',        'rodrigo.prof@escola.com',       'prof1018', '1993-10-10', 'Avenida da Vitória, 666',  '11987654311', 'Masculino'),
(19,'23012345678', 'Prof. Renata',         'renata.prof@escola.com',        'prof1019', '1984-04-20', 'Rua do Sol, 777',          '11987654310', 'Feminino'),
(20,'20112345678', 'Prof. Júlio',          'julio.prof@escola.com',         'prof1020', '1983-01-05', 'Rua Nova, 888',            '11987654309', 'Masculino'),
(21,'30011234567', 'Prof. Paula',          'paula.prof@escola.com',         'prof1021', '1991-03-04', 'Rua do Tempo, 999',        '11987654308', 'Feminino'),
(22,'21012345678', 'Prof. Samira',        'samira.prof@escola.com',        'prof1022', '1995-02-15', 'Rua da Lua, 1010',         '11987654307', 'Feminino'),
(23,'31123456789', 'Prof. Marcos',         'marcos.prof@escola.com',        'prof1023', '1986-11-30', 'Avenida das Árvores, 1111', '11987654306', 'Masculino'),
(24,'20134567891', 'Prof. Vanessa',        'vanessa.prof@escola.com',       'prof1024', '1990-09-29', 'Rua do Amanhã, 1212',      '11987654305', 'Feminino'),
(25,'20123456780', 'Prof. Eduardo',        'eduardo.prof@escola.com',       'prof1025', '1981-07-22', 'Rua da Amizade, 1313',     '11987654304', 'Masculino'),
(26,'31012345679', 'Prof. Letícia',        'leticia.prof@escola.com',       'prof1026', '1985-06-15', 'Rua da União, 1414',       '11987654303', 'Feminino'),
(27,'20145678901', 'Prof. Juliana',        'juliana.prof@escola.com',       'prof1027', '1992-10-20', 'Rua da Esperança, 1515',   '11987654302', 'Feminino'),
(28,'20345678912', 'Prof. André',          'andre.prof@escola.com',         'prof1028', '1987-12-25', 'Rua do Progresso, 1616',   '11987654301', 'Masculino'),
(29,'21456789023', 'Prof. Sofia',          'sofia.prof@escola.com',         'prof1029', '1988-08-14', 'Avenida do Futuro, 1717',  '11987654300', 'Feminino'),
(30,'20198765432', 'Prof. Ruy',            'ruy.prof@escola.com',           'prof1030', '1982-04-30', 'Rua do Conhecimento, 1818', '11987654299', 'Masculino'),
(31,'20123456790', 'Prof. Carla',          'carla.prof@escola.com',         'prof1031', '1990-06-15', 'Rua da Coragem, 1919',     '11987654298', 'Feminino'),
(32,'20345678923', 'Prof. Bruno',          'bruno.prof@escola.com',         'prof1032', '1981-03-29', 'Rua da Vitória, 2020',     '11987654297', 'Masculino'),
(33,'20134567892', 'Prof. Alice',          'alice.prof@escola.com',         'prof1033', '1985-05-05', 'Rua da Conquista, 2121',   '11987654296', 'Feminino'),
(34,'20123456793', 'Prof. Vitor',          'vitor.prof@escola.com',         'prof1034', '1989-09-09', 'Avenida das Estrelas, 2222', '11987654295', 'Masculino'),
(35,'20145678924', 'Prof. Mariana',        'mariana.prof@escola.com',       'prof1035', '1993-11-11', 'Rua do Destino, 2323',     '11987654294', 'Feminino'),
(36,'30123456789', 'Prof. Diogo',          'diogo.prof@escola.com',         'prof1036', '1984-07-07', 'Rua do Futuro, 2424',      '11987654293', 'Masculino'),
(37,'21123456789', 'Prof. Larissa',        'larissa.prof@escola.com',       'prof1037', '1986-12-05', 'Rua do Amor, 2525',        '11987654292', 'Feminino'),
(38,'20123456789', 'Prof. Gabriel',        'gabriel.prof@escola.com',       'prof1038', '1991-01-17', 'Rua da Luz, 2626',         '11987654291', 'Masculino'),
(39,'30123456790', 'Prof. Tamires',        'tamires.prof@escola.com',       'prof1039', '1987-02-22', 'Avenida do Sol, 2727',    '11987654290', 'Feminino'),
(40,'21012345679', 'Prof. Leonardo',       'leonardo.prof@escola.com',      'prof1040', '1995-03-10', 'Rua das Acácias, 2828',    '11987654289', 'Masculino');

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
(10, 'Biologia'),
(11,  'Quimica'),
(12,  'Astrologia'),
(13,  'Gastronomia'),
(14,  'T.I.'),
(15,  'Engenharia'),
(16,  'Montagem e Manutenção'),
(17,  'Gramatica'),
(18,  'Educação Fisica'),
(19,  'Artes'),
(20,  'Saude e Bem-estar');

-- Criação de Horários --------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Horarios (Id_Horario, Turno, Inicio, Fim, Dia_Semana, Ano)
VALUES 
 -- Turno da Manhã --
(1,  'Manhã', '07:00:00', '08:40:00', 'Segunda', 2024), -- Segunda-Feira
(2,  'Manhã', '08:40:00', '10:20:00', 'Segunda', 2024),
(3,  'Manhã', '10:40:00', '12:20:00', 'Segunda', 2024),
(4,  'Tarde', '13:00:00', '14:40:00', 'Segunda', 2024),
(5,  'Tarde', '14:40:00', '16:20:00', 'Segunda', 2024),
(6,  'Tarde', '16:40:00', '18:20:00', 'Segunda', 2024),
(7,  'Manhã', '07:00:00', '08:40:00', 'Terça', 2024), -- Terça-Feira
(8,  'Manhã', '08:40:00', '10:20:00', 'Terça', 2024),
(9,  'Manhã', '10:40:00', '12:20:00', 'Terça', 2024),
(10,  'Tarde', '13:00:00', '14:40:00', 'Terça', 2024),
(11,  'Tarde', '14:40:00', '16:20:00', 'Terça', 2024),
(12,  'Tarde', '16:40:00', '18:20:00', 'Terça', 2024),
(13,  'Manhã', '07:00:00', '08:40:00', 'Quarta', 2024), -- Quarta-Feira
(14,  'Manhã', '08:40:00', '10:20:00', 'Quarta', 2024),
(15,  'Manhã', '10:40:00', '12:20:00', 'Quarta', 2024),
(16,  'Tarde', '13:00:00', '14:40:00', 'Quarta', 2024),
(17,  'Tarde', '14:40:00', '16:20:00', 'Quarta', 2024),
(18,  'Tarde', '16:40:00', '18:20:00', 'Quarta', 2024),
(19,  'Manhã', '07:00:00', '08:40:00', 'Quinta', 2024), -- Quinta-Feira
(20,  'Manhã', '08:40:00', '10:20:00', 'Quinta', 2024),
(21,  'Manhã', '10:40:00', '12:20:00', 'Quinta', 2024),
(22,  'Tarde', '13:00:00', '14:40:00', 'Quinta', 2024), 
(23,  'Tarde', '14:40:00', '16:20:00', 'Quinta', 2024),
(24,  'Tarde', '16:40:00', '18:20:00', 'Quinta', 2024),
(25,  'Manhã', '07:00:00', '08:40:00', 'Sexta', 2024), -- Sexta-Feira
(26,  'Manhã', '08:40:00', '10:20:00', 'Sexta', 2024),
(27,  'Manhã', '10:40:00', '12:20:00', 'Sexta', 2024),
(28,  'Tarde', '13:00:00', '14:40:00', 'Sexta', 2024), 
(29,  'Tarde', '14:40:00', '16:20:00', 'Sexta', 2024),
(30,  'Tarde', '16:40:00', '18:20:00', 'Sexta', 2024);

-- Associar cada Professor com seu respectivo Horário (que horário esse professor dará aula) ----------------------------------------------------------------
INSERT INTO Professores_Horarios (Horario_ID, Professor_ID) VALUES
(1,  1),                      -- Ex: manhã 07:00, Segunda, Prof. Alberto Mat 81 
(3,  1),                      -- Ex: manhã 08:40, Segunda, Prof. Alberto Mat 81 
(2,  40),                     -- Ex: manhã 08:40, Segunda, Prof. Leonardo Port 81  
(3,  40),                     -- Ex: manhã 10:40, Segunda, Prof. Leonardo Port 81  
(12, 38),                     -- Ex: Tarde 16:40, Terça, Prof. Gabriel Astro 11, 12 e 13
(17, 38),                     -- Ex: Tarde 14:40, Quarta, Prof. Gabriel Astro 11, 12 e 13
(22, 38),                     -- Ex: Tarde 13:00, Quinta, Prof. Gabriel Astro 11, 12 e 13
(23, 33),                     -- Ex: Tarde 16:40, Quinta, Prof. Alice Gas 11, 12 e 13
(28, 33),                     -- Ex: Tarde 13:00, Sexta, Prof. Alice Gas 11, 12 e 13 
(11, 33),                     -- Ex: Tarde 14:40, Terça, Prof. Alice Gas 11, 12 e 13
(4, 34),                      -- Ex: Tarde 13:00, Segunda, Prof. Vitor T.I. 11, 12 e 13
(18, 34),                     -- Ex: Tarde 16:40, Quarta, Prof. Vitor T.I. 11, 12 e 13
(30, 34),                     -- Ex: Tarde 14:40, Sexta, Prof. Vitor T.I. 11, 12 e 13
(4, 30),                      -- Ex: Tarde 13:00, Segunda, Prof. Ruy Port 11, 12 e 13
(11, 30),                     -- Ex: Tarde 14:40, Terça, Prof. Ruy Port 11, 12 e 13
(30, 30),                     -- Ex: Tarde 16:40, Terça, Prof. Ruy Port 11, 12 e 13
(2, 22),                      -- Ex: manhã 08:40, segunda, Prof. Samira His 81
(1, 22),                      -- Ex: manhã 07:00, segunda, Prof. Samira His 91
(20, 20),                     -- Ex: manhã 08:40, Quinta, Prof. Júlio Quimica 91
(25, 20),                     -- Ex: Manhã 07:00, Sexta, Prof. Júlio Quimica 81
(6, 28),                      -- Ex: Tarde 16:40, Segunda, Prof. André Quimica 11, 12 e 13
(28, 28),                     -- Ex: Tarde 13:00, Sexta, Prof. André Quimica 11, 12 e 13
(29, 28),                     -- Ex: Tarde 14:40, Sexta, Prof. André Quimica 11, 12 e 13
(6, 31),                      -- Ex: Tarde 14:40, segunda, Prof. Carla His 11, 12 e 13
(12, 31),                     -- Ex: Tarde 16:40, Terça, Prof. Carla His 11, 12 e 13
(28, 31),                     -- Ex: Tarde 13:00, Sexta, Prof. Carla His 11, 12 e 13 
(5, 39),                      -- Ex: Tarde 14:40, Segunda, Prof. Tamires Matemática 11, 12 e 13
(10, 39),                     -- Ex: Tarde 13:00, Terça, Prof. Tamires Matemática 11, 12 e 13
(17, 39),                     -- Ex: Tarde 14:40, Quarta, Prof. Tamires Matemática 11, 12 e 13 
(7, 37),                      -- Ex: Manha 07:00, Terça, Prof. Larissa Geo 81
(8, 37),                      -- Ex: Manha 08:40, Terça, Prof. Larissa Geo 91
(4, 8),                       -- Ex: Tarde 13:00, Segunda, Prof. Carlos Pereira Geo 11, 12 e 13
(11, 8),                      -- Ex: Tarde 14:40, Terça, Prof. Carlos Pereira Geo 11, 12 e 13
(23, 8),                      -- Ex: Tarde 14:40, Quinta, Prof. Carlos Pereira Geo 11, 12 e 13 	
(17, 10),                     -- Ex: Manha 07:00, Terça, Prof. Aline PV 81
(5, 10),                      -- Ex: Manha 08:40, Terça, Prof. Aline PV 91
(5, 11),                      -- Ex: Tarde 13:00, Segunda, Prof. Carla Engenharia 11, 12 e 13
(10, 11),                     -- Ex: Tarde 13:00, Terça, Prof. Carla Engenharia 11, 12 e 13 
(24, 11),                     -- Ex: Tarde 16:40, Quinta, Prof. Carla Engenharia 11, 12 e 13
(13, 12),                     -- Ex: Manha 10:40, Terça, Prof. Daniel Filosofia 81
(9, 12),                      -- Ex: Manha 07:00, Quarta, Prof. Daniel Filosofia 91
(16, 13),                     -- Ex: Tarde 13:00, Quarta, Prof. Beatriz Filosofia 11, 12 e 13
(18, 13),                     -- Ex: Tarde 16:00, Quarta, Prof. Beatriz Filosofia 11, 12 e 13
(24, 13),                     -- Ex: Tarde 16:40, Quinta, Prof. Beatriz Filosofia 11, 12 e 13 
(26, 14),                     -- Ex: manha 08:40, Sexta, Prof. Tiago Gramatica 81
(27, 14),                     -- Ex: manha 10:40, Sexta, Prof. Tiago Gramatica 91
(21, 15),                     -- Ex: manha 10:40, Quinta, Prof. Larissa Artes 81
(25, 15),                     -- Ex: manha 07:00, Sexta, Prof. Larissa Artes 91	
(20, 16),                     -- Ex: manha 08:40, Quinta, Prof. Felipe Educação Fisica 81
(21, 16),                     -- Ex: manha 10:40, Quinta, Prof. Felipe Educação Fisica 91
(9, 17),                      -- Ex: manha 10:40, Terça, Prof. Luana Fisica 81
(13, 17),                     -- Ex: manha 10:40, Quarta, Prof. Luana Fisica 91
(6, 18),                      -- Ex: Tarde 16:40, Segunda, Prof. Rodrigo Fisica 11, 12 e 13
(12, 18),                     -- Ex: Tarde 16:40, Terça, Prof. Rodrigo Fisica 11, 12 e 13
(22, 18),                     -- Ex: Tarde 13:00, Quinta, Prof. Rodrigo Fisica 11, 12 e 13
(19, 19),                     -- Ex: manha 07:00, Quinta, Prof. Renata Bio 81
(27, 19),                     -- Ex: manha 10:40, Sexta, Prof. Renata Bio 91
(16, 24),                     -- Ex: Tarde 13:00, Quarta, Prof. Vanessa Bio 11, 12 e 13
(18, 24),                     -- Ex: Tarde 16:40, Quarta, Prof. Vanessa Bio 11, 12 e 13
(23, 24),                     -- Ex: Tarde 14:40, Quinta, Prof. Vanessa Bio 11, 12 e 13
(19, 25),                     -- Ex: manha 07:00, Quinta, Prof. Eduardo Saude e Bem-estar 81
(26, 25),                     -- Ex: manha 08:40, Sexta, Prof. Eduardo Saude e Bem-estar 91
(14, 26),                     -- Ex: manha 08:40, Quarta, Prof. Letícia Ingles 81
(15, 26),                     -- Ex: manha 10:40, Quarta, Prof. Letícia Ingles 91
(16, 27),                     -- Ex: Tarde 13:00, Quarta, Prof. Juliana Ingles 11, 12 e 13
(17, 27),                     -- Ex: Tarde 14:40, Quarta, Prof. Juliana Ingles 11, 12 e 13
(29, 27),                     -- Ex: Tarde 14:40, Sexta, Prof. Juliana Ingles 11, 12 e 13
(10, 9),                      -- Ex: Tarde 13:00, Quinta, Prof. José Montagem e Manutenção 11, 12 e 13
(22, 9),                      -- Ex: Tarde 14:40, Quinta, Prof. José Montagem e Manutenção 11, 12 e 13
(24, 9),                      -- Ex: Tarde 14:40, Sexta, Prof. José Montagem e Manutenção 11, 12 e 13
(14, 4),                      -- Ex: manha 08:40, Quarta, Prof. João Lima sociologia 91
(15, 4),                      -- Ex: manha 10:40, Quarta, Prof. João Lima sociologia 81
(5, 5),                       -- Ex: Tarde 14:40, Segunda, Prof. Maria Santos sociologia 11, 12 e 13
(29, 5),                      -- Ex: Tarde 14:40, Sexta, Prof. Maria Santos sociologia 11, 12 e 13
(30, 5);                      -- Ex: Tarde 16:40, Sexta, Prof. Maria Santos sociologia 11, 12 e 13
-- Ex: Matematica, Portugues, Historia, Quimica, Projeto de Vida, filosofia, Geografia, Granatica, sociologia, Ingles, Arte, Educação Física, Astrologia, fisíca, Montagem e Manutenção, Gastrologia, Biologia, Saude e Bem-estar, engenharia e T.I. feitos

-- Associar cada turma com suas matérias (e em qual horário ela terá aula dessa matéria) --------------------------------------------------------------------
INSERT INTO Horarios_Materias (Horario_ID, Materia_ID, Turma_ID)
VALUES 
(1,  1,  1),                 -- Ex: manhã 07:00, segunda, Matemática, Turma 801
(2,  3,  1),                 -- Ex: manhã 08:40, segunda, História, Turma 801
(3,  2,  1),                 -- Ex: manhã 10:40, segunda, Português, Turma 801
(7,  5,  1),                 -- Ex: manhã 07:00, Terça, Projeto de Vida, Turma 801
(8,  4,  1),                 -- Ex: manhã 08:40, Terça, Geografia, Turma 801
(9,  7,  1),                 -- Ex: manhã 10:40, Terça, Fsíca, Turma 801
(13,  6, 1),                 -- Ex: manhã 07:00, Quarta, Filosofia, Turma 801
(14,  9,  1),                -- Ex: manhã 08:40, Quarta, Ingles, Turma 801
(15,  8,  1),                -- Ex: manhã 10:40, Quarta, sociologia, Turma 801
(19, 20,  1),                -- Ex: manhã 07:00, Quinta, Saude e Bem-estar, Turma 801
(20, 18,  1),		       	 -- Ex: manhã 08:40, Quinta, Educação Fisica, Turma 801
(21, 19,  1),                -- Ex: manhã 10:40, Quinta, Artes, Turma 801
(25, 11,  1),   		     -- Ex: manhã 07:00, Sexta, Quimica, Turma 801
(26, 17,  1),   			 -- Ex: manhã 08:40, Sexta, Gramatica, Turma 801
(27, 10,  1),     	    	 -- Ex: manhã 10:40, Sexta, Biologia, Turma 801
							 
(1,  3,  2),                 -- Ex: manhã 07:00, segunda, Historia, Turma 901
(2,  2,  2),                 -- Ex: manhã 08:40, segunda, Português, Turma 901
(3,  1,  2),                 -- Ex: manhã 10:40, segunda, Matemática, Turma 901
(7,  4,  2),                 -- Ex: manhã 07:00, Terça, Geografia, Turma 901
(8,  5,  2),                 -- Ex: manhã 08:40, Terça, Projeto de Vida, Turma 901
(9,  6,  2),                 -- Ex: manhã 10:40, Terça, Filosofia, Turma 901
(13,  7, 2),                 -- Ex: manhã 07:00, Quarta, Fisíca, Turma 901
(14,  8,  2),                -- Ex: manhã 08:40, Quarta, sociologia, Turma 901
(15,  9,  2),                -- Ex: manhã 10:40, Quarta, Inglês, Turma 901
(19, 10,  2),                -- Ex: manhã 07:00, Quinta, Biologia, Turma 901
(20, 11,  2),		       	 -- Ex: manhã 08:40, Quinta, Quimica, Turma 901
(21, 18,  2),                -- Ex: manhã 10:40, Quinta, Educação Fisica, Turma 901
(25, 19,  2),   			 -- Ex: manhã 07:00, Sexta, Artes, Turma 901
(26, 20,  2),   			 -- Ex: manhã 08:40, Sexta, Saude e bem_estar, Turma 901
(27, 17,  2),   		     -- Ex: manhã 10:40, Sexta, Gramatica, Turma 901
                             
(4,  2,  3),                 -- Ex: Tarde 13:00, segunda, Português, Turma 1101
(5,  1,  3),                 -- Ex: Tarde 14:40, segunda, Matemática, Turma 1101
(6,  3,  3),                 -- Ex: Tarde 16:40, segunda, Historia, Turma 1101
(10, 15, 3),                 -- Ex: Tarde 13:00, Terça, Engenharia, Turma 1101
(11, 4,  3),                 -- Ex: Tarde 14:40, Terça, Geografia, Turma 1101
(12, 7,  3),                 -- Ex: Tarde 16:40, Terça, Fisíca, Turma 1101
(16, 6, 3),                  -- Ex: Tarde 13:00, Quarta, Filosofia, Turma 1101
(17, 9, 3),                  -- Ex: Tarde 14:40, Quarta, Inglês, Turma 1101
(18, 10, 3),                 -- Ex: Tarde 16:40, Quarta, Biologia, Turma 1101
(22, 12, 3),                 -- Ex: Tarde 13:00, Quinta, Astrologia, Turma 1101
(23, 13, 3),		       	 -- Ex: Tarde 14:40, Quinta, Gastronomia, Turma 1101
(24, 16, 3),                 -- Ex: Tarde 16:40, Quinta, Montagem e Manutenção, Turma 1101
(28, 11, 3),   			     -- Ex: Tarde 13:00, Sexta, Quimica, Turma 1101
(29, 8,  3),   			     -- Ex: Tarde 14:40, Sexta, sociologia, Turma 1101
(30, 14, 3),   		         -- Ex: Tarde 16:40, Sexta, T.I., Turma 1101
                             
(4,  4,  4),                 -- Ex: Tarde 13:00, segunda, Geografia, Turma 1201
(5,  15, 4),                 -- Ex: Tarde 14:40, segunda, Engenharia, Turma 1201
(6,  7,  4),                 -- Ex: Tarde 16:40, segunda, Fisíca, Turma 1201
(10,  1, 4),                 -- Ex: Tarde 13:00, Terça, Matemática, Turma 1201
(11,  2, 4),                 -- Ex: Tarde 14:40, Terça, Português, Turma 1201
(12,  3, 4),                 -- Ex: Tarde 16:40, Terça, História, Turma 1201
(16,  9, 4),                 -- Ex: Tarde 13:00, Quarta, Inglês, Turma 1201
(17, 12, 4),                 -- Ex: Tarde 14:40, Quarta, Astrologia, Turma 1201
(18, 14, 4),                 -- Ex: Tarde 16:40, Quarta, T.I., Turma 1201
(22, 16, 4),                 -- Ex: Tarde 13:00, Quinta, Montagem e Manutenção, Turma 1201
(23, 10, 4),		       	 -- Ex: Tarde 14:40, Quinta, Biologia, Turma 1201
(24, 6,  4),                 -- Ex: Tarde 16:40, Quinta, Filosofia, Turma 1201
(28, 13,  4),   			 -- Ex: Tarde 13:00, Sexta, Astrologia, Turma 1201
(29, 11, 4),   		         -- Ex: Tarde 14:40, Sexta, Quimica, Turma 1201
(30, 8,  4),   		         -- Ex: Tarde 16:40, Sexta, Sociologia, Turma 1201
							 
(4,  14,  5),                -- Ex: Tarde 13:00, segunda, T.I., Turma 1301
(5,  8,  5),                 -- Ex: Tarde 14:40, segunda, Sociologia, Turma 1301
(6,  11,  5),                -- Ex: Tarde 16:40, segunda, Quimica, Turma 1301
(10,  16, 5),                -- Ex: Tarde 13:00, Terça, Montagem e Manutenção, Turma 1301
(11,  13, 5),                -- Ex: Tarde 14:40, Terça, Gastronomia, Turma 1301
(12,  12, 5),                -- Ex: Tarde 16:40, Terça, Astrologia, Turma 1301
(16,  10, 5),                -- Ex: Tarde 13:00, Quarta, Biologia, Turma 1301
(17,  1, 5),                 -- Ex: Tarde 14:40, Quarta, Matemática, Turma 1301
(18,  6, 5),                 -- Ex: Tarde 16:40, Quarta, Filosofia, Turma 1301
(22, 7,  5),                 -- Ex: Tarde 13:00, Quinta, Fisíca, Turma 1301
(23, 4,  5),		       	 -- Ex: Tarde 14:40, Quinta, Geografia, Turma 1301
(24, 15, 5),                 -- Ex: Tarde 16:40, Quinta, Engenharia, Turma 1301
(28, 3,  5),   			     -- Ex: Tarde 13:00, Sexta, História, Turma 1301
(29, 9,  5),   			     -- Ex: Tarde 14:40, Sexta, Inglês, Turma 1301
(30, 2,  5);   		         -- Ex: Tarde 16:40, Sexta, Português, Turma 1301