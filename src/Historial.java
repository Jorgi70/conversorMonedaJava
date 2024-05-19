import java.util.ArrayList;
import java.util.List;

public class Historial {

        private String baseMoneda;
        private String cambioMoneda;
        private double numeroCambio;
        private List<Monedas> historialTransacciones;


    public Historial(double numeroCambio) {
        this.baseMoneda = baseMoneda;
        this.cambioMoneda = cambioMoneda;
        this.numeroCambio = numeroCambio;
        this.historialTransacciones = new ArrayList<>();
    }


    public void agregarLista(Monedas monedas){
        historialTransacciones.add(monedas);
    }

    public String getBaseMoneda() {
        return baseMoneda;
    }

    public String getCambioMoneda() {
        return cambioMoneda;
    }

    public double getNumeroCambio() {
        return numeroCambio;
    }

    public List<Monedas> getHistorialTransacciones() {
        return historialTransacciones;
    }
}



