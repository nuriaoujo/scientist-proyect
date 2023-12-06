package org.example;

import java.util.Scanner;

public class AppLogic {
    private Proyects proyects;
    private Scanner kb = new Scanner(System.in);
    private int proyectOperation;
    public AppLogic() { }

    public void homeProyect() {
        System.out.println( "Bienvenido al gestor de proyectos científicos, \n" +
                            "Selecciona una operación"
        );
        System.out.println( "(1). Crear un nuevo proyecto \n" +
                            "(2). Mostrar información del proyecto"
        );
        do {
            this.proyectOperation = kb.nextInt();
            switch (this.proyectOperation) {
                case 1:
                    System.out.println("Has seleccionado: Crear un nuevo proyecto");
                    createNewProyect();
                    break;
                case 2:
                    System.out.println("Has seleccionado: Mostrar información del proyecto");
                    showProyectDetails();
                    break;
                default:
                    System.out.println("ERROR, el valor insertado no es correcto");

                    break;
            }
        } while (this.proyectOperation < 1 || this.proyectOperation > 2);
        kb.close();
    }

    public void createNewProyect() {
        System.out.println("Creando un nuevo proyecto...");
        System.out.println("///////////////////////////////////////");
        System.out.println( "Bienvenido al gestor de Proyectos, \n" +
                            "¿Quieres generar un nuevo proyecto?"
        );
        System.out.println("SI(1), NO(2)");
        int createProyect = kb.nextInt();

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

    public void showProyectDetails() {
        System.out.println("Mostrando detalles del proyecto...");
        System.out.println("///////////////////////////////////////");
    }
}
