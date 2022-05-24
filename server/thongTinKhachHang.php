<?php
	include "connect.php";
	$json = $_POST['json'];
		$data = json_decode($json, true);
	 foreach ($data as $value) {
		$id_sanpham = $value['id_sanpham'];
		$id_khach_hang = $value['id_khachhang'];
		$tensanpham = $value['tensanpham'];
		$giasanpham = $value['giasp'];
		$soluongsanpham = $value['soluongsanpham'];
	}
		$madonhang  = rand();
		$trangthai = 0;
 		$query = "INSERT INTO donhang( madonhang, trangthai, idkhachhang) VALUES 
		 ('$madonhang','$trangthai', '$id_khach_hang')";
		if (mysqli_query($conn, $query)) {
			$iddonhang = $conn->insert_id;
			$query1 = "INSERT INTO chitietdonhang(iddonhang,madonhang,masanham,tensanpham,giasanpham,soluongsanpham) 
			VALUES
			('$iddonhang','$madonhang','$id_sanpham','$tensanpham','$giasanpham','$soluongsanpham')";
			mysqli_query($conn,$query1);
			echo "1";
		}else{
			echo "0";
		}
		//
	// 	include "connect.php";
	// $json = $_POST['json'];
	// $data = json_decode($json, true);
	// foreach ($data as $value) {
	// 	$madonhang = $value['madonhang'];
	// 	$masanham = $value['masanham'];
	// 	$tensanpham = $value['tensanpham'];
	// 	$giasanpham = $value['giasanpham'];
	// 	$soluongsanpham = $value['soluongsanpham'];
	// 	$query = "INSERT INTO chitietdonhang (id, madonhang, masanham, tensanpham, giasanpham, soluongsanpham) VALUES (null, '$madonhang', '$masanham', '$tensanpham', '$giasanpham', '$soluongsanpham')";
	// 	$data2 = mysqli_query($conn,$query);
	// 	}
	// 	if ($data2) {
	// 		echo "1";
	// 	}else{
	// 		echo "0";
	// 	}
	
?>