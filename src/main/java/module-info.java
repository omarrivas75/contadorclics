module com.mycompany.contadorclics {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.contadorclics to javafx.fxml;
    exports com.mycompany.contadorclics;
}
