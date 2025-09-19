public class Tablet extends Equipo {
    public String tamanoDiagonal;
    public TipoPantalla tipoPantalla;
    public String tamanoMemoriaNAND;
    public SistemaOperativo sistemaOperativo;

    public Tablet(String fabricante, String modelo, String microprocesador, String memoria,
                  String tamanoDiagonal, TipoPantalla tipoPantalla,
                  String tamanoMemoriaNAND, SistemaOperativo sistemaOperativo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
        this.memoria = memoria;
        this.tamanoDiagonal = tamanoDiagonal;
        this.tipoPantalla = tipoPantalla;
        this.tamanoMemoriaNAND = tamanoMemoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }
}
