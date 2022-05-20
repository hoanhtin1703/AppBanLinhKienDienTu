<?php
	include "connect.php";
	$query = "SELECT * FROM loaisanpham";
	$data = mysqli_query($conn, $query);
	$mangloaisp = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangloaisp, new loaisp (
			$row['id'],
			$row['tenloaisanpham'],
			$row['hinhanh']));
	}
	echo json_encode($mangloaisp);
	class loaisp{
		function loaisp($id,$tenloaisanpham,$hinhanh){
			$this->id = $id;
			$this->tenloaisanpham = $tenloaisanpham;
			$this->hinhanh = $hinhanh;
		}
	}
?>