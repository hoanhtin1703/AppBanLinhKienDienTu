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

import com.example.doan.Activity.DanhMucChiTiet;
import com.example.doan.R;
import com.example.doan.model.LoaiSp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaiSpAdapter extends RecyclerView.Adapter<LoaiSpAdapter.LoaiSpViewHolder> {
    ArrayList<LoaiSp> arrayListloaisp;
    Context context;

    public LoaiSpAdapter(ArrayList<LoaiSp> arrayListloaisp, Context context) {
        this.arrayListloaisp = arrayListloaisp;
        this.context = context;
    }

    @NonNull
    @Override
    public LoaiSpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_loaisp,parent,false);
         LoaiSpViewHolder loaiSpViewHolder = new LoaiSpViewHolder(view);
        return loaiSpViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiSpViewHolder holder, int position) {
        LoaiSp loaisanPham = arrayListloaisp.get(position);
        holder.tvloaisp.setText(loaisanPham.getTenloaisanpham());
        Picasso.with(context).load(loaisanPham.getHinhanhloaisanpham())
                .placeholder((R.drawable.noimage))
                .error(R.drawable.images)
                .into(holder.hinhanhdanhmuc);

    }

    @Override
    public int getItemCount() {
        return arrayListloaisp.size();
    }

    public class LoaiSpViewHolder extends RecyclerView.ViewHolder{
        public TextView tvloaisp;
        public ImageView hinhanhdanhmuc;
        public LoaiSpViewHolder(@NonNull View itemView) {
            super(itemView);
            tvloaisp = (TextView) itemView.findViewById(R.id.textviewloaisanpham);
            hinhanhdanhmuc = (ImageView) itemView.findViewById(R.id.hinhdanhmuc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhMucChiTiet.class);
                    intent.putExtra("id_danhmuc", arrayListloaisp.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    context.startActivity(intent);
                }
            });
        }
    }

}
