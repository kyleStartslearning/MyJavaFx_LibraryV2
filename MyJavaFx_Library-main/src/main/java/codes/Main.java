package codes;

import codes.Databases.Admin;
import codes.Databases.LibraryDataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
    

    @Override
    public void start(Stage primaryStage) {

        System.out.print("Practice1");
        try {

            Admin.initializeAdminDatabase();
            LibraryDataBase libraryDB = new LibraryDataBase();
            libraryDB.initializeDatabase();
            libraryDB.initializeBookInventory();

            Parent root = FXMLLoader.load(getClass().getResource("/LogIn.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/LogIn.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            primaryStage.setTitle("Log in Page");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }




    public static void main(String[] args) {
        launch(args);
    }
}