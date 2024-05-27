package core;

import java.util.List;

public interface Service<T> {
    void add(T objet);
    List<T> show();
    T getBy(String critere);
    int count();
}