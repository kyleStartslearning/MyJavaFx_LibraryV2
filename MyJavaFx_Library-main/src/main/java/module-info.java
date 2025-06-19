module codes {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    

    opens codes to javafx.fxml;
    opens codes.Controllers to javafx.fxml;  // Add this line
    exports codes;
    exports codes.Controllers;  // Add this line
}