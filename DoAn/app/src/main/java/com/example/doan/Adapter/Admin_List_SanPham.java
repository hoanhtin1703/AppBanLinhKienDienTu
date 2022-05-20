package com.example.doan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.doan.Admin.CRUD_Product;
import com.example.doan.R;
import com.example.doan.model.SanPham;
import com.example.doan.util.KiemTraKetNoi;

import java.text.DecimalFormat;
import java.util.List;

public class Admin_List_SanPham extends RecyclerView.Adapter<Admin_List_SanPham.ProductViewHolder> {
    Context context;
    List<SanPham> mlistsanpham;

public Admin_List_SanPham(Context context,List<SanPham> listsanpham){
    this.context = context;
    this.mlistsanpham = listsanpham;
}
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_sanpham,parent,false);
    return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
SanPham sp = mlistsanpham.get(position) ;
     holder.tensp.setText(sp.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.giasp.setText("Giá : " + decimalFormat.format(sp.getGiaSanPham()) +" Đ");
        holder.trangthai.setText("Trạng thái trong kho :" +sp.getSoLuong());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.skipMemoryCache(true);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
        requestOptions.placeholder(R.drawable.images);
        requestOptions.error(R.drawable.images);
        Glide.with(context)
                .load(sp.getHinhAnhSanPham())
                .apply(requestOptions)
                .into(holder.imagesanpham);
}

    @Override
    public int getItemCount() {
    if(mlistsanpham != null){
        return mlistsanpham.size();
    }
       return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagesanpham;
        public  TextView tensp,giasp,trangthai;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tensp = itemView.findViewById(R.id.textviewtensanpham);
            giasp = itemView.findViewById(R.id.textviewgiasanpham);
            trangthai = itemView.findViewById(R.id.textviewsoluong);
            imagesanpham = itemView.findViewById(R.id.imageviewsanpham);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, CRUD_Product.class);
                    intent.putExtra("id",mlistsanpham.get(getPosition()).getID());
                    intent.putExtra("tensanpham",mlistsanpham.get(getPosition()).getTenSanPham());
                    intent.putExtra("giasanpham",mlistsanpham.get(getPosition()).getGiaSanPham());
                    intent.putExtra("hinhanhsanpham",mlistsanpham.get(getPosition()).getHinhAnhSanPham());
                    intent.putExtra("soluong",mlistsanpham.get(getPosition()).getSoLuong());
                    intent.putExtra("motasanpham",mlistsanpham.get(getPosition()).getMoTaSanPham());
                    intent.putExtra("idsanpham",mlistsanpham.get(getPosition()).getIDSanPham());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    KiemTraKetNoi.show_Toast_Short(context, mlistsanpham.get(getPosition()).getTenSanPham());
                    context.startActivity(intent);
                }
            });
        }

    }
}
