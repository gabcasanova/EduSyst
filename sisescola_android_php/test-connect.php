<?php
    $host="localhost";
    $user="root";
    $password="";
    $con=mysqli_connect($host,$user,$password);

    if($con) {
        echo '<h1>Conectado ao MySQL</h1>';
    } else {
        echo '<h1>Servidor MySQL não conectado...</h1>';
    }
?>