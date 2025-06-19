package codes.Controllers;

import java.io.IOException;
import codes.UtilityClass;
import codes.Databases.Admin;
import codes.Databases.LibraryDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField UserField;

    @FXML
    private Button closeButton;

    @FXML
    private Button createAccButton;

    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }

    @FXML
    void BTNCreate(ActionEvent event) throws IOException {
        UtilityClass.switchScene(event, "/CreateScene.fxml", "/CreateAcc.css");
    }

    @FXML
    void BTNlogin(ActionEvent event) throws IOException {
        String email = UserField.getText().trim();
        String password = PasswordField.getText();

        if(email.isEmpty() || password.isEmpty()) {
            UtilityClass.ShowError("Error", "Please fill in all fields");
        } else {
            if (Admin.verifyAdminCredentials(email, password)) {
                UtilityClass.currentUserEmail = email;
                UtilityClass.switchScene(event, "/AdminMain.fxml", "/AdminMain.css");
            } else if (LibraryDataBase.verifyMemberCredentials(email, password)) {
                UtilityClass.currentUserEmail = email;
                UtilityClass.switchScene(event, "/StudentMain.fxml", "/StudentMain.css");
            } else {
                UtilityClass.ShowError("LOGIN FAILED", "INVALID USERNAME OR PASSWORD PLEASE TRY AGAIN");
                PasswordField.clear();
            }
        }
    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }
}