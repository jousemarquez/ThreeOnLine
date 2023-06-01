package com.example.tresraya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

public class ThreeOnLineController {


    @FXML
    private ToggleButton bt00;

    @FXML
    private ToggleButton bt01;

    @FXML
    private ToggleButton bt02;

    @FXML
    private ToggleButton bt10;

    @FXML
    private ToggleButton bt11;

    @FXML
    private ToggleButton bt12;

    @FXML
    private ToggleButton bt20;

    @FXML
    private ToggleButton bt21;

    @FXML
    private ToggleButton bt22;

    String currentPlayer;

    public void initialize() {
        currentPlayer = "X";
        System.out.println(currentPlayer);
    }

    private void switchPlayer() {
        if(currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }

    @FXML
    public void btClick(ActionEvent actionEvent) {
        // Recupero el botón que se ha presionado
        ToggleButton presionado = (ToggleButton) actionEvent.getSource();
        System.out.println(presionado);

        // Le cambio el color y lo deshabilito para evitar futuros clicks
        presionado.setStyle("-fx-font: 24 arial; -fx-font-weight: bold; -fx-background-color: yellow");
        presionado.setDisable(true);

        // Pongo el botón del texto del jugador que acaba de jugar
        presionado.setText(currentPlayer);

        // Compruebo si el jugador que acaba de jugar ha ganado
        if(hasWin()) {
            System.out.println("El jugador que gana es: " + currentPlayer);
            disableAllButtons();
            return;
        }

        // Compruebo si fin
        if(isTheEnd()) {
            System.out.println("El juego ha acabo en empate.");
            return;
        }

        // Se lanza el método para cambiar al jugador
        switchPlayer();
    }

    private void disableAllButtons() {
        bt00.setDisable(true);
        bt01.setDisable(true);
        bt02.setDisable(true);
        bt10.setDisable(true);
        bt11.setDisable(true);
        bt12.setDisable(true);
        bt20.setDisable(true);
        bt22.setDisable(true);
    }

    private boolean threeOnline(ToggleButton b0, ToggleButton b1, ToggleButton b2) {
        if(b0.getText().equals(currentPlayer)
                && b1.getText().equals(currentPlayer) &&
                b2.getText().equals(currentPlayer)){
            return true;
        }
        return false;
    }

    // Comprueba las condiciones de victoria en cada uno de los casos.
    private boolean hasWin() {
        if(threeOnline(bt00, bt01, bt02)) { // Caso 1
            return true;
        } else if(threeOnline(bt10, bt11, bt12)) { // Caso 2
            return true;
        } else if(threeOnline(bt20, bt21, bt22)) { // Caso 3
            return true;
        } else if(threeOnline(bt00, bt10, bt20)) { // Caso 4
            return true;
        } else if(threeOnline(bt01, bt11, bt21)) { // Caso 5
            return true;
        } else if(threeOnline( bt02, bt12, bt22)) { // Caso 6
            return true;
        } else if(threeOnline(bt00, bt11, bt22)) { // Caso 7
            return true;
        } else if(threeOnline(bt02, bt11, bt20)) { // Caso 8
            return true;
        }
        return false;
    }

    private boolean isTheEnd() {

        boolean firstRowCompleted = bt00.isDisabled() && bt01.isDisabled() && bt02.isDisabled();
        boolean secondRowCompleted = bt10.isDisabled() && bt11.isDisabled() && bt12.isDisabled();
        boolean thirdRowCompleted = bt20.isDisabled() && bt21.isDisabled() && bt22.isDisabled();
        return firstRowCompleted && secondRowCompleted && thirdRowCompleted;

    }
}