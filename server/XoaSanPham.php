<?php 

header("Content-Type: application/json; charset=UTF-8");

include "connect.php";

$id      = $_POST['id'];
$image = $_POST['hianhsanpham'];


    $query = "DELETE FROM products WHERE id='$id' ";
        if ( mysqli_query($conn, $query) ){
            $iparr = explode("/", $image);
            $picture_split = $iparr[5];
            if (unlink("picture/".$picture_split) ){

                $result["value"] = "1";
                $result["message"] = "Success!";

                echo json_encode($result);
                mysqli_close($conn);

            } else {
            
                $response["value"] = "0";
                $response["message"] = "Error to delete a image! ".mysqli_error($conn);
                echo json_encode($response);
                mysqli_close($conn);
            }

        } 
        else {
            $response["value"] = "0";
            $response["message"] = "Error! ".mysqli_error($conn);
            echo json_encode($response);
            mysqli_close($conn);
        }



?>