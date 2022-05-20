<?php
	include "connect.php";
	$MangSanPhamMoiNhat = array();
	$query = " SELECT * FROM products ORDER BY ID DESC LIMIT 10";
	$data = mysqli_query($conn,$query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($MangSanPhamMoiNhat, new SanPhamMoiNhat($row['id'],$row['tensanpham'],$row['giasanpham'],$row['hinhanhsanpham'],$row['motasanpham'],$row['idsanpham']));
	}
	echo json_encode($MangSanPhamMoiNhat);
	class SanPhamMoiNhat{
		function SanPhamMoiNhat($id, $tensanpham, $giasanpham, $hinhanhsanpham, $motasanpham, $idsanpham ){
			$this->id=$id;
		$this->tensanpham=$tensanpham;
		$this->giasanpham=$giasanpham;
		$this->hinhanhsanpham=$hinhanhsanpham;
		$this->motasanpham=$motasanpham;
		$this->idsanpham=$idsanpham;
		}
	}
?>