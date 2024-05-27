package entities;

import java.util.ArrayList;
import java.util.List;

public class Professeur {
    private int id;
    private String nomComplet;
    private static int nbProf;

    // Attribut Navigable
    //OneToMany (Professeur => Cours)
    private List<Cours> cours = new ArrayList<>();

    public Professeur(String nomComplet) {
        this.id = ++nbProf;
        this.nomComplet = nomComplet;
    }

    public Professeur() {
        id=++nbProf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public static int getNbProf() {
        return nbProf;
    }

    public static void setNbProf(int nbProf) {
        Professeur.nbProf = nbProf;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void add(Cours cour) {
        cours.add(cour);
    }

    @Override
    public String toString() {
        return "Professeur [id=" + id + ", nomComplet=" + nomComplet + ", cours=" + cours + "]";
    }
}
