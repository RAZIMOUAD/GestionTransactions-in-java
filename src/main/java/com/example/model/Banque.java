package com.example.model;
import java.util.ArrayList;
import java.util.List;
public class Banque {
    private String id;
    private String pays;
    private List<Compte> comptes;

//constructeur
public Banque(String id, String pays) {
    this.id = id;
    this.pays = pays;
    this.comptes = new ArrayList<>();
}
//getters
public String getId() {
    return id;
}
    public String getPays() {
        return pays;
    }
    public List<Compte> getComptes() {
        return comptes;
    }
    //setters
    public void setId(String id) {
        this.id = id;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }

    // Ajouter un compte à la banque
    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }






}
