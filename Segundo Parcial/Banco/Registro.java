import java.util.*;
public class Registro{
  public static int idMov = 0;
  private String nombre;
  private Fecha fecha;
  private String detalle;

  public Registro(String nombre, String detalle){
    Calendar f = Calendar.getInstance();
    fecha = new Fecha(f.get(Calendar.DAY_OF_MONTH),f.get(Calendar.MONTH),f.get(Calendar.YEAR));
    this.nombre = nombre;
    this.detalle = detalle;
  }
  public Registro(String nombre, String detalle, Fecha f){
    fecha = new Fecha(f.getDia(),f.getMes(),f.getAno());
    this.nombre = nombre;
    this.detalle = detalle;
  }
  public String toString(){
    return nombre+"      "+fecha+"      "+detalle+"\n";
  }
}
