package com.example.doan.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    public class Result implements Serializable{}
    public SanPham(int ID, String tenSanPham, Integer giaSanPham, String hinhAnhSanPham, String moTaSanPham, int IDSanPham, String status) {
        this.ID = ID;
        TenSanPham = tenSanPham;
        GiaSanPham = giaSanPham;
        HinhAnhSanPham = hinhAnhSanPham;
        MoTaSanPham = moTaSanPham;
        this.IDSanPham = IDSanPham;
        this.status = status;
    }

    public int ID;
    public String SoLuong;
    public String TenSanPham;
    public Integer GiaSanPham;
    public String HinhAnhSanPham;
    public String MoTaSanPham;
    public int IDSanPham;
    public SanPham(int id, String tensanpham, Integer giasanpham, String hinhanhsanpham, String motasanpham, int iDsanpham) {
        this.ID = id;
//        this.SoLuong = Soluong;
        this.TenSanPham = tensanpham;
        this.GiaSanPham = giasanpham;
        this.HinhAnhSanPham = hinhanhsanpham;
        this.MoTaSanPham = motasanpham;
        this.IDSanPham = iDsanpham;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String status;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String soLuong) {
        SoLuong = soLuong;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public Integer getGiaSanPham() {
        return GiaSanPham;
    }

    public void setGiaSanPham(Integer giaSanPham) {
        GiaSanPham = giaSanPham;
    }

    public String getHinhAnhSanPham() {
        return HinhAnhSanPham;
    }

    public void setHinhAnhSanPham(String hinhAnhSanPham) {
        HinhAnhSanPham = hinhAnhSanPham;
    }

    public String getMoTaSanPham() {
        return MoTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        MoTaSanPham = moTaSanPham;
    }

    public int getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(int IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public SanPham(int ID, String tenSanPham, Integer giaSanPham, String hinhAnhSanPham,String Soluong, String moTaSanPham, int IDSanPham) {
        this.ID = ID;
        this.SoLuong = Soluong;
        this.TenSanPham = tenSanPham;
        this.GiaSanPham = giaSanPham;
        this.HinhAnhSanPham = hinhAnhSanPham;
        this.MoTaSanPham = moTaSanPham;
        this.IDSanPham = IDSanPham;
    }
}
