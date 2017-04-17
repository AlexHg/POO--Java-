public class EmpBaseCom extends EmpComision{
	private int diasLab;
	private double salDiario;

	public EmpBaseCom(String nss, String name, int ant, double com, double ven, int dl, double sd){
		super(nss,name,ant,com,ven);
		diasLab = dl;
		salDiario = sd;
	}
	public String toString(){
		return " Empleado B-C : "+super.toString()+" Dias lab : "+this.diasLab+"Salario diario : "+salDiario;
	}
	public double obtenerSal(){
		return super.obtenerSal()+diasLab*salDiario;
	}
}
