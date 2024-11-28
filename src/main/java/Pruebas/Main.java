package Pruebas;

import java.util.Scanner;

public class Main {

    // ALGORITMO 1

    public static void ParesOImpares() {

        // Utilizamos la clase Scanner para utilizar la instrucción LEER NUMERO
        Scanner leerNumero = new Scanner(System.in);
        System.out.println("Escriba un numero entero: ");
        int numero = leerNumero.nextInt();

        // Si es par, mediante un bucle for imprimimos los pares descendientes hasta 0
        if(numero % 2 == 0) {
            System.out.println("El numero introducido es par");
            for(int i = numero; i >= 0; i -= 2) {
                System.out.println(i);
            }
        } else { // Si es impar, se imprime lo mismo pero hasta el 1
            System.out.println("El numero introducido es impar");
            for(int i = numero; i >= 1; i -= 2) {
                System.out.println(i);
            }
        }

        // Por ultimo, cerramos el scanner
        leerNumero.close();
    }

    // ALGORITMO 2

    // Para resolver este problema hemos importado la clase Persona, creada en este mismo paquete.

    public static void ClasificarPersonas(int opcion) {

        // Variables resultado
        int mayor18 = 0;
        int menor18 = 0;
        int masc18 = 0;
        int femNo18 = 0;
        int mujeres = 0;

        // Vector que almacenará las 50 personas
        Persona[] personas = new Persona[50];

        // PARA FACILITAR LA CORRECCIÓN, SE PUEDE GENERAR UN ARRAY DE 50 PERSONAS CON VALORES ALEATORIOS

        if(opcion == 2) {
            Persona.Generar50Personas(personas);
        }
        else { // SINO SE INTRODUCEN LOS DATOS MANUALMENTE COMO DICE EL ENUNCIADO

            // Utilizamos la instrucción LEER PERSONA para introducir los datos
            Scanner leerPersona = new Scanner(System.in);
            for(int i = 0; i < 50; i++) {
                System.out.println("Introduzca la persona " + (i + 1) + ": ");
                System.out.println("Sexo M/F: ");
                String sexo = leerPersona.next();
                System.out.println("Edad: ");
                int edad = leerPersona.nextInt();

                personas[i] = new Persona(sexo, edad);
            }
            // Cerramos scanner
            leerPersona.close();
        }

        // Clasificamos las personas segun los criterios
        for(Persona persona : personas) {
            if(persona.getEdad() > 18) {
                mayor18++;
                if(persona.getSexo().equalsIgnoreCase("M")) {
                    masc18++;
                }
            } else {
                menor18++;
                if(persona.getSexo().equalsIgnoreCase("F")) {
                    femNo18++;
                }
            }
            if(persona.getSexo().equalsIgnoreCase("F")) {
                mujeres++;
            }
        }

        // Calculamos porcentajes
        double porcentajeHombresMayores = (double) mayor18/50 * 100;
        double porcentajeMujeres = (double) mujeres/50 * 100;

        System.out.println("\nResultados:");
        System.out.println("Cantidad de personas mayores de edad: " + mayor18);
        System.out.println("Cantidad de personas menores de edad: " + menor18);
        System.out.println("Cantidad de personas masculinas mayores de edad: " + masc18);
        System.out.println("Cantidad de personas femeninas menores de edad: " + femNo18);
        System.out.println("Porcentaje de personas mayores de edad: " + porcentajeHombresMayores + "%");
        System.out.println("Porcentaje de mujeres: " + porcentajeMujeres + "%");
    }

    // ALGORITMO 3

    public static void CalculoSalario() {

        // Variables resultado
        double salario;

        // Scanner para leer los datos
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("Introduzca las horas trabajadas: ");
        int horasTrabajadas = leerDatos.nextInt();
        System.out.println("Introduzca la tarifa por hora: ");
        double tarifa = leerDatos.nextDouble();

        // Calculo del salario
        if (horasTrabajadas > 40) {
            int horasExtras = horasTrabajadas - 40;
            salario = (40 * tarifa) + (horasExtras * (tarifa * 1.5));
        } else {
            salario = horasTrabajadas * tarifa;
        }

        System.out.println("El salario del trabajador es de: " + salario + "€");

        leerDatos.close();
    }

    // EJECUCIÓN DEL PROGRAMA PARA LA CORRECCIÓN

    public static void main(String[] args) {
        Scanner leerEjercicio = new Scanner(System.in);
        System.out.println("Que algoritmo desea corregir? (1, 2 o 3)");
        int ejercicio = leerEjercicio.nextInt();
        switch (ejercicio) {
            case 1:
                ParesOImpares();
                break;
            case 2:
                Scanner leerOpcion = new Scanner(System.in);
                System.out.println("Para facilitar la corrección: ");
                System.out.println("(1) Introducir datos manualmente/(2) Generar 50 personas aleatoriamente");
                int opcion = leerOpcion.nextInt();
                ClasificarPersonas(opcion);
                break;
            case 3:
                CalculoSalario();
        }
    }
}
