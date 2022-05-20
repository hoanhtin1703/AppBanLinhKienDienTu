package com.example.doan.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan.Admin.List_Product;
import com.example.doan.R;
import com.example.doan.model.Account;
import com.example.doan.model.KhachHang;
import com.example.doan.util.Api_Client;
import com.example.doan.util.Api_interface;
import com.example.doan.util.KiemTraKetNoi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {
    private Api_interface apiInterface; // Khởi tạo API_Interface
    private EditText user_name,password;
    private String muser_name,mpassword;
    private List<KhachHang> khachHangListlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Khởi tạo các View'

        user_name = findViewById(R.id.edt_user_name);
        password = findViewById(R.id.edt_password);
        TextView click_to_register = findViewById(R.id.click_to_register);
        click_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                muser_name = user_name.getText().toString().trim();
                mpassword = password.getText().toString().trim();
                login(muser_name,mpassword);

            }
            public  void login(final String email,String password){
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Đang Đăng Nhập...");
                progressDialog.show();

                apiInterface = Api_Client.getApiClient().create(Api_interface.class);
                Call<Account> call = apiInterface.dangnhap(email,password);

                call.enqueue(new Callback<Account>() {
                    @Override
                    public void onResponse(Call<Account> call, retrofit2.Response<Account> response) {
                        String value = response.body().getValue();
                        int id = response.body().getId();
                        Log.e("idkhachang",String.valueOf(id));
                        Log.e("value", value);
//                        int id_khachhang = response.body().getId();
                        int level = response.body().getLevel();
                        if(value.equals("0")){
                            progressDialog.dismiss();
                            KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"loi");
                        }else {
                            if (level == 0) {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent i = new Intent(getApplicationContext(), List_Product.class);
                                        startActivity(i);
                                    }
                                }, 2000);
                            } else {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                        i.putExtra("idkhachhang",id);
                                        startActivity(i);

                                    }
                                }, 2000);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Account> call, Throwable t) {
            progressDialog.dismiss();
KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Sai Thông Tin");
                    }
                });
            }

        });
    }
}