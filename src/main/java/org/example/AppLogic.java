package org.example;

import java.util.Scanner;

public class AppLogic {
    private Scanner kb = new Scanner(System.in);
    private int proyectOperation;

    private ManageProyects manageProyects;

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
                    manageProyects.createNewProyect();
                    closeProyectApp();
                    break;
                case 2:
                    System.out.println("Has seleccionado: Mostrar información del proyecto");
                    manageProyects.showProyectDetails();
                    closeProyectApp();
                    break;
                default:
                    System.out.println("ERROR, el valor insertado no es correcto");
                    break;
            }
        } while (this.proyectOperation < 1 || this.proyectOperation > 2);
    }


    public void showScientistDetails() {
        System.out.println("Mostrando los científicos...");
        System.out.println("///////////////////////////////////////");

        closeProyectApp();
    }

    public void closeProyectApp() {
        System.out.println("Quieres realizar otra operación?");
        System.out.println("SI(1), NO(2)");

        do {
            this.proyectOperation = kb.nextInt();
            switch (this.proyectOperation) {
                case 1:
                    System.out.println("Serás redirigido al menú de inicio...");
                    System.out.println("///////////////////////////////////////");
                    homeProyect();
                    break;
                case 2:
                    System.out.println("Cerrando aplicación...");
                    System.out.println("///////////////////////////////////////");
                    break;
                default:
                    System.out.println("ERROR, el valor insertado no es correcto");
                    break;
            }
        } while (this.proyectOperation < 1 || this.proyectOperation > 2);
    }
}
