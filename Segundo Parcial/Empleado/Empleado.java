abstract public class Empleado{
	private String nss;
	private String nombre;
	private int ant;

	public Empleado(String nss, String name, int a){
		this.nss = nss;
		nombre = name;
		ant = a;
	}
	abstract double obtenerSal();
	public boolean mayorQue(Empleado e){
		return this.ant > e.ant;
	}
	public boolean ganaMas(Empleado e){
		return this.obtenerSal() > e.obtenerSal();
	}
	public int obtenerAnt(){
		return ant;
	}
	public String toString(){
		return "NSS : "+nss+" Nombre : "+nombre+" Antiguaedad : "+ant;
	}
}