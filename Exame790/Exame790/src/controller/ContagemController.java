package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContagemController {

    @FXML
    private Button btnFechar;

    @FXML
    private TextField txPalavras;

    @FXML
    public void getResposta(int valor){
            this.txPalavras.setText( valor + " palavras.");
    }

    @FXML
    void fechar(ActionEvent event) {
        Stage stage = (Stage) this.btnFechar.getScene().getWindow();
        stage.close();
    }

}
