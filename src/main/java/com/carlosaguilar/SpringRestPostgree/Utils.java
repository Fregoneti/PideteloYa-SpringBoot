package com.carlosaguilar.SpringRestPostgree;


import java.util.Scanner;

public class Utils {

    public Utils() {
    }
    Scanner teclado;

    /**
     * Espera de Scanner int (Escritura)
     * @return El valor del Scanner
     */
    public int intScanner(){
        int result = 0;
        boolean salir = false;
         teclado = new Scanner(System.in);
        while (!salir) {
            try {
                result = teclado.nextInt();
                salir = true;
            } catch (Exception e) {
                System.out.println("Error");
                teclado = new Scanner(System.in);
            }
        }

        return result;

    }
    /**
     * Espera de Scanner String (Escritura)
     * @return El valor del Scanner
     */
    public String stringScanner() {
        String result = "";
        boolean salir = false;
        Scanner teclado = new Scanner(System.in);
        while (!salir) {
            try {
                result = teclado.next();
                salir = true;
            } catch (Exception e) {
                System.out.println("Error");
                teclado = new Scanner(System.in);
            }
        }
        return result;
    }
}
