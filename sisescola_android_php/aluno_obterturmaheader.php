<?php
    require('db-connect.php');

    $id_aluno = $_GET["id_aluno"];

    $sql = "select * from turmas inner join turmas_alunos on turmas_alunos.turma_id = turmas.id_turma inner join alunos on alunos.id_aluno = turmas_alunos.aluno_id where alunos.id_aluno='$id_aluno'";
    $result = mysqli_query($con, $sql);

    $data = array(); // Initialize data array

    if (mysqli_num_rows($result) > 0) {
        $linha = $result->fetch_assoc();
        $data['classe'] = $linha["Classe"]; 
        $data['etapa'] = $linha["Etapa"]; 
    }

    echo json_encode($data);

    mysqli_close($con);
?>
