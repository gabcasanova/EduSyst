<?php
    require('db-connect.php');

    $id_professor = $_GET["id_professor"];

    $sql = "SELECT * FROM professores WHERE id_professor='$id_professor'";
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
