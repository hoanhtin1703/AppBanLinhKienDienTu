package com.example.doan.Admin;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.doan.R;
import com.example.doan.model.LoaiSp;
import com.example.doan.model.SanPham;
import com.example.doan.util.Api_Client;
import com.example.doan.util.Api_interface;
import com.example.doan.util.KiemTraKetNoi;
import com.example.doan.util.Server;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;

public class CRUD_Product extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner loaispspiner;
ArrayList<LoaiSp> MangLoaiSp ;
SpinnerAdapter adapter;
EditText edt_tensanpham,edt_giasanpham,edt_mota,edt_soluong;
int idsanpham =0;
Bitmap bitmap;
CircleImageView mpicture;
FloatingActionButton mfabpicture;
private int id,iddanhmuc;
private  Integer giasp;
private String tensp,motasp,hinhanhsp,soluong;
Api_interface api_interface;

    private Menu action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.ThemeCustom);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_product);
        if (KiemTraKetNoi.haveNetworkConnection(getApplicationContext())){
            init();
            GetLoaiSp();
        } else {
            KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Hãy kiểm tra lại kết nối!");
            finish();
        }

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        tensp = intent.getStringExtra("tensanpham");
        giasp = intent.getIntExtra("giasanpham",0);
        hinhanhsp = intent.getStringExtra("hinhanhsanpham");
        motasp = intent.getStringExtra("motasanpham");
        soluong = intent.getStringExtra("soluong");
        iddanhmuc = intent.getIntExtra("idsanpham", 0);
        SetdulieuSp();
        System.out.println(iddanhmuc);
    }
    private void SetdulieuSp() {

        if (id != 0) {
readMode();
            edt_tensanpham.setText(tensp);
            DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
            edt_giasanpham.setText(giasp.toString());
            edt_soluong.setText(soluong);
            edt_mota.setText(motasp);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.skipMemoryCache(true);
            requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
            requestOptions.placeholder(R.drawable.images);
            requestOptions.error(R.drawable.images);
            Glide.with(CRUD_Product.this)
                    .load(hinhanhsp)
                    .apply(requestOptions)
                    .into(mpicture);
        getsingleLoaiSP();
        }
    }
    private void getsingleLoaiSP() {

api_interface = Api_Client.getApiClient().create(Api_interface.class);
        Call<LoaiSp> call= api_interface.insert_id_loaisp(iddanhmuc);
       call.enqueue(new Callback<LoaiSp>() {
           @Override
           public void onResponse(Call<LoaiSp> call, retrofit2.Response<LoaiSp> response) {
                    int id = response.body().getId();
                    String name = response.body().getTenloaisanpham();
               MangLoaiSp.add(new LoaiSp(id,name));
               System.out.println(MangLoaiSp);
               ArrayAdapter<LoaiSp> AdapterLoaiSP = new ArrayAdapter<LoaiSp>(CRUD_Product.this, android.R.layout.simple_spinner_dropdown_item,MangLoaiSp );
//                            AdapterLoaiSP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
               loaispspiner.setAdapter(AdapterLoaiSP);
               loaispspiner.setSelection(0);
           }

           @Override
           public void onFailure(Call<LoaiSp> call, Throwable t) {
KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"loi");
           }
       });
    }
    private void GetLoaiSp() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongDanTenLoaiSanPham, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    int ID = 0;
                    String tenloaisanpham = " ";

                    for (int i = 0; i < response.length(); i++){
                        try {
                            LoaiSp sp = new LoaiSp();
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            tenloaisanpham = jsonObject.getString("tenloaisanpham");
                            MangLoaiSp.add(new LoaiSp(ID,tenloaisanpham));
                            System.out.println(MangLoaiSp);
                            ArrayAdapter<LoaiSp> AdapterLoaiSP = new ArrayAdapter<LoaiSp>(CRUD_Product.this, android.R.layout.simple_spinner_dropdown_item,MangLoaiSp );
//                            AdapterLoaiSP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           loaispspiner.setAdapter(AdapterLoaiSP);
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
        loaispspiner.setOnItemSelectedListener(this);
    }
    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                mpicture.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    @SuppressLint("ResourceType")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        LoaiSp sp = (LoaiSp) adapterView.getItemAtPosition(i);
        idsanpham= sp.Id;
        Toast.makeText(this,String.valueOf(sp.Id) +" "+String.valueOf(sp.Tenloaisanpham) ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor, menu);
        action = menu;
        action.findItem(R.id.menu_save).setVisible(false);
        if (id != 0) {
            action.findItem(R.id.menu_edit).setVisible(true);
            action.findItem(R.id.menu_delete).setVisible(true);
            action.findItem(R.id.menu_save).setVisible(false);
        }
        else{
            action.findItem(R.id.menu_edit).setVisible(false);
            action.findItem(R.id.menu_delete).setVisible(false);
            action.findItem(R.id.menu_save).setVisible(true);
        }

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.menu_edit:
                //Edit
                editMode();
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(edt_name, InputMethodManager.SHOW_IMPLICIT);
                action.findItem(R.id.menu_edit).setVisible(false);
                action.findItem(R.id.menu_delete).setVisible(false);
                action.findItem(R.id.menu_save).setVisible(true);
                return true;
            case R.id.menu_save:
                //Save
                if (id == 0 ) {
                    // Nếu như không nhập gì cả , hiển thị cho người dùng dòng thông báo
                    if (TextUtils.isEmpty(edt_tensanpham.getText().toString()) ||
                            TextUtils.isEmpty(edt_giasanpham.getText().toString()) ||
                            TextUtils.isEmpty(edt_mota.getText().toString()) ||
                            TextUtils.isEmpty(edt_soluong.getText().toString())) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                        alertDialog.setMessage("Làm ơn hãy điền hết vào chỗ trống!");
                        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertDialog.show();
                    } else {
                        // Post dữ liệu vào host
                        ThemSanPham();
                        action.findItem(R.id.menu_edit).setVisible(false);
                        action.findItem(R.id.menu_save).setVisible(true);
                        action.findItem(R.id.menu_delete).setVisible(false);
                        readMode();

                    }
                } else {
                    // Cập Nhật dữ liệu
                    SuaSanPham();
                    action.findItem(R.id.menu_edit).setVisible(true);
                    action.findItem(R.id.menu_save).setVisible(false);
                    action.findItem(R.id.menu_delete).setVisible(true);
                    readMode();
                  finish();
                }
                return true;
            case R.id.menu_delete:
                // Xóa
                AlertDialog.Builder dialog = new AlertDialog.Builder(CRUD_Product.this);
                dialog.setMessage("Bạn có muốn xóa sinh viên này");
                dialog.setPositiveButton("Có" ,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    XoaSanPham();
                    finish();
                    }
                });
                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public  void ThemSanPham() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Đang Thuc Hien...");
        progressDialog.show();
        String tensp = edt_tensanpham.getText().toString().trim();
        String giasp = edt_giasanpham.getText().toString().trim();
        String mota = edt_mota.getText().toString().trim();
        String soluong = edt_soluong.getText().toString().trim();
        String picture = null;
        if (bitmap == null) {
            picture = "";
        } else {
            picture = getStringImage(bitmap);
        }
        String finalPicture = picture;
        Log.e("picture",String.valueOf(idsanpham));
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.POST, Server.DuongDanThemSanPham, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                finish();
KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"success");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"error");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<String,String>();
                param.put("tensanpham",tensp);
                param.put("giasanpham",giasp);
                param.put("hinhanhsanpham",finalPicture);
                param.put("soluong",soluong);
                param.put("motasanpham",mota);
                param.put("idsanpham",String.valueOf(idsanpham));

                return param;
            }
        };
        requestQueue.add(request);

    }
    private  void SuaSanPham(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Đang Thuc Hien...");
        progressDialog.show();
        String tensp = edt_tensanpham.getText().toString().trim();
        String giasp = edt_giasanpham.getText().toString().trim();
        String mota = edt_mota.getText().toString().trim();
        String soluong = edt_soluong.getText().toString().trim();
        String picture = null;
        if (bitmap == null) {
            picture = "";
        } else {
            picture = getStringImage(bitmap);
        }
   Log.e("bitmap",String.valueOf(bitmap));
        String finalPicture = picture;

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.POST, Server.DuongDanSuaSanPham, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                finish();
                    KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Cap Nhat Thanh Cong");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"error");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<String,String>();
                param.put("id",String.valueOf(id));
                param.put("tensanpham",tensp);
                param.put("giasanpham",giasp);
                param.put("hinhanhsanpham", finalPicture);
                param.put("soluong",soluong);
                param.put("motasanpham",mota);
                param.put("idsanpham",String.valueOf(idsanpham));

                return param;
            }
        };
        requestQueue.add(request);
//        finish();
    }
public void XoaSanPham(){

api_interface = Api_Client.getApiClient().create(Api_interface.class);
Call<SanPham> call = api_interface.delete_sanpham(id,hinhanhsp);
call.enqueue(new Callback<SanPham>() {
    @Override
    public void onResponse(Call<SanPham> call, retrofit2.Response<SanPham> response) {
    String status = response.body().getStatus();
    if(status.equals(1)){
        finish();
        KiemTraKetNoi.show_Toast_Short(getApplicationContext(),"Xoas thanh cong");
    }
    }

    @Override
    public void onFailure(Call<SanPham> call, Throwable t) {

    }
});
}
    @SuppressLint("RestrictedApi")
    void readMode(){
        edt_tensanpham.setFocusableInTouchMode(false);
        edt_giasanpham.setFocusableInTouchMode(false);
        edt_mota.setFocusableInTouchMode(false);
        edt_soluong.setFocusableInTouchMode(false);
        mfabpicture.setVisibility(View.INVISIBLE);
        loaispspiner.setEnabled(false);

    }
    private void editMode(){

        edt_tensanpham.setFocusableInTouchMode(true);
        edt_giasanpham.setFocusableInTouchMode(true);
        edt_mota.setFocusableInTouchMode(true);
        edt_soluong.setFocusableInTouchMode(true);
       loaispspiner.setSelection(MangLoaiSp.indexOf(0));
      loaispspiner.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
              MangLoaiSp.clear();
              GetLoaiSp();
              return false;
          }
      });

        loaispspiner.setEnabled(true);

        mfabpicture.setVisibility(View.VISIBLE);
    }
    public  void init(){
        edt_tensanpham = findViewById(R.id.edt_product_name);
        edt_giasanpham= findViewById(R.id.edt_price);
        edt_mota = findViewById(R.id.edt_descreption);
        edt_soluong = findViewById(R.id.edt_quantity);
        mpicture = findViewById(R.id.picture);
        mfabpicture = findViewById(R.id.fabChoosePic);
//        toolbar = (Toolbar) findViewById(R.id.tootlbarMHC);
//        navigationView = (NavigationView) findViewById(R.id.navigationview);
//        listView = (ListView) findViewById(R.id.listviewMHC);
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        viewFlipper = (ViewFlipper) findViewById(R.id.viewfliper);
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        MangLoaiSp = new ArrayList<LoaiSp>();
        loaispspiner = (Spinner) findViewById(R.id.spinner_category);
        mfabpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
            }
        });

    }
}