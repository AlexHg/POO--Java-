//package PruebaRacional;
/**
 * @author alexx
 */
import java.util.*;
import java.lang.Runtime;
public class JugarMascota {

	public static class Mascota{
		public static int score = 0;

		public static ArrayList<Stuff> Mochila = new ArrayList<Stuff>();
		public static void llenaMochila(){
			for(int i = 0; i < 8; i++){
				Mochila.add(new Stuff());
			}
		}

		//Datos
		private String nombre;
		private String especie;
		private String genero; // Macho /  Hembra
		private float peso; //Kg
		private float tamano; //Mts
		//Estadisticas
		private int hp; // 1000max
		private int furia; // despues de un determinado punto, si se enoja: te come y pierdes
		//Necesidades
		private int hambre; // despues de cierto punto pierde puntos vitales
		private int suciedad; // despues de cierto punto pierde puntos de vida
		private int sueno; // si no duerme, perdera hp
		private boolean ganasBano; // se puede hacer en frente de ti
		private int banoCant; // si llega a 10, la naturaleza llamará
		//Estados
		private Scanner enter = new Scanner(System.in);
		public static Scanner ent = new Scanner(System.in);
		private Random Randomizar = new Random();

		private boolean enfermo;
		private String enfermedad;

		private int pesoMin, pesoMax, tamMax, tamMin, opcionAccion;
		private String[] cls = new String[] {"cmd.exe", "/c", "cls"};
		//Metodos constructores
		public Mascota(){

			System.out.println("Bienvenido a la tienda de mascotas exoticas!\n\n");
			System.out.println("Elige el nombre de su mascota");
				this.nombre = enter.nextLine();
			elegirEspecie();


		}
		public Mascota(String nombre){
			this.nombre = nombre;
			System.out.println("Bienvenido a la tienda de mascotas exoticas!\n Porfavor elija la mascota de su agrado.\n\n");
			elegirEspecie();
		}

		public void alimentar(){
			if(hambre == 0){
				System.out.println("\n"+nombre+" no tiene hambre, no va a comer nada");
			}else if(hambre < 3){
				System.out.println("\n"+nombre+" comio de mala gana");
				hambre--;
				banoCant++;
				suciedad++;
				sueno++;
				peso += 3.56;
				tamano += 0.016;
				if(Randomizar.nextInt(100) < 5){
					System.out.println("\n"+nombre+" comio algo en mal estado");
					enfermedad = "Infección estomacal";
					enfermo = true;
					System.out.println("\n"+nombre+" se enfermó del estomago: "+enfermedad);
				}
			}else if(hambre < 5){
				System.out.println("\n"+nombre+" comio sin prisa");
				hambre-=2;
				banoCant++;
				suciedad++;
				sueno++;
				peso += 4.36;
				tamano += 0.016;
				if(Randomizar.nextInt(100) < 5){
					System.out.println("\n"+nombre+" comio algo en mal estado");
					enfermedad = "Infección estomacal";
					enfermo = true;
					System.out.println("\n"+nombre+" se enfermó del estomago: "+enfermedad);
				}else if(Randomizar.nextInt(100) < 10){
					System.out.println("\n"+nombre+" se mordió");
					hp -= 5;
				}
			}else if(hambre < 8){
				System.out.println("\n"+nombre+" comio muy rapido");
				hambre-=2;
				banoCant+=2;
				suciedad+=2;
				sueno+=2;
				peso += 5.36;
				tamano += 0.016;
				if(Randomizar.nextInt(100) < 5){
					System.out.println("\n"+nombre+" comio algo en mal estado");
					enfermedad = "Infección estomacal";
					enfermo = true;
					System.out.println("\n"+nombre+" se enfermó del estomago: "+enfermedad);
				}else if(Randomizar.nextInt(100) < 10){
					System.out.println("\n"+nombre+" se mordió");
					hp -= 5;
				}else if(Randomizar.nextInt(100) < 15){
					System.out.println("\n"+nombre+" comio tan rapido que se empachó");
					enfermedad = "Dolor estomago";
					enfermo = true;
					System.out.println("\n"+nombre+" se enfermó del estomago: "+enfermedad);
				}
			}else {
				System.out.println("\n"+nombre+" se comio hasta el plato!");
				hambre-=3;
				banoCant+=3;
				suciedad+=3;
				sueno+=2;
				peso += 6;
				tamano += 0.056;
				if(Randomizar.nextInt(100) < 5){
					System.out.println("\n"+nombre+" comio algo en mal estado");
					enfermedad = "Infección estomacal";
					enfermo = true;
					System.out.println("\n"+nombre+" se enfermó del estomago: "+enfermedad);
				}else if(Randomizar.nextInt(100) < 10){
					System.out.println("\n"+nombre+" se mordió");
					hp -= 5;
				}else if(Randomizar.nextInt(100) < 15){
					System.out.println("\n"+nombre+" comio tan rapido que se empachó");
					enfermedad = "Dolor estomago";
					enfermo = true;
					System.out.println("\n"+nombre+" se enfermó del estomago: "+enfermedad);
				}else if(Randomizar.nextInt(100) < 20){
					System.out.println("\n"+nombre+" comio tanto que le dio colitis");
					enfermedad = "Colitis";
					enfermo = true;
					System.out.println("\n"+nombre+" se enfermó del estomago: "+enfermedad);
				}
			}
			
		}

		public void jugar(){
			System.out.println("\n Empezaste a jugar con "+nombre);
			if(furia > 0) System.out.println("\n"+nombre+" no se ve muy animado");
			else if(furia < 0) System.out.println("\n"+nombre+" se esta divirtiendo");
			furia-=3;
			sueno += 3;
			suciedad += 2;
			hambre += 2;
			if(Randomizar.nextInt(100) < 5){
				System.out.println("\n"+nombre+" se resfio jugando en el agua");
				enfermedad = "Gripe";
				enfermo = true;
				System.out.println("\n"+nombre+" se enfermó de: "+enfermedad);
			}
			
		}

		public void pasear(){
			System.out.println("\n Saliste a pasear con "+nombre);
			if(furia > 0) System.out.println("\n"+nombre+" no se ve muy animado");
			else if(furia < 0) System.out.println("\n"+nombre+" se esta divirtiendo");
			furia-=5;
			sueno += 4;
			suciedad += 3;
			hambre += 4;
			sueno+=2;
		}

		public void dormir(){
			System.out.println("\n Estas tratando de dormir a "+nombre);
			if(sueno > 3) {
				System.out.println("\n"+nombre+" esta durmiendo...");
				furia-=7;
				sueno -= 4;
				suciedad += 1;
				hambre += 6;
			}
			else System.out.println("\n"+nombre+" no tiene sueno");
			furia-=5;
			sueno -= 4;
			suciedad += 3;
			hambre += 4;
			
		}

		public void molestar(){
			System.out.println("\n Estas molestando a "+nombre+". eso lo hace enojar.");
			furia += 7;
			
		}

		public void banar(){
			System.out.println("\n Estas bañando a "+nombre+".");
			furia += 4;
			suciedad = 0;
			hambre += 3;
			sueno += 2;
			if(Randomizar.nextInt(100) < 5){
				System.out.println("\n"+nombre+" se resfio con el agua");
				enfermedad = "Gripe";
				enfermo = true;
				System.out.println("\n"+nombre+" se enfermó de: "+enfermedad);
			}
			
		}

		public void irBano(){
			if(ganasBano){
				System.out.println("\n"+nombre+" salió a hacer sus necesidades");
				ganasBano = false;
				banoCant = 0;
			}
		}

		public void ignorar(){
			System.out.println("\nNo le prestas atencion a "+nombre);
		}

		public void reganar(){
			System.out.println("\nRegañaste a "+nombre+" y se puso triste.");
			furia += 5;
		}

		public void medicar(){
			if(Mochila.size() > 0){
				//Collections.sort(Mochila);
				Collections.sort(Mochila, Collections.reverseOrder()); //Ordenamiento inverso

				System.out.println("Elija el medicamento para darle a su mascota\n");
				System.out.println("\nEl medicamento con mejores propiedades es el \n"+Collections.max(Mochila, null)+" \ny el que tiene las peores es \n"+Collections.min(Mochila, null)+"\n");
				imprimir(Mochila);
				int indexMochila = enter.nextInt();
				Stuff medicamento = Mochila.get(indexMochila);
				hp += medicamento.hpp();
				if(!medicamento.cura()) enfermo = medicamento.cura();
				furia -= medicamento.alegra();
				peso -= medicamento.laxa();
				hambre -= medicamento.vitaminar();
				sueno -= medicamento.descansar();
				Mochila.remove(indexMochila);
				System.out.println("Usaste: "+medicamento.nombrar()+"\nhp + "+medicamento.hpp()+"\nSe curo?: "+!medicamento.cura()+"\n"+nombre+" esta mas alegre\nBajo "+medicamento.laxa()+"kg de peso\n");	
			}else System.out.println("No tienes mas medicamentos");
		}

		public void golpear(){
			System.out.println("\nGolpeaste a "+nombre+" y lo lastimaste.");
			hp -= 100;
			furia += 7;
		}

		//Metodos privados
		private void actualizar(){
			score+=10;
			if(hp < 300){
				System.out.println("\n"+nombre+" se esta muriendo!\n");
				if(hp <= 0){
					System.out.println("\n"+nombre+" se murio!!!!\n\nTu puntuacion: "+score);
					System.exit(0);
				}
			}
			if(enfermo){
				System.out.println("\n"+nombre+" esta enfermo, tiene "+enfermedad);
				hp -= 40;
			}else enfermedad = "";
			if(furia < 0){
				System.out.println("\n"+nombre+" esta feliz :)");
				hp += 10;
			}else if(furia > 0){
				System.out.println("\n"+nombre+" esta enojado >:(");
				hp -= 10;
			}

			if( banoCant > 7 ){
				System.out.println("\n"+nombre+" tiene ganas de ir al baño!");
				ganasBano = true;
			}else ganasBano = false;

			if( ganasBano && banoCant > 8 ){
				System.out.println("\n"+nombre+" tenia tantas ganas que se hizo en tu zapato!");
				ganasBano = true;
				hp -= 20;
				banoCant -= 5;
				peso -= 2;
			}
			if(peso > pesoMax){
				System.out.println("\n"+nombre+" tiene sobre peso!");
				hp -= 3;
			}
			if(hambre > 5){
				System.out.println("\n"+nombre+" tiene hambre!");
				if(hambre > 9) hp -= 20;
			}
			if(suciedad > 5){
				System.out.println("\n"+nombre+" esta muy sucio.");
				if(suciedad > 9) hp -= 20;
			}
			if(sueno > 5){
				System.out.println("\n"+nombre+" tiene mucho sueno, deberias dejarlo dormir.");
				if(sueno > 8) hp -= 10;
			}
		}
		private void elegirEspecie(){
			System.out.println("Catalogo de mascotas!\n 0) Dragon \n 1) Velociraptor \n 2) Cocodrilo \n 3) Tigre dientes de sable \n 4) Panda asesino\n\n Elije la mascota de tu agrado");
			//int especieo = enter.nextInt();
			this.hp = 1000;
			this.genero = (Randomizar.nextInt(10) < 5)? "Macho":"Hembra"; //Ternario
			switch(enter.nextInt()){
				case 0:
					this.especie = "Dragon";
					pesoMin = 300;
					pesoMax = 1200;
					tamMin = 20;
					tamMax = 50;
					break;
				case 1:
					this.especie = "Velociraptor";
					pesoMin = 50;
					pesoMax = 400;
					tamMin = 2;
					tamMax = 3;
					break;
				case 2:
					this.especie = "Cocodrilo";
					pesoMin = 40;
					pesoMax = 330;
					tamMin = 2;
					tamMax = 3;
					break;
				case 3:
					this.especie = "Tigre dientes de sable";
					pesoMin = 90;
					pesoMax = 410;
					tamMin = 3;
					tamMax = 4;
					break;
				case 4:
					this.especie = "Panda asesino";
					pesoMin = 130;
					pesoMax = 650;
					tamMin = 2;
					tamMax = 3;
					break;
				default:
					this.especie = "Dragon";
					pesoMin = 300;
					pesoMax = 1200;
					tamMin = 20;
					tamMax = 50;
					break;
			}

			this.peso = Randomizar.nextFloat() * (pesoMax - pesoMin) + pesoMin;
			this.tamano = Randomizar.nextFloat() * (tamMax - tamMin) + tamMin;
			this.furia = -3;
			hambre = suciedad = sueno = banoCant = 0;
			ganasBano = enfermo = false;
			enfermedad = "";
			System.out.println("\nHa nacido tu "+especie+"\nNombre: "+nombre+"\nGenero: "+genero+"\nPeso: "+peso+" Kg\nTamano: "+tamano+" Metros\n\nPuntos de vida: "+hp);
		}
		public void acciones(){
			System.out.println("\n\n ===================================================== \n");
			System.out.println("\nScore:"+Mascota.score+"\n\nTu "+especie+"\nNombre: "+nombre+"\nGenero: "+genero+"\nPeso: "+peso+" Kg\nTamano: "+tamano+" Metros\n\nPuntos de vida: "+hp);
			actualizar();
			if(hp <= 0){
				System.out.println("\n"+nombre+" se murio!!!!");
				System.exit(0);
			}
			System.out.println("\n\nQue quieres hacer con "+nombre+"?\n0) Alimentarlo\n1) Jugar con el\n2) Dormirlo\n3) Pasearlo\n4) Molestarlo\n5) Bañarlo\n6) Golpearlo\n7) Sacarlo al baño\n8) Ignorarlo\n9) Regañarlo\n10) Darle medicina\n11) Estadisticas de "+nombre+"\n\nOpcion:");
			opcionAccion = enter.nextInt();
			switch(opcionAccion){
				case 0: alimentar(); break;
				case 1: jugar(); break;
				case 2: dormir(); break;
				case 3: pasear(); break;
				case 4: molestar(); break;
				case 5: banar(); break;
				case 6: golpear(); break;
				case 7: irBano(); break;
				case 8: ignorar(); break;
				case 9: reganar(); break;
				case 10: medicar(); break;
				case 11: 
					System.out.println("\nTu "+especie+"\nNombre: "+nombre+"\nGenero: "+genero+"\nPeso: "+peso+" Kg\nTamano: "+tamano+" Metros\n\nPuntos de vida: "+hp);
					break;
				default: ignorar(); break;
			}
			acciones();
		}
	}
	public static class Stuff implements Comparable<Stuff>{
		private static int cont = 0;

		private String nombre;
		private int hpUp;
		private boolean curar; //
		private int feliz;
		private int bajaPeso;
		private int vitamina;
		private int quitaSueno;
		private Random Randomizar = new Random(); 

		public Stuff(String nombre, int hpUp, boolean curar, int feliz, int bajaPeso, int vitamina, int quitaSueno){
			this.nombre = nombre;
			this.hpUp = hpUp;
			this.curar = curar;
			this.feliz = feliz;
			this.bajaPeso = bajaPeso;
			this.vitamina = vitamina;
			this.quitaSueno = quitaSueno;
			Stuff.cont++;
		}
		public Stuff(String nombre){
			nombre = nombre;
			hpUp = Randomizar.nextInt(200) + 15;
			curar = true;
			feliz = Randomizar.nextInt(10);
			bajaPeso = Randomizar.nextInt(15);
			vitamina = Randomizar.nextInt(10);
			quitaSueno = Randomizar.nextInt(10);
			Stuff.cont++;
		}
		public Stuff(){
			//nombre = "Medicamento "+Stuff.quantity();
			nombre = crearNombre();
			hpUp = Randomizar.nextInt(200) + 15;
			curar = (Randomizar.nextInt(10) < 5 )? true : false;
			feliz = Randomizar.nextInt(10);
			bajaPeso = Randomizar.nextInt(15);
			vitamina = Randomizar.nextInt(10);
			quitaSueno = Randomizar.nextInt(10);
			Stuff.cont++;
		}

		public void finalize(){
			nombre = "";
			hpUp = 0; feliz = 0; bajaPeso = 0; vitamina=0; quitaSueno = 0;
			Randomizar = null;
			curar = false;
			System.out.println("Se liberó memoria");
		}

		public static int quantity(){ return cont; }
		public String nombrar(){ return nombre; }
		public int hpp(){ return hpUp;}
		public boolean cura(){ return (curar)? false : true; }
		public int alegra(){ return feliz; }
		public int laxa(){ return bajaPeso; }
		public int vitaminar(){ return vitamina; }
		public int descansar(){ return quitaSueno; }

		private String crearNombre(){
			String[] partOne = new String[]{"Meno","Para","Tela","Seda","Arbi","Kali","Perro","Mare","Pelu","Chaka","Remo","Meti","Ome"};
			String[] middle = new String[]{"si","no","pi","ne","ni","pa","pe","na","re","di","bi","ri"};
			String[] partTwo = new String[]{"setil","stin","kalix","peril","bastil","mozon","atil","corten"};
			String[] partTree = new String[]{" Compuesto"," Adulto"," Jr"," de 500"};
			return ""+partOne[Randomizar.nextInt(partOne.length-1)]+middle[Randomizar.nextInt(middle.length-1)]+partTwo[Randomizar.nextInt(partTwo.length-1)]+partTree[Randomizar.nextInt(partTree.length-1)]+"";
		}

		public String toString(){
            //Segundo metodo para imprimir usando System.out.println(R);
           	//return nombre;
           	return " "+nombre+" (Hp: "+hpUp+"; Curativo: "+(curar? "Si" : "No")+"; Felicidad: "+(feliz)+"; Baja peso: "+bajaPeso+")";
        }

		/*@Override
        public int compareTo(Stuff o) { 
        	return nombre.compareTo(o.nombre);
        }*/
        @Override
        public int compareTo(Stuff o) { 
        	if(hpUp == o.hpUp) return 0;
        	else if(hpUp > o.hpUp) return 1;
        	else return -1;
        }

        public boolean equals(Object O){
            //Compara dos racionales y retorna un True si son iguales, False si no
            if(O instanceof Stuff){
                Stuff aux = (Stuff) O; // Downcasting: Forzamiento hacia abajo
                if(this.nombre==aux.nombre) return true;
                else return false;
            }
            return false;
        }
	}
	public static void imprimir(ArrayList<Stuff> mochila){
       	int i = -1;
       	System.out.println("Medicamentos en la mochila ("+mochila.size()+")");
       	for(Stuff aux : mochila){
           	i++;
           	System.out.println("["+i+"]"+aux);
       	}
       	System.out.println(" ");
    }

	public static void main(String[] args) {
		Mascota miMascota = new Mascota();
		Mascota.llenaMochila();
		miMascota.acciones();
	}

}
