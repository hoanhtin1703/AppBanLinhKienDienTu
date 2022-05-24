<?php
	include "connect.php";
	$query = "SELECT * FROM loaisanpham";
	$data = mysqli_query($conn, $query);
	$mangloaisp = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangloaisp,array(
            'id' => $row['id'],
			'tenloaisanpham' =>$row['tenloaisanpham'],
			'hinhanhloaisanpham' =>$row['hinhanh']));	
	}
	echo json_encode($mangloaisp);
?>