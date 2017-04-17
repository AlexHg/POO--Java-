import java.util.*;
public class Geometria{

  public static void main(String[] args) {
    //Primer cuadrante
    Rectangulo R1 = new Rectangulo("R1", new Punto("A1", 3, 2), new Punto("A2", 7, 4));
    Rectangulo R2 = new Rectangulo("R2", new Punto("B1", 5, 3), new Punto("B2", 10, 7));
    //Segundo Cuadrante
    Rectangulo R3 = new Rectangulo("R3", new Punto("C1", -3, 8), new Punto("C2", -9, 2));
    Rectangulo R4 = new Rectangulo("R4", new Punto("D1", -4, 6), new Punto("D2", -7, 4));
    //Tercer Cuadrante
    Rectangulo R5 = new Rectangulo("R5", new Punto("E1", -3, -2), new Punto("E2", -7, -5));
    Rectangulo R6 = new Rectangulo("R6", new Punto("F1", -4, -3), new Punto("F2", -6, -7));
    //Cuarto Cuadrante
    Rectangulo R7 = new Rectangulo("R7", new Punto("G1", 5, -3), new Punto("G2", 2, -6));
    Rectangulo R8 = new Rectangulo("R8", new Punto("H1", 8, -4), new Punto("H2", 4, -8));

    System.out.println(R1);
    System.out.println(R2);

    Punto Punto32 = new Punto( 4, 3);
    if( R1.contains( Punto32 ) ) System.out.println(R1+" si contiene el punto "+Punto32+"\n");
    else System.out.println(R2+" no contiene el punto "+Punto32+"\n");

    if( R1.comparar(R2) == 0 ) System.out.println("Las areas son iguales\n");
    else if(R1.comparar(R2) == 1) System.out.println("R1 es de mayor de area que R2\n");
    else System.out.println("R1 es de menor area que R2\n");

    Rectangulo R1i2 = new Rectangulo(R1.Interseccion(R2));
    System.out.println("\nInterseccion de "+R1+" y "+R2);
    System.out.println(R1i2+"\n");

    Rectangulo R1u2 = new Rectangulo(R1.Union(R2));
    System.out.println("\nUnion de "+R1+" y "+R2);
    System.out.println(R1u2+"\n");

    Rectangulo R3i4 = new Rectangulo(R3.Interseccion(R4));
    System.out.println("\nInterseccion de "+R3+" y "+R4);
    System.out.println(R3i4+"\n");

    Rectangulo R3u4 = new Rectangulo(R3.Union(R4));
    System.out.println("\nUnion de "+R3+" y "+R4);
    System.out.println(R3u4+"\n");

    Rectangulo R5i6 = new Rectangulo(R5.Interseccion(R6));
    System.out.println("\nInterseccion de "+R5+" y "+R6);
    System.out.println(R5i6+"\n");

    Rectangulo R5u6 = new Rectangulo(R5.Union(R6));
    System.out.println("\nUnion de "+R5+" y "+R6);
    System.out.println(R5u6+"\n");

    Rectangulo R7i8 = new Rectangulo(R7.Interseccion(R8));
    System.out.println("\nInterseccion de "+R7+" y "+R8);
    System.out.println(R7i8+"\n");

    Rectangulo R7u8 = new Rectangulo(R7.Union(R8));
    System.out.println("\nUnion de "+R7+" y "+R8);
    System.out.println(R7u8+"\n");

  }
}
