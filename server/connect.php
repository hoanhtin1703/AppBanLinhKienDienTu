<?php
	$host = "localhost";
	$UserName = "root";
	$password ="";
	$database = "sanpham";

	$conn = mysqli_connect($host, $UserName, $password, $database);
	mysqli_query($conn, "SET NAMES 'utf8'");
?>