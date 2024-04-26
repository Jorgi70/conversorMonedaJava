import java.util.ArrayList;
import java.util.List;

public class Historial {

        private String baseMoneda;
        private String cambioMoneda;
        private double numeroCambio;
        private List<Monedas> historialTransacciones;

        Monedas moneda = new Monedas(baseMoneda,cambioMoneda,numeroCambio);

    public Historial(double numeroCambio) {
        this.baseMoneda = moneda.base_code();
        this.cambioMoneda = moneda.target_code();
        this.numeroCambio = moneda.conversion_rate();
        this.historialTransacciones = new ArrayList<>();
    }

    public boolean agregarHistorial(Monedas moneda){
        if(moneda.conversion_rate() != 0){
            getHistorialTransacciones().add(moneda);
            return true;
        }
        return false;
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
