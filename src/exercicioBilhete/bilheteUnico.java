package exercicioBilhete;

import java.util.Random;

public class bilheteUnico {

    long numero;
    double saldo;
    Usuario usuario;
    static final double TARIFA=5.20;

    public bilheteUnico (long cpf, String nome, String perfil){
        Random random = new Random();
        numero = random.nextLong(1000, 10000);
        usuario = new Usuario(cpf,nome,perfil);
    }

    public double carregaBilhete(double carga){
        return saldo+=carga;
    }

    public double consultarSaldo(){
        return saldo;
    }

    public String catraca(){
        if(saldo>=TARIFA/2) {
            if (usuario.perfil.equalsIgnoreCase("Comum")) {
                saldo -= TARIFA;
                return "Catraca liberada";
            } else {
                saldo -= TARIFA / 2;
                return "Catraca liberada";
            }
        }else {
            return "Saldo insuficiente";
        }
    }

}
