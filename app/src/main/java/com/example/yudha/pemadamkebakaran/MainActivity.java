package com.example.yudha.pemadamkebakaran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PemadamAdapter.ClickHandler {
    RecyclerView recMain;
    ProgressBar progressBar;
    ApiInterface apiInterface;
    PemadamAdapter adapter;

    //static, fungsinya tidak perlu membuat ombjek, liat di Detail Activity
    //public static final String LNG = "LNG";
    //public static final String Alamat = "Alamat";
    //jika variablenya banyak bikin class Constants
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recMain = (RecyclerView) findViewById(R.id.rec_main);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        loadData();
    }

    private void loadData(){
       apiInterface = RestAPI.getApiInterface();

        //parssing Call<Pemadam> dengan belum di execute
        Call<Pemadam> pemadam = apiInterface.getPemadam(
                getResources().getString(R.string.token));
        //untuk executenya dengan pemadam.enqueue
        pemadam.enqueue(new Callback<Pemadam>() {
            @Override
            public void onResponse(Call<Pemadam> call, Response<Pemadam> response) {
                Pemadam responsePemadam = response.body();
                setRecyclerView(responsePemadam);
            }

            @Override
            public void onFailure(Call<Pemadam> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerView(Pemadam responsePemadam) {
        progressBar.setVisibility(View.GONE);
        recMain.setVisibility(View.VISIBLE);
        recMain.setLayoutManager(new LinearLayoutManager(this));

        //ganti jadi Data[] jika array
        List<Data> data = responsePemadam.data;
        adapter = new PemadamAdapter(data, this, this);
        recMain.setAdapter(adapter);
    }

    @Override
    public void onClick(Data data) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        String[] datas = new String[]{data.getALAMAT(), data.getPOS_PEMADAM(),
                data.getKELURAHAN(), data.getRT_RW()};
        //cara lain menggunakan object bundle, object bundle berfungsi untuk menampung data
        //1. membuat object bundle
        Bundle bundle = new Bundle();
        //perbedaannya ada pada putnya, kalau bundle lebih spesifik
        bundle.putString(Constants.NAMA, data.getPOS_PEMADAM());
        bundle.putString(Constants.ALAMAT, data.getALAMAT());
        bundle.putString(Constants.KELURAHAN, data.getKELURAHAN());
        bundle.putString(Constants.RTRW, data.getRT_RW());
        bundle.putDouble(Constants.LAT, data.getLAT());
        bundle.putDouble(Constants.LNG, data.getLNG());

        //kalau array

        //intent.putExtra("datas", datas);
        //kalau biasa
        /// intent.putExtra("alamat", data.getALAMAT());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}

