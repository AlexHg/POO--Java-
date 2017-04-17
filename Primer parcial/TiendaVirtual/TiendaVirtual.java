import java.util.*;
public class TiendaVirtual{
	private static Scanner enter = new Scanner(System.in);
	//Clase superior
	public static class Producto implements Comparable<Producto>{
		public static int stock = 0;
		protected String id = "";
		protected String nombre;
		protected float precio;
		protected String tipo;
		protected String descripcion;
		protected String fecha;

		protected Random Randomizar = new Random();
		protected final String folio = obtenerFolio();

		public Producto(){
			Producto.stock++; 
		}

		public Producto retornar(){
			return this;
		}

		public void llenarDatos(){
			System.out.println("Ingrese el nombre del articulo.");
			enter.nextLine();
			nombre = enter.nextLine();
			System.out.println("Ingrese su precio.");
			precio = enter.nextFloat();
			enter.nextLine();
			System.out.println("Ingrese el tipo del articulo.");
			tipo = enter.nextLine();
			System.out.println("Ingrese la descripcion del articulo");
			descripcion = enter.nextLine();
			id += folio + tipo;

		}
		public void llenarDatos(String nombre, float precio, String tipo, String descripcion){
			this.nombre = nombre;
			this.precio = precio;
			this.tipo = tipo;
			this.descripcion = descripcion;
			id += folio + tipo;
		}

		private String obtenerFolio(){
			//Garantiza que el folio sea de 6 numeros
			String folio = ""+Randomizar.nextInt(999999)+"";
			for(int i = 0; i < (6 - folio.length()); i++ ){
				folio = "0"+folio;
			}
			return folio;
		}

		private String regresarId(){
			return id;
		}
		@Override
        public int compareTo(Producto o) {
            return fecha.compareTo(o.fecha);
        }

        public String toString(){
        	return "Id: "+id+", Nombre: "+nombre+", Precio: "+precio+", Tipo: "+tipo+", descripcion: "+descripcion; 
        }
	}
	//Clases por tipo de producto
	public static class Electronico extends Producto{
		public static int stock = 0;
		protected int meses;
		protected boolean garantia;
		protected int garantiaMeses;
		private final String prefijo_n1 = "ELE_";

		public Electronico(){
			Electronico.stock++; 
			id += prefijo_n1;
		}
	}
	public static class Otro extends Producto{
		public static int stock = 0;
		private final String prefijo_n1 = "OTR_";

		public Otro(){
			Otro.stock++; 
			id += prefijo_n1;
		}

	}
	//Tipo de Productos 'Electronicos'
	public static class Almacenamiento extends Electronico{
		public static int stock = 0;
		private int capacAl;
		private String puerto;

		private final String prefijo_n2 = "ALMA";

		public Almacenamiento(){
			Almacenamiento.stock++;
			id += prefijo_n2;
			llenarDatos();
			System.out.println("Ingrese la capacidad de Almacenamiento");
			capacAl = enter.nextInt();
			enter.nextLine();
			System.out.println("Ingrese el puerto de transferencia.");
			puerto = enter.nextLine();
			System.out.println("Ingrese los meses sin intereses");
			this.meses = enter.nextInt();
			enter.nextLine();
			System.out.println("\nEl producto tiene garantia? (si/no)");
			this.garantia = (enter.nextLine() == "si")? true : false;
			if(garantia){
				System.out.println("Ingrese los meses con garantia");
				this.garantiaMeses = enter.nextInt();
			}
		}
		public Almacenamiento(String nombre, float precio, String tipo, String descripcion, int capacAl, String puerto){
			Almacenamiento.stock++;
			id += prefijo_n2;
			llenarDatos(nombre, precio, tipo, descripcion);
			this.capacAl = capacAl;
			this.puerto = puerto;
			System.out.println("Ingrese los meses sin intereses");
			this.meses = enter.nextInt();
			enter.nextLine();
			System.out.println("\nEl producto tiene garantia? (si/no)");
			this.garantia = (enter.nextLine() == "si")? true : false;
			if(this.garantia){
				System.out.println("Ingrese los meses con garantia");
				this.garantiaMeses = enter.nextInt();
			}

		}
		public Almacenamiento(String nombre, float precio, String tipo, String descripcion, int meses, boolean garantia, int capacAl, String puerto){
			Almacenamiento.stock++;
			id += prefijo_n2;
			llenarDatos(nombre, precio, tipo, descripcion);
			this.capacAl = capacAl;
			this.puerto = puerto;
			
			this.meses = meses;
			this.garantia = garantia;
			if(garantia){
				System.out.println("Ingrese los meses con garantia");
				this.garantiaMeses = enter.nextInt();
			}
		}
	}
	public static class Periferico extends Electronico{ 
		public static int stock = 0;
		private int capacAl;
		private int ram;
		private String procesador;
		private final String prefijo_n2 = "PERI";

		public Periferico(){
			Periferico.stock++;
			id += prefijo_n2;
			llenarDatos();

			System.out.println("Ingrese la capacidad de Almacenamiento");
			this.capacAl = enter.nextInt();
			System.out.println("Ingrese la ram");
			this.ram = enter.nextInt();
			enter.nextInt();
			System.out.println("Ingrese el procesador del dispositivo");
			this.procesador = enter.nextLine();
			
			System.out.println("Ingrese los meses sin intereses");
			this.meses = enter.nextInt();
			enter.nextLine();
			System.out.println("\nEl producto tiene garantia? (si/no)");
			this.garantia = (enter.nextLine() == "si")? true : false;
			if(this.garantia){
				System.out.println("Ingrese los meses con garantia");
				this.garantiaMeses = enter.nextInt();
			}
		}
		public Periferico(String nombre, float precio, String tipo, String descripcion){
			Periferico.stock++;
			id += prefijo_n2;
			llenarDatos(nombre, precio, tipo, descripcion);

			System.out.println("Ingrese la capacidad de Almacenamiento");
			this.capacAl = enter.nextInt();
			System.out.println("Ingrese la ram");
			this.ram = enter.nextInt();
			enter.nextInt();
			System.out.println("Ingrese el procesador del dispositivo");
			this.procesador = enter.nextLine();
			
			System.out.println("Ingrese los meses sin intereses");
			this.meses = enter.nextInt();
			enter.nextLine();
			System.out.println("\nEl producto tiene garantia? (si/no)");
			this.garantia = (enter.nextLine() == "si")? true : false;
			if(this.garantia){
				System.out.println("Ingrese los meses con garantia");
				this.garantiaMeses = enter.nextInt();
			}
		}
		public Periferico(String nombre, float precio, String tipo, String descripcion, int meses, boolean garantia, int capacAl, int ram, String procesador){
			Periferico.stock++;
			id += prefijo_n2;
			llenarDatos(nombre, precio, tipo, descripcion);

			this.capacAl = capacAl;
			this.ram = ram;
			this.procesador = procesador;
			
			this.meses = meses;
			this.garantia = garantia;
			if(garantia){
				System.out.println("Ingrese los meses con garantia");
				this.garantiaMeses = enter.nextInt();
			}
		}
	}
	public static class Accesorio extends Electronico{ 
		public static int stock = 0;
		private final String prefijo_n2 = "ACCE";

		public Accesorio(){
			Accesorio.stock++;
			id += prefijo_n2;
			llenarDatos();
			
			System.out.println("Ingrese los meses sin intereses");
			this.meses = enter.nextInt();
			enter.nextLine();
			System.out.println("\nEl producto tiene garantia? (si/no)");
			this.garantia = (enter.nextLine() == "si")? true : false;
			if(this.garantia){
				System.out.println("Ingrese los meses con garantia");
				this.garantiaMeses = enter.nextInt();
			}
		}
		public Accesorio(String nombre, float precio, String tipo, String descripcion){
			Accesorio.stock++;
			id += prefijo_n2;
			llenarDatos(nombre, precio, tipo, descripcion);
			System.out.println("Ingrese los meses sin intereses");
			this.meses = enter.nextInt();
			enter.nextLine();
			System.out.println("\nEl producto tiene garantia? (si/no)");
			this.garantia = (enter.nextLine() == "si")? true : false;
			if(this.garantia){
				System.out.println("Ingrese los meses con garantia");
				this.garantiaMeses = enter.nextInt();
			}

		}
		public Accesorio(String nombre, float precio, String tipo, String descripcion, int meses, boolean garantia){
			Accesorio.stock++;
			id += prefijo_n2;
			llenarDatos(nombre, precio, tipo, descripcion);
			this.meses = meses;
			this.garantia = garantia;
			if(garantia){
				System.out.println("Ingrese los meses con garantia");
				this.garantiaMeses = enter.nextInt();
			}

		}
	}
	//Tipo de Productos 'Otros'
	public static class Limpieza extends Otro { 
		public static int stock = 0;
		private final String prefijo_n2 = "LIMP"; 

		public Limpieza(){
			Limpieza.stock++;
			id += prefijo_n2;
			llenarDatos();
		}
		public Limpieza(String nombre, float precio, String tipo, String descripcion){
			Limpieza.stock++;
			id += prefijo_n2;
			llenarDatos(nombre, precio, tipo, descripcion);
		}
	}

	public static class Tienda{
		private int dinero = 10000;
		private ArrayList<Producto> Stock = new ArrayList<Producto>();
		private ArrayList<Producto> Ventas = new ArrayList<Producto>();
		public Tienda(){
			System.out.println("Haz abierto tu nueva tienda!!\nTienes $"+dinero+" MXN iniciales.\n\n");
			Stock.add(new Almacenamiento("Disco duro externo",1200,"DIS","Disco duro para guardar cosas", 6, false, 500, "USB3.0"));
			Stock.add(new Accesorio("Audifonos",500,"AUD","Audifonos de buena calidad", 0, false));
			Stock.add(new Limpieza("Sepillo para teclado",30,"SEP","Sepillo para limpiar el teclado"));
			Stock.add(new Periferico("Laptop AMD",12000,"LAP","Una laptop",18, false, 1000, 8, "AMD FX 8350"));
			Stock.add(new Periferico("Laptop INTEL",17000,"LAP","Una laptop",26, false, 2000, 16, "Intel i7 4440k"));
			Stock.add(new Limpieza("Sepillo para teclado",30,"SEP","Sepillo para limpiar el teclado"));
		}

		public void menu(){
			System.out.println("Tienes $"+dinero+" MXN");
			System.out.println("Ingresa la opcion deseada.\n1) Realizar venta.\n2) Realizar devolucion.\n3) Agregar producto.\n4) Salir.");
			switch(enter.nextInt()){
				case 1: vender(); break;
				case 2: devolver(); break;
				case 3: 
					//System.out.println("Que tipo de Producto es?\n0) Almacenamiento\n1) Accesorios\n2) Limpieza\n3) Periferico.");
					/*switch(enter.nextInt()){
						case 0: Stock.add(new Almacenamiento()); break;
						case 1: Stock.add(new Accesorio()); break;
						case 2: Stock.add(new Limpieza()); break;
						case 3: Stock.add(new Periferico()); break;
					} */
					agregarProducto();
					break;
				case 4: System.exit(0); break;
			}
			menu();
		}
		private void vender(){
			System.out.println("\n\n1) Ingresar por id\n2) Elegir de la lista");
			int opcion = enter.nextInt();
			String elId;
			Producto x = new Producto();
			Producto.stock--;
			if(opcion == 1){
				elId = enter.nextLine();
				int i = -1;
				for(Producto aux : Stock){
					if(aux.regresarId() == elId){
						System.out.println(aux);
						x = Stock.get(i);
						Ventas.add(x);
						Stock.remove(i);
						break;
					}
				}
				Producto.stock--;
				if(x instanceof Electronico){
					Electronico.stock--;
					if(x instanceof Periferico) Periferico.stock--;
					else if(x instanceof Almacenamiento) Almacenamiento.stock--;
					else if(x instanceof Accesorio) Accesorio.stock--;
				}else if(x instanceof Otro){
					Otro.stock--;
					if(x instanceof Limpieza) Limpieza.stock--;
				}
			}else if(opcion == 2){
				imprimir(Stock);
				int opt = enter.nextInt();
				x = Stock.get(opt);
				Ventas.add(x);
				Stock.remove(opt);
				Producto.stock--;
				if(x instanceof Electronico){
					Electronico.stock--;
					if(x instanceof Periferico) Periferico.stock--;
					else if(x instanceof Almacenamiento) Almacenamiento.stock--;
					else if(x instanceof Accesorio) Accesorio.stock--;
				}else if(x instanceof Otro){
					Otro.stock--;
					if(x instanceof Limpieza) Limpieza.stock--;
				}
			}
			dinero += x.precio;
		}
		private void devolver(){
			System.out.println("\n\n1) Ingresar por id\n\n2) Elegir de la lista");
			int opcion = enter.nextInt();
			String elId;
			Producto x = new Producto();
			Producto.stock--;
			if(opcion == 1){
				int i = -1;
				elId = enter.nextLine();
				for(Producto aux : Ventas){
					i++;
					if(aux.regresarId() == elId){ 
						System.out.println(aux);
						x = Ventas.get(i);
						Stock.add(x);
						Ventas.remove(i);
						break;
					}

				}
				Producto.stock++;
				if(x instanceof Electronico){
					Electronico.stock++;
					if(x instanceof Periferico) Periferico.stock++;
					else if(x instanceof Almacenamiento) Almacenamiento.stock++;
					else if(x instanceof Accesorio) Accesorio.stock++;
				}else if(x instanceof Otro){
					Otro.stock++;
					if(x instanceof Limpieza) Limpieza.stock++;
				}
			}else if(opcion == 2){
				imprimir(Ventas);
				int opt = enter.nextInt();
				x = Ventas.get(opt);
				Stock.add(x);
				Ventas.remove(opt);
				Producto.stock++;
				if(x instanceof Electronico){
					Electronico.stock++;
					if(x instanceof Periferico) Periferico.stock++;
					else if(x instanceof Almacenamiento) Almacenamiento.stock++;
					else if(x instanceof Accesorio) Accesorio.stock++;
				}else if(x instanceof Otro){
					Otro.stock++;
					if(x instanceof Limpieza) Limpieza.stock++;
				}
			}
			dinero -= x.precio;
		}

		private void agregarProducto(){
			System.out.println("\nIngrese la clasificacion del producto:\n1) Electronico\n2) Otros");
			int clase = enter.nextInt();
			System.out.println("\nIngrese la subclase del producto:");
			if (clase == 1) {
				System.out.println("\n1) Almacenamiento\n2) Accesorio\n3) Periferico");
				switch (enter.nextInt()) {
					case 1: Stock.add(new Almacenamiento()); break;
					case 2: Stock.add(new Accesorio()); break;
					case 3: Stock.add(new Periferico()); break;
					default: Stock.add(new Periferico()); break;
				}
			}else{
				System.out.println("\n1) Limpieza");
				switch (enter.nextInt()) {
					default: Stock.add(new Limpieza()); break;
				}
			}
		}
		private void imprimir(ArrayList<Producto> list){
			int i = -1;
	       	System.out.println("\n\nArticulos en la lista ("+Producto.stock+"), Electronicos ("+Electronico.stock+"), Otros ("+Otro.stock+")\nPerifericos ("+Periferico.stock+"), Almacenamiento ("+Almacenamiento.stock+"), Accesorios ("+Accesorio.stock+"), Limpieza ("+Limpieza.stock+")\n");
	       	for(Producto aux : list ){
           		i++;
           		System.out.println("["+i+"] "+aux+"\n");
           	}
       		System.out.println(" ");
		}

	}
	public static void main(String[] args) {
		Tienda miTienda = new Tienda();
		miTienda.menu();
		//System.out.println("Productos: "+Producto.stock);
		//System.out.println("Electronicos: "+Electronico.stock);
		//System.out.println("Otros: "+Otro.stock);
		
	}
}