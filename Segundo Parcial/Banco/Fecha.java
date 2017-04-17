public class Fecha{
  private int dia, mes, ano;
  public Fecha(){/*Contructor por defecto*/}
  public Fecha(int dia, int mes, int ano){
    this.dia = dia;
    this.mes = mes+1;
    this.ano = ano;
  }
  public Fecha obtenerFecha(){
    return this;
  }
  public void establecerFecha(int dia, int mes, int ano){
    this.dia = dia;
    this.mes = mes+1;
    this.ano = ano;
  }
  public int getDia(){
    return this.dia;
  }
  public int getMes(){
    return this.mes;
  }
  public int getAno(){
    return this.ano;
  }
  public String toString(){
    if(dia < 10){
      if(mes < 10){
        return "0"+dia+"-0"+mes+"-"+ano+"";
      }
      return "0"+dia+"-"+mes+"-"+ano+"";
    }else if(mes < 10){
      return dia+"-0"+mes+"-"+ano+"";
    }
    return dia+"-"+mes+"-"+ano+"";
  }
}
