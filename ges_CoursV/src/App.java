import java.util.Scanner;

import core.Service;
import entities.Classe;
import entities.Cours;
import entities.Professeur;
import entities.Seance;
import enums.Statut;
import services.ClasseService;
import services.CoursService;
import services.SeanceService;
import views.ClasseView;
import views.CoursView;
import views.SeanceView;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ClasseView classeView = new ClasseView();
        CoursView coursView = new CoursView();
        SeanceView seanceView = new SeanceView();
        Service<Classe> classeService = new ClasseService();
        Service<Cours> coursService = new CoursService();
        Service<Seance> seanceService = new SeanceService();
        classeView.setScanner(scanner);
        coursView.setScanner(scanner);
        seanceView.setScanner(scanner);
        int choice;
        Classe cl;
        Cours cr;
        Seance sc;
        do {
            choice = menu();
            // scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    cl = classeView.saisi();
                    if (classeService.getBy(cl.getNomClasse()) == null) {
                        classeService.add(cl);
                    } else {
                        System.out.println("La Classe " + cl.getNomClasse() + " existe deja !!!");
                    }
                }
                case 2 -> {
                    // if (classeService.show().isEmpty()) {
                    if (classeService.count() == 0) {
                        System.out.println("La liste de Classe est vide pour le moment!");
                    } else {
                        classeView.affiche(classeService.show());
                    }
                }
                case 3 -> {
                    if (classeService.count() != 0) {
                        scanner.nextLine();
                        cr = coursView.saisi();
                        Professeur professeur = new Professeur();
                        do {
                            System.out.print("Entrer le Nom du Professeur: ");
                            professeur.setNomComplet(scanner.nextLine());
                        } while (professeur == null);
                        if (coursService.getBy(cr.getModule()) == null) {
                            String nomCl;
                            int rep;
                            do {
                                do {
                                    System.out.println("Le(s) Classe(s) : ");
                                    for (Classe classe : classeService.show()) {
                                        System.out.println(classe);
                                    }
                                    System.out.println("Entrer le nom de la classe ou le cours sera enseigne:");
                                    nomCl = scanner.nextLine();
                                    Classe classe = classeService.getBy(nomCl);
                                    if (classe == null) {
                                        System.out.println("Cette Classe n'existe pas!!!");
                                    } else {
                                        int n = 0;
                                        if (!(classe.getCours().isEmpty())) {
                                            for (Cours cour : classe.getCours()) {
                                                if (cour.getModule().compareToIgnoreCase(cr.getModule()) == 0) {
                                                    // donc le module existe dans le tab de cours
                                                    n++;
                                                }
                                            }
                                            if (n == 0) {
                                                // Cours => Classe
                                                cr.add(classe);
                                                // Classe => Cours
                                                classe.add(cr);
                                                // Professeur => Cours
                                                professeur.add(cr);
                                                // Cours => Professeur
                                                cr.setProfesseur(professeur);
                                                // Ajout du Cours dans le tableau de Cours
                                                coursService.add(cr);
                                            }
                                        } else {
                                            // Cours => Classe
                                            cr.add(classe);
                                            // Classe => Cours
                                            classe.add(cr);
                                            // Professeur => Cours
                                            professeur.add(cr);
                                            // Cours => Professeur
                                            cr.setProfesseur(professeur);
                                            // Ajout du Cours dans le tableau de Cours
                                            coursService.add(cr);
                                        }
                                    }
                                } while ("".equals(nomCl));
                                rep = continuer();
                            } while (rep == 1);
                        } else {
                            System.out.println("Le Module " + cr.getModule() + " existe deja !!!");
                        }
                    } else {
                        System.out.println("il vous faut au moin une classe");
                    }
                }
                case 4 -> {
                    if (coursService.show().isEmpty()) {
                        System.out.println("La liste de Cours est vide pour le moment!");
                    } else {
                        coursView.affiche(coursService.show());
                    }
                }
                case 5 -> {
                    if (classeService.count() != 0) {
                        String nomCl;
                        scanner.nextLine();
                        System.out.print("Entrer le nom de la Classe: ");
                        nomCl = scanner.nextLine();
                        Classe classe = classeService.getBy(nomCl);
                        if (classe != null) {
                            if (classe.getCours().isEmpty()) {
                                System.out.println("Cette classe n'a pas encore de Cours");
                            } else {
                                for (Cours cour : classe.getCours()) {
                                    System.out.println(cour);
                                }
                            }
                        } else {
                            System.out.println("Cette Classe n'existe pas");
                        }
                    } else {
                        System.out.println("Vous devez avoir au moins une classe");
                    }
                }
                case 6 -> {
                    if (coursService.count() != 0) {
                        String module;
                        scanner.nextLine();
                        System.out.print("Entrer le Module du cours: ");
                        module = scanner.nextLine();
                        Cours cour = coursService.getBy(module);
                        if (cour != null) {
                            for (Classe classe : cour.getClasses()) {
                                System.out.println(classe);
                            }
                        } else {
                            System.out.println("Ce Cours n'existe pas !");
                        }
                    } else {
                        System.out.println("Il faut au moins un Cours !");
                    }
                }
                case 7 -> {
                    if (coursService.count() != 0) {
                        coursView.affiche(coursService.show());
                        String module;
                        scanner.nextLine();
                        System.out.print("Entrer le Module du cours: ");
                        module = scanner.nextLine();
                        Cours cour = coursService.getBy(module);
                        if (cour != null) {
                            sc = seanceView.saisi();
                            seanceService.add(sc);
                            // Cours => Seance
                            cour.add(sc);
                            // Seance => Cours
                            sc.setCours(cour);
                        } else {
                            System.out.println("ce cours n'existe pas");
                        }
                    } else {
                        System.out.println("Vous devriez avoir au moins un cours");
                    }
                }
                case 8 -> {
                    if (!(seanceService.show().isEmpty())) {
                        for (Seance seance : seanceService.show()) {
                            System.out.println(seance);
                        }
                        String id;
                        scanner.nextLine();
                        System.out.print("Entrez l'ID de la seance: ");
                        id = scanner.nextLine();
                        Seance seance = seanceService.getBy(id);
                        if (seance != null) {
                            Cours cour = seance.getCours();
                            Statut statut = seanceView.choixStatut();
                            //Changer le statut dans Seance
                            seance.setStatut(statut);
                            // Mettre a jour aussi dans le cour
                            cour.setStatut(statut);
                            System.out.println("Statut Changer a: "+ statut);
                        }else{
                            System.out.println("Ce cours n'existe pas");
                        }
                    } else {
                        System.out.println("il faut d'abord creer une seance !");
                    }
                }
                default -> {
                    System.out.println("Invalid choice");
                }
            }
        } while (choice != 13);
    }

    public static int menu() {
        System.out.println("1-Créer une classe");
        System.out.println("2-Lister les Classe");
        System.out.println("3-Créer un Cours");
        System.out.println("4-Lister Tous les cours");
        System.out.println("5-Lister Tous les cours d une classe");
        System.out.println("6-Lister La  ou les  classes d un cours");
        System.out.println("7-Créer une ou des Séance à un cours");
        System.out.println("8-Changer le statut d une séance de cours");
        System.out.println("9-Lister les séances d un cours par Statut");
        System.out.println("10-Lister Les séances de cours de la journée");
        System.out.println("11-Les séances de cours d une classe de la journée");
        System.out.println("12-Affecter un cours a une classe");
        System.out.println("13-Quitter");
        System.out.print("Votre choix : ");
        return scanner.nextInt();
    }

    public static int continuer() {
        int choix = 0;
        do {
            System.out.println("1-Oui");
            System.out.println("2-Non");
            System.out.print("Voulez-Vous Continuer ?: ");
            try {
                choix = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextInt();
            }
        } while (choix != 1 && choix != 2);
        scanner.nextLine();
        return choix;
    }
}
