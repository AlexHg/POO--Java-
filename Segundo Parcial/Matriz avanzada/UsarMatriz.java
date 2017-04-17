import java.util.*;
import java.lang.Math;
public class UsarMatriz{
  public static void main(String[] args){
    // Crea la matriz M1 de orden 3X3 (cuadrada) inicializando todos sus
    // elementos al valor de 1. El nombre de la matriz es "M1". 
    // Tanto la parte real como imaginaria de los complejos tienen el valor de 1
    Matriz M1 = new Matriz("M1",3);
    //Crea la matriz M2 de orden 3X4 (3 renglones y 4 columnas) 
    // e inicializa todos sus valores a 1. El nombre de la matriz es "M2". 
    // Tanto la parte real como imaginaria de los complejos tienen el valor de 1
    Matriz M2 = new Matriz("M2",3,4);  
    //Crea la matriz M3 de orden 3X2 (3 renglones y 2 columnas) 
    // e inicializa los valores objetos de la clase Complejo de forma aleatoria (Random) 
    // en el rango de 0 a 10: tanto la parte imaginaria como la real. 
    // EL valor "R10" es un String
    // El nombre de la matriz es "M3"
    Matriz M3 = new Matriz("M3",3,2,"R10");  
    //Crea la matriz M4 de orden 3X2 (3 renglones y 2 columnas) 
    // e inicializa los valores objetos de la clase Complejo de forma aleatoria (Random) 
    // en el rango de 0 a 50: tanto la parte imaginaria como la real. 
    // El nombre de la matriz es "M4" 
    Matriz M4 = new Matriz("M4",3,2,"R50");  
    // Crea la matriz M5 con las mismas características de M1
    // El nombre de la matriz es "M5" 
    Matriz M5 = new Matriz("M5",M1);       
    M1.mostrar("binomio");
    M2.mostrar("binomio");
    M3.mostrar("binomio");
    M4.mostrar("binomio");
    M5.mostrar("binomio");
    /* Despliega la matriz M1
    en pantalla, de la siguiente forma:
    Matriz M3:
        (1,1)  (1,1)  (1,1)
        (1,1)  (1,1)  (1,1)
        (1,1)  (1,1)  (1,1)
    */
    // Despliega la matriz M1 en pantalla, en representación polar, con un módulo (r) y un 
    // argumento (ángulo ) Ver figura.
    M1.mostrar("polar"); 
    M2.mostrar("polar"); 
    M3.mostrar("polar"); 
    M4.mostrar("polar"); 
    M5.mostrar("polar"); 
    /*
    Matriz M3:
        (1.4142,45) (1.4142,45) (1.4142,45)
        (1.4142,45) (1.4142,45) (1.4142,45)
        (1.4142,45) (1.4142,45) (1.4142,45)
    */
    //Establece la coordenada [1,1] de la matriz M3 al valor de (5,8), parte real=5; parte 
    // imaginaria= 8
    M3.establecer(1,1,5,8); 
    // Suma las matrices M3 y M4 ((siempre y cuando el orden de ambas matrices sea válido, de 
    // otra forma la operación no es realizada), el resultado queda en M3. 
    // La suma de matrices debe usar el método sumar de la clase Complejo
    // La operación matemática es: M3= M3 + M4 M3.sumar(M3,M4);
    // Suma las matrices M1 y M2, y el resultado queda en M2 (siempre y cuando el orden de ambas matrices sea válido, de otra forma la operación no es realizada).
    // La suma de matrices debe usar el método sumar de la clase Complejo
    // La operación matemática es: M1= M1 + M2
    M1.sumar(M2);
    //Suma la matriz M3 con M4, el resultado de esta suma queda en M3; a continuación se hace
    // la suma de M2 con M3, el resultado queda en M2
    // Equivalente a M2 = M2 + M3 + M4
    M2.sumar(M3.sumar(M4));
    // Hace la resta de M2 menos M1, dejando el resultado en M2 (siempre y cuando el orden de 
    // ambas matrices sea válido, de otra forma la operación no es realizada).
    // La resta de matrices debe usar el método restar de la clase Complejo
    // M2 = M2 - M1;
    M2.restar(M1);       
    //Se crea la matriz "M5" de 4 renglones por 3 columnas, inicializada con valores aleatorios
    // entre 1 y 80,  tanto para la parte real como para la parte imaginaria de los objetos 
    // Complejo
    Matriz M6 = new Matriz("M5", 4,3,"R80");
    //Se crea la matriz "M6" de 3 renglones por 4 columnas, inicializada con valores aleatorios
    // entre 1 y 100, tanto para la parte real como para la parte imaginaria de los objetos 
    // Complejo
    Matriz M7 = new Matriz("M6", 3,4,"R100");
    Matriz M8 = new Matriz("M8", 5, 4, "R12");
    // Realiza la multiplicación de M5 por M6; el resultado es asignado a la matriz MM
    // Esta operación debe revisarque el producto sea válido, es decir, el número de 
    // de columnas de la primera matriz (M5) debe coincidir con el número de renglones de la
    // segunda matriz (M6).  
    // La matriz resultante tiene el orden de los renglones de M1 por las columnas de M2, esto es 
    // 4X4 
    Matriz MM = new Matriz("MM",M6.multiplicar(M7));
    M6.mostrar();
    M7.mostrar();
    MM.mostrar();
    MM.mostrar("polar");
    // Se obtiene la matriz transpuesta de M3. Por lo tanto, la matriz M3 queda modificada: se
    // convierte en la matriz transpuesta de sí misma. 
    // Nota: no es válido imprimir la matriz invirtiendo las columnas por los renglones, la
    // matriz debe quedar modificada como su propia matriz transpuesta
    M3.mostrar();
    M3.transpuesta(); 
    M3.mostrar();
    // Imprime cálculos: el valor máximo, el valor mínimo, el promedio, y la moda, 
    M4.calculos();

    M8.mostrar("binomio");
    M8.mostrar("polar");
    M8.espiral();
    // El método equals prueba si dos matrices son iguales tanto en orden como en contenido
    // Devuelve el valor true si son iguales, devuelve el valor false en casocontrario.
    boolean b = M2.equals(M3);           
    if (b) 
         System.out.println("\n\nM2 es igual que M3");
    else
        System.out.println("\n\nM2 no es igual a M3");
  }
}
