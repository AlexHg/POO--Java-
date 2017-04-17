import java.util.*
public class Cuenta{
  protected double saldo;

  public Cuenta(double saldoInicial){
    saldo = saldoInicial;

  }
  public double Consultar(){

  }
  public void Depositar(double monto){

  }
  public void Retirar(double monto){

  }
}

public class CuentaDeAhorros extends Cuenta{
  private double tasaDeInteres;
  public CuentaDeAhorros(double saldoInicial, double tasaDeInteres){
    super(saldoInicial);
    this.tasaDeInteres = tasaDeInteres;
  }
  @overriden
  public double Consultar(){

  }
}

public class CuentaDeCheques extends Cuenta{
  private double montoSobregiro;
  public CuentaDeCheques(double saldoInicial, double sobregiro){
    super(saldoInicial);
    montoSobregiro = sobregiro;
  }
  public CuentaDeCheques(double saldoInicial){

  }
  @overriden
  public void Retirar(double monto){

  }
}
public class Usuario{
  public static void main(String[] args) {
    
  }
}
