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
                //registrar desktops
            }
            case 2: {
                //registrar laptops

            }
            case 3: {
                //Registrar tables ejemplo de como hacerlo (Acá toca validar si es capacitiva o resistiva con el enum de tipo de pantalla)
//                Tablet t = new Tablet();
//                t.fabricante = JOptionPane.showInputDialog("Fabricante:");
//                t.modelo = JOptionPane.showInputDialog("Modelo:");
//                t.microprocesador = JOptionPane.showInputDialog("Microprocesador:");

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
               //listar desktops
                break;
            case 2:
                //listar laptops

                break;
            case 3:
                //listar tablets

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
}
