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

public class AkunController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnGuest;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField fieldPassword;

    @FXML
    private TextField fieldUsername;

    @FXML
    void toExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void toGuest(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeGuest.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toLogin(ActionEvent event) throws IOException {
        if ((fieldUsername.getText().equals("Zipas") && fieldPassword.getText().equals("2117051070")) || (fieldUsername.getText().equals("Gilram") && fieldPassword.getText().equals("2117051082"))){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
            System.out.println("Berhasil Login");
        }
        else {
            System.out.println("Gagal Login");
        }
    }

}
