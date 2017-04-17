import java.util.*;
public class CtaAhorros extends Cuenta implements Impuestos{
  private double tasa;
  private int id = 0;
  private int diasTrans = 0;
  private String det = "";

  public CtaAhorros(Fecha fechaApertura, double saldo, double tasa){
    super(fechaApertura);
    this.tasa = tasa;
    this.saldo = saldo;
    id++;
  }
  public double consultar(){
    Calendar fecha = Calendar.getInstance();
    Fecha hoy = new Fecha(fecha.get(Calendar.DAY_OF_MONTH),fecha.get(Calendar.MONTH),fecha.get(Calendar.YEAR));
    Fecha ap = super.apertura;
    String detalles = "Saldo: $"+saldo;
    if((hoy.getAno()-ap.getAno())>=0){
      int dias = (hoy.getAno()-ap.getAno())*365;
      dias += (hoy.getMes()-ap.getMes())*30;
      dias += (hoy.getDia()-ap.getDia());
      double bono = (int)(dias/30)*tasa;
      System.out.println("Como sabes el banco te da una tasa del "+(tasa*100)+"% cada 30 dias\nHan transcurrido "+dias+" por lo que tu saldo aumento: $"+bono);
      saldo += bono;
      if(bono > 0)
        detalles += "+"+bono+" (gracias a la tasa de porcentaje a favor) = "+saldo;
    }else{
      System.out.println("'La fecha de creacion' de la cuenta aun no ha llegado.");
    }
    det = detalles;
    pagarISRanual();
    pagarISRmensual();
    super.movimientos.add(new Registro("Consulta",det));
    return saldo;
  }
  //Metodos que retornan al mismo objeto en si para llamar multiples metodos en una linea
  public Cuenta consultar(int m){
    consultar();
    return this;
  }
  public void pagarISRmensual(){
    Calendar fecha = Calendar.getInstance();
    Fecha hoy = new Fecha(fecha.get(Calendar.DAY_OF_MONTH),fecha.get(Calendar.MONTH),fecha.get(Calendar.YEAR));
    Fecha ap = super.apertura;
    if((hoy.getAno()-ap.getAno())>=0 && saldo > 1000){
      int dias = (hoy.getAno()-ap.getAno())*365;
      dias += (hoy.getMes()-ap.getMes())*30;
      dias += (hoy.getDia()-ap.getDia());
      if((dias-diasTrans) > 30){
        int auxDias = diasTrans;
        diasTrans += dias-auxDias;
        System.out.println("Se ha descontado el ISR mensual con un valor de $"+(saldo*ISRm));
        saldo -= saldo*ISRm;
        det += "(se cobro $"+saldo*ISRm+" por el ISR mensual) ";
      }
    }
  }
  public void pagarISRanual(){
    Calendar fecha = Calendar.getInstance();
    Fecha hoy = new Fecha(fecha.get(Calendar.DAY_OF_MONTH),fecha.get(Calendar.MONTH),fecha.get(Calendar.YEAR));
    Fecha ap = super.apertura;
    if((hoy.getAno()-ap.getAno())>=0 && saldo > 5000){
      int dias = (hoy.getAno()-ap.getAno())*365;
      dias += (hoy.getMes()-ap.getMes())*30;
      dias += (hoy.getDia()-ap.getDia());
      if((dias-diasTrans) > 365){
        int auxDias = diasTrans;
        diasTrans += dias-auxDias;
        System.out.println("Se ha descontado el ISR anual con un valor de $"+(saldo*ISRa));
        saldo -= saldo*ISRa;
        det += "(se cobro $"+saldo*ISRa+" por el ISR anual) ";
      }
    }
  }
}
