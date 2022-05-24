<?php 

include "connect.php";
$id  = $_POST['id'];
$sql = "SELECT customer.id,customer.tenkhachhang,customer.sodienthoai,customer.diachi,account.email,account.password  FROM customer INNER JOIN account WHERE account.id ='$id'  AND customer.id_account ='$id'";
$result = mysqli_query($conn,$sql);
  $row = mysqli_fetch_assoc($result);

    echo json_encode(array(
      "id" => $row['id'],
    "tenkhachang" =>$row['tenkhachhang'],
    "sodienthoai" => $row['sodienthoai'],
    "email" => $row['email'],
    "password" => $row['password'],
    "diachi"=>$row['diachi']));
            // echo json_encode(array("value" =>"0","level" =>$level),JSON_FORCE_OBJECT); 
?>