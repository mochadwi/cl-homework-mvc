package io.github.mochadwi.practicerecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import io.github.mochadwi.practicerecyclerview.adapter.BukuAdapter;
import io.github.mochadwi.practicerecyclerview.model.Buku;
import io.github.mochadwi.practicerecyclerview.utility.OkHttp;
import io.github.mochadwi.practicerecyclerview.utility.RecyclerTouchListener;
import io.github.mochadwi.practicerecyclerview.utility.UrlTag;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {
    ArrayList<Buku> bukuArrayList = new ArrayList<Buku>();
    BukuAdapter bukuAdapter;
    RecyclerView rvBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        rvBuku = (RecyclerView) findViewById(R.id.rv_arraylist);
        bukuAdapter = new BukuAdapter(bukuArrayList, this);
        rvBuku.setHasFixedSize(true);
        rvBuku.setLayoutManager(new LinearLayoutManager(this));
        rvBuku.addOnItemTouchListener(new RecyclerTouchListener(this, rvBuku,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Buku bk = bukuArrayList.get(position);
                        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                        intent.putExtra("Judul", bk.getJudulBuku());
                        intent.putExtra("Penerbit", bk.getPenerbit());
                        intent.putExtra("Deskripsi", bk.getDeskripsi());
                        startActivityForResult(intent, 0);
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
        rvBuku.setAdapter(bukuAdapter);

        prepareData();
    }

    private void prepareData() {
        Call call = OkHttp.getDataFromServer(UrlTag.volQuery);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("Status", "Get data...");
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    JSONArray jsonArray = new JSONArray(jsonObject.getString("items"));
//                    Log.e("Json : ", jsonArray.toString());

                    for (int i = 0; i < jsonArray.length(); i++) {
//                        if (i != 1) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            JSONObject volInfo = object.getJSONObject("volumeInfo");
                            // Log.e("Volume Info", volInfo.getString("description"));

                            Buku buku = new Buku(
                                    object.getString("id"),
                                    volInfo.getString("title"),
                                    volInfo.getString("publisher"),
                                    volInfo.getString("description"),
                                    0
                            );
                            bukuArrayList.add(buku);

                            OkHttpActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    bukuAdapter.notifyDataSetChanged();
                                }
                            });
//                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
