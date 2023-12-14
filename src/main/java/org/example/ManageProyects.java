package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProyects {
    private Proyects newproyect;
    private AppLogic appLogic;
    private String proyectName;
    private String departmentName;
    private int proyectDepartment;
    private int proyectBudget;
    private int proyectDuration;
    private int proyectOperation;
    private int scientistOperation;

    private Scanner kb = new Scanner(System.in);
    private Scanner kbTxt = new Scanner(System.in);
    private List<Proyects> proyectsList = new ArrayList<>();
    private List<String> proyectsScientist;

    public ManageProyects(AppLogic appLogic) {
        this.appLogic = appLogic;
    }

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
                System.out.println("La duración ha sido insertada exitósamente");
                System.out.println("///////////////////////////////////////");
            }
        } while (proyectOperation != 1);

        System.out.println("Selecciona el científico del proyecto");

        if (appLogic.getManageScientist().getScientistsRegistrationList().isEmpty()) {
            System.out.println( "ERROR: No existe ningún científico registrado, \n" +
                                "¿Quieres registrar un científico?");
            System.out.println("SI(1), NO(2)");

            do {
                this.proyectOperation = kb.nextInt();
                if(proyectOperation == 1) {
                    appLogic.getManageScientist().registerNewScientist();
                } else {
                    System.out.println( "No se puede completar el registro del proyecto, \n" +
                                        "serás redirigido al inicio");
                    appLogic.homeProyect();
                }
            } while (proyectOperation < 1 || proyectOperation > 2);
        }

        System.out.println( "¿Cuántos científicos deseas registrar? \n" +
                            "1. Un científico \n" +
                            "2. Dos científicos \n" +
                            "3. Tres científicos"
        );
        do {
            proyectOperation = kb.nextInt();

            switch (proyectOperation) {
                case 1:
                    System.out.println("Has seleccionado: Registrar un científico");
                    System.out.println("///////////////////////////////////////");
                    if (!appLogic.getManageScientist().getScientistsRegistrationList().isEmpty()) {
                        insertOneScientist();
                    } else {
                        System.out.println("ERROR, no tienes científicos registrados, serás redirigido al menú de inicio");
                        appLogic.homeProyect();
                    }
                    break;
                case 2:
                    System.out.println("Has seleccionado: Registrar dos científicos");
                    System.out.println("///////////////////////////////////////");
                    if (appLogic.getManageScientist().getScientistsRegistrationList().size() >= 2) {
                        insertTwoScientists();
                    } else if(!appLogic.getManageScientist().getScientistsRegistrationList().isEmpty()){
                        System.out.println("ERROR, no tienes registrados suficientes científicos, \n" +
                                "¿Deseas registrar únicamente un científico?"
                        );
                        System.out.println("SI(1), NO(2)");
                        scientistOperation = kb.nextInt();
                        if(scientistOperation == 1) {
                            insertOneScientist();
                        } else {
                            appLogic.homeProyect();
                        }
                    } else {
                        System.out.println("ERROR, no tienes científicos registrados, serás redirigido al menú de inicio");
                        appLogic.homeProyect();
                    }
                    break;
                case 3:
                    System.out.println("Has seleccionado: Registrar tres científicos");
                    System.out.println("///////////////////////////////////////");
                    if (appLogic.getManageScientist().getScientistsRegistrationList().size() >= 3) {
                        insertThreeScientists();
                    } else if(!appLogic.getManageScientist().getScientistsRegistrationList().isEmpty()){
                        System.out.println("ERROR, no tienes registrados suficientes científicos, \n" +
                                            "¿Deseas registrar únicamente un científico?"
                        );
                        System.out.println("SI(1), NO(2)");
                        scientistOperation = kb.nextInt();
                        if(scientistOperation == 1) {
                            insertOneScientist();
                        } else {
                            appLogic.homeProyect();
                        }
                    } else {
                        System.out.println("ERROR, no tienes científicos registrados, serás redirigido al menú de inicio");
                        appLogic.homeProyect();
                    }
                    break;
                default:
                    System.out.println("ERROR: El valor seleccionado no existe");
                    break;
            }

            if(proyectOperation == 1) {
                System.out.println("El científico ha sido registrado exitósamente");
                System.out.println("///////////////////////////////////////");
            } else if (proyectOperation == 2 || proyectOperation == 3) {
                System.out.println("Los científicos han sido registrados exitósamente");
                System.out.println("///////////////////////////////////////");
            }
        } while (proyectOperation < 1 || proyectOperation > 3);

        //Budget calculation
        System.out.println("Calculando el presupuesto del proyecto...");
        this.proyectBudget = proyectDuration * proyectsScientist.size() * 5000;
        System.out.println("Este es el presupuesto del proyecto: " + proyectBudget);
        System.out.println("El presupuesto ha sido calculado correctamente");

        this.newproyect = new Proyects(proyectName, departmentName, proyectBudget, proyectDuration, proyectsScientist);
        proyectsList.add(newproyect);
        System.out.println("///////////////////////////////////////");
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

                    for(int i = 0; i < proyectsList.get(proyectOperation - 1).getScientistsList().size(); i++) {
                        System.out.println("- "+ proyectsList.get(proyectOperation - 1).getScientistsList().get(i));
                    }
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

    public void insertOneScientist(){
        System.out.println("Selecciona el científico que deseas registrar");
        do {
            for(int i = 0; i < appLogic.getManageScientist().getScientistsRegistrationList().size(); i++) {
                System.out.println("( " +  (i + 1) + " ). " +
                        appLogic.getManageScientist().getScientistsRegistrationList().get(i).getName() + ", " +
                        appLogic.getManageScientist().getScientistsRegistrationList().get(i).getAge() + ", " +
                        appLogic.getManageScientist().getScientistsRegistrationList().get(i).getAddress()
                );
            }
            this.proyectOperation = kb.nextInt();
            if (proyectOperation < 1 || proyectOperation > appLogic.getManageScientist().getScientistsRegistrationList().size() + 1) {
                System.out.println("El valor seleccionado no es válido");
            }
        } while (proyectOperation < 1 || proyectOperation > appLogic.getManageScientist().getScientistsRegistrationList().size() + 1);

        System.out.println("¿Estás seguro en querer registrar a " + appLogic.getManageScientist().getScientistsRegistrationList().get(proyectOperation - 1).getName());
        System.out.println("SI(1), NO(2)");
        scientistOperation = kb.nextInt();
        if(scientistOperation == 1) {
            this.proyectsScientist = new ArrayList<>();
            proyectsScientist.add(appLogic.getManageScientist().getScientistsRegistrationList().get(proyectOperation - 1).getName());
        } else {
            insertOneScientist();
        }
    }

    public void insertTwoScientists() {
        System.out.println("Selecciona el primer científico que deseas registrar");
        do {
            for(int i = 0; i < appLogic.getManageScientist().getScientistsRegistrationList().size(); i++) {
                System.out.println("( " +  (i + 1) + " ). " +
                        appLogic.getManageScientist().getScientistsRegistrationList().get(i).getName() + ", " +
                        appLogic.getManageScientist().getScientistsRegistrationList().get(i).getAge() + ", " +
                        appLogic.getManageScientist().getScientistsRegistrationList().get(i).getAddress()
                );
            }
            this.proyectOperation = kb.nextInt();
            if (proyectOperation < 1 || proyectOperation > appLogic.getManageScientist().getScientistsRegistrationList().size() + 1) {
                System.out.println("El valor seleccionado no es válido");
            }
        } while (proyectOperation < 1 || proyectOperation > appLogic.getManageScientist().getScientistsRegistrationList().size() + 1);

        System.out.println("¿Estás seguro en querer registrar a " + appLogic.getManageScientist().getScientistsRegistrationList().get(proyectOperation - 1).getName());
        System.out.println("SI(1), NO(2)");
        scientistOperation = kb.nextInt();
        if(scientistOperation == 1) {
            this.proyectsScientist = new ArrayList<>();
            proyectsScientist.add(appLogic.getManageScientist().getScientistsRegistrationList().get(proyectOperation - 1).getName());
        } else {
            insertOneScientist();
        }

        System.out.println("Selecciona el segundo científico que deseas registrar");
        do {
            this.proyectOperation = kb.nextInt();
            if (proyectOperation < 1 || proyectOperation > appLogic.getManageScientist().getScientistsRegistrationList().size() + 1) {
                System.out.println("El valor seleccionado no es válido");
            }
        } while (proyectOperation < 1 || proyectOperation > appLogic.getManageScientist().getScientistsRegistrationList().size() + 1);

        System.out.println("¿Estás seguro en querer registrar a " + appLogic.getManageScientist().getScientistsRegistrationList().get(proyectOperation - 1).getName());
        System.out.println("SI(1), NO(2)");
        scientistOperation = kb.nextInt();
        if(scientistOperation == 1) {
            proyectsScientist.add(appLogic.getManageScientist().getScientistsRegistrationList().get(proyectOperation - 1).getName());
        } else {
            insertOneScientist();
        }
    }

    public void insertThreeScientists() {
        insertTwoScientists();

        System.out.println("Selecciona el tercer científico que deseas registrar");
        do {
            this.proyectOperation = kb.nextInt();
            if (proyectOperation < 1 || proyectOperation > appLogic.getManageScientist().getScientistsRegistrationList().size() + 1) {
                System.out.println("El valor seleccionado no es válido");
            }
        } while (proyectOperation < 1 || proyectOperation > appLogic.getManageScientist().getScientistsRegistrationList().size() + 1);

        System.out.println("¿Estás seguro en querer registrar a " + appLogic.getManageScientist().getScientistsRegistrationList().get(proyectOperation - 1).getName());
        System.out.println("SI(1), NO(2)");
        scientistOperation= kb.nextInt();
        if(scientistOperation == 1) {
            proyectsScientist.add(appLogic.getManageScientist().getScientistsRegistrationList().get(proyectOperation - 1).getName());
        } else {
            insertOneScientist();
        }
    }
}
