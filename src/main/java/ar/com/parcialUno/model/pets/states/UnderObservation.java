package ar.com.parcialUno.model.pets.states;

public class UnderObservation implements InterfaceState {
    @Override
    public void quiereJugar() {
        System.out.println("No quiere jugar");
    }
}
