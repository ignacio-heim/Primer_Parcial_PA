package ar.com.parcialUno.infrastructure.container;

public interface InterfaceContainer<T> {

    void addContaing(T type);
    T obteainContaing(Integer id);
    boolean isEmpty();
    Integer size();
}
