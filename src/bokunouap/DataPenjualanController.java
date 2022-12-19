package bokunouap;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DataPenjualanController implements Initializable {

    PenjualanModel pjl = new PenjualanModel();
    ProdukModel prd = new ProdukModel();

    @FXML
    private Button btnCekKeranjang;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;

    @FXML
    private TextField fieldHarga;

    @FXML
    private TextField fieldJumlah;

    @FXML
    private TextField fieldNama;

    @FXML
    private TableColumn<Produk, Double> viewHarga;

    @FXML
    private TableColumn<Produk, Integer> viewJumlah;

    @FXML
    private TableColumn<Produk, String> viewNamaProduk;

    @FXML
    private TableView<Produk> viewProduk;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showProduk();
    }

    @FXML
    void toKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Akun.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toKeranjang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Keranjang.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnCekKeranjang.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toTambah(ActionEvent event) throws IOException {
        Penjualan pjl1 = new Penjualan(Integer.parseInt(fieldJumlah.getText()), fieldNama.getText(), Double.parseDouble(fieldHarga.getText()));
        pjl.addPenjualan(pjl1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void showProduk(){
        ObservableList<Produk> list = prd.getListProduk();
        viewNamaProduk.setCellValueFactory(new PropertyValueFactory<Produk, String>("nama_produk"));
        viewHarga.setCellValueFactory(new PropertyValueFactory<Produk, Double>("harga"));
        viewJumlah.setCellValueFactory(new PropertyValueFactory<Produk, Integer>("jumlah"));

        viewProduk.setItems(list);
    }

}
