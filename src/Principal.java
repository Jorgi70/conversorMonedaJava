import java.util.*;

public class Principal {
    public static void main(String[] args) {

        int opcion = 0;

        ConvertirAPI consulta = new ConvertirAPI();

        Scanner lectura = new Scanner(System.in);

        double numeroCambio = 0;

        Historial historial = new Historial(numeroCambio);

        try{
            while (opcion != 7) {

                String menu = """
                        ***********************************************************
                        Bienvanido al Convesor de Moneda de Alura
                                            
                        1 - Dolar ===> Pesos Argentinos
                        2 - Pesos Argentino ===> Dolar
                        3 - Dolar ===> Real Brasilero
                        4 - Real Brasilero ===> Dolar
                        5 - Dolar ===> Pesos Colombianos
                        6 - Pesos Colombianos ===> Dolar
                        7 - Salir
                                            
                        Elija una opcion VALIDA:
                                                
                        ***********************************************************
                        """;
                System.out.println(menu);
                opcion = lectura.nextInt();
                if (opcion > 0 && opcion < 7) {
                    String base = "", cambiar = "";
                    System.out.println("Ingrese el Valor a Convertir");
                    var valor = lectura.nextInt();

                    switch (opcion) {
                        case 1:
                            base = "USD";
                            cambiar = "ARS";
                            break;
                        case 2:
                            base = "ARS";
                            cambiar = "USD";
                            break;
                        case 3:
                            base = "USD";
                            cambiar = "BRL";
                            break;
                        case 4:
                            base = "BRL";
                            cambiar = "USD";
                            break;
                        case 5:
                            base = "USD";
                            cambiar = "COP";
                            break;
                        case 6:
                            base = "COP";
                            cambiar = "USD";
                            break;
                    }
                    Monedas monedas = new Monedas(base, cambiar, numeroCambio);
                    Monedas resultado = consulta.convertir(base, cambiar);
                    numeroCambio = valor * resultado.conversion_rate();

                    historial.agregarLista(monedas);
                    System.out.println("El valor convertido de " + base + " a " + cambiar + ":" + numeroCambio);

                } else {
                    System.out.println("Gracias por utilizar nuestro sistema");
                }

            }

        }catch (Exception e){
            System.out.println("Error al convertir, todos los servidores estan ocupados");
        }


        Collections.sort(historial.getHistorialTransacciones());
        System.out.println("******************************");
        System.out.println("Historial de Transacciones: ");
        for (Monedas monedas : historial.getHistorialTransacciones()){
            System.out.println(monedas.base_code() + "-" + monedas.target_code() + "-" + monedas.conversion_rate());
        }
        System.out.println("******************************");
    }
}
