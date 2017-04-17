import java.util.*;
public class Banco{
  public static void main(String[] args) {
    System.out.println("BIENVENIDO A BANAPOLI.\n A continuacion desglozamos informacion de la incumvencia de los clientes\n");
    Cliente c1 = new Cliente("Quijote");

    c1.agregarCuenta(
      new CtaAhorros(
        new Fecha(1,10,2015), //Los meses empiezan en 0
        27350.31, 
        0.02
      )
    );

    c1.agregarCuenta(
      new CtaCheques(
        new Fecha(6,0,2015), 
        332250.0, 
        22100
      )
    );

    c1.agregarCuenta(
      new CtaCredito(
        new Fecha(4,11,2014), 
        273.99, 
        0.01
      )
    );

    c1.agregarCuenta(
      new CtaAhorros(
        new Fecha(23,6,2012), 
        457823.2, 
        0.002
      )
    );

    c1.obtenerCuenta(0)
      .depositar(23000,1)
      .retirar(24327,1)
      .consultar(1);

    c1.obtenerCuenta(1)
      .consultar(1)
      .retirar(200,1)
      .depositar(3000,1)
      .consultar(1)
      .retirar(340000,1)
      .consultar(1)
      .depositar(10000,1)
      .consultar(1);

    c1.obtenerCuenta(2)
      .retirar(250,1)
      .depositar(3000,1)
      .consultar(1)
      .consultar(1)
      .retirar(4023,1)
      .consultar(1)
      .consultar(1)
      .depositar(500,1)
      .consultar(1)
      .consultar(1)
      .depositar(500,1)
      .consultar(1)
      .consultar(1);
      
    c1.obtenerCuenta(3)
      .depositar(200,1)
      .consultar(1)
      .depositar(500,1)
      .depositar(1200,1)
      .retirar(100,1)
      .retirar(1000,1)
      .consultar(1);

    c1.reportarCliente();
  }
}
