<?php
    require('db-connect.php');

    $id_aluno = $_GET["id_aluno"];

    $sql = "SELECT distinct notas.nome_materia AS materia_nome, professores.Nome AS professor_nome, "
            . "turmas.Classe AS turma_classe, notas.Primeira_Etapa as primeira_etapa, "
            . "notas.Segunda_Etapa as segunda_etapa, notas.Terceira_Etapa as terceira_etapa, "
            . "notas.Quarta_Etapa as quarta_etapa "
            . "FROM professores "
            . "INNER JOIN professores_horarios ON professores.Id_Professor = professores_horarios.Professor_ID "
            . "INNER JOIN horarios ON horarios.Id_Horario = professores_horarios.Horario_ID "
            . "INNER JOIN horarios_materias ON horarios_materias.Horario_ID = horarios.Id_Horario "
            . "INNER JOIN materias ON materias.Id_Materia = horarios_materias.Materia_ID "
            . "INNER JOIN turmas ON turmas.Id_Turma = horarios_materias.Turma_ID "
            . "INNER JOIN turmas_alunos ON turmas_alunos.Turma_ID = turmas.Id_Turma "
            . "INNER JOIN alunos ON alunos.Id_Aluno = turmas_alunos.Aluno_ID "
            . "INNER JOIN notas ON notas.Aluno_Id = alunos.Id_Aluno "
            . "AND notas.Professor_ID = professores.Id_Professor "
            . "WHERE alunos.Id_Aluno = '$id_aluno'";

    $result = mysqli_query($con, $sql);

    $data = array();
    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }

    header('Content-Type: application/json');
    echo json_encode($data);

    mysqli_close($con);
?>