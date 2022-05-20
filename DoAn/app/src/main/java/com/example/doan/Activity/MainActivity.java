package com.example.doan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.doan.Adapter.LoaiSpAdapter;
import com.example.doan.Adapter.SanPhamAdapter;
import com.example.doan.R;
import com.example.doan.model.GioHang;
import com.example.doan.model.LoaiSp;
import com.example.doan.model.SanPham;
import com.example.doan.util.KiemTraKetNoi;
import com.example.doan.util.Server;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static int idkhachang;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ListView listView;
    RecyclerView recyclerView,recyclerView1;
    ViewFlipper viewFlipper;
    ArrayList<LoaiSp> MangLoaiSp;
    LoaiSpAdapter loaiSpAdapter;
    int id = 0;
    String tenloaisanpham = "";
    String hinhanh = "";
    ArrayList<SanPham> MangSanPham;
    SanPhamAdapter sanPhamAdapter;

    public static ArrayList<GioHang> mangGioHang;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        if (KiemTraKetNoi.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFliper();
            GetDuLieuLoaiSP();
            GetDuLieuSPMoiNhat();
            ChonItemListView();
        } else {
            KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Hãy kiểm tra lại kết nối!");
            finish();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuCart:
                Intent intent = new Intent(getApplicationContext(),CartActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void ChonItemListView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
              switch (id){
                  case R.id.trangchu:
                      if (KiemTraKetNoi.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,MainActivity.class);
                          AnhXa();
                            startActivity(intent);
                        } else {
                            KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối! ");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                  case R.id.yeuthich: KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Bạn đã nhấp vào danh mục");
                      if (KiemTraKetNoi.haveNetworkConnection(getApplicationContext())){
                          Intent intent = new Intent(MainActivity.this,DanhMucActivity.class);

                          startActivity(intent);

                      } else {
                          KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối! ");
                      }
                      drawerLayout.closeDrawer(GravityCompat.START);
                      break;

                  case R.id.hoso: KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Bạn đã nhấp vào hồ sơ");
                      if (KiemTraKetNoi.haveNetworkConnection(getApplicationContext())){
                          Intent intent = new Intent(MainActivity.this,LienHeActivity.class);

                          startActivity(intent);

                      } else {
                          KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối! ");
                      }
                      drawerLayout.closeDrawer(GravityCompat.START);
                      break;
                  case R.id.thoat: KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Bạn đã nhấp vào thoát");
                      if (KiemTraKetNoi.haveNetworkConnection(getApplicationContext())){
                          Intent intent = new Intent(MainActivity.this,LoginActivity.class);

                          startActivity(intent);
                          finish();

                      } else {
                          KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối! ");
                      }
                      drawerLayout.closeDrawer(GravityCompat.START);
                      break;
              }
                return false;
            }
        });
//
    }

    private void GetDuLieuSPMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongDanSPMoiNhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                   int ID = 0;
                   String tensanpham = " ";
                   Integer Giasanpham = 0;
                   String Hinhanhsanpham = "";
                   String Motasanpham = "";
//                   String soluong = null;
                   int IDsanpham = 0;
                   for (int i = 0; i < response.length(); i++){
                       try {
                           JSONObject jsonObject = response.getJSONObject(i);
                           ID = jsonObject.getInt("id");
                           tensanpham = jsonObject.getString("tensanpham");
                           Giasanpham = jsonObject.getInt("giasanpham");
                           Hinhanhsanpham = jsonObject.getString("hinhanhsanpham");
                           Motasanpham = jsonObject.getString("motasanpham");
                           IDsanpham = jsonObject.getInt("idsanpham");
//                           soluong = jsonObject.getString("soluong");
//                           list.add(new SanPham(ID,tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,IDsanpham));
                           MangSanPham.add(new SanPham(ID,tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,IDsanpham));
                           Log.e("Mangsanpham",String.valueOf(ID));
                           sanPhamAdapter.notifyDataSetChanged();
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }

                   }
                    }
                }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    private void GetDuLieuLoaiSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongDanTenLoaiSanPham, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    for (int i = 0 ; i < response.length() ; i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenloaisanpham = jsonObject.getString("tenloaisanpham");
                            hinhanh = jsonObject.getString("hinhanhloaisanpham");
                            MangLoaiSp.add(new LoaiSp(id, tenloaisanpham,hinhanh));
                            Log.e("Mangloaisp",MangLoaiSp.toString());

//                            loaiSpAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
//                    MangLoaiSp.add(5, new LoaiSp(0, "Contact us", "https://static.vecteezy.com/system/resources/thumbnails/002/363/153/small/contact-icon-free-vector.jpg"));
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                KiemTraKetNoi.show_Toast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionViewFliper() {
        ArrayList<String> MangQuangCao = new ArrayList<>();
        MangQuangCao.add("https://innovativehub.com.vn/wp-content/uploads/2020/12/nganh-linh-kien-dien-tu-truc-tuyen.jpg");
        MangQuangCao.add("https://www.schaeffler.vn/remotemedien/media/_shared_media_rwd/04_sectors_1/industry_1/productronics/00017D8F_16_9-schaeffler-productronics-circuit-board_rwd_600.jpg");
        MangQuangCao.add("https://1.bp.blogspot.com/-W9-B35LMVXo/XWMsZy5HK3I/AAAAAAAAADo/RzuK9P6FIrISejS0cAaoL0H4xE0WC0kXgCLcBGAs/s1600/cac-loai-linh-kien-dien-tu.jpg");
        MangQuangCao.add("https://laodongnhatban.com/wp-content/uploads/2017/08/xkld-nganh-dien-tu.jpeg");
        for (int i = 0; i < MangQuangCao.size() ; i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(MangQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
            viewFlipper.setFlipInterval(5000);
            viewFlipper.setAutoStart(true);
            Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
            Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
            viewFlipper.setInAnimation(animation_slide_in);
            viewFlipper.setOutAnimation(animation_slide_out);
        }
    }

    private void ActionBar(){

        toolbar = (Toolbar) findViewById(R.id.tootlbarMHC);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    private void AnhXa() {
        idkhachang = getIntent().getIntExtra("idkhachhang",0);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listView = (ListView) findViewById(R.id.listviewMHC);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView1 = (RecyclerView) findViewById(R.id.rcv_danhmuc);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewfliper);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        MangLoaiSp = new ArrayList<>();
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
        loaiSpAdapter = new LoaiSpAdapter(MangLoaiSp,getApplicationContext());
        recyclerView1.setAdapter(loaiSpAdapter);
        MangSanPham = new ArrayList<>();
        sanPhamAdapter = new SanPhamAdapter(getApplicationContext(),MangSanPham);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(sanPhamAdapter);
        NavigationView navigationView = findViewById(R.id.navigationview);

        if (mangGioHang != null) {

        }else {
            mangGioHang = new ArrayList<>();
        }
    }
}