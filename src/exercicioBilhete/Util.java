package exercicioBilhete;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Double.*;

public class Util {
    private bilheteUnico[] bilhete = new bilheteUnico[2];
    private int index=0;
    public void menuPrincipal(){
        int opcao;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";

        do{
           opcao = parseInt(showInputDialog(menu));
           if(opcao==1){
                   menuAdministrador();
           }else{
               if(opcao==2){

               }
           }

        }while(opcao !=3);

    }
    private void menuAdministrador(){
        int opcao=0;
        while(!((opcao) ==4)) {
            String menu = "MENU ADMINISTRADOR\n1. Emitir Bilhete\n2.Listar bilhetes\n3.Excluir bilhete\n4. Sair";
            opcao = parseInt(showInputDialog(menu));
            if (opcao == 1) {
                emitirBilhete();
            } else {
                if (opcao == 2) {
                    listarBilhete();
                }
            }
        }
    }
    private void emitirBilhete(){
       String nome,perfil;
       long cpf;
       if(index< bilhete.length){
           nome=showInputDialog("Nome do usuário:");
           cpf=parseLong(showInputDialog("CPF: "));
           perfil=showInputDialog("Estudante/Professor/Comum");
           bilhete[index++]= new bilheteUnico(cpf,nome,perfil);
        }else{
           showMessageDialog(null, "Procure um posto de atendimento");
       }
    }
    private void listarBilhete(){
        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";
        for(int i=0;i<index;i++){
            aux+="Numero do bilhete: "+ bilhete[i].numero+"\n";
            aux+="Saldo do bilhete: R$"+ df.format(bilhete[i].saldo)+"\n";
            aux+="Nome do usuário: "+ bilhete[i].usuario.nome+"\n";
            aux+="Perfil do usuário: "+ bilhete[i].usuario.perfil+"\n";
            aux+="CPF do usuário: "+ bilhete[i].usuario.cpf+"\n\n";
        }
        showMessageDialog(null,aux);
    }
    private void excluirBilhete(){
        String num = "Numero do bilhete que deseja excluir";
        int aux;
        aux=parseInt(showInputDialog(num));
    }
}
