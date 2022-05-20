package com.example.doan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.R;
import com.example.doan.model.List_Data_home;
import com.example.doan.model.LoaiSp;
import com.example.doan.model.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class Adapter_home extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int TYPE_SANPHAM =1;
    public static int TYPE_DANHMUC =0;
    Context context;
    private List<List_Data_home> sanPhamList;
    private List<SanPham> msanpham;
    private List<LoaiSp> mlistdanhmuc;
    public Adapter_home(Context conxtext, List arraySanPham) {
        this.context = context;
        this.sanPhamList = arraySanPham;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println(getItemViewType(viewType));
        if(getItemViewType(viewType) == 1 ){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sanphammoinhat,parent,false);
        SanPhamMoiNhatViewHolder sanPhamMoiNhatViewHolder = new SanPhamMoiNhatViewHolder(view);
        return sanPhamMoiNhatViewHolder;
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_loaisp,parent,false);
            DanhMucViewHolder danhMucViewHolder = new DanhMucViewHolder(view);
            return danhMucViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List_Data_home data_home = (List_Data_home) sanPhamList.get(position);
        if(getItemViewType(position)==0){
            mlistdanhmuc = data_home.getListdanhmuc();
            LoaiSp Mloaisanpham = (LoaiSp) mlistdanhmuc.get(position);
            DanhMucViewHolder danhmuc = (DanhMucViewHolder) holder;
            danhmuc.tenloaisp.setText(Mloaisanpham.getTenloaisanpham());
        }
        else {
            msanpham = data_home.getListsanpham();
            SanPham Msanpham = (SanPham) msanpham.get(position);
            SanPhamMoiNhatViewHolder sp = (SanPhamMoiNhatViewHolder) holder;
            sp.txttensanpham.setText(Msanpham.getTenSanPham());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            sp.txtgiasanpham.setText("Giá : " + decimalFormat.format(Msanpham.getGiaSanPham()) +" Đ");
            Picasso.with(context).load(Msanpham.getHinhAnhSanPham())
                    .placeholder((R.drawable.noimage))
                    .error(R.drawable.images)
                    .into(sp.imageSanPham);
        }

    }

    @Override
    public int getItemCount() {
        if(sanPhamList !=null){
            return sanPhamList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {

        return sanPhamList.get(position).getType() ;
    }

    public class SanPhamMoiNhatViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageSanPham;
        public TextView txttensanpham, txtgiasanpham;
        public SanPhamMoiNhatViewHolder(@NonNull View itemView) {
            super(itemView);
            imageSanPham = (ImageView) itemView.findViewById(R.id.imageviewsanpham);
            txtgiasanpham = (TextView) itemView.findViewById(R.id.textviewgiasanpham);
            txttensanpham = (TextView) itemView.findViewById(R.id.textviewtensanpham);
        }
    }
    public class DanhMucViewHolder extends RecyclerView.ViewHolder{
        private TextView tenloaisp;
        public DanhMucViewHolder(@NonNull View itemView) {
            super(itemView);
            tenloaisp = (TextView) itemView.findViewById(R.id.textviewloaisanpham);
        }
    }
}
