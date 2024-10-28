<?php
    require('db-connect.php');

    $id_professor = $_GET["id_professor"];

    $sql = "SELECT DISTINCT Alunos.Nome as alunos_nome, Alunos.Email as alunos_email, Turmas.Classe as turmas_classe "
            . "FROM Alunos "
            . "INNER JOIN Turmas_Alunos ON Turmas_Alunos.Aluno_ID = Alunos.Id_Aluno "
            . "INNER JOIN Turmas ON Turmas.Id_Turma = Turmas_Alunos.Turma_ID "
            . "INNER JOIN Horarios_Materias ON Horarios_Materias.Turma_ID = Turmas.Id_Turma "
            . "INNER JOIN Horarios ON Horarios.Id_Horario = Horarios_Materias.Horario_ID "
            . "INNER JOIN Professores_Horarios ON Professores_Horarios.Horario_ID = Horarios.Id_Horario "
            . "INNER JOIN Professores ON Professores.Id_Professor = Professores_Horarios.Professor_ID "
            . "WHERE Professores.Id_Professor = '$id_professor' "
            . "ORDER BY Turmas.Classe, Alunos.Nome ASC";

    $result = mysqli_query($con, $sql);

    $data = array();
    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }

    header('Content-Type: application/json');
    echo json_encode($data);

    mysqli_close($con);
?>
