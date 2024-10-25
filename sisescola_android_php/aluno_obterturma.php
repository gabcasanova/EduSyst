<?php
    require('db-connect.php');

    $id_aluno = $_GET["id_aluno"];

    $sql = "SELECT alunos.nome as aluno_nome, alunos.email as aluno_email, turmas.classe as turma_classe "
            . "FROM alunos "
            . "INNER JOIN turmas_alunos ON turmas_alunos.aluno_id = alunos.id_aluno "
            . "INNER JOIN turmas ON turmas.id_turma = turmas_alunos.turma_id "
            . "WHERE turmas_alunos.turma_id IN ( "
                . "SELECT turma_id FROM turmas_alunos WHERE aluno_id = '$id_aluno' "
            . ")";

    $result = mysqli_query($con, $sql);

    $data = array();
    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }

    header('Content-Type: application/json');
    echo json_encode($data);

    mysqli_close($con);
?>
