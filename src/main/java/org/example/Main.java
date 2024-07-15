package org.example;
import java.util.Scanner;
public class Main {
  /*  private static final Scanner scanner = new Scanner(System.in);
    private final CurrencyConverter currencyConverter = new CurrencyConverter();

    public void start() {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            int choice = scanner.nextInt();
            if (choice == 2) {
                break;
            } else if (choice == 1) {
                System.out.print("Ingrese la cantidad en USD: ");
                double amount = scanner.nextDouble();
                System.out.print("Ingrese el código de moneda de destino (ej. ARS, BRL, etc.): ");
                String targetCurrency = scanner.next();
                double convertedAmount = currencyConverter.convert(amount, targetCurrency);
                System.out.printf("Monto convertido: %.2f %s\n", convertedAmount, targetCurrency);
            } else {
                System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }*/

    private static final Scanner scanner = new Scanner(System.in);
    private final CurrencyConverter currencyConverter = new CurrencyConverter();

    public void start() {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            int choice = scanner.nextInt();
            if (choice == 2) {
                break;
            } else if (choice == 1) {
                try {
                    System.out.print("Ingrese la cantidad en USD: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Ingrese el código de moneda de destino (ej. ARS, BRL, etc.): ");
                    String targetCurrency = scanner.next();
                    double convertedAmount = currencyConverter.convert(amount, targetCurrency);
                    System.out.printf("Monto convertido: %.2f %s\n", convertedAmount, targetCurrency);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }
}