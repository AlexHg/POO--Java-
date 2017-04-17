public class Triangulo{
  private String nombre;
  private Punto A, B, C;

  //Constructores
  public Triangulo(){
    this.A = new Punto("A",0,0);
    this.B = new Punto("B",0,0);
    this.B = new Punto("C",0,0);
  }
   public Triangulo(String nombre, Punto A, Punto B){
    this.nombre = nombre;
    this.A = new Punto(A);
    this.B = new Punto(B);
  }
  public Triangulo(String nombre, int x1, int y1, int x2, int y2, int x3, int y3){
    this.nombre = nombre;
    this.A = new Punto("A", x1, y1);
    this.B = new Punto("B", x2, y2);
    this.C = new Punto("C", x3, y3);
  }
  public Triangulo(String nombre, Triangulo cpy){
    this.nombre = nombre;
    this.A = new Punto(cpy.A);
    this.B = new Punto(cpy.B);
    this.C = new Punto(cpy.C);
  }
  public Triangulo(Triangulo cpy){
    this.nombre = cpy.nombre;
    this.A = new Punto(cpy.A);
    this.B = new Punto(cpy.B);
    this.C = new Punto(cpy.C);
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

  //Area
  public double Area(){
    return (this.A.distancia(this.B) * this.B.distancia(this.C))/2;
  }
  //Perimetro
  public double Perimetro(){
    return (this.A.distancia(this.B) + this.B.distancia(this.C) + this.C.distancia(this.A));
  }
  //Cuadrante
  public int cuadrante(){
    if(this.A.cuadrante() == this.B.cuadrante() == this.C.cuadrante()) return this.A.cuadrante();
    return 0;
  }
  //toString
  public String toString(){
    return this.nombre+" ["+this.A+""+this.B+""+this.C+"]";
  }
  public void mover(Punto A, Punto B){
    this.A = new Punto(A);
    this.B = new Punto(B);
    this.C = new Punto(C);
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
}
