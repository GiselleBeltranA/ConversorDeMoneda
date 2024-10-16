import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionDeMenu = 0;
        ConsultarMoneda consulta = new ConsultarMoneda();
        double valor = 0;
        String origen = "";
        String destino = "";



        System.out.println("********************************************************************\n");
        String menu = """
                
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar =>> Peso argentino
                2) Peso Argentio =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                
                Elija una opción válida:
                ********************************************************************
                """;
        while (opcionDeMenu != 7) {
            System.out.println(menu);
            opcionDeMenu = lectura.nextInt();

            switch (opcionDeMenu) {
                case 1:
                    origen = "USD";
                    destino = "ARS";
                    break;

                case 2:
                    origen = "ARS";
                    destino = "USD";
                    break;

                case 3:
                    origen = "USD";
                    destino = "BRL";
                    break;

                case 4:
                    origen = "BRL";
                    destino = "USD";
                    break;

                case 5:
                    origen = "USD";
                    destino = "COP";
                    break;

                case 6:
                    origen = "COP";
                    destino = "USD";
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Valor invalido");
                    break;
            }
            if (opcionDeMenu >= 1 && opcionDeMenu <= 6) {
                System.out.println("Ingrese el valor que desea convertir: ");
                valor = lectura.nextDouble();

                if (valor > 0) {
                    try {
                        Moneda consultarMoneda = consulta.convertirMoneda(origen, destino, valor);
                        System.out.println("El valor de " + valor +
                                " [" + origen + "] equivale a " + consultarMoneda.conversion_result() +
                                " [" + destino + "]");

                        GeneradorDeArchivo generador = new GeneradorDeArchivo();
                        generador.guardarJson(consultarMoneda);

                    } catch (NumberFormatException e) {
                        System.out.println("Error, número no encontrado: " + e.getMessage());
                    } catch (IOException e) {
                        System.out.println("Error al grabar datos a JSON " + e.getMessage());
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Por favor, ingrese un valor mayor a 0");
                }
            }
        }

        System.out.println("Finalizó la ejecución del programa");
    }
}