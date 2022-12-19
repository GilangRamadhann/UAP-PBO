package bokunouap;

import java.util.ArrayList;

public class Penjualan implements ProductCounter {
    private ArrayList<Produk> listProduk;
    private int jumlahProduk;
    private int stok;
    private double harga;
    private String namaProduk;

    public Penjualan(int stok, String namaProduk, double harga) {
        this.stok = stok;
        this.namaProduk = namaProduk;
        this.harga = harga;
    }

    public Penjualan(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public Penjualan() {
    }

    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }

    public int getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(int jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getProduk(){
        return null;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public int hitungJumlahProduk(){
        return 0;
    }

    @Override
    public double hitungHargaProduk(){
        return 0;
    }

}
