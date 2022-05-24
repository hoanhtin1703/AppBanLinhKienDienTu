<?php 

include "connect.php";


// $id  = $_POST['id'];
$tensp   = $_POST['tensanpham'];
$giasp       = $_POST['giasanpham'];
$hinhanh   = $_FILES['hinhanhsanpham'];
$soluong      = $_POST['soluong'];
$mota     = $_POST['motasanpham'];
$idsanpham      = $_POST['idsanpham'];

    $query = "INSERT INTO products 
    (
        tensanpham,giasanpham,soluong,motasanpham,idsanpham
    )
    VALUES 
    (
        '$tensp', '$giasp', '$soluong','$mota','$idsanpham'
    )";
            if (mysqli_query($conn, $query) ){
                if ($hinhanh == "") {
                    $finalPath = "/server/picture/noimage.png"; 
                    $result["value"] = "1";
                    $result["message"] = "Success";
                    echo json_encode($result);
                    mysqli_close($conn);
                } else {
                    $id = mysqli_insert_id($conn);
                    $permited = array('jpg','jpeg','png','gif');
                    $file_name = $_FILES['hinhanhsanpham']['name'];
                    $file_size = $_FILES['hinhanhsanpham']['size'];
                    $file_temp = $_FILES['hinhanhsanpham']['tmp_name'];
                    $path = "picture/$file_name";
                    $finalPath = "/server/".$path;
                    $insert_picture = "UPDATE products SET hinhanhsanpham='$finalPath' WHERE id='$id' ";
                
                    if (mysqli_query($conn, $insert_picture)) {
                
                        if ( move_uploaded_file($file_temp,$path) )  {
                            
                            $result["status"] = "1";
                            $result["message"] = "Success!";
                            echo json_encode($result);
                            mysqli_close($conn);
                        } else {
                            $response["status"] = "0";
                            $response["message"] = "Error! ".mysqli_error($conn);
                            echo json_encode($response);
                            mysqli_close($conn);
                        }
    
                    }
                }
            } 
            else {
                $response["status"] = "0";
                $response["message"] = "Error! ".mysqli_error($conn);
                echo json_encode($response);
                mysqli_close($conn);
            }
?>