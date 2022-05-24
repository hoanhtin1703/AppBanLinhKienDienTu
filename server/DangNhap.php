<?php 

include "connect.php";
$email  = $_POST['email'];
$password   = $_POST['password'];
$sql = "SELECT * FROM account WHERE email ='$email' AND password='$password'";
$result = mysqli_query($conn,$sql);
        if (mysqli_num_rows($result)>0)
        {
            $row = mysqli_fetch_assoc($result);
            $id = $row['id'];
            $level = $row ['level'];
            // echo json_encode(array("value" =>"0","level" =>$level),JSON_FORCE_OBJECT);
            $query = "SELECT * FROM customer WHERE  id_account ='$id'";
            if($result1 = mysqli_query($conn, $query)){
            $row1 = mysqli_fetch_assoc($result1) ;
        
                echo json_encode(array( "value" => "1",
                                        "id"   =>$row1['id'],
                                        "level" =>$level
                                        ));
            }
        } else 
        {
                echo json_encode(array("value" => "0", 'result_code' =>'Khong co tai khoan '));
         }
        


        
?>