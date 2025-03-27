package exercicioBilhete;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Double.*;

public class Util {
    private bilheteUnico[] bilhete = new bilheteUnico[3];
    private int index = 0;


    public void menuPrincipal() {
        int opcao;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";

        do {
            opcao = parseInt(showInputDialog(menu));
            if (opcao == 1) {
                menuAdministrador();
            } else {
                if (opcao == 2) {
                    menuUsuario();
                }
            }

        } while (opcao != 3);

    }

    private void menuAdministrador() {
        int opcao = 0;
        while (!((opcao) == 4)) {
            String menu = "MENU ADMINISTRADOR\n1. Emitir Bilhete\n2.Listar bilhetes\n3.Excluir bilhete\n4. Sair";
            opcao = parseInt(showInputDialog(menu));
            if (opcao == 1) {
                emitirBilhete();
            } else {
                if (opcao == 2) {
                    listarBilhete();
                } else {
                    if (opcao == 3) {
                        excluirBilhete();
                    }
                }
            }
        }
    }

    private void emitirBilhete() {
        String nome, perfil;
        long cpf;
        if (index < bilhete.length) {
            nome = showInputDialog("Nome do usuário:");
            cpf = parseLong(showInputDialog("CPF: "));
            perfil = showInputDialog("Estudante/Professor/Comum");
            bilhete[index++] = new bilheteUnico(cpf, nome, perfil);
        } else {
            showMessageDialog(null, "Procure um posto de atendimento");
        }
    }

    private void listarBilhete() {
        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";
        for (int i = 0; i < index; i++) {
            aux += "Numero do bilhete: " + bilhete[i].numero + "\n";
            aux += "Saldo do bilhete: R$" + df.format(bilhete[i].saldo) + "\n";
            aux += "Nome do usuário: " + bilhete[i].usuario.nome + "\n";
            aux += "Perfil do usuário: " + bilhete[i].usuario.perfil + "\n";
            aux += "CPF do usuário: " + bilhete[i].usuario.cpf + "\n\n";
        }
        showMessageDialog(null, aux);
    }

    private void excluirBilhete() {
        int resposta;
        int indice = acharBilhete();
        long cpf;
        if (indice != -1) {
            resposta = showConfirmDialog(null, "Tem certeza que deseja excluir?");
            if (resposta == YES_OPTION) {
                bilhete[indice] = bilhete[index - 1];
                index--;
            }
        }
    }


    public void menuUsuario() {

        int opcao;
        String menu = "1. Carregar Bilhete\n2. Consultar saldo\n3.Passar na catraca\n4. Sair";

        do {
            opcao = parseInt(showInputDialog(menu));
            if (opcao == 1) {
                carregarSaldo();
            } else {
                if (opcao == 2) {
                    consultarSado();
                } else {
                    if (opcao == 3) {
                        passarCatraca();
                    } else {
                        if (opcao == 4) {
                            menuPrincipal();
                        } else {
                            showMessageDialog(null, "Opção inválida");
                        }
                    }
                }
            }
        } while (opcao != 3);
    }

    private int acharBilhete() {
        long cpf = parseLong(showInputDialog("CPF: "));
        int aux;

        for (int i = 0; i < index; i++) {
            if (cpf == bilhete[i].usuario.cpf) {
                return i;
            }
        }
        showMessageDialog(null, cpf + " Não encontrado");
        return -1;
    }

    private void carregarSaldo() {
        int indice = acharBilhete();
        double valor;
        if (indice != -1) {
            valor = parseDouble(showInputDialog("Valor da recarga:"));
            bilhete[indice].carregaBilhete(valor);
        }
    }

    private void consultarSado() {
        int indice = acharBilhete();
        if (indice != -1) {
            showMessageDialog(null, "Saldo = RS$ " + bilhete[indice].consultarSaldo());
        }


    }

    private void passarCatraca() {
        int indice = acharBilhete();
        if (indice != -1) {
            showMessageDialog(null, bilhete[indice].catraca());
        }
    }
}
