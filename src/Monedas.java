public record Monedas (String base_code,
                      String target_code,
                      Integer valor,
                      double conversion_rate) implements Comparable<Monedas> {

    @Override
    public String toString() {
        return " Valor = " + valor + " "+ base_code +
                ", Conversion a " +"("+ conversion_rate +")"+ target_code +
                ", Total = " + (conversion_rate * valor);
    }


    @Override
    public int compareTo(Monedas otraMoneda) {
        return Double.valueOf(this.conversion_rate).compareTo(Double.valueOf(otraMoneda.conversion_rate));
    }
}
