package ar.com.parcialUno;

import java.util.ArrayList;
import java.util.List;

public class EstadoDelivery {
    private List<InterfaceState> interfaceStates;
    public EstadoDelivery() {
        interfaceStates = new ArrayList<>();
        this.interfaceStates.add(new Healthy());
        this.interfaceStates.add(new SpecialCares());
        this.interfaceStates.add(new UnderObservation());
    }

    public void agregarEstado(InterfaceState interfaceState) {
        interfaceStates.add(interfaceState);
    }

    public void changeState(Pet aPet, InterfaceState newState) {
        aPet.setActualState(newState);
    }

    public InterfaceState obtenerEstado(Pet aPet) {
        for (InterfaceState interfaceState : interfaceStates) {
            return aPet.getState();
        }
        throw new RuntimeException("Estado no encontrado");
    }
}
