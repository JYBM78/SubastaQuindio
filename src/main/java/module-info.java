module co.edu.uniquindio.programacion3.subastaquindio {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens co.edu.uniquindio.programacion3.subastaquindio to javafx.fxml;
    exports co.edu.uniquindio.programacion3.subastaquindio;
    exports co.edu.uniquindio.programacion3.subastaquindio.viewController;
    opens co.edu.uniquindio.programacion3.subastaquindio.viewController to javafx.fxml;

}