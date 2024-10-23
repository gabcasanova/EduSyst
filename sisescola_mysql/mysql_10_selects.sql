-- OBTENÇÃO DE DADOS ----------------------------------------------------------------------------------------------------------------------------------------
use edusyst;
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Seleções simples -----------------------------------------------------------------------------------------------------------------------------------------
select * from administradores; -- Obter usuários
select * from responsaveis;      
select * from alunos;           
select * from professores;   

select * from materias;        -- Obter informações
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Obter responsáveis dos alunos ----------------------------------------------------------------------------------------------------------------------------
select responsaveis.Nome as "Responsável", alunos.Nome as "Aluno" from responsaveis
inner join alunos
on alunos.Responsavel_ID = responsaveis.Id_Responsavel;
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Obter alunos de uma turma específica (Ex: Obter alunos da turma 901) -------------------------------------------------------------------------------------
select cpf, nome, email, classe from alunos 
inner join turmas_alunos 
	on alunos.id_aluno = turmas_alunos.aluno_id 
inner join turmas
	ON turmas.id_turma = turmas_alunos.turma_id
where turmas.id_turma = 1;
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Obter grade de horário (ex: obter professores do aluno 6 - Rafael) ---------------------------------------------------------------------------------------
select horarios.Dia_Semana, horarios.Turno, horarios.Inicio, horarios.Fim, materias.Nome, professores.Nome as "Professor", turmas.Classe from professores 
inner join professores_horarios
	on professores.Id_Professor = professores_horarios.Professor_ID
inner join horarios
	on horarios.Id_Horario = professores_horarios.Horario_ID
inner join horarios_materias
	on horarios_materias.Horario_ID = horarios.Id_Horario
inner join materias
	on materias.Id_Materia = horarios_materias.Materia_ID
inner join turmas
	on turmas.Id_Turma = horarios_materias.Turma_ID
inner join turmas_alunos
	on turmas_alunos.Turma_ID = turmas.Id_Turma
inner join alunos
	on alunos.Id_Aluno = turmas_alunos.Aluno_ID
where alunos.Id_Aluno = 6;
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------

-- Obter turma de um aluno específico
select turmas.classe from turmas
inner join turmas_alunos
	on turmas_alunos.turma_id = turmas.id_turma
inner join alunos
	on alunos.id_aluno = turmas_alunos.aluno_id
where alunos.id_aluno=1;

-- Obter etapa de um aluno específico
select turmas.etapa from turmas
inner join turmas_alunos
	on turmas_alunos.turma_id = turmas.id_turma
inner join alunos
	on alunos.id_aluno = turmas_alunos.aluno_id
where alunos.id_aluno=1;

-- Obter professores
select distinct professores.Nome as "Professor", professores.email from professores 
inner join professores_horarios
	on professores.Id_Professor = professores_horarios.Professor_ID
inner join horarios
	on horarios.Id_Horario = professores_horarios.Horario_ID
inner join horarios_materias
	on horarios_materias.Horario_ID = horarios.Id_Horario
inner join materias
	on materias.Id_Materia = horarios_materias.Materia_ID
inner join turmas
	on turmas.Id_Turma = horarios_materias.Turma_ID
inner join turmas_alunos
	on turmas_alunos.Turma_ID = turmas.Id_Turma
inner join alunos
	on alunos.Id_Aluno = turmas_alunos.Aluno_ID
where alunos.Id_Aluno = 1;

-- Obter matérias
select * from professores 
inner join professores_horarios
	on professores.Id_Professor = professores_horarios.Professor_ID
inner join horarios
	on horarios.Id_Horario = professores_horarios.Horario_ID
inner join horarios_materias
	on horarios_materias.Horario_ID = horarios.Id_Horario
inner join materias
	on materias.Id_Materia = horarios_materias.Materia_ID
inner join turmas
	on turmas.Id_Turma = horarios_materias.Turma_ID
inner join turmas_alunos
	on turmas_alunos.Turma_ID = turmas.Id_Turma
inner join alunos
	on alunos.Id_Aluno = turmas_alunos.Aluno_ID
inner join responsaveis
	on responsaveis.Id_Responsavel = alunos.Responsavel_id
where alunos.responsavel_id=1;

-- Obter alunos de uma turma a partir de um aluno 
SELECT alunos.nome, alunos.email, turmas.classe
FROM alunos
INNER JOIN turmas_alunos ON turmas_alunos.aluno_id = alunos.id_aluno
INNER JOIN turmas ON turmas.id_turma = turmas_alunos.turma_id
WHERE turmas_alunos.turma_id IN (
    SELECT turma_id
    FROM turmas_alunos
    WHERE aluno_id = 1
);

-- Obter notas de um aluno específico
SELECT 
    materias.Nome AS Materia, 
    professores.Nome AS Professor, 
    turmas.Classe AS Turma,
    notas.Primeira_Etapa, 
    notas.Segunda_Etapa, 
    notas.Terceira_Etapa, 
    notas.Quarta_Etapa,
    
    -- Verifica se todas as etapas são diferentes de NULL para calcular a média
    IF( notas.Primeira_Etapa IS NOT NULL 
        AND notas.Segunda_Etapa IS NOT NULL 
        AND notas.Terceira_Etapa IS NOT NULL 
        AND notas.Quarta_Etapa IS NOT NULL, 
        -- Se todas forem diferentes de NULL, calcula a média truncada
        TRUNCATE( (notas.Primeira_Etapa + notas.Segunda_Etapa + notas.Terceira_Etapa + notas.Quarta_Etapa) / 4, 1), 
        -- Caso contrário, retorna "indisponível"
        'Indisponível') AS media,

    -- Verifica se todas as etapas são diferentes de NULL para determinar a situação
    IF( notas.Primeira_Etapa IS NOT NULL 
        AND notas.Segunda_Etapa IS NOT NULL 
        AND notas.Terceira_Etapa IS NOT NULL 
        AND notas.Quarta_Etapa IS NOT NULL, 
        -- Se todas forem diferentes de NULL, verifica se a média é >= 6 para definir a situação
        IF( TRUNCATE( (notas.Primeira_Etapa + notas.Segunda_Etapa + notas.Terceira_Etapa + notas.Quarta_Etapa) / 4, 1) >= 6, 
            'Aprovado', 
            'Reprovado'), 
        -- Caso qualquer etapa seja NULL, retorna "indisponível" para a situação
        'Indisponível') AS situacao

FROM professores
INNER JOIN professores_horarios ON professores.Id_Professor = professores_horarios.Professor_ID
INNER JOIN horarios ON horarios.Id_Horario = professores_horarios.Horario_ID
INNER JOIN horarios_materias ON horarios_materias.Horario_ID = horarios.Id_Horario
INNER JOIN materias ON materias.Id_Materia = horarios_materias.Materia_ID
INNER JOIN turmas ON turmas.Id_Turma = horarios_materias.Turma_ID
INNER JOIN turmas_alunos ON turmas_alunos.Turma_ID = turmas.Id_Turma
INNER JOIN alunos ON alunos.Id_Aluno = turmas_alunos.Aluno_ID
INNER JOIN notas ON notas.Aluno_Id = alunos.Id_Aluno
AND notas.Professor_ID = professores.Id_Professor

-- Substitua o valor do aluno por um específico ou uma variável
WHERE alunos.Id_Aluno = 1;






-- obter materias de um professor
select distinct materias.nome from professores 
INNER JOIN professores_horarios ON professores.Id_Professor = professores_horarios.Professor_ID
INNER JOIN horarios ON horarios.Id_Horario = professores_horarios.Horario_ID
INNER JOIN horarios_materias ON horarios_materias.Horario_ID = horarios.Id_Horario
INNER JOIN materias ON materias.Id_Materia = horarios_materias.Materia_ID
where professores.Id_Professor = 1;

-- obter horários de um professor
select horarios.Dia_Semana, horarios.Turno, horarios.Inicio, horarios.Fim, materias.Nome, turmas.Classe from professores 
INNER JOIN professores_horarios ON professores.Id_Professor = professores_horarios.Professor_ID
INNER JOIN horarios ON horarios.Id_Horario = professores_horarios.Horario_ID
INNER JOIN horarios_materias ON horarios_materias.Horario_ID = horarios.Id_Horario
INNER JOIN materias ON materias.Id_Materia = horarios_materias.Materia_ID
INNER JOIN turmas ON turmas.Id_Turma = horarios_materias.Turma_ID
where professores.Id_Professor = 1;

select professores.nome, professores.email from professores order by professores.nome asc;


-- obter alunos de um professor
select alunos.nome, alunos.email, responsaveis.nome, responsaveis.email, turmas.classe, turmas.ano from alunos
inner join responsaveis on responsaveis.Id_Responsavel = alunos.Responsavel_ID
inner join turmas_alunos on turmas_alunos.Aluno_ID = alunos.Id_Aluno
inner join turmas on turmas.Id_Turma = turmas_alunos.Turma_ID

inner join Horarios_Materias on Horarios_Materias.Turma_ID = turmas.Id_Turma
inner join horarios on horarios.Id_Horario = horarios_materias.Horario_ID
inner join professores_horarios on professores_horarios.Horario_ID = horarios.Id_Horario
inner join professores on professores.Id_Professor = professores_horarios.Professor_ID
where professores.Id_Professor = 1 order by turmas.classe, alunos.nome asc
;

-- obter turmas de um prof
select distinct materias.nome, turmas.classe, turmas.ano from alunos
inner join turmas_alunos on turmas_alunos.Aluno_ID = alunos.Id_Aluno
inner join turmas on turmas.Id_Turma = turmas_alunos.Turma_ID

inner join Horarios_Materias on Horarios_Materias.Turma_ID = turmas.Id_Turma

inner join materias on horarios_materias.Materia_ID = materias.Id_Materia

inner join horarios on horarios.Id_Horario = horarios_materias.Horario_ID
inner join professores_horarios on professores_horarios.Horario_ID = horarios.Id_Horario
inner join professores on professores.Id_Professor = professores_horarios.Professor_ID
where professores.Id_Professor = 1 order by turmas.ano, turmas.classe, materias.nome asc
;


select distinct
	professores.nome, notas.nome_materia, alunos.nome, turmas.classe, notas.primeira_etapa, notas.segunda_etapa, 
	notas.terceira_etapa, notas.quarta_etapa,
    
	-- Verifica se todas as etapas são diferentes de NULL para calcular a média
    IF( notas.Primeira_Etapa IS NOT NULL 
        AND notas.Segunda_Etapa IS NOT NULL 
        AND notas.Terceira_Etapa IS NOT NULL 
        AND notas.Quarta_Etapa IS NOT NULL, 
        -- Se todas forem diferentes de NULL, calcula a média truncada
        TRUNCATE( (notas.Primeira_Etapa + notas.Segunda_Etapa + notas.Terceira_Etapa + notas.Quarta_Etapa) / 4, 1), 
        -- Caso contrário, retorna "indisponível"
        'Indisponível') AS media,

    -- Verifica se todas as etapas são diferentes de NULL para determinar a situação
    IF( notas.Primeira_Etapa IS NOT NULL 
        AND notas.Segunda_Etapa IS NOT NULL 
        AND notas.Terceira_Etapa IS NOT NULL 
        AND notas.Quarta_Etapa IS NOT NULL, 
        -- Se todas forem diferentes de NULL, verifica se a média é >= 6 para definir a situação
        IF( TRUNCATE( (notas.Primeira_Etapa + notas.Segunda_Etapa + notas.Terceira_Etapa + notas.Quarta_Etapa) / 4, 1) >= 6, 
            'Aprovado', 
            'Reprovado'), 
        -- Caso qualquer etapa seja NULL, retorna "indisponível" para a situação
        'Indisponível') AS situacao
        
from alunos
inner join turmas_alunos on turmas_alunos.aluno_id = alunos.id_aluno
inner join turmas on turmas.id_turma = turmas_alunos.turma_id
inner join notas on alunos.id_aluno = notas.aluno_id
inner join professores on professores.id_professor = notas.professor_id
where turmas.ano = 2023 and
professores.id_professor = 1 order by notas.nome_materia, alunos.nome asc;

select distinct materias.nome from professores
inner join professores_horarios on professores_horarios.professor_id = professores.id_professor
inner join horarios on horarios.id_horario = professores_horarios.horario_id
inner join horarios_materias on horarios_materias.horario_id = horarios.id_horario
inner join materias on materias.id_materia = horarios_materias.materia_id
inner join turmas on turmas.id_turma = horarios_materias.turma_id
where turmas.ano = 2024 and
professores.id_professor = 1
;