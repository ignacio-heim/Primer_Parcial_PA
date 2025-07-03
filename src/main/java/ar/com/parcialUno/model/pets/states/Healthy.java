package ar.com.parcialUno.model.pets.states;

public class Healthy implements InterfaceState {

    @Override
    public void quiereJugar() {
        System.out.println("Quiere jugar");
    }

    /*
    @Override
    public boolean cumple(Pet aPet) {
        return false;
    }
     */
}
