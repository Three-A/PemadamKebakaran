package com.example.yudha.pemadamkebakaran;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yudha on 12/2/2017.
 */

//pastikan viewholdernya sudah generate
public class PemadamAdapter extends RecyclerView.Adapter<PemadamViewHolder> {
    List<Data> Datas;
    ClickHandler clickHandler;

    Context mContext;
    //membuat interface untuk clickHandler agar recyclerview dapat di klik dan melakukan action
    interface ClickHandler {
        void onClick(Data data);
    }
    //mmebuat constructor
    //constructor adalah fungsi yang harus memiliki nama seperti kelasnya
    //berguna untuk parsing data
    public PemadamAdapter(List<Data> /* data[] */ datas, ClickHandler clickHandler, Context context){
        mContext = context;
        Datas = datas;
        //Data[] = datas;
        this.clickHandler = clickHandler;
    }
    @Override
    public PemadamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //membuat view
        //LayoutInflater berguna untuk menginflate/nampung suatu view ke view yang lain
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);

        return new PemadamViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PemadamViewHolder holder, int position) {
        Data data = Datas.get(position);
        //String image = "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/24852633_1359311877510735_758755190507060218_n.jpg?oh=9a9648f52c445209e0df03e73ee2baa6&oe=5A94D328";
       // https://images.freeimages.com/images/large-previews/12c/fire-1-1251322.jpg
       // Picasso.with(mContext).load(image).into(holder.imgIcon);
        bind(holder, data);
    }

    private void bind(PemadamViewHolder holder, final Data data){
        holder.txtPos.setText(data.getPOS_PEMADAM());
        holder.txtAlamat.setText(data.getALAMAT());
        holder.holderClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHandler.onClick(data);
            }
        });
    }
//untuk memberitahu RecycleView panjang data yang harus di buat nantinya
    @Override
    public int getItemCount() {
        //return Datas.lenght;
        return Datas.size();
    }



}
