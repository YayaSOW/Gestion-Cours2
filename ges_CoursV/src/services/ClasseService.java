package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Classe;

public class ClasseService implements Service<Classe> {
List <Classe> classes = new ArrayList<>(); 
    @Override
    public void add(Classe objet) {
        classes.add(objet);
    }

    @Override
    public List<Classe> show() {
        return classes;
    }

    @Override
    public Classe getBy(String critere) {
        for (Classe classe : classes) {
            if (classe.getNomClasse().compareToIgnoreCase(critere)==0) {
                return classe;
            }
        }
        return null;
    }

    @Override
    public int count(){
        int counter = 0;
        for (Classe classe : classes) {
            if (classe != null) {
                counter++;
            }
        }
        return counter;
    }

}
