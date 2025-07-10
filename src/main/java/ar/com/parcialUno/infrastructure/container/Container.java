package ar.com.parcialUno.infrastructure.container;

import ar.com.parcialUno.model.pets.Contain;

import java.util.ArrayList;
import java.util.List;

public class Container<T extends Contain> implements InterfaceContainer<T> {

    private List<T> container;

    public Container() {
        this.container = new ArrayList<>();
    }

    @Override
    public void addContaing(T aThing) {
        container.add(aThing);
    }

    @Override
    public boolean isEmpty() {
        return container.isEmpty();
    }
    @Override
    public Integer size() {
        return container.size();
    }

    @Override
    public T obteainContaing(Integer id) {
        if (isEmpty() || size() < id) {
            return null;
        } else {
            return container.get(id);
        }
    }

    public boolean hasAnAnimal() {
        return obteainContaing(0).isAnimal();
    }


    public boolean hasAThing() {
        return obteainContaing(0).isAnimal();
    }


}
