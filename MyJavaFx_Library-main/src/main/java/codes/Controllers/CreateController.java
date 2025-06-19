package codes.Controllers;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Optional;

import codes.UtilityClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import codes.Databases.Admin;
import codes.Databases.LibraryDataBase;
import codes.Databases.LibraryMember;

public class CreateController {


    @FXML
    private TextField AgeField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField NumberField;

    @FXML
    private TextField PasswordField;

    @FXML
    void BTNSignIn(ActionEvent event) throws IOException {
        UtilityClass.switchScene(event, "/LogIn.fxml", "/LogIn.css");
    }

    @FXML
    void BTNsignUp(ActionEvent event) throws IOException {
        String Name = NameField.getText().trim();
        String Age = AgeField.getText().trim();
        String Email = EmailField.getText().trim();
        String Number = NumberField.getText().trim();
        String Password = PasswordField.getText().trim();

        if (Name.isEmpty() || Age.isEmpty() || Email.isEmpty() || Number.isEmpty() || Password.isEmpty()) {
            UtilityClass.ShowError("Fill up", "Please fill in all fields");
            return;
        }

        if (Name.length() < 2) {
            UtilityClass.ShowWarning("Invalid Name", "Please enter a valid name");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(Age);
            if (age <= 0 || age > 100) {
                UtilityClass.ShowWarning("Invalid Age", "Please enter a valid age between 1 and 100");
                return;
            }
        } catch (NumberFormatException e) {
            UtilityClass.ShowError("Invalid Age", "Please enter a valid number for age");
            return;
        }

        if (Password.length() < 4) {
            UtilityClass.ShowWarning("Weak Password", "Password must be at least 4 characters long");
            return;
        }

        if (!Number.matches("\\d{11}")) {
            UtilityClass.ShowWarning("Invalid Phone", "Please enter a valid 11-digit phone number");
            return;
        }

        if (!Email.contains("@") || !Email.contains(".")) {
            UtilityClass.ShowWarning("Invalid Email", "Please enter a valid email address");
            return;
        }

        if (LibraryDataBase.getMembers().containsKey(Email)) {
            UtilityClass.ShowWarning("Duplicate Email", "An account with this email already exists");
            return;
        }

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirm Registration");
        confirmationAlert.setHeaderText("Are you sure you want to create this account?");
        confirmationAlert.setContentText("Name: " + Name + "\nEmail: " + Email + "\nAge: " + age + "\nPhone Number: " + Number);
        
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Alert accountTypeAlert = new Alert(Alert.AlertType.CONFIRMATION);
            accountTypeAlert.setTitle("Select Account Type");
            accountTypeAlert.setHeaderText("Please select the type of account you want to create:");
            ButtonType studentButton = new ButtonType("Student");
            ButtonType adminButton = new ButtonType("Admin");
            accountTypeAlert.getButtonTypes().setAll(studentButton, adminButton);
        
            Optional<ButtonType> accountTypeResult = accountTypeAlert.showAndWait();
            if (accountTypeResult.get() == studentButton) {
                LibraryDataBase.getMembers().put(Email, new LibraryMember(Name, Password, Email, age, Number));
                UtilityClass.currentUserEmail = Email;
                UtilityClass.switchScene(event, "/StudentMain.fxml", "/StudentMain.css");
            } else if (accountTypeResult.get() == adminButton) {
                Alert adminPasscodeAlert = new Alert(Alert.AlertType.CONFIRMATION);
                adminPasscodeAlert.setTitle("Admin Verification");
                adminPasscodeAlert.setHeaderText("Enter Admin Passcode:");
                TextField passcodeField = new TextField();
                adminPasscodeAlert.getDialogPane().setContent(passcodeField);

                Optional<ButtonType> passcodeResult = adminPasscodeAlert.showAndWait();
                if (passcodeResult.isPresent() && passcodeResult.get() == ButtonType.OK) {
                    if (Admin.VerifyPasscode(passcodeField.getText())) {
                        Admin.addAdmin(Name, Password, Email, age, Number);
                        UtilityClass.currentUserEmail = Email;
                        UtilityClass.switchScene(event, "/AdminMain.fxml", "/AdminMain.css");
                    } else {
                        UtilityClass.ShowError("Invalid Passcode", "The admin passcode is incorrect");
                    }
                }
            }
        }
    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }
}