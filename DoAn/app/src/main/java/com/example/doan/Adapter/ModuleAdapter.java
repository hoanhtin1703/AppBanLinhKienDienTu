package com.example.doan.Adapter;

import android.content.Context;
import android.media.Image;
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

public class ModuleAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arrayModule;

    public ModuleAdapter(Context context, ArrayList<SanPham> arrayModule) {
        this.context = context;
        this.arrayModule = arrayModule;
    }

    @Override
    public int getCount() {
        return arrayModule.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayModule.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHoder{
        public TextView txttenModule,txtgiaModule,txtmotaModule;
        public ImageView imageViewModule;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder = null;
        if (view == null) {
            viewHoder = new ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_module,null);
            viewHoder.txttenModule = (TextView) view.findViewById(R.id.textviewtenModule);
            viewHoder.txtgiaModule = (TextView) view.findViewById(R.id.textviewGiaModule);
            viewHoder.txtmotaModule = (TextView) view.findViewById(R.id.textviewmotaModule);
            viewHoder.imageViewModule = (ImageView) view.findViewById(R.id.imgageModule);
            view.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) view.getTag();
        }
        SanPham sanPham = (SanPham) getItem(position);
        viewHoder.txttenModule.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHoder.txtgiaModule.setText("Giá : " + decimalFormat.format(sanPham.getGiaSanPham()) +" Đ");
        viewHoder.txtmotaModule.setMaxLines(2);
        viewHoder.txtmotaModule.setEllipsize(TextUtils.TruncateAt.END);
        viewHoder.txtmotaModule.setText(sanPham.getMoTaSanPham());
        Picasso.with(context).load(sanPham.getHinhAnhSanPham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.images)
                .into(viewHoder.imageViewModule);
        return view;
    }
}
