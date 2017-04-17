import java.util.*;
public class CtaCredito extends Cuenta{
  private double tasa;
  private double deficit;
  private int id=0;
  private int diasTrans=0;

  public CtaCredito(Fecha fecha, double saldo, double tasa){
    super(fecha);
    this.saldo = saldo;
    this.tasa = tasa;
    id++;
    super.movimientos.add(new Registro("Consulta","Saldo: "+saldo+"\tdeficit: "+deficit, new Fecha(1,0,2015)));
    intereses();
  }
  public double consultar(){
    super.movimientos.add(new Registro("Consulta","Saldo: "+saldo+"\tdeficit: "+deficit));
    intereses();
    return super.consultar();
  }
  public Cuenta consultar(int n){
    super.movimientos.add(new Registro("Consulta","Saldo: "+saldo+"\tdeficit: "+deficit));
    intereses();
    return this;
  }
  public void depositar(double monto){
    double deposito = monto;
    if(deficit > 0){
      if(deficit >= deposito) deficit -= deposito;
      else{
        saldo += deposito-deficit;
        deficit = 0;
      }
    }else{
      saldo += deposito;
    }
    super.movimientos.add(new Registro("Deposito","Monto: "+monto));
  }
  public void retirar(double monto){
    if(saldo <= 0){
      deficit += monto;
    }
    else if(saldo <= monto){
      if ((monto-saldo) > 0) {
        deficit+=(monto-saldo);
      }
      saldo = 0;
    }
    else if(saldo > monto){
      saldo -= monto;
    }
    super.movimientos.add(new Registro(" Retiro ","Monto: "+monto));
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
  public void intereses(){
    Calendar fecha = Calendar.getInstance();
    Fecha hoy = new Fecha(fecha.get(Calendar.DAY_OF_MONTH),fecha.get(Calendar.MONTH),fecha.get(Calendar.YEAR));
    Fecha ap = super.apertura;
    if((hoy.getAno()-ap.getAno())>=0){
      int dias = (hoy.getAno()-ap.getAno())*365;
      dias += (hoy.getMes()-ap.getMes())*30;
      dias += (hoy.getDia()-ap.getDia());
      if((dias-diasTrans) > 30){
        int auxDias = diasTrans;
        diasTrans += dias-auxDias;
        if(deficit > 0){
          deficit=deficit+deficit*tasa;
          System.out.println("Se cobraron: "+(deficit*tasa)+" de intereses");
        }
        if(saldo > 0){
          saldo -= deficit*tasa;
        }
      }
    }
    if(deficit*tasa > 0.0)
      System.out.println("Se cobraron: "+(deficit*tasa)+" de intereses");
      deficit=deficit+deficit*tasa;
  }
}
