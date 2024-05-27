package views;

import entities.Classe;
import enums.Filiere;
import enums.Niveau;

public class ClasseView extends ViewImp<Classe> {

    @Override
    public Classe saisi() {
        Filiere filiere;
        Niveau niveau;
        String nomClasse;
        filiere = choixFiliere();
        niveau = choixNiveau();
        nomClasse= niveau + "" + filiere;
        return new Classe(nomClasse,filiere,niveau);
    }
    
    public Filiere choixFiliere(){
        int choix=0;
        do {
            System.out.println("Veuillez choisir la Filiere :");
            System.out.println("1-GLRS");
            System.out.println("2-ETSE");
            System.out.println("3-IAGE");
            System.out.println("4-MAE");
            System.out.println("5-MOSIEF");
            System.out.print("Votre Choix : ");
            try {
                choix = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Erreur de Saisi!!! Entrer un entier entre [1-5]");
                scanner.next();
            }
        } while (choix<1 || choix > 5);
        return Filiere.values()[choix-1];
    }
    public Niveau choixNiveau(){
        int choix=0;
        do {
            System.out.println("Veuillez choisir le Niveau :");
            System.out.println("1-L1");
            System.out.println("2-L2");
            System.out.println("3-L3");
            System.out.println("4-M1");
            System.out.println("5-M2");
            System.out.print("Votre Choix : ");
            try {
                choix = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Erreur de Saisi!!! Entrer un entier entre [1-5]");
                scanner.next();
            }
            
        } while (choix<1 || choix > 5);
        return Niveau.values()[choix-1];
    }

}
