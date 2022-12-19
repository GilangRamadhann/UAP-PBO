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

public class KategoriController implements Initializable {

    KategoriModel ktg = new KategoriModel();

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;

    @FXML
    private TextField fieldNamaKategori;

    @FXML
    private TableView<Kategori> viewKategori;

    @FXML
    private TableColumn<Kategori, String> viewNamaKategori;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showKategori();
    }

    @FXML
    void toHapus(ActionEvent event) throws IOException {
        Kategori ktg1 = new Kategori(fieldNamaKategori.getText());
        ktg.deleteKategori(ktg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnHapus.getScene().getWindow();
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
    void toTambah(ActionEvent event) throws IOException {
        Kategori ktg1 = new Kategori(fieldNamaKategori.getText());
        ktg.addKategori(ktg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void showKategori(){
        ObservableList<Kategori> list = ktg.getListKategori();
        viewNamaKategori.setCellValueFactory(new PropertyValueFactory<Kategori, String>("nama_kategori"));

        viewKategori.setItems(list);
    }
}
