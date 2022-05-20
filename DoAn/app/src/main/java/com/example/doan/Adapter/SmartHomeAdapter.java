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

public class SmartHomeAdapter  extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arraySmartHome;

    public SmartHomeAdapter(Context context, ArrayList<SanPham> arraySmartHome) {
        this.context = context;
        this.arraySmartHome = arraySmartHome;
    }

    @Override
    public int getCount() {
        return arraySmartHome.size();
    }

    @Override
    public Object getItem(int position) {
        return arraySmartHome.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHoder{
        public TextView txttenSmartHome,txtgiaSmartHome,txtmotaSmartHome;
        public ImageView imageViewSmartHome;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        SmartHomeAdapter.ViewHoder viewHoder = null;
        if (view == null) {
            viewHoder = new SmartHomeAdapter.ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_smarthome,null);
            viewHoder.txttenSmartHome = (TextView) view.findViewById(R.id.textviewtenSmartHome);
            viewHoder.txtgiaSmartHome = (TextView) view.findViewById(R.id.textviewGiaSmartHome);
            viewHoder.txtmotaSmartHome = (TextView) view.findViewById(R.id.textviewmotaSmartHome);
            viewHoder.imageViewSmartHome = (ImageView) view.findViewById(R.id.imgageSmartHome);
            view.setTag(viewHoder);
        }else {
            viewHoder = (SmartHomeAdapter.ViewHoder) view.getTag();
        }
        SanPham sanPham = (SanPham) getItem(position);
        viewHoder.txttenSmartHome.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHoder.txtgiaSmartHome.setText("Giá : " + decimalFormat.format(sanPham.getGiaSanPham()) +" Đ");
        viewHoder.txtmotaSmartHome.setMaxLines(2);
        viewHoder.txtmotaSmartHome.setEllipsize(TextUtils.TruncateAt.END);
        viewHoder.txtmotaSmartHome.setText(sanPham.getMoTaSanPham());
        Picasso.with(context).load(sanPham.getHinhAnhSanPham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.images)
                .into(viewHoder.imageViewSmartHome);
        return view;
    }
}
