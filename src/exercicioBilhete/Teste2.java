package exercicioBilhete;

public class Teste2 {
    public static void main(String[] args) {
        System.out.println("soma = "+ somar(2,3));
        System.out.println("soma = "+ somar(2,3,4));
        System.out.println("soma = "+ somar(2,3,4,1,7));
    }
    public static int somar (int ...x){
        int total=0;
        for(int i:x){
            total+=i;
        }
        return total;
    }

}
