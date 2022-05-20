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
import com.example.doan.Adapter.CamBienAdapter;
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

public class CamBienActivity extends AppCompatActivity {

    Toolbar toolbarCamBien;
    ListView listViewCamBien;
    CamBienAdapter camBienAdapter;
    ArrayList<SanPham> mangCamBien;
    int idCamBien = 0;
    int page = 1;
    View footerView;
    boolean isLoading = false;
    boolean limitData = false;
    CamBienActivity.mHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_bien);
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
        listViewCamBien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ChiTietSanPham.class);
                intent.putExtra("thongtinsanpham",mangCamBien.get(position));
                startActivity(intent);
            }
        });
        listViewCamBien.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0 && isLoading == false && limitData == false) {
                    isLoading = true;
                    Thread threadData = new CamBienActivity.ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.DuongDanCamBien+String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String TenCamBien = "";
                int GiaCamBien = 0;
                String HinhAnhCamBien = "";
                String MotaCamBien = "";
                int idsanphamCamBien = 0;
                String soluong =null;
                if (response != null && response.length() != 2) {
                    listViewCamBien.removeFooterView(footerView);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0 ; i <jsonArray.length() ; i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            TenCamBien = jsonObject.getString("tensp");
                            GiaCamBien = jsonObject.getInt("giasp");
                            HinhAnhCamBien = jsonObject.getString("hinhanhsp");
                            MotaCamBien = jsonObject.getString("motasp");
                            idsanphamCamBien = jsonObject.getInt("idsanpham");
                            mangCamBien.add(new SanPham(id,TenCamBien,GiaCamBien,HinhAnhCamBien,soluong,MotaCamBien,idsanphamCamBien));
                            camBienAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    limitData = true;
                    listViewCamBien.removeFooterView(footerView);
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
                param.put("idsanpham",String.valueOf(idCamBien));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void GetIDLoaisp() {
        idCamBien = getIntent().getIntExtra("idloaisanpham",-1);
        Log.d("giatriloaisanpham",idCamBien+"");
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarCamBien);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarCamBien.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarCamBien = (Toolbar) findViewById(R.id.tootlbarCambien);
        listViewCamBien = (ListView) findViewById(R.id.listviewCambien);
        mangCamBien = new ArrayList<>();
        camBienAdapter = new CamBienAdapter(getApplicationContext(),mangCamBien);
        listViewCamBien.setAdapter(camBienAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerView = inflater.inflate(R.layout.progressbar,null);
        mHandler = new CamBienActivity.mHandler();
    }
    public class mHandler extends Handler {
        public void handleMessage(Message msg){
            switch (msg.what){
                case 0:
                    listViewCamBien.addFooterView(footerView);
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