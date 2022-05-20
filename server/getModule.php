<?php
	include "connect.php";
	$page = $_GET['page'];
	$idsp = 1;
	$space = 5;
	$limit = ($page - 1) * $space;
	$mangsanpham = array();
	$query = "SELECT * FROM products WHERE idsanpham = $idsp LIMIT $limit,$space";
	$data = mysqli_query($conn,$query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangsanpham, new Sp(
			$row['id'],
			$row['tensanpham'],
			$row['giasanpham'],
			$row['hinhanhsanpham'],
			$row['motasanpham'],
			$row['idsanpham']
		));
	}
	echo json_encode($mangsanpham);
	class Sp{
		function Sp($id,$tensp,$giasp,$hinhanhsp,$motasp,$idsanpham){
			$this->id = $id;
			$this->tensp = $tensp;
			$this->giasp = $giasp;
			$this->hinhanhsp = $hinhanhsp;
			$this->motasp = $motasp;
			$this->idsanpham = $idsanpham;
		}
	}
?>