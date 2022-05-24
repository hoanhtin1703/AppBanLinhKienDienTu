<?php
	include "connect.php";
	$id = $_POST['id'];
	$query = "SELECT * FROM loaisanpham WHERE id = '$id'";
	$data = mysqli_query($conn, $query);
   $result = mysqli_fetch_assoc($data);
	echo json_encode(array("Id"=>$result['id'],"Tenloaisanpham"=>$result['tenloaisanpham']));
?>