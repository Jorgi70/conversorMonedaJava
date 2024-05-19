public record Monedas (String base_code,
                      String target_code,
                      double conversion_rate) implements Comparable<Monedas> {

    @Override
    public String toString() {
        return " Valor ='" + base_code +
                "Conversion ='" + target_code +
                "Precio =" + conversion_rate;
    }

    @Override
    public int compareTo(Monedas otraMoneda) {
        return Double.valueOf(this.conversion_rate).compareTo(Double.valueOf(otraMoneda.conversion_rate));
    }
}
