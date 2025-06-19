package codes.Controllers;

import java.io.IOException;

import codes.UtilityClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class StudentController {

    @FXML
    private AnchorPane contentArea;

    @FXML
    private Label userLabel;

    @FXML
    void BTNborrowReturn(ActionEvent event) {

    }

    @FXML
    void BTNsearch(ActionEvent event) {

    }

    @FXML
    void BTNlogOut(ActionEvent event) throws IOException {
         UtilityClass.switchScene(event, "/LogIn.fxml", "/LogIn.css");



    }

}
