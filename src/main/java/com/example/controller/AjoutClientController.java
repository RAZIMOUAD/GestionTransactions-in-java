package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AjoutClientController {
    @FXML
    private TextField numClientField;
    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField adresseField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
            protected void ajouterClient(){
    long numClient= Long.parseLong(numClientField.getText());
    String nom=nomField.getText();
    String prenom=prenomField.getText();
    String adresse=adresseField.getText();
    String phone=phoneField.getText();
    String email=emailField.getText();
    System.out.println("Client ajouté :"+ nom + ""+ prenom+"("+email+")");
}

}
