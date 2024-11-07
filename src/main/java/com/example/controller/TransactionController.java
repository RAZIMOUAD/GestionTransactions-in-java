package com.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.example.model.Compte;
import com.example.model.Banque;
import com.example.model.Transaction;
import com.example.model.Transaction.TypeTransaction;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class TransactionController {

    @FXML
    private TextField refTransactionField;

    @FXML
    private TextField compteSourceField;

    @FXML
    private TextField compteDestinationField;

    @FXML
    private TextField montantField;

    @FXML
    private Label resultLabel;

    // Simuler une base de données de comptes et de banques
    private Map<Integer, Compte> comptes = new HashMap<>();

    public TransactionController() {
        // Créer des banques
        Banque banqueA = new Banque("Banque A", "Maroc");
        Banque banqueB = new Banque("Banque B", "Maroc");
        Banque banqueC = new Banque("Banque C", "France");

        // Créer des comptes et les associer aux banques
        comptes.put(1001, new Compte(1001, banqueA));
        comptes.put(1002, new Compte(1002, banqueA));
        comptes.put(2001, new Compte(2001, banqueB));
        comptes.put(3001, new Compte(3001, banqueC));
    }

    @FXML
    protected void effectuerTransaction() {
        try {
            // Récupérer les informations saisies par l'utilisateur
            String refTransaction = refTransactionField.getText();
            int numCompteSource = Integer.parseInt(compteSourceField.getText());
            int numCompteDestination = Integer.parseInt(compteDestinationField.getText());
            double montant = Double.parseDouble(montantField.getText());

            // Vérifier que les comptes existent
            Compte compteSource = comptes.get(numCompteSource);
            Compte compteDestination = comptes.get(numCompteDestination);

            if (compteSource == null || compteDestination == null) {
                resultLabel.setText("Erreur : L'un des comptes n'existe pas.");
                return;
            }

            // Déterminer le type de transaction
            TypeTransaction typeTransaction = determineTypeTransaction(compteSource, compteDestination);

            // Effectuer la transaction si les comptes sont valides et le montant est supérieur à zéro
            if (numCompteSource != numCompteDestination && montant > 0) {
                // Créer la transaction avec les comptes source et destination
                Transaction transaction = new Transaction(refTransaction, new java.util.Date(), typeTransaction, montant, Collections.singletonList(compteSource), Collections.singletonList(compteDestination));

                resultLabel.setText("Transaction Réussie : Réf: " + refTransaction + ", Montant : "
                        + montant + "€, Type : " + typeTransaction);

                // Convertir la transaction en JSON
                convertTransactionToJson(transaction);
            } else {
                resultLabel.setText("Erreur : Vérifiez les informations saisies.");
            }

        } catch (NumberFormatException e) {
            resultLabel.setText("Erreur : Assurez-vous que les montants et comptes sont corrects.");
        }
    }

    // Méthode pour déterminer le type de transaction
    private TypeTransaction determineTypeTransaction(Compte compteSource, Compte compteDestination) {
        Banque banqueSource = compteSource.getBanque();
        Banque banqueDestination = compteDestination.getBanque();

        if (banqueSource.getId().equals(banqueDestination.getId())) {
            return TypeTransaction.VIRINT; // Transactions entre 2 clients de la même banque
        } else if (banqueSource.getPays().equals(banqueDestination.getPays())) {
            return TypeTransaction.VIRMULTA; // Transactions entre 2 banques différentes du même pays
        } else {
            return TypeTransaction.VIRCHAC; // Transactions entre 2 banques différentes et 2 pays différents
        }
    }

    // Méthode pour convertir une transaction en JSON
    private void convertTransactionToJson(Transaction transaction) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("transaction.json"), transaction);
        } catch (IOException e) {
            e.printStackTrace();
            resultLabel.setText("Erreur : Impossible de convertir la transaction en JSON.");
        }
    }
    // Méthode pour enregistrer la transaction dans la base de données
    private void saveTransactionToDatabase(Transaction transaction) {
        String sql = "INSERT INTO Transaction (reference, timestamp, type, montant, numCompteSource, numCompteDestination) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, transaction.getReference());
            pstmt.setTimestamp(2, new java.sql.Timestamp(transaction.getTimestamp().getTime()));
            pstmt.setString(3, transaction.getType().name());
            pstmt.setDouble(4, transaction.getMontant());
            pstmt.setInt(5, transaction.getComptesSources().get(0).getNumCompte());
            pstmt.setInt(6, transaction.getComptesDestinations().get(0).getNumCompte());

            pstmt.executeUpdate();
            System.out.println("Transaction enregistrée avec succès dans la base de données.");

        } catch (SQLException e) {
            e.printStackTrace();
            resultLabel.setText("Erreur : Impossible d'enregistrer la transaction dans la base de données.");
        }
    }
}
