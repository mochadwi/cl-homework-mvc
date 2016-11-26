package io.github.mochadwi.practicerecyclerview.model;

/**
 * Created by mochadwi on 11/18/16.
 */

public class Buku {
    private String kdBuku, judulBuku, penerbit, deskripsi;
    private int harga;

    public Buku(String kdBuku, String judulBuku, String penerbit, String deskripsi, int harga) {
        this.kdBuku = kdBuku;
        this.judulBuku = judulBuku;
        this.penerbit = penerbit;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public String getKdBuku() {
        return kdBuku;
    }

    public void setKdBuku(String kdBuku) {
        this.kdBuku = kdBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenerbit() {
        return deskripsi;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
