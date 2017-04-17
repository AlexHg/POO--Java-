public class EmpComision extends Empleado implements Honorarios{
	private double comision;
	private double ventas;

	public EmpComision(String nss,String nom,int a, double com,double ven){
		super(nss,nom,a);
		comision=com;
		ventas=ven;
	}

	public String toString(){
		return super.toString()+"La comision es: "+comision + "Las ventas son: "+ventas;
	}
	public double obtenerSal(){
		return comision*ventas;
	}
	public void pagarIva(){
		if(obtenerSal() > 15000)
			System.out.println("Pago de Iva = "+(obtenerSal()*0.1));
		else
			System.out.println("No paga impuesto IVA");
	}
	public void pagarBono(){
		if (ventas <= 10000)
			System.out.println("Recibe un bono del 10% : "+ventas*0.1);
		else if(ventas <= 50000)
			System.out.println("Recibe un bono del 15% : "+ventas*0.15);
		else
			System.out.println("No recibe bono");
	}
}
