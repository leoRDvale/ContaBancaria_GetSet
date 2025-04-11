import javax.swing.*;

public class ContaBancaria {
    private static int contador = 1;
    private Titular titular;
    private int conta;
    private double saldo;

    public ContaBancaria(Titular titular) {
        this.titular = titular;
        this.conta = contador++;
        this.saldo = 0.0;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        ContaBancaria.contador = contador;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static void criarConta() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do titular: ");
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do titular: ");
        String endereco = JOptionPane.showInputDialog(null, "Digite o endereço do titular: ");
        String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do titular: ");

        Titular titular = new Titular(nome, cpf, endereco, telefone);
        ContaBancaria novaConta = new ContaBancaria(titular);
        Main.contas.add(novaConta);
        JOptionPane.showMessageDialog(null, "Conta criada com sucesso! Número da conta: " + novaConta.getConta());
    }

    public static void depositar() {
        String contaDeposito = JOptionPane.showInputDialog(null, "Digite o número da conta para depósito: ");
        double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser depositado: "));
        boolean contaEncontrada = false;

        for (ContaBancaria conta : Main.contas) {
            if (conta.getConta() == Integer.parseInt(contaDeposito)) {
                conta.setSaldo(conta.getSaldo() + valorDeposito);
                JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso! Novo saldo: R$" + conta.getSaldo());
                contaEncontrada = true;
                break;
            }
        }

        if (!contaEncontrada) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public static void sacar() {
        String contaSaque = JOptionPane.showInputDialog(null, "Digite o número da conta para saque: ");
        double valorSaque = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser sacado: "));
        boolean contaEncontrada = false;

        for (ContaBancaria conta : Main.contas) {
            if (conta.getConta() == Integer.parseInt(contaSaque)) {
                if (conta.getSaldo() >= valorSaque) {
                    conta.setSaldo(conta.getSaldo() - valorSaque);
                    JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! Novo saldo: R$" + conta.getSaldo());
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                }
                contaEncontrada = true;
                break;
            }
        }

        if (!contaEncontrada) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public static void transferir() {
        String contaTransferencia = JOptionPane.showInputDialog(null, "Digite o número da conta origem para transferência: ");
        double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser transferido: "));
        String contaDestino = JOptionPane.showInputDialog(null, "Digite o número da conta de destino: ");
        boolean contaEncontrada = false;

        for (ContaBancaria conta : Main.contas) {
            if (conta.getConta() == Integer.parseInt(contaTransferencia)) {
                if (conta.getSaldo() >= valorTransferencia) {
                    for (ContaBancaria contaDest : Main.contas) {
                        if (contaDest.getConta() == Integer.parseInt(contaDestino)) {
                            conta.setSaldo(conta.getSaldo() - valorTransferencia);
                            contaDest.setSaldo(contaDest.getSaldo() + valorTransferencia);
                            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso! Novo saldo: R$" + conta.getSaldo());
                            contaEncontrada = true;
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                }
                break;
            }
        }

        if (!contaEncontrada) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public static void exibirExtrato() {
        String contaSaldo = JOptionPane.showInputDialog(null, "Digite o número da conta para exibir o extrato: ");
        boolean contaEncontrada = false;

        for (ContaBancaria conta : Main.contas) {
            if (conta.getConta() == Integer.parseInt(contaSaldo)) {
                JOptionPane.showMessageDialog(null, "Extrato da conta: \n\n Nome: " + conta.getTitular().getNome() + "\n CPF: " + conta.getTitular().getCpf() + "\n Endereço: " + conta.getTitular().getEndereco() + "\n Telefone: " + conta.getTitular().getTelefone() + "\n Número da Conta: " + conta.getConta() + "\n Saldo: R$" + conta.getSaldo());
                contaEncontrada = true;
                break;
            }
        }

        if (!contaEncontrada) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }



}