<?php
    require('db-connect.php');

    $id_aluno = $_GET["id_aluno"];

    $sql = "select * from alunos inner join turmas on turmas.Id_Turma = alunos.Turma_ID WHERE Id_Aluno='$id_aluno'";
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
