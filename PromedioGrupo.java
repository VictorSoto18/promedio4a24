import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PromedioGrupo{

    // Declarando variables globales
    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;
    // Declaración de un arreglo de un TDA
    public static Alumno [] alumnos;

    public static void leerAlumnos() throws IOException {
        String matricula, nombre;
        System.out.println("Solicitud de información de cada estudiante");
        for ( int i = 0; i < alumnos.length; i++){
            System.out.println("--------------------------------------------");
            System.out.println("Escribe la  matricula");
            entrada = bufer.readLine();
            matricula = entrada;
            System.out.println("Escribe el nombre");
            entrada = bufer.readLine();
            nombre = entrada;
            //Creacion de un objeto Alumno (POJO)
            Alumno a = new Alumno(matricula, nombre);
            //Leyendo calificaciones
            System.out.println("Escribe calificacion de estructuras de datos");
            entrada = bufer.readLine();
            a.setEstructuras(Double.parseDouble(entrada));
            System.out.println("Escribe la calificacion de inglés: ");
            entrada = bufer.readLine();
            a.setIngles(Double.parseDouble(entrada));
            System.out.println("Escribe la calificación de IOT");
            entrada = bufer.readLine();
            a.setIot(Double.parseDouble(entrada));
            a.setPromedio();
            // Agregando un alumno al arreglo
            alumnos[i] = a;

        }
    }
    public static void imprimirAlumnos(){
        System.out.println("Contenido del arreglo Alumnos");
        for(Alumno a : alumnos){
            System.out.println("-----------------------------------------");
            System.out.println("Información del Alumno");
            System.out.println(a.toString());
        }
    }
    public static double calcularPromedio(){
        double suma = 0;
        for(Alumno a : alumnos){
            suma = suma + a.getPromedio();
        }
        return suma / alumnos.length;
    }

    public static void main(String[] args) throws IOException{
        int n; // tamaño de grupo
         double promedio; // el promedio del grupo

        System.out.println("Programa que calcula el promedio de un grupo");
        System.out.println("------------------------------------");
        // Recuperando el tamaño del grupo
        System.out.println("Escribe el número de alumnos de un grupo: ");
        entrada = bufer.readLine(); //Lectura de teclado
        n = Integer.parseInt(entrada); // Conversion de String a int

        // construir el arreglo alumnos
        alumnos = new Alumno[n];
        //Introducir información de los alumnos
        leerAlumnos();
        // Introducir información
        imprimirAlumnos();



        // Obtener el promedio
        promedio = calcularPromedio();

        System.out.println("-------------------------------------");
        System.out.println("El promedio del grupo es: " + promedio);

    }
}