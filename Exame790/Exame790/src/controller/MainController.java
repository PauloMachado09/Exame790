package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btnContar;

    @FXML
    private TextField txFrase;

    public int contaPalavras(String frase) {
        String fraseE = this.txFrase.getText();
        int palavras = 1;

        for (int i = 0; i < fraseE.length() - 1; i++) {

            if (fraseE.charAt(i) == ' ' && Character.isLetter(frase.charAt(i+1)) && (i > 0)){
                palavras++;
            }

        }
        return palavras;
    }

    public boolean verificaPonto (){
        char valor = '.';
        String input = this.txFrase.getText();
        boolean result = false;
        for (int i = 0 ; i < input.length () ; i++)
        {
            if (input.charAt (i) == valor)
            {
                result = true;
                break;
            }
        }
        return result;
    }

    @FXML
    void contarPalavras(ActionEvent event) {

            try {
                if(!this.txFrase.getText().isEmpty()) {
                    if (!verificaPonto()) {
                        alerta(Alert.AlertType.ERROR, "Deve acabar com um ponto!", "ERRO");
                    } else {
                        String frase = this.txFrase.getText();

                        int resultado = contaPalavras(frase);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/contagemView.fxml"));
                        Parent root = loader.load();
                        ContagemController controller = loader.getController();
                        controller.getResposta(resultado);
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.setScene(scene);
                        stage.showAndWait();


                    }
                }else {
                    alerta(Alert.AlertType.ERROR, "Deve escrever algo!", "ERRO");
                }
            } catch (IOException e) {
                e.printStackTrace();

        }
    }

    public void alerta(Alert.AlertType tipo, String txt, String titulo) {
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(titulo);
        alerta.setContentText(txt);
        alerta.showAndWait();
    }

}