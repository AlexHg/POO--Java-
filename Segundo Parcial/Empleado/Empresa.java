public class Empresa{
  public static void main(String[] args){
    Empleado[] empleados = new Empleado[8];
    empleados[0] = new EmpBase("QX400", "El Quijote", 410, 10.5, 20);
    empleados[1] = new EmpComision("PPR23", "Pedro Paramo", 65, 53840.35, 0.22);
    empleados[2] = new EmpHoras("GS1935", "Gregorio Samsa", 80, 40, 10);
    empleados[3] = new EmpBaseCom("AB1957", "Aureliano Buendia", 58, 78342.40, 0.15, 21, 50.30);
    empleados[4] = new EmpBase("PPZ123","Pablito Perez",120, 12.1, 30);
    empleados[5] = new EmpComision("AHG999","Alejandro Hernandez", 2000, 1209231, 0.9);
    empleados[6] = new EmpHoras("KK1231","Keke Kamaro", 90, 30, 20);
    empleados[7] = new EmpBaseCom("BA0192","Buendia, Aureliano",60, 80000.9, 0.2, 22, 40);

    for(Empleado aux: empleados){
      System.out.print(aux);
      System.out.println(" "+aux.obtenerSal());
      if(aux instanceof EmpBase){
        EmpBase eb = (EmpBase)aux; //Downcasting
        eb.vacacionar();
      }
      if(aux instanceof EmpHoras){
        EmpHoras eh = (EmpHoras)aux;
        eh.tratamiento();
      }
      if(aux instanceof EmpComision){
        EmpComision ec = (EmpComision)aux;
        ec.pagarBono();
      }

    }


  }
}
