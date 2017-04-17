import java.util.*;
public class Cliente{
  private String nombre;
  private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
  public int numeroCuentas;
  private String nCuenta;

  public Cliente(){
    
  }
  public Cliente(String nombre){
    this.nombre = nombre;
    asignarId(nombre);
    numeroCuentas++;
  }
  public Cliente(String nombre, ArrayList<Cuenta> cuentas){
    this.nombre = nombre;
    this.cuentas = cuentas;
    asignarId(nombre);
    numeroCuentas++;
  }
  private void asignarId(String nombre){
    String prefijo = "";
    for(int i = 0; i < 3; i++) 
      prefijo+= nombre.charAt(i);
    nCuenta = ""+prefijo+numeroCuentas;
  }
  public void agregarCuenta(Cuenta cuenta){
    cuentas.add(cuenta);
  }
  public Cuenta obtenerCuenta(int index){
    return cuentas.get(index);
  }
  public void reportarCliente(){
    System.out.println(this);
  }
  public void reportarEdoCuenta(){
    //Imprimir todos los estados de cuenta.
    for(Cuenta aux : this.cuentas){
      System.out.println(aux);
    }
  }
  public int aconum(){
    return cuentas.size();
  }
  public String toString(){
    String registro = "";
    for (Cuenta aux : cuentas ) {
      registro += aux;
    }
    return "\n\nCliente: "+nCuenta+"\nNombre:"+nombre+"\nCuentas en su poder: "+Cuenta.nCuenta+"\n\n"+registro;
  }
}
