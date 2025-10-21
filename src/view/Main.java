package view;

import controller.ReservaController;
import java.util.Scanner;
import model.Reserva;

public class Main {
    public static void main(String[] args) {
        ReservaController controller = new ReservaController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Reserva de Hotel ===");
        try {
            System.out.print("ID da Reserva: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nome do Cliente: ");
            String nome = scanner.nextLine();

            System.out.print("Documento (CPF): ");
            String documento = scanner.nextLine();

            System.out.print("Tipo de quarto (standard/luxo): ");
            String tipoQuarto = scanner.nextLine();

            System.out.print("Data de Check-in (dd/MM/yyyy): ");
            String dataCheckIn = scanner.nextLine();

            controller.criarReserva(id, nome, documento, tipoQuarto, dataCheckIn);

            System.out.println("\nReservas cadastradas:");
            for (Reserva r : controller.listarReservas()) {
                System.out.println(r);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
