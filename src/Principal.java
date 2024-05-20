import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Principal {
    public static void main(String[] args) throws IOException {

        int opcion = 0;

        ConvertirAPI consulta = new ConvertirAPI();

        Scanner lectura = new Scanner(System.in);

        double numeroCambio = 0;

        Historial historial = new Historial(numeroCambio);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

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

                    Monedas resultado = consulta.convertir(base, cambiar);
                    numeroCambio = valor * resultado.conversion_rate();
                    Monedas monedas = new Monedas(base, cambiar,valor, resultado.conversion_rate());


                    historial.agregarLista(monedas);
                    System.out.println("El valor convertido de " + base + " a " + cambiar + ":" + numeroCambio);

                } else {
                    System.out.println("Gracias por utilizar nuestro sistema");
                }

            }

        }catch (Exception e){
            System.out.println("Error al convertir, todos los servidores estan ocupados \nU escribio parametros diferentes a monedas \nPor Favor intente Nuevamente !!");
        }


        Collections.sort(historial.getHistorialTransacciones());
        System.out.println("******************************");
        System.out.println("Historial de Transacciones: ");
        for (Monedas monedas : historial.getHistorialTransacciones()){
            System.out.println(monedas);
        }
        System.out.println("******************************");
        //
        FileWriter escritura = new FileWriter("Datos.json");
        escritura.write(gson.toJson(historial));
        escritura.close();
    }
}
