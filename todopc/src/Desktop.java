public class Desktop extends Equipo {
    private String tarjetaGrafica;
    private String tamanoPantalla;
    private String capacidadDisco;
    private TipoPantalla tipoPantalla;
    private SistemaOperativo sistemaOperativo;

    public Desktop(String fabricante, String modelo, String microprocesador, String memoria,
                   String tarjetaGrafica, String tamanoPantalla, String capacidadDisco,
                   TipoPantalla tipoPantalla, SistemaOperativo sistemaOperativo) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoPantalla = tamanoPantalla;
        this.capacidadDisco = capacidadDisco;
        this.tipoPantalla = tipoPantalla;
        this.sistemaOperativo = sistemaOperativo;
    }

    public enum TipoPantalla {
        TACTIL,
        NO_TACTIL
    }

    public enum SistemaOperativo {
        WINDOWS,
        MACOS,
        LINUX,
        ANDROID
    }

    @Override
    public String toString() {
        return "Fabricante: " + getFabricante()
                + "\nModelo: " + getModelo()
                + "\nMicroprocesador: " + getMicroprocesador()
                + "\nMemoria: " + getMemoria()
                + "\nTarjeta Gráfica: " + tarjetaGrafica
                + "\nTamaño Pantalla: " + tamanoPantalla
                + "\nTipo Pantalla: " + tipoPantalla
                + "\nSistema Operativo: " + sistemaOperativo
                + "\nCapacidad Disco Duro: " + capacidadDisco;
    }
}
