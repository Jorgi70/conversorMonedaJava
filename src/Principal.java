import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        int opcion = 0;

        ConvertirAPI consulta = new ConvertirAPI();

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

                System.out.println("Ingrese el Valor a Convertir");
                var valor = lectura.nextInt();
                String base="", cambiar="";
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
                    case 7:
                        System.out.println("Gracias por utilizar nuestros servicios");
                        break;
                    default:
                        System.out.println("Opcion no Valida");
                }
                Monedas moneda = consulta.convertir( base, cambiar);
                double resultado = valor * moneda.conversion_rate();

                System.out.println("El valor convertido de " +base+ " a "+cambiar+":" + resultado);
            }
        }catch (Exception e){
            System.out.println("Error al convertir, todos los servidores estan ocupados");
        }
    }
}
