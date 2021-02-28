package com.carlosaguilar.SpringRestPostgree.View;

import com.carlosaguilar.SpringRestPostgree.Utils;

public class GUI {
    Utils u = new Utils();

    public void first() {
        int opcion = 0;
        System.out.println("Has entrado en la App prueba de Lugares, pulse para registrar o loguear");


        do {
            System.out.println("------------------");
            System.out.println();
            System.out.println("Pulse 1. Registrar");
            System.out.println("Pulse 1. Login");
            System.out.println("------------------");
            opcion = u.intScanner();

        } while (opcion < 1 || opcion > 2);

        switch (opcion) {
            case 1:
                registrar();
                break;

            case 2:
                login();
                break;

        }
    }

    public void registrar() {
        String mail;
        String pass;
        System.out.println("Has entrado en registrar");
        System.out.println("------------------------");
        System.out.println("Introduce un correo");
        mail = u.stringScanner();
        System.out.println("Introduce una contraseña");
        pass = u.stringScanner();

    }


    public void login() {
        String mail;
        String pass;
        System.out.println("Has entrado en loguear");
        System.out.println("------------------------");
        System.out.println("Introduce tu correo");
        mail = u.stringScanner();
        System.out.println("Introduce tu contraseña");
        pass = u.stringScanner();

    }

}







