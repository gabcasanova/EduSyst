<?php
    require('db-connect.php');

    $id_professor = $_GET["id_professor"];

    $sql = "SELECT * FROM professores WHERE id_professor='$id_professor'";
    $result = mysqli_query($con, $sql);

    $data = array(); // Initialize data array

    if (mysqli_num_rows($result) > 0) {
        $linha = $result->fetch_assoc();
        $data['nome'] = $linha["Nome"]; // Set 'Nome' key in data array
    }

    echo json_encode($data);

    mysqli_close($con);
?>
