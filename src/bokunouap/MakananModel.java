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

public class MakananModel {
    private final Connection CONN;

    public MakananModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addMakanan(Makanan mkn){
        String insert = "INSERT INTO makanan VALUES (" +
                        mkn.getId() + ", " + mkn.getDaya_tahan() + ", '" +
                        mkn.getNama_produk() + "', " + mkn.getHarga() + ", " +
                        mkn.getJumlah() + ", " + mkn.getDiskon() + ");";
        
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Data berhasil dimasukkan");
            }
            else{
                System.out.println("Data gagal dimasukkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dimasukkan");
        }
    }
    
    public void deleteMakanan(Makanan mkn){
        String delete = "DELETE FROM makanan WHERE id = " +
                        mkn.getId() + ";";
        
        try {
            if(CONN.createStatement().executeUpdate(delete) > 0){
                System.out.println("Data berhasil dihapus");
            }
            else{
                System.out.println("Data gagal dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dihapus");
        }
    }

    public ObservableList<Makanan> getListMakanan(){
        ObservableList<Makanan> listMakanan = FXCollections.observableArrayList();
        String query = "SELECT * FROM makanan;";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Makanan mkn = new Makanan(rs.getString("nama_produk"), rs.getDouble("harga"),
                                            rs.getDouble("diskon"), rs.getInt("jumlah"),
                                            rs.getInt("id"), rs.getInt("daya_tahan"));
                listMakanan.add(mkn);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listMakanan;
    }
}
