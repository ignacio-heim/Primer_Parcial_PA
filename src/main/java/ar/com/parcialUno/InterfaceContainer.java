package ar.com.parcialUno;

public interface InterfaceContainer<T> {

    void addContaing(T type);
    T obteainContaing(Integer id);
    boolean isEmpty();
    Integer size();
}
