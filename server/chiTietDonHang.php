<?php
	include "connect.php";
	$json = $_POST['json'];
	$data = json_decode($json, true);
	foreach ($data as $value) {
		$madonhang = $value['madonhang'];
		$masanham = $value['masanham'];
		$tensanpham = $value['tensanpham'];
		$giasanpham = $value['giasanpham'];
		$soluongsanpham = $value['soluongsanpham'];
		$query = "INSERT INTO chitietdonhang (id, madonhang, masanham, tensanpham, giasanpham, soluongsanpham) VALUES (null, '$madonhang', '$masanham', '$tensanpham', '$giasanpham', '$soluongsanpham')";
		$data2 = mysqli_query($conn,$query);
		}
		if ($data2) {
			echo "1";
		}else{
			echo "0";
		}
?>