import javax.swing.*;
import java.util.ArrayList;

public class App {

    // Listas para almacenar los equipos
    static ArrayList<Desktop> desktops = new ArrayList<>();
    static ArrayList<Laptop> laptops = new ArrayList<>();
    static ArrayList<Tablet> tablets = new ArrayList<>();

    public static void main(String[] args) {
        int opcion = 0;

        do {
            String menu =
                    "=== MENÚ PRINCIPAL ===\n" +
                            "1. Registrar equipo\n" +
                            "2. Ver equipos\n" +
                            "3. Salir\n";

            String input = JOptionPane.showInputDialog(menu);
            if (input == null) break; // si cancela

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número");
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarEquipo();
                    break;
                case 2:
                    verEquipos();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Has seleccionado Salir");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }

        } while (opcion != 3);
    }

    private static void registrarEquipo() {
        String menu =
                "¿Qué tipo de equipo quieres registrar?\n" +
                        "1. Desktop\n" +
                        "2. Laptop\n" +
                        "3. Tablet\n";

        String input = JOptionPane.showInputDialog(menu);
        if (input == null) return;

        int opcion;
        try {
            opcion = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opción inválida");
            return;
        }

        switch (opcion) {
            case 1: {
                Desktop d = new Desktop();
                d.fabricante = solicitarTextoNoVacio("Fabricante:");
                d.modelo = solicitarTextoNoVacio("Modelo:");
                d.microprocesador = solicitarTextoNoVacio("Microprocesador:");
                d.memoria = solicitarTextoNoVacio("Memoria:");
                d.tarjetaGrafica = solicitarTextoNoVacio("Tarjeta gráfica:");
                d.tamanoTorre = solicitarTextoNoVacio("Tamaño de torre:");
                d.capacidadDisco = solicitarTextoNoVacio("Capacidad de disco:");
                desktops.add(d);
                JOptionPane.showMessageDialog(null, "Desktop registrada correctamente.");
                break;
            }
            case 2: {
                Laptop l = new Laptop();
                l.fabricante = solicitarTextoNoVacio("Fabricante:");
                l.modelo = solicitarTextoNoVacio("Modelo:");
                l.microprocesador = solicitarTextoNoVacio("Microprocesador:");
                l.memoria = solicitarTextoNoVacio("Memoria:");
                l.tamanoPantalla = solicitarTextoNoVacio("Tamaño de pantalla:");
                l.capacidadDisco = solicitarTextoNoVacio("Capacidad de disco:");
                laptops.add(l);
                JOptionPane.showMessageDialog(null, "Laptop registrada correctamente.");
                break;
            }
            case 3: {
                    Tablet t = new Tablet();

                    // Solicitar datos básicos
                    t.fabricante = solicitarTextoNoVacio("Fabricante:");
                    t.modelo = solicitarTextoNoVacio("Modelo:");
                    t.microprocesador = solicitarTextoNoVacio("Microprocesador:");
                    t.tamanoDiagonal = solicitarTextoNoVacio("Tamaño diagonal de pantalla:");

                    // Validar tipo de pantalla con enum
                    TipoPantalla tipoPantalla = null;
                    do {
                        String inputPantalla = JOptionPane.showInputDialog(
                                "Tipo de pantalla (CAPACITIVA o RESISTIVA):"
                        );
                        if (inputPantalla == null) break; // Cancelar registro
                        try {
                            tipoPantalla = TipoPantalla.valueOf(inputPantalla.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null, "Tipo de pantalla no válido. Intenta nuevamente.");
                        }
                    } while (tipoPantalla == null);
                    t.tipoPantalla = tipoPantalla;

                    // Tamaño memoria NAND
                    t.tamanoMemoriaNAND = solicitarTextoNoVacio("Tamaño memoria NAND:");

                    // Selección de Sistema Operativo usando enum
                    String[] opcionesSO = new String[SistemaOperativo.values().length];
                    for (int i = 0; i < SistemaOperativo.values().length; i++) {
                        opcionesSO[i] = SistemaOperativo.values()[i].name();
                    }
                    String seleccionSO = (String) JOptionPane.showInputDialog(
                            null,
                            "Selecciona Sistema Operativo:",
                            "Sistema Operativo",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesSO,
                            opcionesSO[0]
                    );
                    t.sistemaOperativo = seleccionSO != null ? SistemaOperativo.valueOf(seleccionSO) : SistemaOperativo.ANDROID;

                    // Agregar a la lista de tablets
                    tablets.add(t);
                    JOptionPane.showMessageDialog(null, "Tablet registrada correctamente.");
                    break;
                }

                default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void verEquipos() {
        String menu =
                "¿Qué equipos quieres ver?\n" +
                        "1. Desktops\n" +
                        "2. Laptops\n" +
                        "3. Tablets\n";

        String input = JOptionPane.showInputDialog(menu);
        if (input == null) return;

        int opcion;
        try {
            opcion = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opción inválida");
            return;
        }

        StringBuilder sb = new StringBuilder();

        switch (opcion) {
            case 1:
                sb.append("=== DESKTOPS ===\n");
                for (Desktop d : desktops) {
                    sb.append("Fabricante: ").append(d.fabricante).append("\n")
                            .append("Modelo: ").append(d.modelo).append("\n")
                            .append("Microprocesador: ").append(d.microprocesador).append("\n")
                            .append("Memoria: ").append(d.memoria).append("\n")
                            .append("Tarjeta gráfica: ").append(d.tarjetaGrafica).append("\n")
                            .append("Tamaño de torre: ").append(d.tamanoTorre).append("\n")
                            .append("Capacidad de disco: ").append(d.capacidadDisco).append("\n")
                            .append("----------------------------\n");
                }
                break;

            case 2:
                sb.append("=== LAPTOPS ===\n");
                for (Laptop l : laptops) {
                    sb.append("Fabricante: ").append(l.fabricante).append("\n")
                            .append("Modelo: ").append(l.modelo).append("\n")
                            .append("Microprocesador: ").append(l.microprocesador).append("\n")
                            .append("Memoria: ").append(l.memoria).append("\n")
                            .append("Tamaño pantalla: ").append(l.tamanoPantalla).append("\n")
                            .append("Capacidad de disco: ").append(l.capacidadDisco).append("\n")
                            .append("----------------------------\n");
                }
                break;

            case 3:
                sb.append("=== TABLETS ===\n");
                for (Tablet t : tablets) {
                    sb.append("Fabricante: ").append(t.fabricante).append("\n")
                            .append("Modelo: ").append(t.modelo).append("\n")
                            .append("Microprocesador: ").append(t.microprocesador).append("\n")
                            .append("Tamaño diagonal: ").append(t.tamanoDiagonal).append("\n")
                            .append("Tipo pantalla: ").append(t.tipoPantalla).append("\n")
                            .append("Tamaño memoria NAND: ").append(t.tamanoMemoriaNAND).append("\n")
                            .append("Sistema operativo: ").append(t.sistemaOperativo).append("\n")
                            .append("----------------------------\n");
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }

        if (sb.length() == 0) {
            JOptionPane.showMessageDialog(null, "No hay equipos registrados en esta categoría");
        } else {
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
    private static String solicitarTextoNoVacio(String mensaje) {
        String input;
            input = JOptionPane.showInputDialog(mensaje); // pedir valor
            if (input == null) { // si presiona Cancelar
                return  "No brindado"; // interrumpe el registro
            }
            if (input.trim().isEmpty()) { // si deja vacío o espacios
               return  "No brindado";
            }
        return input; // devuelve valor válido
    }
}