package com.example.yudha.pemadamkebakaran;

import java.util.List;

/**
 * Created by yudha on 12/2/2017.
 */

public class Pemadam {
    //membuat object yang ingin di kembaliin terlebih dahulu
    String status;
    int count;

    //jika menggunakan arrya
    //Data[] datas;
    List<Data> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
