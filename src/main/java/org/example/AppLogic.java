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
    }

    public void createNewProyect() {
        System.out.println("Creando un nuevo proyecto...");
        System.out.println("///////////////////////////////////////");

        do { //Proyect name
            System.out.println("Inserta el nombre de tu proyecto");
            String proyectName = kb.nextLine();
            System.out.println( "El nombre seleccionado es: " + proyectName + ",\n" +
                    "¿Estás seguro de querer este nombre?"
            );
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(this.proyectOperation == 1) {
                System.out.println("El nombre ha sido insertado exitósamente");
                System.out.println("///////////////////////////////////////");
                proyects.setName(proyectName);
            }
        } while (proyectOperation != 1);

        int proyectDepartment;
        do { //Proyect department
            System.out.println("Selecciona el departamento");
            System.out.println( "(1). Departamento de Márketing \n" +
                                "(2). Departamento de Investigación \n" +
                                "(3). Departamento de Informática"
            );
            proyectDepartment = kb.nextInt();
            String departmentName;
            switch (proyectDepartment) {
                case 1:
                    departmentName = "Márketing";
                    break;
                case 2:
                    departmentName = "Investigación";
                    break;
                case 3:
                    departmentName = "Informática";
                    break;
                default:
                    System.out.println("El valor seleccionado no es válido");
                    departmentName = "";
                    break;
            }
            if (proyectDepartment == 1 || proyectDepartment == 2 || proyectDepartment == 3) {
                System.out.println( "El departamento seleccionado es:" + departmentName + ",\n" +
                        "¿Estás seguro de esta operación?"
                );
                System.out.println("SI(1), NO(2)");
                this.proyectOperation = kb.nextInt();

                if(this.proyectOperation == 1) {
                    System.out.println("El departamento ha sido seleccionado exitósamente");
                    System.out.println("///////////////////////////////////////");
                    proyects.setDepartment(departmentName);
                }
            }
        } while (proyectOperation != 1 || proyectDepartment < 1 || proyectDepartment > 3);

        do { //Proyect budget
            System.out.println("Inserta el presupuesto de tu proyecto");
            int proyectBudget = kb.nextInt();
            System.out.println( "El presupuesto insertado es: " + proyectBudget + ",\n" +
                    "¿Estás seguro de este presupuesto?"
            );
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(this.proyectOperation == 1) {
                System.out.println("El presupuesto ha sido insertado exitósamente");
                System.out.println("///////////////////////////////////////");
                proyects.setBudget(proyectBudget);
            }
        } while (proyectOperation != 1);

        do { //Proyect duration
            System.out.println("Inserta la duración del proyecto (en meses)");
            int proyectDuration = kb.nextInt();
            System.out.println( "El total de los meses insertados es: " + proyectDuration + ",\n" +
                    "¿Estás seguro de que este valor es correcto?"
            );
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(this.proyectOperation == 1) {
                System.out.println("La duración ha sido insertado exitósamente");
                System.out.println("///////////////////////////////////////");
                proyects.setDuration(proyectDuration);
            }
        } while (proyectOperation != 1);

        //Científicos en proceso!!
        System.out.println("Selecciona el/los científicos del proyecto");
        System.out.println("/////////////////////EN PROCESO/////////////////////");

        closeProyectApp();
    }

    public void showProyectDetails() {
        System.out.println("Mostrando detalles del proyecto...");
        System.out.println("///////////////////////////////////////");

        closeProyectApp();
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
