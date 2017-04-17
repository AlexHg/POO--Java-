public class Coordenada{
  //Coordenadas rectangulares
  public double x, y;

  public Coordenada(int x, int y){
    this.x = x+0.0;
    this.y = y+0.0;
  }
  public Coordenada(Double x, Double y){
    this.x = x;
    this.y = y;
  }
  public Coordenada(Coordenada n){
    this.x = n.x;
    this.y = n.y;
  }
  public Coordenada toPolar(){
    Double modulo = Math.hypot( x,y );
    Double angulo = Math.toDegrees( Math.atan2( x, y )  );
    return new Coordenada(modulo, angulo);
  }
  public Coordenada sumar(Coordenada s){
    this.x+=s.x;
    this.y+=s.y;
    return new Coordenada(this);
  }

  public Coordenada restar(Coordenada s){
    this.x-=s.x;
    this.y-=s.y;
    return new Coordenada(this);
  }

  public Coordenada multiplicar(Coordenada s){
    return new Coordenada((this.x*s.x), (this.y*s.y));
  }

  public String toString(){
    if( ((int)x - x) == 0 && ((int)y - y) == 0)
      return "("+(int)x+","+(int)y+")";
    if( ((int)y - y) == 0)
      return "("+String.format("%.4f",x)+" , "+(int)y+("°").charAt(1)+")";
    return "("+String.format("%.4f",x)+" , "+String.format("%.2f",y)+("°").charAt(1)+")";
  }

  public int comparar(Coordenada n){
    if(Math.hypot( x,y ) > Math.hypot( n.x,n.y )) return 1;
    if(Math.hypot( x,y ) < Math.hypot( n.x,n.y )) return -1;
    return 0;
  }

  public boolean equals(Coordenada n){
    if(x == n.x && y == n.y) return true;
    return false;
  }
}
