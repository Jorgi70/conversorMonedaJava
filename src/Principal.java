import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        int opcion = 1;

        Monedas moneda = new Monedas();

        try{
            while (opcion != 7) {
                String menu = """
                        ***********************************************************
                        Bienvanido al Convesior de Moneda de Alura
                                            
                                           
                        1 - Dolar ===> Pesos Argentinos
                        7- Salir
                                            
                        Elija una opcion VALIDA:
                        ***********************************************************
                        """;
                opcion = lectura.nextInt();


                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el Valor a Converir");
                        var valor = lectura.nextInt();

                        var dolarPeso = Integer.valueOf(valor);
                        var resultado = moneda.target_code() * moneda.conversion_rate();
                        double principal = moneda.target_code();
                        System.out.println("El valor de " + moneda.base_code());
                        System.out.println("El valor converitido a USD es de:" + resultado);


                }
            }
        }catch (Exception e){
            System.out.println("Error al convertir, todos los servidores estan ocupados");
        }
    }
}
