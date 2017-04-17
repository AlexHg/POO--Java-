public class Rectangulo{
  private String nombre;
  private Punto A, B;
  private Punto C, D;
  //A -> Esquina inferior izquierda
  //B -> Esquina superior derecha

  //Contructores
  public Rectangulo(){
    this.A = new Punto("A",0,0);
    this.B = new Punto("B",0,0);
    calculatePoints();
  }
  public Rectangulo(String nombre, Punto A, Punto B){
    this.nombre = nombre;
    this.A = new Punto(A);
    this.B = new Punto(B);
    calculatePoints();
  }
  public Rectangulo(String nombre, int x1, int y1, int x2, int y2){
    this.nombre = nombre;
    this.A = new Punto("A", x1, y1);
    this.B = new Punto("B", x2, y2);
    calculatePoints();
  }
  public Rectangulo(String nombre, Rectangulo cpy){
    this.nombre = nombre;
    this.A = new Punto(cpy.A);
    this.B = new Punto(cpy.B);
    calculatePoints();
  }
  public Rectangulo(Rectangulo cpy){
    this.nombre = cpy.nombre;
    this.A = new Punto(cpy.A);
    this.B = new Punto(cpy.B);
    calculatePoints();
  }

  private void calculatePoints(){
    this.C = new Punto(A.getX(), B.getY());
    this.D = new Punto(B.getX(),A.getY());
  }

  //Esta adentro?
  public boolean contains(Punto P){
    boolean contain = true;
    int i = 0;
    if(P.getX() >= this.A.getX()) i++;
    if(P.getY() >= this.A.getY()) i++;
    if(P.getX() <= this.B.getX()) i++;
    if(P.getY() <= this.B.getY()) i++;
    
    if(i == 4) return true;
    i = 0;

    if(P.getX() <= this.A.getX()) i++;
    if(P.getY() <= this.A.getY()) i++;
    if(P.getX() >= this.B.getX()) i++;
    if(P.getY() >= this.B.getY()) i++;
      
    if(i==4) return true;
    return false;
  }
  //Compara areas de rectangulos
  public int comparar(Rectangulo snd){
    if(this.Area() > snd.Area()) return 1;
    else if(this.Area() < snd.Area()) return -1;
    return 0;
  }
  //Union
  public Rectangulo Union(Rectangulo snd){
    if(this.contains(snd.A)){
      if(this.contains(snd.B)) 
        return new Rectangulo(""+this.nombre+" U "+snd.nombre+"", this.A, this.B);
      if(snd.contains(this.B))
        return new Rectangulo(""+this.nombre+" U "+snd.nombre+"", this.A, snd.B);
      if(snd.contains(this.A))
        return new Rectangulo(""+this.nombre+" U "+snd.nombre+"", this.A, snd.A);
    }
    if(snd.contains(this.A)){
      if(snd.contains(this.B)) 
        return new Rectangulo(""+this.nombre+" U "+snd.nombre+"", snd.A, snd.B);
      if(this.contains(snd.B))
        return new Rectangulo(""+this.nombre+" U "+snd.nombre+"", snd.A, this.B);
      if(this.contains(snd.A))
        return new Rectangulo(""+this.nombre+" U "+snd.nombre+"", snd.A, this.A);

    }
    return new Rectangulo(""+this.nombre+" U "+snd.nombre+"", this);
  }
  //Interseccion
  public Rectangulo Interseccion(Rectangulo snd){
    Punto nPu;
    if(this.contains(snd.A)){
      if(this.contains(snd.B)) 
        return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", snd.A, snd.B);
      if(snd.contains(this.B))
        return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", snd.A, this.B);
      if(snd.contains(this.A))
        return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", snd.A, this.A);

      if(snd.B.getX() > this.B.getX()){
        if(snd.B.getY() > this.B.getY())
          return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", snd.A, new Punto("A", snd.B.getX(), snd.B.getY()) );
        else 
          return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", snd.A, new Punto("A", snd.B.getX(), this.B.getY()) );
      }else{ 
        if(snd.B.getY() > this.B.getY())
          return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", snd.A, new Punto("A", this.B.getX(), snd.B.getY()) );
        else
          return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", snd.A, new Punto("A", this.B.getX(), this.B.getY()) );
      }
      //return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", snd.A, this.B);
    }

    if(snd.contains(this.A)){
      if(snd.contains(this.B)) 
        return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", this.A, this.B);
      if(this.contains(snd.B))
        return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", this.A, snd.B);
      if(this.contains(snd.A))
        return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", this.A, snd.A);

      if(snd.B.getX() > this.B.getX()){
        if(snd.B.getY() > this.B.getY())
          return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", this.A, new Punto("A", snd.B.getX(), snd.B.getY()));
        else 
          return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", this.A, new Punto("A", snd.B.getX(), this.B.getY()));
      }else{ 
        if(snd.B.getY() > this.B.getY())
          return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", this.A, new Punto("A", this.B.getX(), snd.B.getY()));
        else
          return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", this.A, new Punto("A", this.B.getX(), this.B.getY()));
      }
      //return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", this.A, snd.B);
    }
    return new Rectangulo(""+this.nombre+" I "+snd.nombre+"", this);
  }
  public int Area(){
    return ((this.A.getX() - this.B.getX())*(this.A.getY() - this.B.getY()));
  }
  public int Perimetro(){
    return ((this.A.getX() - this.B.getX())*2 + (this.A.getY() - this.B.getY())*2);
  }
  public void mover(Punto A, Punto B){
    this.A = new Punto(A);
    this.B = new Punto(B);
  }
  public int cuadrante(){
    if(this.A.cuadrante() == this.B.cuadrante()) return this.A.cuadrante();
    return 0;
  }
  //toString
  public String toString(){
    return this.nombre+" ["+this.A+""+this.B+"]";
  }
}
