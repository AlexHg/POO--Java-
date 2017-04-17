import java.util.*;
public class CuentaBancaria{
	public static Scanner enter = new Scanner(System.in);
	public static void Printit(String tout){
		System.out.println(tout);
	}
	public class Movimiento{
		String fecha;
		String movimiento;
		float monto;
		public Movimiento(String movimiento, float monto){
			fecha = "";
			this.movimiento = movimiento;
			this. monto = monto;
		}
	}
	public class Cuenta{
		float saldo;
		ArrayList<Movimiento> Movimientos = new ArrayList<Movimiento>();
		public Cuenta(){
			saldo=0;
		}
		public Cuenta(int monto){
			saldo=monto;
		}
		public float consultar(){
			return saldo;
		}
		public void retirar(float monto){
			Movimientos.add(new Movimiento("Retiro",monto));
			saldo-=monto;
		}
		public void depositar(float montos){
			Movimientos.add(new Movimiento("Deposito",monto));
			saldo+=monto;
		}
	}
	public class Cliente{
		String nombre;
		Cuenta cuenta = new Cuenta();
		String folio;

		public Cliente(){
			
		}
		public Cliente(String folio){

		}
		public Cliente(String nombre){

		}
		public Cliente(String nombre, String folio){

		}
		public String obtenerNombre(){
			return nombre;
		}
		public Cuenta obtenerCuenta(){
			return cuenta;
		}
	}
	public class Banco{
		String nombre;
		ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
		int numClientes;
		private static nBanco = 0; 
		public Banco(){
			Printit("Ingrese el nombre del banco");
			nombre = enter.nextln();
			Banco.newBanco();
		}
		public Banco(String nombre){
			this.nombre = nombre;
			Banco.newBanco();
		}
		public void agregarCliente(String name, String folio){
			Clientes.add(new Cliente(nombre, folio));
		}
		public Cliente obtenerCliente(int indice){

		}
		public void imprimirClientes(){

		}
		public static void newBanco(){
			nBanco++;
		}
		/*public static void main(String [] args){
			Cuenta ctaAux;
			Cliente cliente = new Cliente("El quijote","QX400");
			cliente.establecerCuenta(new Cuenta(550.45));
			qx.obtenerCuenta().depositar(300.55);
			System.out.println("Nombre Cliente: "+qx.obtenerNombre());
			System.out.println("Numero de cuenta: "+qx.obtenerCuenta());
		}*/

	}
	public class UsuarioBanco{
		public static void main(String [] args){
			/*Banco B1 = new Banco();
			Banco B2 = new Banco();
			B1.agregarCliente("Pedro Paramo","PP568");
			Cliente C1 = new Cliente("Gregorio Samsa");
			B2.agregarCliente(C1);
			Cuenta CU1 = new Cuenta(100.5);
			B1.obtenerCliente("PP568").establecerCuenta(CU1);
			Cuenta CU2 = new Cuenta(10.3);
			C1.establecerCuenta(CU2);
			B1.obtenerCliente("Gregorio Samsa").obtenerCuenta().depositar(400.6); //Despliega un menu en pantalla con las coincidencias de "Gregorio Samsa" si existen y deja elegir una para retornarla
			*/
		}
	}
}