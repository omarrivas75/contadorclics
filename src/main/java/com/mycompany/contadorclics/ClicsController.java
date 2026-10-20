package com.mycompany.contadorclics;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class ClicsController implements Initializable {

    @FXML
    private TextField txtContador;

    @FXML
    private Button btnContar;

    @FXML
    private ProgressBar barra;

    @FXML
    private Button btnEsperar;

    private int contador = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtContador.setText("0");
        barra.setProgress(0);

    }

    @FXML
    private void contar() {

        contador++;
        txtContador.setText(String.valueOf(contador));

    }

    @FXML
    private void esperar() {

        barra.setProgress(0);

        btnContar.setDisable(true);
        btnEsperar.setDisable(true);

        Task<Void> tarea = new Task<>() {

            @Override
            protected Void call() throws Exception {

                for (int i = 0; i <= 100; i++) {

                    updateProgress(i, 100);

                    Thread.sleep(100);
                }

                return null;
            }
        };

        barra.progressProperty().bind(tarea.progressProperty());

        tarea.setOnSucceeded(e -> {

            btnContar.setDisable(false);
            btnEsperar.setDisable(false);

        });

        Thread hilo = new Thread(tarea);
        hilo.setDaemon(true);
        hilo.start();
    }
}