<?php
    require('db-connect.php');

    $id_aluno = $_GET["id_aluno"];

    $sql = "SELECT * FROM Alunos WHERE Id_Aluno='$id_aluno'";
    $result = mysqli_query($con, $sql);

    $data = array();

    if (mysqli_num_rows($result) > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $data[] = $row;
        }
    }

    echo json_encode($data);

    mysqli_close($con);
?>
