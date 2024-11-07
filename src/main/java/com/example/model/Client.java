package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private long numClient;
    private String nom;
    private String prenom;
    private String adresse;
    private int phone ;
    private String email;
    List <Compte> mesComptes;
//Constructeurs
    public Client(long numClient, String nom, String prenom, String adresse, int phone, String email){
        this.numClient = numClient;
        this.nom = nom;
        this.prenom= prenom;
        this.adresse=adresse;
        this.phone= phone;
        this.email= email;
        this.mesComptes= new ArrayList<>();
    }
//Getters
public long getNumClient(){
    return numClient;
}
public String getNom(){
    return nom;
}
public String getPrenom(){
    return prenom;
}
public String getAdresse(){
    return adresse;
}
public int getPhone(){
    return phone;
}
public String getEmail(){
    return email;
}
public List<Compte> getComptes(){
    return mesComptes;
}
//Setters
public void setNumClient(long numClient){
    this.numClient=numClient;
}
public void setNom(String nom){
    this.nom=nom;
}
public void setPrenom(String prenom){
    this.prenom=prenom;
}
public void setAdresse(String adresse){
    this.adresse=adresse;
}
public void setPhone(int phone){
    this.phone=phone;
}
public void setEmail(String email){
    this.email=email;
}
 // Méthode pour ajouter un compte au client
 public void ajouterComptes(Compte compte){
    mesComptes.add(compte);
    compte.setProprietaire(this);
 }
// Méthode pour supprimer un compte
public void supprimerComptes(Compte compte){
    mesComptes.remove(compte);
    compte.setProprietaire(null);
}



























}
