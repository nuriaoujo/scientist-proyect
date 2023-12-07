package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProyects {
    private Proyects newproyect;
    private String proyectName;
    private String departmentName;
    private int proyectDepartment;
    private int proyectBudget;
    private int proyectDuration;
    private int proyectOperation;

    private Scanner kb = new Scanner(System.in);
    private Scanner kbTxt = new Scanner(System.in);
    private List<Proyects> proyectsList = new ArrayList<>();

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

        do { //Proyect budget
            System.out.println("Inserta el presupuesto de tu proyecto");
            this.proyectBudget = kb.nextInt();
            System.out.println( "El presupuesto insertado es: " + proyectBudget + ",\n" +
                    "¿Estás seguro de este presupuesto?"
            );
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(this.proyectOperation == 1) {
                System.out.println("El presupuesto ha sido insertado exitósamente");
                System.out.println("///////////////////////////////////////");
            }
        } while (proyectOperation != 1);

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

        System.out.println("El científico ha sido registrado exitósamente");
        System.out.println("///////////////////////////////////////");
        this.newproyect = new Proyects(proyectName, departmentName, proyectBudget, proyectDuration, null);
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
                System.out.println("Nombre: " + proyectsList.get(proyectOperation -1).getName());
                System.out.println("Departamento: " + proyectsList.get(proyectOperation -1).getDepartment());
                System.out.println("Presupuesto: " + proyectsList.get(proyectOperation -1).getBudget());
                System.out.println("Duración: " + proyectsList.get(proyectOperation -1).getDuration());
                System.out.println("/////////////////CIENTIFICOS EN PROCESO/////////////////");
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
