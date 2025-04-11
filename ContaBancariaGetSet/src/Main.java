import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<ContaBancaria> contas = new ArrayList<>();

    public static void main(String[] args) {


        while (true) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "****** Ben-vindo ao banco Nubank ****** \n\n Digite a opção desejada:\n 1 - Criar Conta\n 2 - Depositar \n 3 - Sacar \n 4 - Transferir \n 5 - Extrato \n 6 - Sair"));

            switch (opcao) {

                case 1:
                    ContaBancaria.criarConta();
                    break;

                case 2:
                    ContaBancaria.depositar();
                    break;

                case 3:
                  ContaBancaria.sacar();
                    break;


                case 4:
                    ContaBancaria.transferir();
                    break;

                case 5:
                    ContaBancaria.exibirExtrato();
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;


            }

        }
    }
}
