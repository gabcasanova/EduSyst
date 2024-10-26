<?php
    require('db-connect.php');

    $cpf = $_POST["cpf"];
    $email = $_POST["email"];
    $senha = $_POST["senha"];

    // Use prepared statements to avoid SQL injection
    $stmt = $con->prepare("SELECT * FROM professores WHERE CPF=? AND Email=? AND Senha=?");
    $stmt->bind_param("sss", $cpf, $email, $senha);
    $stmt->execute();
    $resultado = $stmt->get_result();

    header('Content-Type: application/json');

    if ($resultado->num_rows > 0) {
        $linha = $resultado->fetch_assoc();
        $response = array(
            "status" => "success",
            "nome" => $linha["Nome"],
            "id_professor" => $linha["Id_Professor"]
        );
    } else {
        $response = array(
            "status" => "error",
            "message" => "Usuário não encontrado ou senha incorreta"
        );
    }

    echo json_encode($response);

    $stmt->close();
    mysqli_close($con);
?>
