package bokunouap;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BarangController {

    BarangModel brg = new BarangModel();

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnMakanan;

    @FXML
    private Button btnTambah;

    @FXML
    private TextField fieldBarcode;

    @FXML
    private TextField fieldDiskon;

    @FXML
    private TextField fieldExpired;

    @FXML
    private TextField fieldHarga;

    @FXML
    private TextField fieldJumlah;

    @FXML
    private TextField fieldKategori;

    @FXML
    private TextField fieldNama;

    @FXML
    void toHapus(ActionEvent event) throws IOException {
        Barang brg1 = new Barang(fieldBarcode.getText());
        brg.deleteBarang(brg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Produk.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Produk.fxml"));
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

    @FXML
    void toTambah(ActionEvent event) throws IOException {
        Barang brg1 = new Barang(fieldNama.getText(), Double.parseDouble(fieldHarga.getText()),
                                Double.parseDouble(fieldDiskon.getText()), Integer.parseInt(fieldJumlah.getText()),
                                fieldBarcode.getText(), fieldExpired.getText(), fieldKategori.getText());
        brg.addBarang(brg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Produk.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
