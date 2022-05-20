package com.example.doan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doan.Adapter.SanPhamCoSanAdapter;
import com.example.doan.R;
import com.example.doan.model.SanPham;
import com.example.doan.util.KiemTraKetNoi;
import com.example.doan.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SanPhamCoSanActivity extends AppCompatActivity {

    Toolbar toolbarSanPhamCoSan;
    ListView listViewSanPhamCoSan;
    SanPhamCoSanAdapter sanPhamCoSanAdapter;
    ArrayList<SanPham> mangSanPhamCoSan;
    int idSanPhamCoSan = 0;
    int page = 1;
    View footerView;
    boolean isLoading = false;
    boolean limitData = false;
    SanPhamCoSanActivity.mHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_co_san);
        Anhxa();
        if (KiemTraKetNoi.haveNetworkConnection(getApplicationContext())){
            GetIDLoaisp();
            ActionToolbar();
            GetData(page);
            LoadMoreData();
        } else{
            KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối!");
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
    private void LoadMoreData() {
        listViewSanPhamCoSan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ChiTietSanPham.class);
                intent.putExtra("thongtinsanpham",mangSanPhamCoSan.get(position));
                startActivity(intent);
            }
        });
        listViewSanPhamCoSan.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0 && isLoading == false && limitData == false) {
                    isLoading = true;
                    Thread threadData = new SanPhamCoSanActivity.ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongDann = Server.DuongDanCoSan+String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,duongDann, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String TenSanPhamCoSan = "";
                int GiaSanPhamCoSan = 0;
                String HinhAnhSanPhamCoSan = "";
                String MotaSanPhamCoSan = "";
                int idsanphamSanPhamCoSan = 0;
                if (response != null && response.length() != 2) {
                    listViewSanPhamCoSan.removeFooterView(footerView);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0 ; i <jsonArray.length() ; i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            TenSanPhamCoSan = jsonObject.getString("tensp");
                            GiaSanPhamCoSan = jsonObject.getInt("giasp");
                            HinhAnhSanPhamCoSan = jsonObject.getString("hinhanhsp");
                            MotaSanPhamCoSan = jsonObject.getString("motasp");
                            idsanphamSanPhamCoSan = jsonObject.getInt("idsanpham");
                            mangSanPhamCoSan.add(new SanPham(id,TenSanPhamCoSan,GiaSanPhamCoSan,HinhAnhSanPhamCoSan,MotaSanPhamCoSan,MotaSanPhamCoSan,idsanphamSanPhamCoSan));
                            sanPhamCoSanAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }else {
                    limitData = true;
                    listViewSanPhamCoSan.removeFooterView(footerView);
                    KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Đã hết dữ liệu!");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<String,String>();
                param.put("idsanpham",String.valueOf(idSanPhamCoSan));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void GetIDLoaisp() {
        idSanPhamCoSan = getIntent().getIntExtra("idloaisanpham",-1);
        Log.d("giatriloaisanpham",idSanPhamCoSan+"");
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarSanPhamCoSan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarSanPhamCoSan.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarSanPhamCoSan = (Toolbar) findViewById(R.id.tootlbarSanPhamCoSan);
        listViewSanPhamCoSan = (ListView) findViewById(R.id.listviewSanPhamCoSan);
        mangSanPhamCoSan = new ArrayList<>();
        sanPhamCoSanAdapter = new SanPhamCoSanAdapter(getApplicationContext(),mangSanPhamCoSan);
        listViewSanPhamCoSan.setAdapter(sanPhamCoSanAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerView = inflater.inflate(R.layout.progressbar,null);
        mHandler = new SanPhamCoSanActivity.mHandler();
    }
    public class mHandler extends Handler {
        public void handleMessage(Message msg){
            switch (msg.what){
                case 0:
                    listViewSanPhamCoSan.addFooterView(footerView);
                    break;
                case 1:
                    GetData(++page);
                    isLoading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }
    public class ThreadData extends Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }
}