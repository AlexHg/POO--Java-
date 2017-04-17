public class EmpHoras extends Empleado{
	private double pago;
	private int horas;

	public EmpHoras(String nss, String name, int ant, double pago, int horas){
		super(nss,name,ant);
		this.pago = pago;
		this.horas = horas;
	}
	public String toString(){
		return super.toString()+" Horas trabajadas "+horas+" Pago obtenido "+pago;
	}
	public double obtenerSal(){
		return pago*horas;
	}
	public void pagarIva(){
		if(obtenerSal() > 15000)
			System.out.println("Pago de Iva = "+(obtenerSal()*0.1));
		else
			System.out.println("No paga impuesto IVA");
	}
	public void tratamiento(){
		if (horas < 12)
			System.out.println("Trabaja mas duro chavo");
		else if (horas > 12 && horas < 16)
			System.out.println("Algo estas haciendo mal, ya ve a dormir a tu casa");
		else
			System.out.println("Ve al medico y descansa un dia, te lo has ganado!");
	}
}
