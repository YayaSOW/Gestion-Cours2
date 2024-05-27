package entities;

import java.util.ArrayList;
import java.util.List;

import enums.Filiere;
import enums.Niveau;

public class Classe {
    private int id;
    private String nomClasse;
    private Filiere filiere;
    private Niveau niveau;
    private static int nbClasse;

    //Attribut navigable
    //ManyToMany (Classe => Cour)
    private List<Cours> cours = new ArrayList<>();

    public Classe(String nomClasse, Filiere filiere, Niveau niveau) {
        this.id = ++nbClasse;
        this.nomClasse = nomClasse;
        this.filiere = filiere;
        this.niveau = niveau;
    }

    public Classe() {
        id =++nbClasse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void add(Cours cour) {
        this.cours.add(cour);
    }

    @Override
    public String toString() {
        return "Classe [id=" + id + ", nomClasse=" + nomClasse + ", filiere=" + filiere + ", niveau=" + niveau
                + ", cours=" + cours + "]";
    }
}
