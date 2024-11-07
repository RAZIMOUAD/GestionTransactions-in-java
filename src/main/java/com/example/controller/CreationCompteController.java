package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreationCompteController {

    @FXML
    private TextField numCompteField;

    @FXML
    private TextField deviseField;

    @FXML
    private DatePicker dateCreationField;

    @FXML
    protected void creerCompte() {
        try{
        int numCompte = Integer.parseInt(numCompteField.getText());
        String devise = deviseField.getText();
        LocalDate dateCreation = dateCreationField.getValue();
        LocalDateTime dateUpdate = LocalDateTime.now();

        // Affichage pour vérifier les données
        System.out.println("Compte créé : " + numCompte + ", Devise : " + devise + ", Date de création : "
                + dateCreation + ", Date de mise à jour : " + dateUpdate);
    } catch(NumberFormatException e){
            System.out.println("Erreur : Le numéro de compte doit être un nombre valide.");
        }catch (NullPointerException e){
            System.out.println("Erreur : Tous les champs doivent être remplis.");
}
    }
}