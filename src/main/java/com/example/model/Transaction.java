package com.example.model;

import java.util.Date;
import java.util.List;

public class Transaction {
    private final String reference;
    private final Date timestamp;
    private final TypeTransaction type;
    private final double montant;
    private final List<Compte> compteSources;
    private final List<Compte> compteDestinations;

    public enum TypeTransaction {
        VIRINT,
        VIREST,
        VIRCHAC,
        VIRMULTA
    }

    // Constructeur
    public Transaction(String reference, Date timestamp, TypeTransaction type, double montant, List<Compte> comptesSources, List<Compte> comptesDestinations) {
        this.reference = reference;
        this.timestamp = new Date(timestamp.getTime());
        this.type = type;
        this.montant = montant;
        this.compteSources = List.copyOf(comptesSources);
        this.compteDestinations = List.copyOf(comptesDestinations);
    }

    // Getters
    public String getReference() {
        return reference;
    }

    public Date getTimestamp() {
        return new Date(timestamp.getTime());
    }

    public TypeTransaction getType() {
        return type;
    }

    public List<Compte> getComptesSources() {
        return compteSources;
    }

    public List<Compte> getComptesDestinations() {
        return compteDestinations;
    }

    public double getMontant() {
        return montant;
    }
}
