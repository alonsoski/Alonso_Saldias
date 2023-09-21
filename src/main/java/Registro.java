import java.util.InputMismatchException;
import java.util.Scanner;




public class Registro {
    public static void main(String[] args) {
        String [][] registro = new String[50][3];
        int a = -1;




        do {
            System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);




            do {
                try {
                    a = new Scanner(System.in).nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                }
            }while (a < 0 || a > 6);




            if(a == 1) {
                if(hayCupo(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String Estadocivil;
                    int edad;




                    while(true) {
                        try {
                            nombre = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            Estadocivil = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            edad = new Scanner(System.in).nextInt();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = String.valueOf(edad);
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
            } else if(a == 2) {
                int mayoresDeEdad = 0;

                for (int i = 0; i < registro.length; i++) {

                    if (Integer.parseInt(registro[i][2]) >= 18){
                        mayoresDeEdad++;
                    }
                }
                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if(a == 3) {
                int menoresDeEdad = 0;
                int cantidadRegistrados = obtenerUltimoEspacio(registro);




                for (int i = 0; i < cantidadRegistrados; i++) {
                    if (Integer.parseInt(registro[i][2]) < 18) {
                        menoresDeEdad++;
                    }
                }




                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if(a == 4) {
                int terceraEdad = 0;




                for (int i = 0; i < registro.length; i++) {

                    if (Integer.parseInt(registro[i][2]) >= 60){
                        terceraEdad++;
                    }
                }
                System.out.println("Hay " + terceraEdad + " personas de tercera edad");
            } else if(a == 5) {
                int c = 0;
                int d = 0;
                for(int i = 0; i < registro.length; i++) {
                    if(registro[i][1].equals("casado/a")) {
                        c++;
                    } else if(registro[i][1].equals("soltero/a")) {
                        d++;
                    }
                }




                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
            } else if(a == 6) {
                System.out.println("Programa finalizado");
            }
        }while (a == 6);
    }




    public static int obtenerUltimoEspacio(String [][] registro)
    {
        return registro.length - espaciosDisponibles(registro);
    }




    public static boolean hayCupo(String [][] registro) {
        return espaciosDisponibles(registro) != 0;
    }


    public static int espaciosDisponibles(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0] == null){
                return registro.length - i;
            }
        }




        return 0;
    }

    public static int mayoresEdad(String[][] registro){

        int mayoresDeEdad = 0;

        for (int i = 0; i < registro.length; i++) {

            if (Integer.parseInt(registro[i][2]) >= 18){
                mayoresDeEdad++;
            }
        }

        return mayoresDeEdad;
    }

    public static int menoresEdad(String[][] registro){

        int menoresDeEdad = 0;
        int cantidadRegistrados = obtenerUltimoEspacio(registro);

        for (int i = 0; i < cantidadRegistrados; i++) {
            if (Integer.parseInt(registro[i][2]) < 18) {
                menoresDeEdad++;
            }
        }

        return menoresDeEdad;
    }

    public static int terceraEdad(String[][] registro){

        int terceraEdad = 0;

        for (int i = 0; i < registro.length; i++) {

            if (Integer.parseInt(registro[i][2]) >= 60){
                terceraEdad++;
            }
        }

        return terceraEdad;
    }

    public static void estadoCivil(String[][] registro){

        int casados = 0;
        int solteros = 0;
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][1].equalsIgnoreCase("casada") || registro[i][1].equalsIgnoreCase("casado")) {
                casados++;
            } else if(registro[i][1].equalsIgnoreCase("soltera") || registro[i][1].equalsIgnoreCase("soltero")) {
                solteros++;
            }
        }

        System.out.println("Hay " + casados + " casados/as.");
        System.out.println("Hay " + solteros + " solteros/as.");

    }
}
