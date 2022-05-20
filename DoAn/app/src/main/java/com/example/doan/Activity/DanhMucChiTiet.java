package com.example.doan.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan.R;
import com.example.doan.model.LoaiSp;
import com.example.doan.model.SanPham;
import com.example.doan.model.SanPhamTheoDanhMuc;
import com.example.doan.util.Api_Client;
import com.example.doan.util.Api_interface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhMucChiTiet extends AppCompatActivity {
    Api_interface api_interface;
    ArrayList<SanPhamTheoDanhMuc> sanPhamTheoDanhMucs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc_chi_tiet);
        GetSanPhamTheoDanhMuc();
    }
    private void GetSanPhamTheoDanhMuc(){

        LoaiSp sanpham = (LoaiSp) getIntent().getSerializableExtra("id_danhmuc");
        int id_danhmuc = sanpham.getId();
        System.out.println(id_danhmuc);
        api_interface = Api_Client.getApiClient().create(Api_interface.class);
       Call<SanPham> call = api_interface.post_id(id_danhmuc);
       call.enqueue(new Callback<SanPham>() {
           @Override
           public void onResponse(Call<SanPham> call, retrofit2.Response<SanPham> response) {
               int id = response.body().getID();
               String tensanpham = response.body().getTenSanPham();
               Integer giasanpham = response.body().getGiaSanPham();
               String Mota = response.body().getMoTaSanPham();
               String hinhanh = response.body().getHinhAnhSanPham();
               String soluong = response.body().getSoLuong();
               int id_sanpham = response.body().getIDSanPham();
               System.out.println(id);

           }

           @Override
           public void onFailure(Call<SanPham> call, Throwable t) {

           }
       });

    }
}