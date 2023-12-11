package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProyects {
    private Proyects newproyect;
    private ManageScientist manageScientist;
    private AppLogic appLogic;
    private String proyectName;
    private String departmentName;
    private int proyectDepartment;
    private int proyectBudget;
    private int proyectDuration;
    private int proyectOperation;

    private Scanner kb = new Scanner(System.in);
    private Scanner kbTxt = new Scanner(System.in);
    private List<Proyects> proyectsList = new ArrayList<>();
    private List<String> proyectsScientist;

    public ManageProyects() {}

    public void createNewProyect() {
        System.out.println("Creando un nuevo proyecto...");
        System.out.println("///////////////////////////////////////");

        do { //Proyect name
            System.out.println("Inserta el nombre de tu proyecto");
            this.proyectName = kbTxt.nextLine();
            System.out.println( "El nombre seleccionado es: " + proyectName + ",\n" +
                    "¿Estás seguro de querer este nombre?"
            );
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(this.proyectOperation == 1) {
                System.out.println("El nombre ha sido insertado exitósamente");
                System.out.println("///////////////////////////////////////");
            }
        } while (proyectOperation != 1);


        do { //Proyect department
            System.out.println("Selecciona el departamento");
            System.out.println( "(1). Departamento de Márketing \n" +
                    "(2). Departamento de Investigación \n" +
                    "(3). Departamento de Informática"
            );
            this.proyectDepartment = kb.nextInt();
            switch (proyectDepartment) {
                case 1:
                    this.departmentName = "Márketing";
                    break;
                case 2:
                    this.departmentName = "Investigación";
                    break;
                case 3:
                    this.departmentName = "Informática";
                    break;
                default:
                    System.out.println("El valor seleccionado no es válido");
                    this.departmentName = "";
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
                }
            }
        } while (proyectOperation != 1 || proyectDepartment < 1 || proyectDepartment > 3);

        do { //Proyect duration
            System.out.println("Inserta la duración del proyecto (en meses)");
            this.proyectDuration = kb.nextInt();
            System.out.println( "El total de los meses insertados es: " + proyectDuration + ",\n" +
                    "¿Estás seguro de que este valor es correcto?"
            );
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(this.proyectOperation == 1) {
                System.out.println("La duración ha sido insertado exitósamente");
                System.out.println("///////////////////////////////////////");
            }
        } while (proyectOperation != 1);

        //Científicos en proceso!!
        System.out.println("Selecciona el/los científicos del proyecto");
        System.out.println("/////////////////////EN PROCESO/////////////////////");

        if (manageScientist.getScientistsRegistrationList().isEmpty()) {
            System.out.println( "ERROR: No existe ningún científico registrado, \n" +
                                "¿Quieres registrar un científico?");
            System.out.println("SI(1), NO(2)");

            do {
                this.proyectOperation = kb.nextInt();
                if(proyectOperation == 1) {
                    manageScientist.registerNewScientist();
                } else {
                    System.out.println( "No se puede completar el registro del proyecto, \n" +
                                        "serás redirigido al inicio");
                    appLogic.homeProyect();
                }
            } while (proyectOperation < 1 || proyectOperation > 2);
        }

        //One scientist
        System.out.println("Selecciona el científico que deseas registrar");
        do {
            for(int i = 0; i < manageScientist.getScientistsRegistrationList().size(); i++) {
                System.out.println("( " +  (i + 1) + " ). " +
                        manageScientist.getScientistsRegistrationList().get(i).getName() + ", " +
                        manageScientist.getScientistsRegistrationList().get(i).getAge() + ", " +
                        manageScientist.getScientistsRegistrationList().get(i).getAddress()
                );
            }
            this.proyectOperation = kb.nextInt();
            if (proyectOperation < 1 || proyectOperation > manageScientist.getScientistsRegistrationList().size() + 1) {
                System.out.println("El valor seleccionado no es válido");
            }
        } while (proyectOperation < 1 || proyectOperation > manageScientist.getScientistsRegistrationList().size() + 1);

        this.proyectsScientist = new ArrayList<>();
        proyectsScientist.add(manageScientist.getScientistsRegistrationList().get(proyectOperation - 1).getName());

        System.out.println("El científico ha sido registrado exitósamente");
        System.out.println("///////////////////////////////////////");

        //Budget calculation
        System.out.println("Calculando el presupuesto del proyecto...");
        this.proyectBudget = proyectDuration * proyectsScientist.size() * 5000;
        System.out.println("El presupuesto ha sido calculado correctamente");

        this.newproyect = new Proyects(proyectName, departmentName, proyectBudget, proyectDuration, proyectsScientist);
        proyectsList.add(newproyect);
        System.out.println("Registrando nuevo proyecto...");
        System.out.println("El proyecto " + newproyect.getName() + " ha sido registrado exitósamente");
        System.out.println("///////////////////////////////////////");
    }

    public void showProyectDetails() {
        System.out.println("Mostrando detalles de los proyectos...");
        System.out.println("///////////////////////////////////////");

        if (proyectsList.isEmpty()) {
            System.out.println("ERROR: No existe ningún proyecto en la base de datos");
        } else {
            System.out.println("Estos son los proyectos registrados: ");
            for(int i = 0; i < proyectsList.size(); i++) {
                System.out.println("(" + (i+1) + "). " + proyectsList.get(i).getName());
            }
            System.out.println("Selecciona el proyecto del que deseas ver más detalles");

            do{
                this.proyectOperation = kb.nextInt();
                if (proyectOperation < 1 || proyectOperation > (proyectsList.size() + 1)) {
                    System.out.println("El valor insertado no es válido, por favor inserte otro");
                } else {
                    System.out.println("Nombre: " + proyectsList.get(proyectOperation - 1).getName());
                    System.out.println("Departamento: " + proyectsList.get(proyectOperation - 1).getDepartment());
                    System.out.println("Presupuesto: " + proyectsList.get(proyectOperation - 1).getBudget());
                    System.out.println("Duración: " + proyectsList.get(proyectOperation - 1).getDuration());
                    System.out.println("Científicos: ");
                }
            } while( proyectOperation < 1 || proyectOperation > (proyectsList.size() + 1));

            System.out.println("///////////////////////////////////////");
            System.out.println("¿Quieres ver los detalles de otro proyecto registrado?");
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(proyectOperation == 1) {
                System.out.println("...");
                showProyectDetails();
            }
        }
    }
}
