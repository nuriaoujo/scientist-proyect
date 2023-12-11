package org.example;

import java.util.Scanner;

public class ManageScientist {
    private String scientistName;
    private String scientistsDirection;
    private Integer scientistAge;
    private int proyectOperation;

    private Scanner kb = new Scanner(System.in);
    private Scanner kbTxt = new Scanner(System.in);

    private Scientists scientists;
    public ManageScientist() { }


    public void registerNewScientist() {
        System.out.println("Registrando un nuevo científico...");
        System.out.println("///////////////////////////////////////");

        do { //Scientist name
            System.out.println("Inserta el nombre y los apellidos");
            this.scientistName = kbTxt.nextLine();
            System.out.println( "El nombre seleccionado es: " + scientistName + ",\n" +
                    "¿Estás seguro de querer este nombre?"
            );
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(this.proyectOperation == 1) {
                System.out.println("El nombre ha sido registrado exitósamente");
                System.out.println("///////////////////////////////////////");
            }
        } while (proyectOperation != 1);

        do { //Scientist age
            System.out.println("Inserta la edad");
            this.scientistAge = kb.nextInt();
            System.out.println( "La edad seleccionada es: " + scientistAge + ",\n" +
                    "¿Estás seguro de la edad insertada?"
            );
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(this.proyectOperation == 1) {
                System.out.println("La edad ha sido registrada exitósamente");
                System.out.println("///////////////////////////////////////");
            }
        } while (proyectOperation != 1);

        do { //Scientist address
            System.out.println("Inserta su dirección");
            this.scientistsDirection = kb.nextLine();
            System.out.println( "La dirección seleccionada es: " + scientistsDirection + ",\n" +
                    "¿Estás seguro de la dirección insertada?"
            );
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(this.proyectOperation == 1) {
                System.out.println("La dirección ha sido registrada exitósamente");
                System.out.println("///////////////////////////////////////");
            }
        } while (proyectOperation != 1);
    }

    public void showScientistDetails() {
        System.out.println("Mostrando los científicos...");
        System.out.println("///////////////////////////////////////");
    }
}
