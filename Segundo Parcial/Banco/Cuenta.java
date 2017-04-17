import java.util.*;
public class Cuenta extends Cliente{
  protected double saldo;
  public Fecha apertura;
  public ArrayList<Registro> movimientos = new ArrayList<Registro>();
  public static int nCuenta = 0;
  private int id = 0;

  public Cuenta(Cuenta c){
    saldo = c.saldo;
    id=Cuenta.nCuenta;
    nCuenta++;
  }
  public Cuenta(Fecha fechaApertura){
    apertura = fechaApertura;
    id=Cuenta.nCuenta;
    nCuenta++;
  }
  public double consultar(){
    movimientos.add(new Registro("Consulta","Saldo: "+saldo));
    return saldo;
  }
  public void depositar(double monto){
    movimientos.add(new Registro("Deposito","Monto: "+monto));
    saldo += monto;
  }
  public void retirar(double monto){
    if(saldo >= monto){
      movimientos.add(new Registro(" Retiro ","Monto: "+monto));
      saldo -= monto;  
    }else System.out.println("No tienes saldo suficiente para hacer la operacion");
  }
  //Metodos que retornan al mismo objeto en si para llamar multiples metodos en una linea
  public Cuenta consultar(int m){
    consultar();
    return this;
  }
  public Cuenta depositar(double monto, int m){
    depositar(monto);
    return this;
  }
  public Cuenta retirar(double monto, int m){
    retirar(monto);
    return this;    
  }
  public String toString(){
    String aux = "";
    if(this instanceof CtaAhorros){
      aux = "Tipo: Cuenta de ahorros";
    }
    if (this instanceof CtaCheques) {
      aux = "Tipo: Cuenta de cheques";
    }
    if (this instanceof CtaCredito) {
      aux = "Tipo: Cuenta de credito";
    }
    String movis ="";
    for(Registro reg : movimientos){
      movis+=reg;
    }
    return "\n\n"+aux+"\nid: "+id+"\nSaldo: "+saldo+"\nFecha de apertura: "+apertura+"\n\nMOVIMIENTOS.\nNombre\t\tFecha\t\tDetalles\n\n"+movis;
  }

}
