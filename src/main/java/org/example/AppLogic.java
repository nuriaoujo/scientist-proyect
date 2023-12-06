package org.example;

import java.util.Scanner;

public class AppLogic {
    private Proyects proyects;
    private Scanner scanner = new Scanner(System.in);
    public AppLogic() { }

    public void createNewProyect() {
        System.out.println("Bienvenido al gestor de Proyectos, \n ¿Quieres generar un nuevo proyecto?");
        System.out.println("SI(1), NO(2)");
        int createProyect = scanner.nextInt();

        switch (createProyect) {
            case 1:
                System.out.println("Has seleccionado: Generar nuevo proyecto");
                break;
            case 2:
                System.out.println("Has seleccionado: Cancelar acción");
                break;
            default:
                System.out.println("ERROR, la opción no es válida");
                createNewProyect();
                break;
        }
    }
}
