package io.github.mochadwi.practicerecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.mochadwi.practicerecyclerview.R;
import io.github.mochadwi.practicerecyclerview.model.Buku;

/**
 * Created by mochadwi on 11/18/16.
 */

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuViewHolder> {
    ArrayList<Buku> bukuArrayList;
    Context context;

    public BukuAdapter(ArrayList<Buku> bukuArrayList, Context context) {
        this.bukuArrayList = bukuArrayList;
        this.context = context;
    }

    /*
        Layout mana yang mau digunain
     */
    @Override
    public BukuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_row_buku, parent, false);
        return new BukuViewHolder(view);
    }


    /*
    Ngisi apa yang udah di inisialisasi di atas
     */
    @Override
    public void onBindViewHolder(BukuViewHolder holder, int position) {
        Buku buku = bukuArrayList.get(position);
        holder.txtJudul.setText(buku.getJudulBuku());
        holder.txtPenerbit.setText(buku.getPenerbit());
        holder.txtHarga.setText(String.valueOf(buku.getHarga()));
    }

    @Override
    public int getItemCount() {
        return bukuArrayList.size();
    }

    public class BukuViewHolder extends RecyclerView.ViewHolder {
        TextView txtJudul, txtPenerbit, txtHarga;

        public BukuViewHolder(View itemView) {
            super(itemView);
            txtJudul = (TextView) itemView.findViewById(R.id.txt_judul);
            txtPenerbit = (TextView) itemView.findViewById(R.id.txt_penerbit);
            txtHarga = (TextView) itemView.findViewById(R.id.txt_harga);
        }
    }
}
