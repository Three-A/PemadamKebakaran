package com.example.yudha.pemadamkebakaran;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by yudha on 12/2/2017.
 */

public class PemadamViewHolder extends RecyclerView.ViewHolder {

    TextView txtAlamat, txtPos;
    ImageView imgIcon;
    CardView holderClick;
    public PemadamViewHolder(View itemView) {
        super(itemView);

        //inisialisasi
        //menggunakan itemView karena bukan sebuah activity jadi tidak terhubungke xml
        holderClick = itemView.findViewById(R.id.holder_click);
        txtAlamat = itemView.findViewById(R.id.txt_alamat);
        txtPos = itemView.findViewById(R.id.txt_pos);
        imgIcon = itemView.findViewById(R.id.image_icon);
    }
}
