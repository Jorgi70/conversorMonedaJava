public record Monedas(String base_code,
                      String target_code,
                      double conversion_rate) {

    @Override
    public String toString() {
        return "Moneda='" + base_code +
               "Tipo de cambio='" + target_code +
               "Valor=" + conversion_rate;
    }
}
