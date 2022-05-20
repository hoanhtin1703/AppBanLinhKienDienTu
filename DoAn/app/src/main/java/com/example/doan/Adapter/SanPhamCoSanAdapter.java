package com.example.doan.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan.R;
import com.example.doan.model.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanPhamCoSanAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arraySanPhamCoSan;

    public SanPhamCoSanAdapter(Context context, ArrayList<SanPham> arraySanPhamCoSan) {
        this.context = context;
        this.arraySanPhamCoSan = arraySanPhamCoSan;
    }

    @Override
    public int getCount() {
        return arraySanPhamCoSan.size();
    }

    @Override
    public Object getItem(int position) {
        return arraySanPhamCoSan.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHoder{
        public TextView txttenSanPhamCoSan,txtgiaSanPhamCoSan,txtmotaSanPhamCoSan;
        public ImageView imageViewSanPhamCoSan;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        SanPhamCoSanAdapter.ViewHoder viewHoder = null;
        if (view == null) {
            viewHoder = new SanPhamCoSanAdapter.ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_spcosan,null);
            viewHoder.txttenSanPhamCoSan = (TextView) view.findViewById(R.id.textviewtenSanPhamCoSan);
            viewHoder.txtgiaSanPhamCoSan = (TextView) view.findViewById(R.id.textviewGiaSanPhamCoSan);
            viewHoder.txtmotaSanPhamCoSan = (TextView) view.findViewById(R.id.textviewmotaSanPhamCoSan);
            viewHoder.imageViewSanPhamCoSan = (ImageView) view.findViewById(R.id.imgageSanPhamCoSan);
            view.setTag(viewHoder);
        }else {
            viewHoder = (SanPhamCoSanAdapter.ViewHoder) view.getTag();
        }
        SanPham sanPham = (SanPham) getItem(position);
        viewHoder.txttenSanPhamCoSan.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHoder.txtgiaSanPhamCoSan.setText("Giá : " + decimalFormat.format(sanPham.getGiaSanPham()) +" Đ");
        viewHoder.txtmotaSanPhamCoSan.setMaxLines(2);
        viewHoder.txtmotaSanPhamCoSan.setEllipsize(TextUtils.TruncateAt.END);
        viewHoder.txtmotaSanPhamCoSan.setText(sanPham.getMoTaSanPham());
        Picasso.with(context).load(sanPham.getHinhAnhSanPham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.images)
                .into(viewHoder.imageViewSanPhamCoSan);
        return view;
    }
}
