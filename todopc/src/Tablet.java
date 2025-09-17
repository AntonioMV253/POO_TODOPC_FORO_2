public class Tablet extends Equipo {
    public String tamanoDiagonal;
    public TipoPantalla tipoPantalla;
    public String tamanoMemoriaNAND;
    public SistemaOperativo sistemaOperativo;

    public Tablet(String fabricante, String modelo, String microproccesador, String memoria, String tamanoDiagonal, TipoPantalla tipoPantalla, String tamanoMemoriaNAND, SistemaOperativo sistemaOperativo){

        super(fabricante, modelo, microproccesador, memoria);
        this.tamanoDiagonal = tamanoDiagonal;
        this.tipoPantalla =tipoPantalla;
        this.tamanoMemoriaNAND = tamanoMemoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

}

