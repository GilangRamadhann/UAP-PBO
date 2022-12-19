package bokunouap;

import db.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProdukModel {
    private final Connection CONN;

    public ProdukModel() {
        this.CONN = DBHelper.getConnection();
    }

    public ObservableList<Produk> getListProduk(){
        ObservableList<Produk> listProduk = FXCollections.observableArrayList();
        String query = "SELECT nama_produk, harga, jumlah FROM makanan UNION " +
                        "SELECT nama_produk, harga, jumlah FROM barang;";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Produk prd = new Produk(rs.getString("nama_produk"), rs.getDouble("harga"),
                                        rs.getInt("jumlah"));
                listProduk.add(prd);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listProduk;
    }
}
