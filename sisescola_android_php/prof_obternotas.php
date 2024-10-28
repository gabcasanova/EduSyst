<?php
    require('db-connect.php');

    $id_professor = $_GET["id_professor"];

    $sql = "select distinct notas.nome_materia as nome_materia, alunos.nome as nome_aluno, "
            . "turmas.classe as turma_classe, "
            . "notas.primeira_etapa as pri_bm, notas.segunda_etapa as seg_bm, "
            . "notas.terceira_etapa as ter_bm, notas.quarta_etapa as quar_bm "
            . "from alunos "
            . "inner join turmas_alunos on turmas_alunos.aluno_id = alunos.id_aluno "
            . "inner join turmas on turmas.id_turma = turmas_alunos.turma_id "
            . "inner join notas on alunos.id_aluno = notas.aluno_id "
            . "inner join professores on professores.id_professor = notas.professor_id "
            . "WHERE Professores.Id_Professor = '$id_professor' "
            . "order by notas.nome_materia, alunos.nome asc;";

    $result = mysqli_query($con, $sql);

    $data = array();
    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }

    header('Content-Type: application/json');
    echo json_encode($data);

    mysqli_close($con);
?>
