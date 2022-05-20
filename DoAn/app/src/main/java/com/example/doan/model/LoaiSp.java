package com.example.doan.model;

import java.io.Serializable;

public class LoaiSp implements Serializable {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int Id;
    public String Tenloaisanpham;
    public String Hinhanhloaisanpham;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String status;


    public String getTenloaisanpham() {
        return Tenloaisanpham ;
    }

    public LoaiSp setTenloaisanpham(String tenloaisanpham) {
        this.Tenloaisanpham = tenloaisanpham;
        return null;
    }

    public String getHinhanhloaisanpham() {
        return Hinhanhloaisanpham;
    }

    public void setHinhanhloaisanpham(String hinhanhloaisanpham) {
        this.Hinhanhloaisanpham = hinhanhloaisanpham;
    }

    public LoaiSp(int id, String tenloaisanpham, String hinhanhloaisanpham) {
        this.Id = id;
        this.Tenloaisanpham = tenloaisanpham;
        this.Hinhanhloaisanpham = hinhanhloaisanpham;
    }
    public LoaiSp(int id, String tenloaisanpham) {
        this.Id = id;
        this.Tenloaisanpham = tenloaisanpham;

    }
    public LoaiSp(String response){
this.Tenloaisanpham = response;
    }
public  LoaiSp(){

}
    public String getName() {
        return this.Tenloaisanpham;
    }
    @Override
    public String toString() {
        return Tenloaisanpham;
    }
}