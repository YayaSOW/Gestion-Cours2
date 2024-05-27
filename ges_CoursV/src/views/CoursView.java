package views;

import entities.Cours;
import enums.Statut;

public class CoursView extends ViewImp<Cours> {

    @Override
    public Cours saisi() {
        Cours cour = new Cours();
        System.out.print("Entrer le Module du Cours: ");
        cour.setModule(scanner.nextLine());
        cour.setStatut(Statut.Planifier);
        return cour;
    }
    
}
