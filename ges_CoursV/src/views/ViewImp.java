package views;

import java.util.List;
import java.util.Scanner;

public abstract class ViewImp<T> implements View<T> {
    protected Scanner scanner;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void affiche(List<T> objet){
        for (T values : objet) {
            System.out.println(values);
        }
    }

}
