package com.example.doan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.doan.Adapter.LoaiSpAdapter;
import com.example.doan.R;
import com.example.doan.model.LoaiSp;
import com.example.doan.util.KiemTraKetNoi;
import com.example.doan.util.Server;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DanhMucActivity extends AppCompatActivity {
    ArrayList<LoaiSp> MangLoaiSp;
    LoaiSpAdapter loaiSpAdapter;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ListView listView;
    RecyclerView recyclerView;
    ViewFlipper viewFlipper;
    MainActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc);
        AnhXa();
        GetDuLieuLoaiSP();
        ActionBar();



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
    private void GetDuLieuLoaiSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongDanTenLoaiSanPham, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    int id=0;
                    String tenloaisanpham = "";
                    String hinhanh ="";
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
    private void ActionBar(){

        toolbar = (Toolbar) findViewById(R.id.tootlbardanhmuc);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void AnhXa() {
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listView = (ListView) findViewById(R.id.listviewMHC);
        recyclerView = (RecyclerView) findViewById(R.id.recve_loaisp);

        MangLoaiSp = new ArrayList<>();
        loaiSpAdapter = new LoaiSpAdapter(MangLoaiSp,getApplicationContext());
//        loaiSpAdapter = new LoaiSpAdapter(MangLoaiSp,getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(loaiSpAdapter);
        NavigationView navigationView = findViewById(R.id.navigationview);
        if (MainActivity.mangGioHang != null) {

        }else {
            MainActivity.mangGioHang = new ArrayList<>();
        }
    }
}