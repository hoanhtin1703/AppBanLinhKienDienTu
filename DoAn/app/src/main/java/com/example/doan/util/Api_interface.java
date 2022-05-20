package com.example.doan.util;

import com.example.doan.model.Account;
import com.example.doan.model.KhachHang;
import com.example.doan.model.LoaiSp;
import com.example.doan.model.SanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api_interface {
    @POST("getSanPham.php")
    Call<List<SanPham>> getStudent();
    @FormUrlEncoded
    @POST("getLoaiSanPham.php")
    Call<LoaiSp> insert_id_loaisp(
    @Field("id") int id
    );
    @FormUrlEncoded
    @POST("SuaSanPham.php")
    Call<SanPham> update_sanpham(
            @Field("id") int id,
            @Field("tensanpham") String tensanpham,
            @Field("giasanpham") String giasanpham,
            @Field("hinhanhsanpham") String hinhanhsanpham,
            @Field("motasanpham") String motasanpham,
            @Field("soluong") String soluong,
            @Field("idsanpham") int idsanpham);
    @FormUrlEncoded
    @POST("XoaSanPham.php")
    Call<SanPham> delete_sanpham(
            @Field("id") int id,
            @Field("hianhanhsanpham") String picture
    );
    @FormUrlEncoded
    @POST("Dangky.php")
    Call<Account> dangky(
            @Field("tennguoidung") String tennguoidung,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone,
            @Field("address") String address

     );
    @FormUrlEncoded
    @POST("DangNhap.php")
    Call<Account> dangnhap(
            @Field("email") String email,
            @Field("password") String password

    );
    @FormUrlEncoded
    @POST("LayThongTin.php")
    Call<KhachHang> laythongtin(
            @Field("id") int id
    );
    @FormUrlEncoded
    @POST("thongTinKhachHang.php")
    Call<Account> xacnhan(
            @Field("id_sanpham") int id_sanpham,
            @Field("id_khachhang") int id_khachhang,
            @Field("tensanpham") String tensanpham,
            @Field("giasanpham") long giasanpham,
            @Field("soluongsanpham") int soluongsanpham
    );
    @FormUrlEncoded
    @POST("getSanhamTheoDanhMuc.php")
    Call<SanPham> post_id(
            @Field("id_danhmuc") int id_danhmuc

    );

}
