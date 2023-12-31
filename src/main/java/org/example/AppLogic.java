package org.example;

import java.util.Scanner;

public class AppLogic {
    private Scanner kb = new Scanner(System.in);
    private int proyectOperation;

    ManageProyects manageProyects;
    ManageScientist manageScientist;


    public int getProyectOperation() { return proyectOperation; }
    public void setProyectOperation(int proyectOperation) { this.proyectOperation = proyectOperation; }

    public ManageProyects getManageProyects() { return manageProyects; }
    public void setManageProyects(ManageProyects manageProyects) { this.manageProyects = manageProyects; }

    public ManageScientist getManageScientist() { return manageScientist; }
    public void setManageScientist(ManageScientist manageScientist) { this.manageScientist = manageScientist; }

    public AppLogic() {
        manageProyects = new ManageProyects(this);
        manageScientist = new ManageScientist(this);
    }

    public void homeProyect() {
        System.out.println( "Bienvenido al gestor de proyectos científicos. \n" +
                            "Selecciona una operación"
        );
        System.out.println( "(1). Crear un nuevo proyecto \n" +
                            "(2). Mostrar información del proyecto \n" +
                            "(3). Registrar un nuevo científico \n" +
                            "(4). Mostrar los científicos registrados"
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
                case 3:
                    System.out.println("Has seleccionado: Registrar un nuevo científico");
                    manageScientist.registerNewScientist();
                    closeProyectApp();
                    break;
                case 4:
                    System.out.println("Has seleccionado: Mostrar los científicos registrados");
                    manageScientist.showScientistDetails();
                    closeProyectApp();
                    break;
                default:
                    System.out.println("ERROR, el valor insertado no es correcto");
                    break;
            }
        } while (this.proyectOperation < 1 || this.proyectOperation > 4);
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
