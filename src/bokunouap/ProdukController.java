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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProdukController implements Initializable {

    BarangModel brg = new BarangModel();
    MakananModel mkn = new MakananModel();

    @FXML
    private Button btnBarang;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnMakanan;

    @FXML
    private TableView<Barang> viewBarang;

    @FXML
    private TableColumn<Barang, Double> viewHargaBarang;

    @FXML
    private TableColumn<Makanan, Double> viewHargaMakanan;

    @FXML
    private TableColumn<Barang, Integer> viewJumlahBarang;

    @FXML
    private TableColumn<Makanan, Integer> viewJumlahMakanan;

    @FXML
    private TableView<Makanan> viewMakanan;

    @FXML
    private TableColumn<Barang, String> viewNamaBarang;

    @FXML
    private TableColumn<Makanan, String> viewNamaMakanan;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showBarang();
        showMakanan();
    }

    @FXML
    void toBarang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnBarang.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toMakanan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnMakanan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void showBarang(){
        ObservableList<Barang> list = brg.getListBarang();
        viewNamaBarang.setCellValueFactory(new PropertyValueFactory<Barang, String>("nama_produk"));
        viewHargaBarang.setCellValueFactory(new PropertyValueFactory<Barang, Double>("harga"));
        viewJumlahBarang.setCellValueFactory(new PropertyValueFactory<Barang, Integer>("jumlah"));

        viewBarang.setItems(list);
    }

    public void showMakanan(){
        ObservableList<Makanan> list = mkn.getListMakanan();
        viewNamaMakanan.setCellValueFactory(new PropertyValueFactory<Makanan, String>("nama_produk"));
        viewHargaMakanan.setCellValueFactory(new PropertyValueFactory<Makanan, Double>("harga"));
        viewJumlahMakanan.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("jumlah"));

        viewMakanan.setItems(list);
    }

}
