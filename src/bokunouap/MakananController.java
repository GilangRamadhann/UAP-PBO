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

public class MakananController {

    MakananModel mkn = new MakananModel();

    @FXML
    private Button btnBarang;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;

    @FXML
    private TextField fieldDayaTahan;

    @FXML
    private TextField fieldDiskon;

    @FXML
    private TextField fieldHarga;

    @FXML
    private TextField fieldId;

    @FXML
    private TextField fieldJumlah;

    @FXML
    private TextField fieldNama;

    @FXML
    void toBarang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnBarang.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toHapus(ActionEvent event) throws IOException {
        Makanan mkn1 = new Makanan(Integer.parseInt(fieldId.getText()));
        mkn.deleteMakanan(mkn1);
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
    void toTambah(ActionEvent event) throws IOException {
        Makanan mkn1 = new Makanan(fieldNama.getText(), Double.parseDouble(fieldHarga.getText()),
                                    Double.parseDouble(fieldDiskon.getText()), Integer.parseInt(fieldJumlah.getText()),
                                    Integer.parseInt(fieldId.getText()), Integer.parseInt(fieldDayaTahan.getText()));
        mkn.addMakanan(mkn1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Produk.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
