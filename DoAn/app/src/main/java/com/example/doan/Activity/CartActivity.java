package com.example.doan.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doan.Adapter.CartAdapter;
import com.example.doan.R;
import com.example.doan.model.GioHang;
import com.example.doan.util.KiemTraKetNoi;

import java.text.DecimalFormat;

public class CartActivity extends AppCompatActivity {
    ListView listViewCart;
    TextView txtThongbao;
    static TextView txtTongtien;
    Button btnThanhToan, btnTiepTuc;
    Toolbar toolbarCart;
    CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        AnhXa();
        ActionToolBar();
        CheckData();
        EvenUltil();
        XoaSanPham();
        EvenButton();
    }

    private void EvenButton() {
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.mangGioHang.size() > 0){
                    Intent intent = new Intent(getApplicationContext(),ThongTinKhachHangActivity.class);
                    startActivity(intent);
                }else {
                    KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Giỏ hàng của bạn chưa có sản phẩm!");
                }
            }
        });
    }

    private void XoaSanPham() {
        listViewCart.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc chắn xóa sản phẩm này");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (MainActivity.mangGioHang.size() <= 0){
                            txtThongbao.setVisibility(View.VISIBLE);
                        }else {
                            MainActivity.mangGioHang.remove(position);
                            cartAdapter.notifyDataSetChanged();
                            EvenUltil();
                            if (MainActivity.mangGioHang.size() <= 0){
                                txtThongbao.setVisibility(View.VISIBLE);
                            }else {
                                txtThongbao.setVisibility(View.INVISIBLE);
                                cartAdapter.notifyDataSetChanged();
                                EvenUltil();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cartAdapter.notifyDataSetChanged();
                        EvenUltil();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    public static void EvenUltil() {
        long tongtien = 0;
        for (int i = 0 ; i < MainActivity.mangGioHang.size() ; i++){
            tongtien += MainActivity.mangGioHang.get(i).getGiasp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTongtien.setText(decimalFormat.format(tongtien) + " Đ");
    }

    private void CheckData() {
        if (MainActivity.mangGioHang.size() <= 0 ){
            cartAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.VISIBLE);
            listViewCart.setVisibility(View.INVISIBLE);
        }else {
            cartAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.INVISIBLE);
            listViewCart.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarCart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarCart.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AnhXa() {
        listViewCart = (ListView) findViewById(R.id.listviewcart);
        txtThongbao = (TextView) findViewById(R.id.textviewthongbao);
        txtTongtien = (TextView) findViewById(R.id.textviewtongtien);
        btnThanhToan = (Button) findViewById(R.id.buttonthanhtoan);
        btnTiepTuc = (Button) findViewById(R.id.buttontieptuc);
        toolbarCart = (Toolbar) findViewById(R.id.toolbarCart);
        cartAdapter = new CartAdapter(CartActivity.this,MainActivity.mangGioHang);
        listViewCart.setAdapter(cartAdapter);
    }
}