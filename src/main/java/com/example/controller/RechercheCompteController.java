package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RechercheCompteController {

    @FXML
    private TextField numCompteField;

    @FXML
    private Label resultLabel;

    @FXML
    protected void rechercherCompte() {
        try {

            int numCompte = Integer.parseInt(numCompteField.getText());

            if (numCompte == 67890) {
                resultLabel.setText("Résultat : Compte trouvé - Numéro: 67890, Devise: EUR, Date de Création: 2023-01-15");
            } else {
                resultLabel.setText("Résultat : Compte non trouvé");
            }

        } catch (NumberFormatException e) {
            resultLabel.setText("Erreur : Veuillez entrer un numéro de compte valide");
        }
    }
}
