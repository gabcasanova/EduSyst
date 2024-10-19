<?php
    require('db-connect.php');

    $id_aluno = $_GET["id_aluno"];

    $sql = "SELECT professores.Nome AS professor_nome, professores.Email AS professor_email, materias.Nome AS materia_nome 
            FROM professores
            INNER JOIN professores_horarios ON professores_horarios.Professor_ID = professores.Id_Professor
            INNER JOIN horarios ON horarios.Id_Horario = professores_horarios.Horario_ID
            INNER JOIN horarios_materias ON horarios_materias.Horario_ID = horarios.Id_Horario
            INNER JOIN materias ON materias.Id_Materia = horarios_materias.Materia_ID
            INNER JOIN turmas ON turmas.Id_Turma = horarios_materias.Turma_ID
            INNER JOIN alunos ON alunos.Turma_ID = turmas.Id_Turma
            WHERE alunos.Id_Aluno = '$id_aluno'";

    $result = mysqli_query($con, $sql);

    $data = array();
    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }

    header('Content-Type: application/json');
    echo json_encode($data);

    mysqli_close($con);
?>
