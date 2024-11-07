package com.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compte {
  private int numCompte ;
  private Date dateCreation ;
  private Date dateUpdate ;
  private String devise;
  // liaisons avec les autres classes
  private Client proprietaire;
  private List<Transaction> transactions;
    private Banque banque;
  //constructeur
  public Compte(int numCompte, Date dateCreation,  Date dateUpdate, String devise ){
   this.numCompte=numCompte ; 
   this.dateCreation=dateCreation;
   this.dateUpdate=dateUpdate;
   this.devise=devise;
   this.transactions=new ArrayList<>();
  }

    public Compte(int numCompte, Banque banque) {
        this.numCompte = numCompte;
        this.banque = banque;
        banque.ajouterCompte(this);
    }

    //getters
public int getNumCompte() {
    return numCompte;
}
public Date getDateCreation() {
    return dateCreation;
}
public Date getDateUpdate() {
    return dateUpdate;
}
public String getDevise() {
    return devise;
}
public Client getProprietaire(){
    return proprietaire;
}
public List<Transaction> getTransactions() {
    return transactions;
}
    public Banque getBanque() {
        return banque;
    }

//setters
public void setNumCompte(int numCompte){
    this.numCompte=numCompte;
}
public void setDateCreation(Date dateCreation) {
    this.dateCreation = dateCreation;
}
public void setDateUpdate(Date dateUpdate) {
    this.dateUpdate = dateUpdate;
}
public void setDevise(String devise) {
    this.devise = devise;
}
    public void setBanque(Banque banque) {
        this.banque = banque;
    }
public void setProprietaire(Client proprietaire) {
    this.proprietaire = proprietaire;
}

//methode pour ajout transactions
public void ajouterTransaction(Transaction transaction){
    transactions.add(transaction);
}












}
