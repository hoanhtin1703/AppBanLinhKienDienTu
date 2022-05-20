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

public class CamBienAdapter extends BaseAdapter {

    Context context;
    ArrayList<SanPham> arrayCamBien;

    public CamBienAdapter(Context context, ArrayList<SanPham> arrayCamBien) {
        this.context = context;
        this.arrayCamBien = arrayCamBien;
    }


    @Override
    public int getCount() {
        return arrayCamBien.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayCamBien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHoder{
        public TextView txttenCamBien,txtgiaCamBien,txtmotaCamBien;
        public ImageView imageViewCamBien;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        CamBienAdapter.ViewHoder viewHoder = null;
        if (view == null) {
            viewHoder = new CamBienAdapter.ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_cambien,null);
            viewHoder.txttenCamBien = (TextView) view.findViewById(R.id.textviewtenCamBien);
            viewHoder.txtgiaCamBien = (TextView) view.findViewById(R.id.textviewGiaCamBien);
            viewHoder.txtmotaCamBien = (TextView) view.findViewById(R.id.textviewmotaCamBien);
            viewHoder.imageViewCamBien = (ImageView) view.findViewById(R.id.imgageCamBien);
            view.setTag(viewHoder);
        }else {
            viewHoder = (CamBienAdapter.ViewHoder) view.getTag();
        }
        SanPham sanPham = (SanPham) getItem(position);
        viewHoder.txttenCamBien.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHoder.txtgiaCamBien.setText("Giá : " + decimalFormat.format(sanPham.getGiaSanPham()) +" Đ");
        viewHoder.txtmotaCamBien.setMaxLines(2);
        viewHoder.txtmotaCamBien.setEllipsize(TextUtils.TruncateAt.END);
        viewHoder.txtmotaCamBien.setText(sanPham.getMoTaSanPham());
        Picasso.with(context).load(sanPham.getHinhAnhSanPham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.images)
                .into(viewHoder.imageViewCamBien);
        return view;
    }
}
