package io.github.mochadwi.practicerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.github.mochadwi.practicerecyclerview.adapter.BukuAdapter;
import io.github.mochadwi.practicerecyclerview.model.Buku;

public class ArrayListActivity extends AppCompatActivity {
    ArrayList<Buku> bukuArrayList = new ArrayList<Buku>();
    BukuAdapter bukuAdapter;
    RecyclerView rvBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);

        rvBuku = (RecyclerView) findViewById(R.id.rv_arraylist);
        bukuAdapter = new BukuAdapter(bukuArrayList, this);
        rvBuku.setAdapter(bukuAdapter);
        rvBuku.setHasFixedSize(true);
        rvBuku.setLayoutManager(new LinearLayoutManager(this));

        prepareData();
    }

    private void prepareData() {
        Buku buku = new Buku("K001", "Sherlock Holmes", "Ganesha", 100000);
        bukuArrayList.add(buku);

        buku = new Buku("K002", "Sherlock Holmes", "Ganesha", 200000);
        bukuArrayList.add(buku);

        bukuAdapter.notifyDataSetChanged();
    }
}
