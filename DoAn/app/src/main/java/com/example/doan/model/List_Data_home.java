package com.example.doan.model;

import java.util.List;

public class List_Data_home {
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SanPham> getListsanpham() {
        return listsanpham;
    }

    public void setListsanpham(List<SanPham> listsanpham) {
        this.listsanpham = listsanpham;
    }

    public List<LoaiSp> getListdanhmuc() {
        return listdanhmuc;
    }

    public void setListdanhmuc(List<LoaiSp> listdanhmuc) {
        this.listdanhmuc = listdanhmuc;
    }

    public List_Data_home(int type, List<SanPham> listsanpham, List<LoaiSp> listdanhmuc) {
        this.type = type;
        this.listsanpham = listsanpham;
        this.listdanhmuc = listdanhmuc;
    }

    private int type;
    private List<SanPham> listsanpham;
    private List<LoaiSp> listdanhmuc;

}
