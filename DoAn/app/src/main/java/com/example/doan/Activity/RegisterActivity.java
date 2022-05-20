package com.example.doan.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.doan.R;
import com.example.doan.model.Account;
import com.example.doan.util.Api_Client;
import com.example.doan.util.Api_interface;
import com.example.doan.util.KiemTraKetNoi;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;

public class RegisterActivity extends AppCompatActivity {
    CoordinatorLayout layout;
    private Api_interface apiInterface;
    private EditText user_name,password,email,phone,address;
    private String muser_name,mpassword,memail,mphone,maddress;
    Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Khởi tạo các View
//        getSupportActionBar().setTitle("Đăng ký tài khoản " );

        setContentView(R.layout.activity_register);
        user_name = findViewById(R.id.edt_user_name);
        password = findViewById(R.id.edt_password);
        email = findViewById(R.id.edt_email);
        phone = findViewById(R.id.edt_phone);
        address = findViewById(R.id.edt_address);
//
        Button btn_register = findViewById(R.id.btn_register);
//
        TextView click_here = findViewById(R.id.tv_click_here);

        click_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(user_name.getText().toString()) ||
                        TextUtils.isEmpty(password.getText().toString()) ||
                        TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(phone.getText().toString())|| TextUtils.isEmpty(address.getText().toString())
                         ){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(RegisterActivity.this);
                    alertDialog.setMessage("Xin Mời Điền Đầy Đủ Hết Thông Tin!");
                    alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }
                else {
                    muser_name = user_name.getText().toString().trim();
                    mpassword = password.getText().toString().trim();
                    memail = email.getText().toString().trim();
                    mphone = phone.getText().toString().trim();
                    maddress = address.getText().toString().trim();
                    DangKy(muser_name,memail,mpassword,mphone,maddress);

//                    Register("register", muser_name, mpassword, mname,mstudent_code,mgrade,mmajor,mdate);
                }
            }
            public  void DangKy(String user_name,String email, String password,String phone,String address){
                apiInterface = Api_Client.getApiClient().create(Api_interface.class);
                Call <Account> call = apiInterface.dangky(user_name,email,password,phone,address);
                call.enqueue(new Callback<Account>() {
                    @RequiresApi(api = Build.VERSION_CODES.P)
                    @Override
                    public void onResponse(Call<Account> call, retrofit2.Response<Account> response) {
                        Log.i(RegisterActivity.class.getSimpleName(), response.toString());
                     String value = response.body().getValue();
                        System.out.println(value);
                        if(value.equals("1")){
                            layout = findViewById(R.id.layout_id);

           KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Đăng ký thành công");
                            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            },2000);
                        }
                        else {
                            KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"loi");
                        }
                    }

                    @Override
                    public void onFailure(Call<Account> call, Throwable t) {
KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"loi");
                    }
                });
            }
//            public void Register(String key,String user,String pass,String name,String student_code,String grade,String major,String date){
//// Gọi Api interface
//                apiInterface = Api_Client.getApiClient().create(Api_interface.class);
//                // Gọi hàm call back
//                Call<Account> call = apiInterface.register(key,user,pass,name,student_code,grade,major,date);
//call.enqueue(new Callback<Account>() {
//    @RequiresApi(api = Build.VERSION_CODES.P)
//    @Override
//    public void onResponse(Call<Account> call, Response<Account> response) {
//        Log.i(RegisterActivity.class.getSimpleName(), response.toString());
//        String status = response.body().getStatus();
//        String result_code = response.body().getResult_code();
//        if(status.equals("true") && result_code.equals("0")){
//           layout = findViewById(R.id.layout_id);
//            Snackbar snackbar = Snackbar
//                    .make(layout, "Đăng ký thành công", Snackbar.LENGTH_LONG);
//            snackbar.show();
//
//            InputMethodManager imm = (InputMethodManager)RegisterActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE); imm.hideSoftInputFromWindow(layout.getWindowToken(), 0);
//           // Xây dựng hàm đợi (delay)
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);                        startActivity(i);
//                }
//            },1000);
//        } else {
//            Toast.makeText(RegisterActivity.this, "Tài Khoản Này Đã Được Sử Dụng Rồi ", Toast.LENGTH_SHORT).show();
//        }
//    }
//    @Override
//    public void onFailure(Call<Account> call, Throwable t) {
//
//    }
//});
//            }

        });

    }


}



