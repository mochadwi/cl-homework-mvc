package io.github.mochadwi.practicerecyclerview.utility;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by mochadwi on 11/18/16.
 */

public class OkHttp {
    /*
    Method getDataFromServer
     */
    public static Call getDataFromServer(String url) {
        Call call = null;
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS) // konek
                .writeTimeout(20, TimeUnit.SECONDS) // ngambil data
                .readTimeout(30, TimeUnit.SECONDS) // baca data
                .build();

        Request request = new Request.Builder()
                .url(url) // ambil url yg tadi
                .build();

        call = client.newCall(request);
        return call;
    }
}
