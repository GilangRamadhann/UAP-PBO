package bokunouap;

import java.io.IOException;
import java.net.URL;
import static db.DBHelper.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class KeranjangController implements Initializable {

    PenjualanModel pjl = new PenjualanModel();

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private TextField fieldNama;

    @FXML
    private Label lblJumlah;

    @FXML
    private Label lblTotal;

    @FXML
    private TableColumn<Penjualan, Double> viewHarga;

    @FXML
    private TableColumn<Penjualan, Integer> viewJumlah;

    @FXML
    private TableColumn<Penjualan, String> viewNama;

    @FXML
    private TableView<Penjualan> viewProduk;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showProduk();
        showJumlah();
        showTotal();
    }

    @FXML
    void toHapus(ActionEvent event) throws IOException {
        Penjualan pjl1 = new Penjualan(fieldNama.getText());
        pjl.deletePenjualan(pjl1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Keranjang.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    public void showProduk(){
        ObservableList<Penjualan> list = pjl.getKeranjang();
        viewNama.setCellValueFactory(new PropertyValueFactory<Penjualan, String>("namaProduk"));
        viewHarga.setCellValueFactory(new PropertyValueFactory<Penjualan, Double>("harga"));
        viewJumlah.setCellValueFactory(new PropertyValueFactory<Penjualan, Integer>("stok"));

        viewProduk.setItems(list);
    }

    public void showJumlah(){
        int count = 0;
        String query = "SELECT jumlah FROM data_pembelian";
        Connection CONN = getConnection();
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                count += rs.getInt("jumlah");
            }
            lblJumlah.setText(Integer.toString(count));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void showTotal(){
        double total = 0;
        String query = "SELECT harga, jumlah FROM data_pembelian";
        Connection CONN = getConnection();
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                total += rs.getDouble("harga") * rs.getInt("jumlah");
            }
            lblTotal.setText(Double.toString(total));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
