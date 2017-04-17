import java.util.*;
public class CtaCheques extends Cuenta{
  private double sobregiro;
  private double sobreTope;
  private int id=0;

  public CtaCheques(Fecha fecha, double saldo, double sobre){
    super(fecha);
    this.saldo = saldo;
    sobregiro = sobreTope = sobre;
    id++;
  }
  public double consultar(){
    super.movimientos.add(new Registro("Consulta","Saldo: "+saldo+"\tsobregiro: "+sobregiro));
    return super.consultar();
  }
  public Cuenta consultar(int n){
    super.movimientos.add(new Registro("Consulta","Saldo: "+saldo+"\tsobregiro: "+sobregiro));
    return this;
  }
  public void depositar(double monto){
    double deposito = monto;
    if(sobregiro < sobreTope){
      double faltante = sobreTope - sobregiro;
      if(faltante >= deposito){
        sobregiro += deposito;
      }
      else{
        saldo += deposito-faltante;
        sobregiro = sobreTope;
      }
    }else{
      saldo += deposito;
    }
    super.movimientos.add(new Registro("Deposito","Monto: "+monto));
  }
  public void retirar(double monto){
    Calendar fecha = Calendar.getInstance();
    Fecha hoy = new Fecha(fecha.get(Calendar.DAY_OF_MONTH),fecha.get(Calendar.MONTH),fecha.get(Calendar.YEAR));
    Fecha ap = super.apertura;
    String detalles = "Saldo: $"+saldo;
    int dias = 0;
    if((hoy.getAno()-ap.getAno())>=0){
      dias = (hoy.getAno()-ap.getAno())*365;
      dias += (hoy.getMes()-ap.getMes())*30;
      dias += (hoy.getDia()-ap.getDia());
    }else{
      System.out.println("'La fecha de creacion' de la cuenta aun no ha llegado.");
    }
    if(dias > 365) {
      super.movimientos.add(new Registro(" Retiro ","Cheque no valido, la cuenta expiro"));
      return;
    }
    else{
      String detalle = "Monto:"+monto;
      if(saldo <= 0){
        if(sobregiro > monto){
          sobregiro -= monto;
          detalle += "Se tomo del sobre giro, Ahora quedan: $"+sobregiro;
        }
        else{
          System.out.println("No tienes saldo suficiente y ya sobrepasaste el sobregiro asignado. Paga deudor!");
          detalle = "no se pudo hacer la operacion";
        }
      }
      else if(saldo <= monto){
        if ((monto-saldo) > 0) {
          sobregiro-=(monto-saldo);
        }
        saldo = 0;
        super.movimientos.add(new Registro(" Retiro ","Monto: "+monto));
      }
      else if(saldo > monto){
       saldo -= monto;
       super.movimientos.add(new Registro(" Retiro ",detalle));
      }
    }
  }
  //Metodos que retornan al mismo objeto en si para llamar multiples metodos en una linea
  public Cuenta depositar(double monto, int m){
    depositar(monto);
    return this;
  }
  public Cuenta retirar(double monto, int m){
    retirar(monto);
    return this;    
  }
}
