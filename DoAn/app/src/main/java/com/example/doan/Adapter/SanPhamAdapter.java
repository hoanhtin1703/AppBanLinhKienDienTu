package com.example.doan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.Activity.ChiTietSanPham;
import com.example.doan.R;
import com.example.doan.model.SanPham;
import com.example.doan.util.KiemTraKetNoi;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ItemHoder> {
    Context context;
    ArrayList<SanPham> arraySanPham;
    public SanPhamAdapter(Context context, ArrayList<SanPham> arraySanPham) {
        this.context = context;
        this.arraySanPham = arraySanPham;
    }

    public ItemHoder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sanphammoinhat,null);
        ItemHoder itemHoder = new ItemHoder(v);
        return itemHoder;
    }

    @Override
    public void onBindViewHolder(ItemHoder holder, int position) {
        SanPham sanPham = arraySanPham.get(position);
        Log.e("idsanpham",String.valueOf(sanPham.getID()));
        holder.txttensanpham.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText("Giá : " + decimalFormat.format(sanPham.getGiaSanPham()) +" Đ");
        Picasso.with(context).load(sanPham.getHinhAnhSanPham())
                .placeholder((R.drawable.noimage))
                .error(R.drawable.images)
                .into(holder.imageSanPham);
    }

    @Override
    public int getItemCount() {
        return arraySanPham.size();
    }

    public class ItemHoder extends RecyclerView.ViewHolder{
        public ImageView imageSanPham;
        public TextView txttensanpham, txtgiasanpham;
        public ItemHoder(View itemView){
            super(itemView);
            imageSanPham = (ImageView) itemView.findViewById(R.id.imageviewsanpham);
            txtgiasanpham = (TextView) itemView.findViewById(R.id.textviewgiasanpham);
            txttensanpham = (TextView) itemView.findViewById(R.id.textviewtensanpham);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChiTietSanPham.class);
                    intent.putExtra("thongtinsanpham",arraySanPham.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    KiemTraKetNoi.show_Toast_Short(context, arraySanPham.get(getPosition()).getTenSanPham());
                    context.startActivity(intent);
                }
            });
        }
    }
}
