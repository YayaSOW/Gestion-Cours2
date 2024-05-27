package views;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.sound.midi.Soundbank;

import entities.Seance;
import enums.Statut;

public class SeanceView extends ViewImp<Seance> {

    @Override
    public Seance saisi() {
        LocalTime heureDebut = null;
        LocalTime heureFin = null;
        Statut statut;
        do {
            try {
                System.out.print("Veuillez saisir l'Heure de Debut du cours [HH:mm]:");
                heureDebut = formatHeure(scanner.nextLine());
                System.out.print("Veuillez saisir l'Heure de Fin du cours [HH:mm]:");
                heureFin = formatHeure(scanner.nextLine());
            } /*catch (DateTimeParseException e) {
                System.out.println("Heure invalide. Veuillez entrer une heure au format HH:mm.");
                scanner.nextLine();
            }*/catch (Exception e) {
                scanner.nextLine();
                System.out.println("l'Heure de debut doit etre inferieur a l'heure de Fin");
            }
        } while (heureDebut.isAfter(heureFin) || heureDebut == null ||heureFin == null);
        statut = Statut.Planifier;
        return new Seance(heureDebut,heureFin,statut);
    }
    public static LocalTime formatHeure(String heure) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(heure, formatter);
    }

    public Statut choixStatut(){
        int choix=0;
        do {
            for (Statut statut : Statut.values()) {
                System.out.println((statut.ordinal()+1) +"-"+statut.name());
            }
            System.out.print("entrer le Statut :");
            try {
                choix = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Erreur de Saisi!!! Entrer un entier entre [1-3]");
                scanner.next();
            }
        } while (choix<1 || choix > 3);
        return Statut.values()[choix - 1];
    }

}
