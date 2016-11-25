package io.github.mochadwi.practicerecyclerview.model;

/**
 * Created by mochadwi on 11/18/16.
 */

public class Buku {
    private String kdBuku, judulBuku, penerbit;
    private int harga;

    public Buku(String kdBuku, String judulBuku, String penerbit, int harga) {
        this.kdBuku = kdBuku;
        this.judulBuku = judulBuku;
        this.penerbit = penerbit;
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
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
