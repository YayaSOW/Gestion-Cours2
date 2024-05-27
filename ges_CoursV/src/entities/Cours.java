package entities;

import java.util.ArrayList;
import java.util.List;

import enums.Statut;

public class Cours {
    private int id;
    private String module;
    private Statut statut;
    private static int nbCours;
    
    //Attribut navigable
    //ManyToOne (Cours => Professeur)
    private Professeur professeur;
    //OneToMany (Cour => Seance)
    private List<Seance> seances = new ArrayList<>();
    //ManyToMany (Cour => Classe)
    private List<Classe> classes = new ArrayList<>();

    public Cours(String module,Statut statut) {
        this.id = ++nbCours;
        this.module = module;
        this.statut = statut;
    }
    public Cours() {
        id = ++nbCours;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModule() {
        return module;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public Professeur getProfesseur() {
        return professeur;
    }
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    public List<Seance> getSeances() {
        return seances;
    }
    public void add(Seance seance) {
        seances.add(seance);
    }
    public List<Classe> getClasses() {
        return classes;
    }
    public void add(Classe classe) {
        this.classes.add(classe);
    }
    @Override
    public String toString() {
        return "Cours [id=" + id + ", module=" + module +  ", professeur=" + professeur.getNomComplet() + ", statut=" + statut + "]";
    }

}
