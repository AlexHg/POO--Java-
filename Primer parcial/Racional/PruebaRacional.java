//package PruebaRacional;
/**
 * @author alexx
 */
import java.util.*;
public class PruebaRacional {

    /**
     * @param args the command line arguments
     */
    public static class Racional implements Comparable<Racional>{
        private int numerador;
        private int denominador;

        /*Inicio Contructores. NOTA: Los costructores siempre tendran el nombre de la clase*/
        public Racional(){
            Random Randomizar = new Random();
            //Primer caso de inicializacion.
            this.numerador = Randomizar.nextInt(9)+1;
            this.denominador = Randomizar.nextInt(9)+1;
            /*if(this.numerador == this.denominador){
                if(this.denominador == 1)this.denominador += 1;
                else this.denominador -= 1;
            }
            if(this.denominador >= 0) this.denominador += 1;*/
            if(this.denominador == 0) this.denominador = 1;
            this.simplificar();
        }
        public Racional(int n, int d){
            //Segundo caso de inicializacion.
            this.numerador = n;
            if(d == 0){
               d = 1;
           } 
            this.denominador = d;
        }
        public Racional(Racional R){
            //Tercer caso de inicializacion.
            this.numerador = R.numerador;
            this.denominador = R.denominador;
            this.simplificar();
        }

        public Racional(int n){
            //Cuarto caso de inicializacion.
            this.numerador = n;
            this.denominador = 1;
        }
        /*Final Constructores*/
    
        /* ~Inicio de función~ Establecer despues de haber sido definido*/
        public void establecer(int numerador, int denominador){
           this.numerador = numerador; //El primer numerador toma el valor del segundo contenido en esta funcion
           if(denominador == 0){
               denominador = 1;
           } 
           this.denominador = denominador;  
           this.simplificar();         
        }

        public void establecer(Racional R){
           this.numerador = R.numerador; //El primer numerador toma el valor del segundo contenido en esta funcion
           if(R.denominador == 0){
               R.denominador = 1;
           } 
           this.denominador = R.denominador;
           this.simplificar();         
        }
        /* ~Final de función~ Establecer despues de haber sido definido*/

         /* ~Inicio de función~ Comparar 2 racionales */
        public boolean comparar(Racional R){
            //Comparar racionales
            boolean result = this.equals(R);
            if(result){
                System.out.println("Los dos numeros racionales son iguales: ["+this.numerador+","+this.denominador+"]");
            }else{
                System.out.println("Los dos numeros racionales son diferentes: ["+this.numerador+","+this.denominador+"] & ["+R.numerador+","+R.denominador+"]");
            }
            return result;
        }
        /* ~Final de función~ Comparar 2 racionales */

        /*Inicio sobrecarga Multiplicar*/
        public Racional multiplicar(Racional R){
            //Multiplicar por otro racional
            this.numerador *= R.numerador;
            this.denominador *= R.denominador;
            this.simplificar();
            return this;
        }

        public Racional multiplicar(Racional R, Racional S){
            //Multiplicar dos racionales e igualarlos
            this.numerador = R.numerador * S.numerador;
            this.denominador = R.denominador * S.denominador;
            this.simplificar();
            return this;
        }

        public Racional multiplicar(int numerador){
            //Multiplicar por enteros (num/1) ingresados como enteros.
            this.numerador *= numerador;
            this.denominador *= 1;
            this.simplificar();
            return this;
        }

        public Racional multiplicar(int numerador, int denominador){
            //Multiplicar por numerador y denominador ingresados como enteros.
            this.numerador *= numerador;
            this.denominador *= denominador;
            this.simplificar();
            return this;
        }
        /*Fin sobrecarga Multiplicar*/

        /*Inicio sobrecarga Dividir*/
         public Racional dividir(Racional R){
            //Dividir por otro racional
            this.numerador *= R.denominador;
            this.denominador *= R.numerador;
            this.simplificar();
            return this;
        }

        public Racional dividir(Racional R, Racional S){
            //Dividir dos racionales e igualarlos
            this.numerador = R.denominador * S.numerador;
            this.denominador = R.numerador * S.denominador;
            this.simplificar();
            return this;
        }

        public Racional dividir(int numerador){
            //Dividir por enteros (num/1) ingresados como enteros.
            this.numerador *= 1;
            this.denominador *= numerador;
            this.simplificar();
            return this;
        }

        public Racional dividir(int numerador, int denominador){
            //Dividir por numerador y denominador ingresados como enteros.
            this.numerador *= denominador;
            this.denominador *= numerador;
            this.simplificar();
            return this;
        }
        /*Fin sobrecarga Dividir*/

        /*Inicio sobrecarga Suma*/
        public Racional adicionar(Racional S){
            //Sumar con un racional ingresado
            Racional R = new Racional();
            R.establecer(S);

            if(this.denominador != R.denominador){
                Racional aux = new Racional();
                aux.establecer(this);
                this.numerador *= R.denominador;
                R.numerador *= aux.denominador;
                this.denominador *= R.denominador;
            }
            this.numerador += R.numerador;
            this.simplificar();
            return this;
        }

        public Racional adicionar(Racional R, Racional S){
            //Sumar con dos racionales ingresados
            this.adicionar(R.adicionar(S));
            this.simplificar();
            return this;
        }

        public Racional adicionar(int numerador){
            //Sumar con un entero
            numerador *= this.denominador;
            this.numerador += numerador;
            this.simplificar();
            return this;
        }

        public Racional adicionar(int numerador, int denominador){
            //Sumar con un racional ingresado por enteros
            if(this.denominador != denominador){
                Racional aux = new Racional();
                aux.establecer(this);
                this.numerador *= denominador;
                numerador *= aux.denominador;
                this.denominador *= denominador;
            }
            this.numerador += numerador;
            this.simplificar();
            return this;
        }
        /*Fin sobrecarga Suma*/

        /*Inicio sobrecarga Resta*/
        public Racional sustraer(Racional S){
             //Sumar con un racional ingresado
            Racional R = new Racional();
            R.establecer(S);

            if(this.denominador != R.denominador){
                Racional aux = new Racional();
                aux.establecer(this);
                this.numerador *= R.denominador;
                R.numerador *= aux.denominador;
                this.denominador *= R.denominador;
            }
            this.numerador -= R.numerador;
            this.simplificar();
            return this;
        }
        public Racional sustraer(Racional R, Racional S){
            //Restar con dos racionales ingresados
            this.sustraer(R.sustraer(S));
            this.simplificar();
            return this;

        }
        public Racional sustraer(int numerador){
            //Restar con un entero
            numerador *= this.denominador;
            this.numerador -= numerador;
            this.simplificar();
            return this;
        }

        public Racional sustraer(int numerador, int denominador){
            //Restar con un racional ingresado por enteros
            
            if(this.denominador != denominador){
                Racional aux = new Racional();
                aux.establecer(this);
                this.numerador *= denominador;
                numerador *= aux.denominador;
                this.denominador *= denominador;
            }
            this.numerador -= numerador;
            this.simplificar();
            return this;
        }
        /*Fin sobrecarga Resta*/

        /* ~Inicio de función~ Imprimir un racional en terminal*/  
        public void imprimir(){
            //Imprimir racional
            System.out.println("["+this.numerador+","+this.denominador+"]");
        }
        /* ~Final de función~ Imprimir un racional en terminal*/   
        
        /* ~Inicio~ Sobrecarga de metodos de los objetos de la API de Java*/
        public String toString(){
            //Segundo metodo para imprimir usando System.out.println(R);
            if(denominador == 1){
                return "-> "+numerador;    
            }
            else return "-> "+numerador+"/"+denominador;
        }

        public boolean equals(Object O){
            //Compara dos racionales y retorna un True si son iguales, False si no
            if(O instanceof Racional){
                Racional aux = (Racional) O; // Downcasting: Forzamiento hacia abajo
                if(this.numerador*aux.denominador == aux.numerador*this.denominador) return true;
                else return false;
            }
            return false;
        }
        @Override
        public int compareTo(Racional o) {
            float compareOne, compareTwo;
            compareOne = numerador/denominador;
            compareTwo = o.numerador/o.denominador;
            if (compareOne < compareTwo) {
                return -1;
            }
            if (compareOne > compareTwo) {
                return 1;
            }
            return 0;
        }
        public void finalize(){
            //this.imprimir();
            /* RECOLECTOR DE BASURA */
            this.numerador = 0;
            this.denominador = 0;
            System.out.println("Acabas de limpiar memoria");

        }
        /* ~Final~ Sobrecarga de metodos de los objetos de la API de Java*/

        /* .... METODOS PRIVADOS .... */
        /* Inicio metodo "SIMPLIFICAR" */
        private Racional simplificar(){
            //Toma como referencia los primeros numeros primos 
            if( (this.numerador%2)==0 && (this.denominador%2)==0){
                this.numerador /= 2;
                this.denominador /= 2;
                this.simplificar(); //Metodo recursivo
            }else if( (this.numerador%3)==0 && (this.denominador%3)==0 ){
                this.numerador /= 3;
                this.denominador /= 3;
                this.simplificar(); //Metodo recursivo
            }else if( (this.numerador%5)==0 && (this.denominador%5)==0 ){
                this.numerador /= 5;
                this.denominador /= 5;
                this.simplificar(); //Metodo recursivo
            }
            else if( (this.numerador%7)==0 && (this.denominador%7)==0 ){
                this.numerador /= 7;
                this.denominador /= 7;
                this.simplificar(); //Metodo recursivo
            }
            else if( (this.numerador%11)==0 && (this.denominador%11)==0 ){
                this.numerador /= 11;
                this.denominador /= 11;
                this.simplificar(); //Metodo recursivo
            }
            return this;
        }

    }
    public static void compareArrayList(ArrayList<Racional> e, ArrayList<Racional> o){
        int i = 0;
        for(Racional aux : o){
            if(e.contains(aux)) i++;
        }
        if(e.size()==i) System.out.println("Los arrayList son identicos");
        else System.out.println("Los arrayList no son los mismos. Nivel de coinsidencia: "+i+" de "+e.size()+"");
    }
    public static void imprimir(ArrayList<Racional> grupo){
        int i = -1;
        for(Racional aux : grupo){
            i++;
            System.out.println("["+i+"]"+aux);
        }
        System.out.println(" ");
    }
    public static void imprimir(Racional[] grupo){
        int i = -1;
        for(Racional aux : grupo){
            i++;
            System.out.println("["+i+"]"+aux);
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {

         long heap = Runtime.getRuntime().totalMemory();    
        long heapMax = Runtime.getRuntime().maxMemory();
        long heapFree = Runtime.getRuntime().freeMemory();
        System.out.println(""+heap+"   "+heapMax+"   "+heapFree+"");
        System.gc();

        ArrayList<Racional> grupo = new ArrayList<Racional>(); //CREA UNA ESTRUCTURA LISTA DINAMICA
        ArrayList<Racional> grupo2 = new ArrayList<Racional>();
        Racional x; //Un racional cualquiera
        Racional[] arrayRacional = new Racional[5]; // Crea un array 
        Racional[] arrayRacionalDos = new Racional[5]; //Segundo array
        int i = -1;
        grupo.add(new Racional());
        grupo.add(new Racional(1,5));
        grupo.add(new Racional(4));
        grupo.add(new Racional( grupo.get(0) ));
        grupo.add(new Racional(5,1));

        arrayRacional[0] = new Racional();
        arrayRacional[1] = new Racional(3,5);
        arrayRacional[2] = new Racional(6);
        arrayRacional[3] = new Racional();
        arrayRacional[4] = new Racional(2,1);

        System.out.println("CON ARRAYLIST");

        //For each o for 'mejorado'
        imprimir(grupo);

        grupo.get(0).adicionar( grupo.get(1) ); //Sumarle [1] a [0] 
        grupo.get(1).sustraer(2); //Quitarle 5 enteros a [1]
        grupo.get(3).multiplicar(2);
        imprimir(grupo);

        grupo.get(1).adicionar(2); //Adicionarle 5 enteros a [1]
        grupo.get(2).sustraer(1,2); //Quitarle 1/2 a [2]
        grupo.get(3).multiplicar(grupo.get(4));
        grupo.get(0).dividir(grupo.get(4));
        
        x = grupo.get(3); //X toma el valor de [3] con el operador '='
        grupo.add(x); //Agregamos x a la lista
        x = null;
        System.gc();

        imprimir(grupo);
        System.out.println("Orden Creciente");
        Collections.sort(grupo);
        imprimir(grupo);

        System.out.println("Orden Dereciente");
        Collections.sort(grupo, Collections.reverseOrder());
        imprimir(grupo);

        System.out.println("CON ARRAY COMUN");
        imprimir(arrayRacional);
        arrayRacional[0].adicionar(arrayRacional[1]);
        imprimir(arrayRacional);
        arrayRacional[1].sustraer(3);
        imprimir(arrayRacional);
        arrayRacional[2].multiplicar(arrayRacional[0]);
        imprimir(arrayRacional);
        arrayRacional[3].dividir(2);
        imprimir(arrayRacional);
        arrayRacional[4].adicionar(1);

        imprimir(arrayRacional);

        System.out.println("Orden Creciente");
        Arrays.sort(arrayRacional);
        imprimir(arrayRacional);

        System.out.println("Orden Dereciente");
        Arrays.sort(arrayRacional, Collections.reverseOrder());
        imprimir(arrayRacional);

        System.out.println("SEGUNDO ARRAY Y ARRAYLIST");
        grupo2.add(new Racional());
        grupo2.add(new Racional());
        grupo2.add(new Racional());
        grupo2.add(new Racional());
        grupo2.add(new Racional());
        grupo2.add(new Racional());

        System.out.println("Maximos y minimos.\nArrayList1 \n   Maximo: "+Collections.max(grupo, null)+"\n   Minimo: "+Collections.min(grupo,null)+"\nArrayList2 \n   Maximo: "+Collections.max(grupo2, null)+"\n   Minimo: "+Collections.min(grupo2,null)+"");

        compareArrayList(grupo, grupo2);

        heap = Runtime.getRuntime().totalMemory();    
        heapMax = Runtime.getRuntime().maxMemory();
        heapFree = Runtime.getRuntime().freeMemory();
        System.out.println(""+heap+"   "+heapMax+"   "+heapFree+"");
        heap = Runtime.getRuntime().totalMemory();    
        heapMax = Runtime.getRuntime().maxMemory();
        heapFree = Runtime.getRuntime().freeMemory();
        System.out.println(""+heap+"   "+heapMax+"   "+heapFree+"");
    }
    
}
