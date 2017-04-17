import java.util.*;
 
public class LeerDatos{
    static Scanner consola = new Scanner(System.in);
     
    public static void main(String[] args){
        String Nombre;
        String Apellido;
        int edad;
        double peso;
        char tipoSangre;
         
        System.out.println("Ingresa tu nombre, apellido, " + "edad, peso, y tipo de sangre; "
                             + " separados por espacios ");
        Nombre = consola.next();
        Apellido = consola.next();
        edad = consola.nextInt();
        peso = consola.nextDouble();
        tipoSangre = consola.next().charAt(0);
         
        System.out.println("Nombre completo: " + Nombre + " " + Apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Peso: " + peso);
        System.out.println("Tipo de sangre: " + tipoSangre);
 
    }
}