import java.util.*;
public class Matriz{
    private int filas;
    private int columnas; 
    private String nombre;
    private Coordenada[][] datos; // Contenido de la matriz
    private Random Randomizar = new Random();

    public Matriz(String name, int fil, int col){
      this.nombre = name;
      if(fil <= 0){
        System.out.println("Valor erroneo, cambiando filas a 1...");
        fil = 1;
      }
      if(col <= 0){ 
        System.out.println("Valor erroneo, cambiando columnas a 1...");
        col = 1;
      }
      this.filas = fil;
      this.columnas = col;
      datos = new Coordenada[filas][columnas];
      //LLenado de arreglo
      for(int i = 0; i < fil; i++){
        for(int j = 0; j < col; j++){
          datos[i][j] = new Coordenada(1,1);
        }
      }
    }
    public Matriz(String name, int fil, int col, String orden){
      this.nombre = name;
      if(fil <= 0){
        System.out.println("Valor erroneo, cambiando filas a 1...");
        fil = 1;
      }
      if(col <= 0){ 
        System.out.println("Valor erroneo, cambiando columnas a 1...");
        col = 1;
      }
      this.filas = fil;
      this.columnas = col;
      datos = new Coordenada[fil][col];
      //llenado de arreglo
      this.LlenarOrden(orden, fil, col);

    }
    public Matriz(String name, int cuad, String orden){
      this.nombre = name;
      if(cuad <= 0){
        System.out.println("Valor erroneo, cambiando filas a 1...");
        cuad = 1;
      }
      this.filas = cuad;
      this.columnas = cuad;
      datos = new Coordenada[cuad][cuad];
      //llenado de arreglo
      this.LlenarOrden(orden, cuad, cuad);

    }
    public Matriz(String name, int cuad){
      this.nombre = name;
      if(cuad <= 0){
        System.out.println("Valor erroneo, cambiando filas a 1...");
        cuad = 1;
      }
      this.filas = cuad;
      this.columnas = cuad;
      datos = new Coordenada[cuad][cuad];
      //llenado de arreglo
      for(int i = 0; i < cuad; i++){
        for(int j = 0; j < cuad; j++){
          datos[i][j] = new Coordenada(1,1);
        }
      }

    }
    public Matriz(Matriz c){
      nombre = c.nombre;
      this.filas = c.filas;
      this.columnas = c.columnas;
      this.datos = new Coordenada[filas][columnas];
      for(int i = 0; i < filas; i++){
        for(int j = 0; j < columnas; j++){
          datos[i][j] = new Coordenada(c.datos[i][j]);
        }
      }
    }
    public Matriz(String name, Matriz c){
      nombre = name;
      this.filas = c.filas;
      this.columnas = c.columnas;
      this.datos = new Coordenada[filas][columnas];
      for(int i = 0; i < filas; i++){
        for(int j = 0; j < columnas; j++){
          datos[i][j] = new Coordenada(c.datos[i][j]);
        }
      }
    }
    public void cambiarNombre(String name){
      nombre = name;
    }
    private void LlenarOrden(String orden, int fil, int col){
      char ordenTipo = orden.charAt(0);
      String sem = "";
      for(int index = 1; index < orden.length(); index++) sem += ""+orden.charAt(index);
      int semilla = Integer.parseInt(sem);
      int i, j; 
      switch(ordenTipo){
        case 'R': 
          //Orden randomizado
          for(i = 0; i < fil; i++){
            for(j = 0; j < col; j++){
              datos[i][j] = new Coordenada((Randomizar.nextInt(semilla)+0.0),(0.0+Randomizar.nextInt(semilla)));
            }
          }
        break;
        case 'O':
          //Orden ascendente
          int toLimit = 1;
          for(i = 0; i < fil; i++){
            for(j = 0; j < col; j++){
              if(toLimit == semilla) toLimit = 1;
              datos[i][j] = new Coordenada( (toLimit+0.0), (toLimit+0.0));
              toLimit++;
            }
          }
        break;
      }
    }

    public void mostrar(){
      String fila = "";
      System.out.println("Matriz "+this.nombre+" en forma binomial");
      for (int i=0; i<this.columnas; i++) {
        for(int j=0; j<this.filas; j++) {
          System.out.print( this.datos[j][i]+" " );
        }
        System.out.print("\n");
      }
      System.out.println("\n");
    }

    public void mostrar(String tipo){
      String fila = "";
      System.out.println("Matriz "+this.nombre+" en forma '"+tipo+"'");
      for (int i=0; i<this.columnas; i++) {
        for(int j=0; j<this.filas; j++) {
          if(tipo == "binomio" || tipo != "polar")
            System.out.print( this.datos[j][i]+" " );
          if(tipo == "polar")
            System.out.print( this.datos[j][i].toPolar()+" " );
        }
        System.out.print("\n");
      }
      System.out.println("\n");
    }


    /////// CALCULOS


    public Matriz sumar(Matriz c){
        System.out.println("La suma de "+nombre+" y "+c.nombre);
      if (filas == c.filas && columnas == c.columnas) {
        for(int i = 0; i < filas; i++){
          for(int j = 0; j < columnas; j++){
            datos[i][j] = new Coordenada( datos[i][j].sumar(c.datos[i][j]) );
          }
        }
      }else{System.out.println("Las matrices no tienen la mismas dimensiones. La operacion no puede proceder.\n");}
      return this;
    }

    public Matriz sumar(Matriz c, Matriz b){
      //Matriz aux = new Matriz(c);
        System.out.println("La suma de "+c.nombre+" y "+b.nombre+"");
      if (b.filas == c.filas && b.columnas == c.columnas) {
        for(int i = 0; i < filas; i++){
          for(int j = 0; j < columnas; j++){
            this.datos[i][j] = new Coordenada( c.datos[i][j].sumar(b.datos[i][j]) );
          }
        }
      }else System.out.println("Las matrices no tienen la mismas dimensiones. La operacion no puede proceder.\n");
      return this;
    }

    public Matriz restar(Matriz c){
        System.out.println("La resta de "+nombre+" y "+c.nombre);
      if (this.filas == c.filas && this.columnas == c.columnas) {
        for(int i = 0; i < filas; i++){
          for(int j = 0; j < columnas; j++){
            datos[i][j] = new Coordenada( datos[i][j].restar(c.datos[i][j]) );
          }
        }
      }else System.out.println("Las matrices no tienen la mismas dimensiones. La operacion no puede proceder.\n");
      return this;
    }

    public Matriz restar(Matriz c, Matriz b){
      Matriz aux = new Matriz(c);
        System.out.println("La resta de "+c.nombre+" y "+b.nombre);
      if (b.filas == c.filas && b.columnas == c.columnas) {
        for(int i = 0; i < filas; i++){
          for(int j = 0; j < columnas; j++){
            this.datos[i][j] = new Coordenada( c.datos[i][j].restar(b.datos[i][j]) );
          }
        }
      }else System.out.println("Las matrices no tienen la mismas dimensiones. La operacion no puede proceder.\n");
      return this;
    }

    public Matriz multiplicar(Matriz c){
      System.out.println("La multiplicacion de "+this.nombre+" y "+c.nombre);
      if(columnas != c.filas){
        throw new RuntimeException("No se pueden multiplicar las matrices");
      }else{
        Matriz aux = new Matriz(this);
        this.datos = new Coordenada[c.filas][columnas];
        this.filas = c.filas;
        for (int i=0; i < filas; i++) {
          for (int j=0; j < columnas; j++) {
            for (int k=0; k<filas; k++) {
              this.datos[i][j] = new Coordenada( aux.datos[i][j].multiplicar(c.datos[i][j]) );
            }
          }
        }
      }
      return this;
    }

    public void calculos(){
      Coordenada max, min;
      Double suma, prom;
      suma = prom = 0.0;
      max = new Coordenada(0,0);
      min = new Coordenada(0,0);
      for (int i=0; i<filas;i++) {
        for (int j= 0; j<columnas;j++ ) {
          if(this.datos[i][j].comparar(max) == 1) max = new Coordenada(this.datos[i][j]);
          if(this.datos[i][j].comparar(min) == -1) min = new Coordenada(this.datos[i][j]);
          suma += Math.hypot( this.datos[i][j].x,this.datos[i][j].y );
        }
      }
      prom = suma/(filas*columnas);
      System.out.println("\nPromedio (de modulos): "+String.format("%.4f",prom)+"\nMaximo: "+max+"\nMinimo: "+min+"\n");
    }
////////////////
    public Matriz transpuesta(){
      System.out.println("Traspuesta de "+this.nombre);
      Matriz aux = new Matriz(this);
      columnas = aux.filas;
      filas = aux.columnas;
      this.datos = new Coordenada[filas][columnas];
      for (int i=0 ; i<filas ;i++ ) {
        for (int j=0; j<columnas; j++) {
          this.datos[i][j] = aux.datos[j][i];
        }
      }
      return this;
    }

    public void espiral(){
      int inicio = 0;
      int cont = 0;
      int flimit, climit;
      flimit=filas;
      climit=columnas;
      System.out.print("Espiral de "+this.nombre+"\n");
      while(cont <= columnas*filas-1){
        for (int i=inicio; i < flimit; i++){
          if(cont <= columnas*filas-1){
            System.out.print(""+this.datos[i][inicio]+" ");
            cont++;
          }
        }
        for (int i=inicio+1; i < climit; i++){
          if(cont <= columnas*filas-1){
            System.out.print(""+this.datos[climit][i]+" ");
            cont++;
          }
        }
        for (int i=flimit-2; i >= inicio; i--){
          if(cont <= columnas*filas-1){ 
            System.out.print(""+this.datos[i][flimit-2]+" ");
            cont++;
          }
        }
        for(int i=climit-2;i>=inicio+1;i--){
          if(cont <= columnas*filas-1){
            System.out.print(""+this.datos[inicio][i]+" ");
            cont++;
          }
        } 
        climit--; flimit--; inicio++;
      }
    }

    public boolean equals(Matriz c){
      if(columnas != c.columnas && filas != c.filas){
        return false;
      }else{
        for (int i=0; i<filas ; i++ ) {
          for (int j=0; j<columnas ;j++ ) {
            if(!datos[i][j].equals(c.datos[i][j])) return false;
          }
        }
      }
      return true;
    }

    public void establecer(int i, int j, Coordenada val){
      if(i <= filas && j <= columnas && j >= 0 && i >= 0){
        this.datos[i][j] = new Coordenada(val);
      }else System.out.println("Los valores "+i+" y "+j+" están fuera de rango");
    }

    public void establecer(int i, int j, int x, int y){
      if(i <= filas && j <= columnas && j >= 0 && i >= 0){
        this.datos[i][j] = new Coordenada(x, y);
      }else System.out.println("Los valores "+i+" y "+j+" están fuera de rango");
    }


}
