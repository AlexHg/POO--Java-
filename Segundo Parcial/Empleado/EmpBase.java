public class EmpBase extends Empleado{
	private double salDiario;
	private int diasLab;

	public EmpBase(String nss, String nom, int a, double sd, int dl){
		super(nss,nom,a);
		salDiario = sd;
		diasLab = dl;
	}
	public String toString(){
		return super.toString()+"Salario diario: "+salDiario+" Dias laborados: "+diasLab;
	}
	public double obtenerSal(){
		return diasLab*salDiario;
	}
	public void vacacionar(){
		if (obtenerAnt() <= 5)
			System.out.println("Vacaciones : 5 dias");
		else if (obtenerAnt() <= 10)
			System.out.println("Vacaciones : 10 dias");
		else
			System.out.println("Vacaciones : 20 dias");
	}
}
