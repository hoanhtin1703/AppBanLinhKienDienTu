package com.example.doan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doan.R;
import com.example.doan.model.KhachHang;
import com.example.doan.util.Api_Client;
import com.example.doan.util.Api_interface;
import com.example.doan.util.KiemTraKetNoi;
import com.example.doan.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class ThongTinKhachHangActivity extends AppCompatActivity {
    EditText editTenKH, editSDT, editEmail, editDiachi;
    Button btnXacnhan, btnTrove;
    Api_interface api_interface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach_hang);
        Log.e("idkhachang",String.valueOf(MainActivity.idkhachang));
        AnhXa();
        Getinfomation();
        btnTrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (KiemTraKetNoi.haveNetworkConnection(getApplicationContext())){
            EvenButton();
        }else {
            KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
        }
    }
private void Getinfomation(){
    api_interface = Api_Client.getApiClient().create(Api_interface.class);
    Call<KhachHang> call = api_interface.laythongtin(MainActivity.idkhachang);
    call.enqueue(new Callback<KhachHang>() {
        @Override
        public void onResponse(Call<KhachHang> call, retrofit2.Response<KhachHang> response) {

            int id = response.body().getId();
            String tenkhachang = response.body().getTenkhachang();
            String sodienthoai = response.body().getSodienthoai();
            String email = response.body().getEmail();
            String diachi = response.body().getDiachi();
           editTenKH.setText(tenkhachang);
            editEmail.setText(email);
            editSDT.setText(sodienthoai);
            editDiachi.setText(diachi);
        }

        @Override
        public void onFailure(Call<KhachHang> call, Throwable t) {

        }
    });
}
    private void EvenButton() {
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xacnhan();
            }
        });
    }
        private void Xacnhan(){

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest request = new StringRequest(Request.Method.POST, Server.DuongDanDonHang, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        MainActivity.mangGioHang.clear();
                        KiemTraKetNoi.show_Toast_Short(getApplicationContext(), "Bạn đã đặt hàng thành công!");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                KiemTraKetNoi.show_Toast_Short(getApplicationContext(), "Mời bạn tiếp tục mua hàng!");
                                startActivity(i);

                            }
                        }, 2000);



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

@Override
protected Map<String, String> getParams() throws AuthFailureError {
    JSONArray jsonArray = new JSONArray();
    for (int i = 0 ; i < MainActivity.mangGioHang.size() ; i++){
        JSONObject jsonObject = new JSONObject();
        try {
//
            jsonObject.put("id_sanpham",String.valueOf(MainActivity.mangGioHang.get(i).getIdsp()));
            jsonObject.put("id_khachhang", String.valueOf(MainActivity.idkhachang));
            jsonObject.put("tensanpham", MainActivity.mangGioHang.get(i).getTensp());
            jsonObject.put("giasp ",MainActivity.mangGioHang.get(i).getGiasp());
            jsonObject.put("soluongsanpham", String.valueOf(MainActivity.mangGioHang.get(i).getSoluongsp()));
//            jsonObject.put("madonhang", madonhang);
//            jsonObject.put("masanham", MainActivity.mangGioHang.get(i).getIdsp());
//            jsonObject.put("giasanpham", MainActivity.mangGioHang.get(i).getGiasp());jsonObject.put("tensanpham", MainActivity.mangGioHang.get(i).getTensp());
//            jsonObject.put("soluongsanpham", MainActivity.mangGioHang.get(i).getSoluongsp());
            System.out.println(MainActivity.mangGioHang.get(i).getGiasp());
                Log.e("giasanpham ",String.valueOf(MainActivity.mangGioHang.get(i).getGiasp()));
        } catch ( JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(jsonObject);
    }
    HashMap<String, String> hashMap = new HashMap<String, String>();
    hashMap.put("json", jsonArray.toString());
    return hashMap;
}
                };
                requestQueue.add(request);

        }
    private void AnhXa() {


        editTenKH = (EditText) findViewById(R.id.edittextTenKH);
        editSDT = (EditText) findViewById(R.id.edittextSdt);
        editEmail = (EditText) findViewById(R.id.edittextEmail);
        editDiachi = (EditText) findViewById(R.id.edittextDiachi);
        btnXacnhan = (Button) findViewById(R.id.buttonXacnhan);
        btnTrove = (Button) findViewById(R.id.buttonTrove);
    }
}