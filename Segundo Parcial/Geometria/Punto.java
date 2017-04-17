public class Punto{
  private String nombre;
  private int x, y;

  //Contructores
  public Punto(){
    this.x = 0;
    this.y = 0;
  }
  public Punto(int x, int y){
    this.nombre = "TEMP";
    this.x = x;
    this.y = y;
  }
  public Punto(String nombre ,int x, int y){
    this.nombre = nombre;
    this.x = x;
    this.y = y;
  }
  public Punto(Punto cpy){
    this.nombre = cpy.nombre;
    this.x = cpy.getX();
    this.y = cpy.getY();
  }
  public Punto(String nombre, Punto cpy){
    this.nombre = nombre;
    this.x = cpy.getX();
    this.y = cpy.getY();
  }
  //Getter's
  public String getName(){
    return this.nombre;
  }
  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }
  //Setter's
  public void setName(String nombre){
    this.nombre = nombre;
  }
  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
    this.y = y;
  }
  public void set(int x, int y){
    this.x = x;
    this.y = y;
  }
  //Distancia
  public double distancia(Punto B){
    return Math.sqrt(
      Math.pow(B.x - this.x, 2) + Math.pow(B.y - this.y, 2)
    );
  }
  public double distancia(){
    return Math.sqrt(
      Math.pow(0 - this.x, 2) + Math.pow(0 - this.y, 2)
    );
  }
  //Cuadrante
  public int cuadrante(){
    if(this.x > 0){
      if(this.y > 0) return 1;
      if(this.y < 0) return 4;
    }
    if(this.x < 0){
      if(this.y > 0) return 2;
      if(this.y < 0) return 3;
    }
    return 0;
  }
  //toString
  public String toString(){
    return nombre+"("+x+","+y+");";
  }
}
