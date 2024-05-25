import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        String moneda = "";
        var cantidad = 0;

        Scanner scanner = new Scanner(System.in);
        BusquedaConExchange consulta = new BusquedaConExchange();
        System.out.println("""
                *****************************************
                    Bienbenido al conversor de moneda
                *****************************************
                """);
        var eleccion = 1;

        while (eleccion!= 7) {

            System.out.println("""
                    
                    *****************************************
                    ingrese el valor que desea convertir
                    """);
             cantidad = scanner.nextInt();

            System.out.println("valor a convertir es de " + cantidad);
            System.out.println("""
                    *****************************************
                        A que moneda desea comvertirlo
                    *****************************************                  
                    1) Dolar => peso argentino
                    2) Peso argentino => dolar
                    3) Real brasileño => dolar
                    4) Dolar => real brasileño
                    5) Dolar => peso Colombiano
                    6) Peso Colombiano => dolar
                    7) Salir
                            
                    Elija un numero
                    *****************************************
                    """);
            eleccion = scanner.nextInt();


            switch (eleccion){
                // conversion de dolar a peso argentio
                case 1:
                    System.out.println("Elegiste de dolar a peso argentino");
                    moneda = "ARS";

                    try {

                        var resultado = consulta.buscarMonedas(moneda);
                        System.out.println("Tasa de cambio: " +resultado);

                        double cantidadConvertida = consulta.convertirUsdMoneda("ARS", cantidad);
                        System.out.println( cantidad+" USD a ARS: "+ cantidadConvertida);

                    } catch (IOException | IllegalArgumentException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                // conversion de peso argentino a dolar
                case 2:
                    System.out.println("Elegiste de peso argentino a dolar");
                    moneda = "ARS";

                    try {

                        var resultado = consulta.buscarMonedas(moneda);
                        System.out.println("Tasa de cambio: " +resultado);

                        double cantidadConvertida = consulta.convertirMonedaUsd("ARS", cantidad);
                        System.out.println( cantidad+" ARS a USD: "+ cantidadConvertida);

                    } catch (IOException | IllegalArgumentException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case 3:
                    System.out.println("Elegiste de real brasileño a dolar");
                    moneda = "BRL";

                    try {

                        var resultado = consulta.buscarMonedas(moneda);
                        System.out.println("Tasa de cambio: " +resultado);

                        double cantidadConvertida = consulta.convertirMonedaUsd("BRL", cantidad);
                        System.out.println( cantidad+" BRL a USD: "+ cantidadConvertida);

                    } catch (IOException | IllegalArgumentException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 4:
                    System.out.println("Elegiste de dolar a real brasileño");
                    moneda = "BRL";

                    try {

                        var resultado = consulta.buscarMonedas(moneda);
                        System.out.println("Tasa de cambio: " +resultado);

                        double cantidadConvertida = consulta.convertirUsdMoneda("BRL", cantidad);
                        System.out.println( cantidad+" USD a BRL: "+ cantidadConvertida);

                    } catch (IOException | IllegalArgumentException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case 5:
                    System.out.println("Elegiste de dolar a peso Colombiano");
                    moneda = "COP";

                    try {

                        var resultado = consulta.buscarMonedas(moneda);
                        System.out.println("Tasa de cambio: " +resultado);

                        double cantidadConvertida = consulta.convertirUsdMoneda("COP", cantidad);
                        System.out.println( cantidad+" USD a COP: "+ cantidadConvertida);

                    } catch (IOException | IllegalArgumentException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 6:
                    System.out.println("Elegiste de peso colombiano a dolas");
                    moneda = "COP";

                    try {

                        var resultado = consulta.buscarMonedas(moneda);
                        System.out.println("Tasa de cambio: " +resultado);

                        double cantidadConvertida = consulta.convertirMonedaUsd("COP", cantidad);
                        System.out.println( cantidad+" COP a USD: "+ cantidadConvertida);

                    } catch (IOException | IllegalArgumentException e) {
                        throw new RuntimeException(e);
                    }

                    break;



            }
            System.out.println("Desea continuar? 1: si - 7: no");
            int vuelta = scanner.nextInt();
            if (vuelta == 7){
                eleccion = 7;
            }

        }








    }
}
