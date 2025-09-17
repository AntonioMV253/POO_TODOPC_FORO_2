public abstract class Equipo {
    public String fabricante;
    public String modelo;
    public String microprocesador;
    public String memoria;

    public Equipo(String fabricante, String modelo, String microprocesador,String memoria){
        this.fabricante = fabricante; 
        this.modelo = modelo;
        this.microprocesador =microprocesador; 
        this.memoria = memoria;
    }

}
