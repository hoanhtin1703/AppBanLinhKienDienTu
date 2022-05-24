<?php
	include "connect.php";
	$MangSanPhamMoiNhat = array();
	$query = " SELECT * FROM products ORDER BY ID DESC LIMIT 10";
	$server_name = $_SERVER['SERVER_ADDR'];
	$data = mysqli_query($conn,$query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($MangSanPhamMoiNhat,
		 array('id'=>$row['id'],
		'tensanpham'=> $row['tensanpham'],
		 'giasanpham'=>$row['giasanpham'],
		 'hinhanhsanpham'=>"http://$server_name".$row['hinhanhsanpham'],
		 'motasanpham'=> $row['motasanpham'],
		 'idsanpham'=> $row['idsanpham']));
	}
	echo json_encode($MangSanPhamMoiNhat);
	
?>