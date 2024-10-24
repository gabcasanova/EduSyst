<?php
    require('db-connect.php');

    $id_aluno = $_GET["id_aluno"];

    $sql = "select distinct professores.Nome as professor_nome, professores.email as professor_email from professores "
            . "inner join professores_horarios on professores.Id_Professor = professores_horarios.Professor_ID "
            . "inner join horarios on horarios.Id_Horario = professores_horarios.Horario_ID "
            . "inner join horarios_materias on horarios_materias.Horario_ID = horarios.Id_Horario "
            . "inner join materias on materias.Id_Materia = horarios_materias.Materia_ID "
            . "inner join turmas on turmas.Id_Turma = horarios_materias.Turma_ID "
            . "inner join turmas_alunos on turmas_alunos.Turma_ID = turmas.Id_Turma "
            . "inner join alunos on alunos.Id_Aluno = turmas_alunos.Aluno_ID "
            . "where alunos.Id_Aluno ='$id_aluno'";

    $result = mysqli_query($con, $sql);

    $data = array();
    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }

    header('Content-Type: application/json');
    echo json_encode($data);

    mysqli_close($con);
?>
