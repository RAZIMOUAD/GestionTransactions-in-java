package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RechercheClientController {

    @FXML
    private TextField numClientField;

    @FXML
    private Label resultLabel;

    @FXML
    protected void rechercherClient() {
        try {

            long numClient = Long.parseLong(numClientField.getText());


            if (numClient == 12345) {
                resultLabel.setText("Résultat : Client trouvé - Nom: John Doe, Email: john.doe@example.com");
            } else {
                resultLabel.setText("Résultat : Client non trouvé");
            }

        } catch (NumberFormatException e) {
            resultLabel.setText("Erreur : Veuillez entrer un numéro de client valide");
        }
    }
}
