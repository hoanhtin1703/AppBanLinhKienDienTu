package com.example.doan.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.Adapter.Admin_List_SanPham;
import com.example.doan.R;
import com.example.doan.model.SanPham;
import com.example.doan.util.Api_Client;
import com.example.doan.util.Api_interface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List_Product extends AppCompatActivity {
//    LoaiSpAdapter loaiSpAdapter;
    Admin_List_SanPham SanPhamAdapter;
    int id = 0;
    String tenloaisanpham = "";
    String hinhanh = "";
    List<SanPham> MangSanPham;
    RecyclerView recyclerView ;
  Api_interface api_interface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

//        if (KiemTraKetNoi.haveNetworkConnection(getApplicationContext())){
            AnhXa();
//            GetDuLieuLoaiSP();
//        } else {
//            KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Hãy kiểm tra lại kết nối!");
//            finish();
//        }
        Button btn = findViewById(R.id.btn_themsanpham);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(List_Product.this,CRUD_Product.class);

                startActivity(i);
            }
        });
    }
    public void GetDuLieuLoaiSP(){
        api_interface = Api_Client.getApiClient().create(Api_interface.class);

        Call<List<SanPham>> call = api_interface.getStudent();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
            MangSanPham =  response.body();
            SanPhamAdapter = new Admin_List_SanPham(getApplicationContext(),MangSanPham);
            recyclerView.setAdapter(SanPhamAdapter);
            SanPhamAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {

            }
        });
//        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.GetTatCaSanPham, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                if (response != null){
//                    int ID = 0;
//                    String tensanpham = " ";
//                    Integer Giasanpham = 0;
//                    String Hinhanhsanpham = "";
//                    String Motasanpham = "";
//                    String Soluong ="";
//                    int IDsanpham = 0;
//                    for (int i = 0; i < response.length(); i++){
//                        try {
//                            JSONObject jsonObject = response.getJSONObject(i);
//                            ID = jsonObject.getInt("id");
//                            tensanpham = jsonObject.getString("tensanpham");
//                            Giasanpham = jsonObject.getInt("giasanpham");
//                            Hinhanhsanpham = jsonObject.getString("hinhanhsanpham");
//                            Motasanpham = jsonObject.getString("motasanpham");
//                            Soluong= jsonObject.getString("soluong");
//                            IDsanpham = jsonObject.getInt("idsanpham");
//                            MangSanPham.add(new SanPham(ID,tensanpham,Giasanpham,Hinhanhsanpham,Soluong,Motasanpham,IDsanpham));
//                            SanPhamAdapter.notifyDataSetChanged();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
    }
    private void AnhXa() {
//        toolbar = (Toolbar) findViewById(R.id.tootlbarMHC);
//        navigationView = (NavigationView) findViewById(R.id.navigationview);
//        listView = (ListView) findViewById(R.id.listviewMHC);
        recyclerView = (RecyclerView) findViewById(R.id.rcv_list_sanpham);
//        viewFlipper = (ViewFlipper) findViewById(R.id.viewfliper);
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
//        MangLoaiSp = new ArrayList<>();
//        MangLoaiSp.add(0,new LoaiSp(0,"Trang chính","https://i.pinimg.com/474x/fc/16/ef/fc16eff6cd8c7ff12538799b8bd8f82e.jpg"));
//        loaiSpAdapter = new LoaiSpAdapter(MangLoaiSp,getApplicationContext());
//        listView.setAdapter(loaiSpAdapter);
//        MangSanPham = new ArrayList<>();

//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

//        if (mangGioHang != null) {
//
//        }else {
//            mangGioHang = new ArrayList<>();
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        GetDuLieuLoaiSP();
    }
}