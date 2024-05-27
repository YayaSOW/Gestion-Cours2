package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Seance;

public class SeanceService implements Service<Seance> {
    List <Seance> seances = new ArrayList<>();
    @Override
    public void add(Seance seance) {
        seances.add(seance);
    }

    @Override
    public List<Seance> show() {
        return seances;
    }

    @Override
    public Seance getBy(String critere) {
        for (Seance seance : seances) {
            if (String.valueOf(seance.getId()).compareToIgnoreCase(critere)==0) {
                return seance;
            }
        }
        return null;
    }

    @Override
    public int count() {
        int counter=0;
        for (Seance seance : seances) {
            if (seance != null) {
                counter++;
            }
        }
        return counter;
    }

}
