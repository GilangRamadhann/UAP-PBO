package bokunouap;

import db.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PenjualanModel {
    private final Connection CONN;

    public PenjualanModel() {
        this.CONN = DBHelper.getConnection();
    }

    public void addPenjualan(Penjualan pjl){
        String insert = "INSERT INTO data_pembelian VALUES ('" + pjl.getNamaProduk() + "', " +
                        pjl.getHarga() + ", " + pjl.getStok() + ");";
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Data berhasil dimasukkan");
            }
            else{
                System.out.println("Data gagal dimasukkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dimasukkan");
        }
    }

    public void deletePenjualan(Penjualan pjl){
        String delete = "DELETE FROM data_pembelian WHERE nama = '" + pjl.getNamaProduk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(delete) > 0){
                System.out.println("Data berhasil dihapus");
            }
            else{
                System.out.println("Data gagal dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dihapus");
        }
    }

    public ObservableList<Penjualan> getKeranjang(){
        ObservableList<Penjualan> listKeranjang = FXCollections.observableArrayList();
        String query = "SELECT * FROM data_pembelian";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Penjualan pjl = new Penjualan(rs.getInt("jumlah"), rs.getString("nama"),
                                                rs.getDouble("harga"));
                listKeranjang.add(pjl);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listKeranjang;
    }
}
