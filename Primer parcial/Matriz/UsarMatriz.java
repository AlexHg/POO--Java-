import java.util.*;
public class UsarMatriz{
	public static class Matriz{
		private int filas;
		private int columnas;	
		private String nombre;
		private int[][] datos; // Contenido de la matriz
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
			datos = new int[filas][columnas];
			//LLenado de arreglo
			for(int i = 0; i < fil; i++){
				for(int j = 0; j < col; j++){
					datos[i][j] = 1;
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
			datos = new int[fil][col];
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
			datos = new int[cuad][cuad];
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
			datos = new int[cuad][cuad];
			//llenado de arreglo
			for(int i = 0; i < cuad; i++){
				for(int j = 0; j < cuad; j++){
					datos[i][j] = 1;
				}
			}

		}
		public Matriz(Matriz c){
			nombre = c.nombre;
			this.filas = c.filas;
			this.columnas = c.columnas;
			this.datos = new int[filas][columnas];
			for(int i = 0; i < filas; i++){
				for(int j = 0; j < columnas; j++){
					datos[i][j] = c.datos[i][j];
				}
			}
		}
		public Matriz(String name, Matriz c){
			nombre = name;
			this.filas = c.filas;
			this.columnas = c.columnas;
			this.datos = new int[filas][columnas];
			for(int i = 0; i < filas; i++){
				for(int j = 0; j < columnas; j++){
					datos[i][j] = c.datos[i][j];
				}
			}
		}

		public void cambiarNombre(String name){
			nombre = name;
		}

		public void imprimir(){
			String fila = "";
			System.out.println("Matriz "+this.nombre);
			for (int i=0; i<this.columnas; i++) {
				for(int j=0; j<this.filas; j++) {
					System.out.print( this.datos[j][i]+" " );
				}
				System.out.print("\n");
			}
			System.out.println("\n");
		}

		public Matriz sumar(Matriz c){
				System.out.println("La suma de "+nombre+" y "+c.nombre);
			if (filas == c.filas && columnas == c.columnas) {
				for(int i = 0; i < filas; i++){
					for(int j = 0; j < columnas; j++){
						datos[i][j] += c.datos[i][j];
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
						this.datos[i][j] = c.datos[i][j] + b.datos[i][j];
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
						datos[i][j] -= c.datos[i][j];
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
						this.datos[i][j] = aux.datos[i][j] - b.datos[i][j];
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
				this.datos = new int[c.filas][columnas];
				this.filas = c.filas;
				for (int i=0; i < filas; i++) {
      				for (int j=0; j < columnas; j++) {
        				for (int k=0; k<filas; k++) {
          					this.datos[i][j] += aux.datos[i][j]*c.datos[i][j]; 
        				}
      				}
    			}
			}
			return this;
		}

		public Matriz transpuesta(){
			System.out.println("Traspuesta de "+this.nombre);
			Matriz aux = new Matriz(this);
			columnas = aux.filas;
			filas = aux.columnas;
			this.datos = new int[filas][columnas];
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

		public void calculos(){
			int max, min, suma, prom;
			max = min = suma = prom = 0;
			for (int i=0; i<filas;i++) {
				for (int j= 0; j<columnas;j++ ) {
					if(this.datos[i][j] > max) max = this.datos[i][j];
					if(this.datos[i][j] < min) min = this.datos[i][j];
					suma += this.datos[i][j];
				}
			}
			prom = suma/(filas*columnas);
			System.out.println("\nPromedio: "+prom+"\nMaximo: "+max+"\nMinimo: "+min+"\n");
		}

		public boolean equals(Matriz c){
			if(columnas != c.columnas && filas != c.filas){
				return false;
			}else{
				for (int i=0; i<filas ; i++ ) {
					for (int j=0; j<columnas ;j++ ) {
						if(datos[i][j] != c.datos[i][j]) return false;
					}
				}
			}
			return true;
		}

		public void establecer(int i, int j, int val){
			if(i <= filas && j <= columnas && j >= 0 && i >= 0){
				this.datos[i][j] = val;
			}else System.out.println("Los valores "+i+" y "+j+" están fuera de rango");
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
							datos[i][j] = Randomizar.nextInt(semilla);
						}
					}
				break;
				case 'O':
					//Orden ascendente
					int toLimit = 1;
					for(i = 0; i < fil; i++){
						for(j = 0; j < col; j++){
							if(toLimit == semilla) toLimit = 1;
							datos[i][j] = toLimit;
							toLimit++;
						}
					}
				break;
			}
		}
	}

	public static void main(String[] args){
		Matriz M1 = new Matriz("M1",3); 
		M1.imprimir(); 
		Matriz M2 = new Matriz("M2",3,2); 
		M2.imprimir();  
		Matriz M3 = new Matriz("M3",3,2,"R10");  
		M3.imprimir(); 
		Matriz M4 = new Matriz("M4",3,2,"R10"); 
		M4.imprimir();  
		Matriz M5 = new Matriz("M5",M3);        
		M5.imprimir();
		M3.sumar(M3,M4); 
		M3.imprimir(); 
		M1.sumar(M2); 
		M1.imprimir();
		M2.sumar(M3.sumar(M4)); 
		M3.imprimir();
		M2.imprimir();
		M2.restar(M1);
		M2.imprimir();        
		Matriz M6 = new Matriz("M5", 4,3); 
		M6.imprimir();
		Matriz M7 = new Matriz("M6", 3,4); 
		M7.imprimir();
		Matriz MM = M6.multiplicar(M7);
		MM.imprimir();
		M3.imprimir();
		M3.transpuesta();  
		M3.imprimir();
		Matriz M8 = new Matriz("M8", 5, 4, "R10");
		M8.imprimir();
		M8.espiral();
		M8.calculos(); 
		boolean b = M2.equals(M3); 
		M2.imprimir(); M3.imprimir();           
		if (b)  
		     System.out.println("M2 es igual que M3"); 
		else 
		    System.out.println("M2 no es igual a M3"); 
	}
}
