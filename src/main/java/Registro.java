import java.util.InputMismatchException;
import java.util.Scanner;




public class Registro {
    public static void main(String[] args) {
        String [][] registro = new String[50][3];

             menu(registro);


    }
    public static void menu(String[][] registro){
        int decision =0;
        while (decision<1 || decision>6){
            printMenu();
            decision=tomarDecision();
        }
        switcHMenu(decision,registro);
    }

    private static void printMenu() {
        System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6) Salir.
                """);
    }

    private static void switcHMenu(int decision, String[][] registro) {
        switch (decision){
            case 1:
                agregarPersona(registro);
                break;
            case 2:
                mayoresEdad(registro);
                break;
            case 3:
                menoresEdad(registro);
                break;
            case 4:
                terceraEdad(registro);
                break;
            case 5:
                estadoCivil(registro);
                break;
            case 6:
                break;
        }
    }
    public static void agregarPersona(String[][] registro){
        if(hayCupo(registro)) {

            String nombre=ingresarNombre();
            String Estadocivil=ingresarEstadoCivil();
            int edad=ingresarEdad();

            int indiceDisponible = obtenerUltimoEspacio(registro);
            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = Estadocivil;
            registro[indiceDisponible][2] = String.valueOf(edad);
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
    }

    public static String ingresarEstadoCivil(){
        String Estadocivil="";
        while(!Estadocivil.toLowerCase().equals("casado") && !Estadocivil.toLowerCase().equals("casada") && !Estadocivil.toLowerCase().equals("soltero") && !Estadocivil.toLowerCase().equals("soltera")) {
            try {
                System.out.println("ingrese el estado civil solo se acepta casado y soltero");
                Estadocivil = new Scanner(System.in).nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
                continue;
            }
        }
        return Estadocivil;
    }
    private static int ingresarEdad() {
        int edad=0;
        while(true) {
            try {
                System.out.println("ingrese la edad");
                edad = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
                continue;
            }
            break;
        }
        return edad;
    }

    private static String ingresarNombre() {
        String nombre="";
        while(true) {
            try {
                System.out.println("ingrese el nombre");
                nombre = new Scanner(System.in).nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
                continue;
            }
            break;
        }
        return  nombre;
    }
    private static int tomarDecision() {
        Scanner t = new Scanner(System.in);
        int retorno=0;
        try {
            retorno=t.nextInt();
            if (retorno>6 || retorno<1){
                System.err.println("dentro del rango, porfavor");
            }
        }catch (InputMismatchException e){
            System.err.println("Solo numeros");
        }
        return retorno;
    }
    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - espaciosDisponibles(registro);
    }
    public static boolean hayCupo(String [][] registro) {
        return espaciosDisponibles(registro) != 0;
    }
    public static int espaciosDisponibles(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0]==null){
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
