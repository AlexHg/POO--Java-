import java.util.*;
public class UsuarioAlumno{
	private static Scanner enter = new Scanner(System.in);

	public static class Alumno implements Comparable<Alumno>{
		public static int cont = 0;
		private String nombre;
		private String boleta;
		private int edad = 0;
		private double promedio = 0.0;
		private double peso = 0.0;
		private double talla = 0.0;

		//Contructores de la clase Alumno
		public Alumno(){
			Alumno.cont++;
		}

		public Alumno(String nom){
			if(checkNom(nom)){
				nombre = nom;
				Alumno.cont++;
			}else{
				System.out.print("El nombre ingresado no es valido\n\n");
			}
		}

		public Alumno(String nom, String id){
			if(checkNom(nom)){
				nombre = nom;
				boleta = id;
				Alumno.cont++;
			}else{
				System.out.print("El nombre ingresado no es valido\n\n");
			}
		}

		public Alumno(String nom, String id, int edad, double promedio, double peso, double talla){
			if(checkNom(nom)){
				this.nombre = nom;
				this.boleta = id;
				this.edad = edad;
				this.promedio = promedio;
				this.peso = peso;
				this.talla = talla;
				Alumno.cont++;
			}else{
				System.out.print("El nombre ingresado no es valido\n\n");
			}
		}

		public Alumno(Alumno B){
			if(checkNom(B.nombre)){
				this.nombre = B.nombre;
				this.boleta = B.boleta;
				this.edad = B.edad;
				this.peso = B.peso;
				this.talla = B.talla;
				Alumno.cont++;
			}else{
				System.out.print("El nombre ingresado no es valido\n\n");
			}
		}

		private boolean checkNom(String nom){
			for(int i = 0; i < nom.length(); i++){
				if(Character.isLetter(nom.charAt(i))) continue; 
				else if(nom.charAt(i) == ' ') continue; 
				else return false; 
			}
			return true;
		}

		//Setters
		public void setName(String nombre){
			if (checkNom(nombre))	this.nombre = nombre;
		}

		public void setId(String id){
			this.boleta = id;
		}

		public void setEdad(int edad){
			this.edad = edad;
		}

		public void setPromedio(double promedio){
			this.promedio = promedio;
		}

		public void setPeso(double peso){
			this.peso = peso;
		}

		public void setTalla(double talla){
			this.talla = talla;
		}

		//Getters
		public String getName(){
			return nombre;
		}
		public String getId(){
			return boleta;
		}
		public int getEdad(){
			return edad;
		}
		public double getPromedio(){
			return promedio;
		}
		public double getPeso(){
			return peso;
		}
		public double getTalla(){
			return talla;
		}

		//
		public String toString(){
			String toPrint=""; 
			if(nombre!=null){
				toPrint = "Alumno "+nombre;
				if(boleta!=null) toPrint+=("\nBoleta: "+boleta);
				if(edad!=0) toPrint+=("\nEdad del alumno: "+edad);
				if(promedio!=0) toPrint+="\nPromedio general: "+promedio;
				if(peso!=0) toPrint+=("\nPeso en Kg: "+peso);
				if(talla!=0) toPrint+="\nEstatura: "+talla;
				if(peso!=0 && talla!=0) toPrint+="\nimc: "+(peso / (talla*talla));
				if(nutricion()!=null) toPrint+="\n  "+nutricion();
			}else{
				System.out.println("¡Lo sentimos! Estas tratando de mostrar un alumno no valido.");
			}
			return (toPrint+"\n");
		}
		private String nutricion(){
			double ntc = peso / (talla*talla);
			String nutricion="";
			if (ntc < 16) {
				nutricion = "El alumno padece de delgadez extrema!";
			}else if (ntc < 17) {
				nutricion = "El alumno tiene delgadez moderada";
			}else if (ntc < 18.5){
				nutricion = "El alumno tiene delgadez leve";
			}else if (ntc < 25) {
				nutricion = "El estado nutricional del alumno es el adecuado.";			
			}else if(ntc < 30){
				nutricion = "El alumno es preobeso";
			}else if (ntc < 35) {
				nutricion = "El alumno tiene obesidad leve";
			}else if (ntc < 40) {
				nutricion = "El alumno tiene obesidad moderada";
			}else if (ntc >= 40) {
				nutricion = "El alumno padece obesidad morbida! ¡Traigan una grua!";
			}
			return (nutricion+"\n");
		}

		public static boolean compareExactList(ArrayList<Alumno> A, ArrayList<Alumno> O){
			if(A.size() == O.size()){
				int i=0;
				for(Alumno aux : O){
					if(!A.get(i).equals(aux)) return false;
					i++;
				}
				return true;

			}else return false;

		}
		public static boolean compareExactList(Alumno[] A,Alumno[] O){
			if(A.length == O.length){
				int i=0;
				for (Alumno aux : O) {
					if (!A[i].equals(aux)) return false;
					i++;
				}
				return true;
			}else return false;

		}

		public static boolean compareList(ArrayList<Alumno> A, ArrayList<Alumno> O){
			if(A.size() == O.size()){
				int i = 0;
	      for(Alumno aux : O){
	        if(!A.contains(aux)) return false;
	          i++;
	      }
	      return true;
	    }
	    return false;
		}

		public boolean equals(Alumno O){
      //Compara dos racionales y retorna un True si son iguales, False si no
        //if(O instanceof Alumno){
          Alumno aux = (Alumno) O; // Downcasting: Forzamiento hacia abajo
            if(nombre == O.nombre && boleta == O.boleta && edad == O.edad && promedio == O.promedio && peso == O.peso && talla == O.talla) return true;
            else return false;
        //}
      //return false;
    }

    public static void desplegarInfo(ArrayList<Alumno> A){
    	Collections.sort(A);
    	System.out.println("\n\nNumero de alumnos en la lista:"+A.size()+"\nMayor promedio: \n"+Collections.max(A, null)+"\n\nLista ordenada.\n");
    	for(Alumno aux : A){
    		System.out.println(aux);
    	}
    }
    public static void desplegarInfo(Alumno[] A){
    	Arrays.sort(A);
    	System.out.println("\n\nNumero de alumnos en el array:"+A.length+"\nMayor promedio: \n"+Collections.max(Arrays.asList(A), null)+"\n\nLista ordenada.\n");
    	for(Alumno aux : A){
    		System.out.println(aux);
    	}
    }
    public static void desplegarInfo(String estado, ArrayList<Alumno> A){
    	double imcmax, imcmin, imc;
    	Collections.sort(A);
    	switch(estado){
    		case "bajo peso": imcmax = 30; imcmin = 0;
    			break;
    		case "normal": imcmax = 20; imcmin = 10;
    			break;
    		case "obesidad": imcmax = 50; imcmin = 25;
    			break;
    	}
    	System.out.println("\n\nNumero de alumnos en la lista:"+A.size()+"\nMayor promedio: \n"+Collections.max(A, null)+"\n\nLista ordenada.\n");
    	for(Alumno aux : A){
    		if(aux.nutricion() != null){ 
    			imc = aux.peso/(aux.talla*aux.talla);
    			if(imc <= imcmax && imc >= imcmin) System.out.println(aux);
    		}
    	}
    }
    public static void desplegarInfo(String estado, Alumno[] A){
    	Arrays.sort(A);
    	double imcmax, imcmin, imc;
    	switch(estado){
    		case "bajo peso": imcmax = 30; imcmin = 0;
    			break;
    		case "normal": imcmax = 20; imcmin = 10;
    			break;
    		case "obesidad": imcmax = 50; imcmin = 25;
    			break;
    	}
    	System.out.println("\n\nNumero de alumnos en el array:"+A.length+"\nMayor promedio: \n"+Collections.max(Arrays.asList(A), null)+"\n\nLista ordenada.\n");
    	for(Alumno aux : A){
    		if(aux.nutricion() != null){ 
    			imc = aux.peso/(aux.talla*aux.talla);
    			if(imc <= imcmax && imc >= imcmin) System.out.println(aux);
    		}
    	}
    }

		@Override
    public int compareTo(Alumno o) {
      if (this.promedio < o.promedio) {
        return -1;
      }
      if (this.promedio > o.promedio) {
        return 1;
      }
      return 0;
    }
	}
	public static void main(String[] args){
		Alumno al1 = new Alumno();
		al1.setName("Pedro Paramo");
		al1.setId("1234567890");
		al1.setPromedio(8.7);
		al1.setPeso(75.6);
		al1.setTalla(1.80);
		al1.setEdad(21);
		System.out.println(al1); //Imprimir objeto, editar toString.


		Alumno A = new Alumno("Lorena", "0123456789",32,62.5,1.61,8.70); 
		// Constructor con dos parámetros
		Alumno B = new Alumno("Alonso Quijano", "0000111122"); 
		// Constructor por omisión
		Alumno C = new Alumno( ); 
		// Constructor por copia
		Alumno X = new Alumno(B); 
		// Error de datos de entrada en la creación del objeto D 
		// El objeto D será creado con todos sus campos convalores prestablecidos, tal como se hace en el  
		// constructor por omisión. 
		Alumno D = new Alumno("Sanch%& Panza10", "12341X23");

		System.out.println("A:\n"+A);System.out.println("D:\n "+D);System.out.println("B:\n"+B);System.out.println("C:\n"+C);System.out.println("X:\n"+X); 
	
		ArrayList<Alumno> grupo = new ArrayList<Alumno>();
		grupo.add(new Alumno(A));
		grupo.add(new Alumno(B));
		grupo.add(new Alumno(X));

		ArrayList<Alumno> grupo1 = new ArrayList<Alumno>();
		grupo1.add(new Alumno(A));
		grupo1.add(new Alumno(B));
		grupo1.add(new Alumno(X));

		Alumno[] conjunto = new Alumno[3];
		conjunto[0] = new Alumno(A);
		conjunto[1] = new Alumno(B);
		conjunto[2] = new Alumno(X);

		Alumno[] conjunto1 = new Alumno[3];
		conjunto1[0] = new Alumno(A);
		conjunto1[1] = new Alumno(B);
		conjunto1[2] = new Alumno(X);

		System.out.println("grupo = grupo1 ?: "+Alumno.compareExactList(grupo, grupo1)+"\nconjunto = conjunto1 ?: "+Alumno.compareExactList(conjunto, conjunto1));

		Alumno.desplegarInfo(grupo1);
		Alumno.desplegarInfo(conjunto1);
		Alumno.desplegarInfo("normal", grupo1);
		Alumno.desplegarInfo("obesidad", conjunto1);

		System.out.println("Numero de alumnos totales creados: "+Alumno.cont);

	}
}
