<?php 

header("Content-Type: application/json; charset=UTF-8");

include "connect.php";

$query = "SELECT * FROM products ORDER BY ID DESC" ;
$result = mysqli_query($conn, $query);
$response = array();

$server_name = $_SERVER['SERVER_ADDR'];
while( $row = mysqli_fetch_assoc($result) ){
    array_push($response, 
    array(
        'ID' =>$row['id'],
        'TenSanPham' =>$row['tensanpham'],
        'GiaSanPham'=>$row['giasanpham'],
        'MoTaSanPham'        =>$row['motasanpham'], 
        'IDSanPham'      =>$row['idsanpham'], 
        'SoLuong'=>$row['soluong'],
        'HinhAnhSanPham'   =>"http://$server_name".$row['hinhanhsanpham']
        ) 
    );
}

echo json_encode($response);
mysqli_close($conn);

?>