<?php 

include "connect.php";

$id = $_POST['id'];
$tensp   = $_POST['tensanpham'];
$giasp       = $_POST['giasanpham'];
$hinhanh   = $_POST['hinhanhsanpham'];
$soluong      = $_POST['soluong'];
$mota     = $_POST['motasanpham'];
$idsanpham      = $_POST['idsanpham'];

   
    $query = "UPDATE products SET 
                                tensanpham ='$tensp'
                                ,giasanpham='$giasp'
                                ,soluong='$soluong'
                                ,motasanpham='$mota'
                                ,idsanpham='$idsanpham'
                                WHERE id = '$id' ";
        if ( mysqli_query($conn, $query) ){
            if ($hinhanh == null) {
                $result["value"] = "1";
                $result["message"] = "Success";
                echo json_encode($result);
                mysqli_close($conn);
            } else {
                $path = "picture/$id.jpeg";
                $finalPath = "/server/".$path;
                $insert_picture = "UPDATE products SET hinhanhsanpham='$finalPath' WHERE id='$id' ";
                if (mysqli_query($conn, $insert_picture)) {
                    if ( file_put_contents( $path, base64_decode($hinhanh) ) ) {
                        $result["value"] = "1";
                        $result["message"] = "Success!";
                        echo json_encode($result);
                        mysqli_close($conn);
                    } else {
                        
                        $response["value"] = "0";
                        $response["message"] = "Error! ".mysqli_error($conn);
                        echo json_encode($response);

                        mysqli_close($conn);
                    }

                }
            }
        } 
        else {
            $response["value"] = "0";
            $response["message"] = "Error! ".mysqli_error($conn);
            echo json_encode($response);

            mysqli_close($conn);
        }

?>