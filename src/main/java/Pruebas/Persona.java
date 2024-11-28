package Pruebas;

public class Persona {
    public String sexo;
    public int edad;

    public Persona() {
    }

    public Persona(String sexo, int edad) {
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // METODO USADO EN EL ALGORITMO 2 PARA PODER GENERAR UN ARRAY DE 50 PERSONAS
    public static Persona[] Generar50Personas(Persona[] personas) {
        for(int i = 0; i < 50; i++) {
            int aleatorio = (int) (Math.random() * 2);
            String sexo = (aleatorio == 0) ? "M" : "F";
            int edad = (int) (Math.random() * 90) + 1;
            personas[i] = new Persona(sexo, edad);
        }
        return personas;
    }
}
