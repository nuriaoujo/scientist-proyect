package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageScientist {
    private String scientistName;
    private String scientistsDirection;
    private Integer scientistAge;
    private int proyectOperation;

    private Scanner kb = new Scanner(System.in);
    private Scanner kbTxt = new Scanner(System.in);

    private List<Scientists> scientistsRegistrationList = new ArrayList<>();

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
            this.scientistsDirection = kbTxt.nextLine();
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

        this.scientists = new Scientists(scientistName,scientistAge,scientistsDirection);
        this.scientistsRegistrationList.add(scientists);
        System.out.println("Registrando nuevo científico...");
        System.out.println("El científico " + scientists.getName() + " ha sido registrado exitósamente");
        System.out.println("///////////////////////////////////////");
    }

    public void showScientistDetails() {
        System.out.println("Mostrando los científicos...");
        System.out.println("///////////////////////////////////////");

        if (scientistsRegistrationList.isEmpty()) {
            System.out.println("ERROR: No hay ningún científico registrado");
        } else {
            System.out.println("Estos son los científicos registrados: ");
            for(int i = 0; i < scientistsRegistrationList.size(); i++) {
                System.out.println("(" + (i+1) + "). " + scientistsRegistrationList.get(i).getName());
            }
            System.out.println("Selecciona el científico del que deseas ver más detalles");

            do{
                this.proyectOperation = kb.nextInt();
                if (proyectOperation < 1 || proyectOperation > (scientistsRegistrationList.size() + 1)) {
                    System.out.println("El valor insertado no es válido, por favor inserte otro");
                } else {
                    System.out.println("Nombre: " + scientistsRegistrationList.get(proyectOperation -1).getName());
                    System.out.println("Edad: " + scientistsRegistrationList.get(proyectOperation -1).getAge());
                    System.out.println("Dirección: " + scientistsRegistrationList.get(proyectOperation -1).getAddress());
                }
            } while( proyectOperation < 1 || proyectOperation > (scientistsRegistrationList.size() + 1));

            System.out.println("///////////////////////////////////////");
            System.out.println("¿Quieres ver los detalles de otro científico registrado?");
            System.out.println("SI(1), NO(2)");
            this.proyectOperation = kb.nextInt();

            if(proyectOperation == 1) {
                System.out.println("...");
                showScientistDetails();
            }
        }
    }
}
