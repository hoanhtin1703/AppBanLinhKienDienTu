
<?php
include "connect.php";

$user_name  = $_POST['tennguoidung'];
$password   = $_POST['password'];
$email      = $_POST['email'];
$phone   = $_POST['phone'];
$address      = $_POST['address'];
$level = 1;
                $query = "INSERT INTO account (email,password,level)
                VALUES ('$email', '$password', '$level')";
                      if(mysqli_query($conn,$query)){
                        $id = mysqli_insert_id($conn);
                        $sql =" INSERT INTO customer (tenkhachhang,sodienthoai,diachi,id_account)
                        VALUES ('$user_name','$phone','$address', '$id') ";
                        mysqli_query($conn,$sql);
                          echo json_encode(array("value" =>"1","result_code" => "0") );
                         
                       }else{
                        echo json_encode(array("value" => "false",JSON_FORCE_OBJECT) );
                              
                      }
        
      

?>