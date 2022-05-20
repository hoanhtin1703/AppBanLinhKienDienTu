package com.example.doan.model;

public class KhachHang {
    public KhachHang(int id, String tenkhachang, String sodienthoai, String diachi, int id_account) {
        this.id = id;
        this.tenkhachang = tenkhachang;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.id_account = id_account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkhachang() {
        return tenkhachang;
    }

    public void setTenkhachang(String tenkhachang) {
        this.tenkhachang = tenkhachang;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public  int id;
    public String tenkhachang;
    public String sodienthoai;
    public String diachi;
    public int id_account;
    public String email;
    public String password;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
