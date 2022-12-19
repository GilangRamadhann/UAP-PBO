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

public class KategoriModel {
    private final Connection CONN;

    public KategoriModel() {
        this.CONN = DBHelper.getConnection();
    }

    public void addKategori(Kategori ktg){
        String insert = "INSERT INTO kategori VALUES ('" + ktg.getNama_kategori() + "');";
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Data berhasil dimasukkan");
            }
            else{
                System.out.println("Data gagal dimasukkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dimasukkan");
        }
    }

    public void deleteKategori(Kategori ktg){
        String delete = "DELETE FROM kategori WHERE nama_kategori = '" + ktg.getNama_kategori() + "';";
        try {
            if(CONN.createStatement().executeUpdate(delete) > 0){
                System.out.println("Data berhasil dihapus");
            }
            else{
                System.out.println("Data gagal dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dihapus");
        }
    }

    public ObservableList<Kategori> getListKategori(){
        ObservableList<Kategori> listKategori = FXCollections.observableArrayList();
        String query = "SELECT * FROM kategori;";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Kategori ktg = new Kategori(rs.getString("nama_kategori"));
                listKategori.add(ktg);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listKategori;
    }
}
