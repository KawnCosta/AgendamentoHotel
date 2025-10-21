package view;

import controller.ReservaController;
import java.util.Scanner;
import model.Reserva;

public class Main {
    public static void main(String[] args) {
        ReservaController controller = new ReservaController();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("=== Sistema de Reserva de Hotel ===");
            System.out.print("ID da Reserva: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nome do Cliente: ");
            String nome = sc.nextLine();

            System.out.print("Documento: ");
            String doc = sc.nextLine();

            System.out.print("Tipo de quarto (standard/luxo): ");
            String tipo = sc.nextLine();

            System.out.print("Data de Check-in (dd/MM/yyyy): ");
            String data = sc.nextLine();

            controller.criarReserva(id, nome, doc, tipo, data);

            System.out.println("\nReservas cadastradas:");
            for (Reserva r : controller.listarReservas()) {
                System.out.println(r);
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
