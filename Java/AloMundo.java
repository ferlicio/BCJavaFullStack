import javax.crypto.interfaces.DHPrivateKey;

public class AloMundo{

    // Isso significa que os atributos estáticos de uma classe são 
    //compartilhados por todas as instâncias dessa classe. 

    //Os métodos static ou métodos da classe são funções que não 
    //dependem de nenhuma variável de instância, quando invocados 
    //executam uma função sem a dependência do conteúdo de um objeto 
    //ou a execução da instância de uma classe, conseguindo chamar 
    //direto qualquer método da classe
    public static void main(String[] args){
       
        System.out.println("Curso Java");

        int x = 5;
        int y = 1;

        //x = y++;
        //x = y;
        //y = y +1;

        x = ++y;

        String minhaString = new String();
        minhaString = "Tatiana";
        System.out.println(minhaString);

        System.out.println("O valor de x é: " + x);
        System.out.println("O valor de y é: " + y);

        int a =1;
        int b = 1;

        a += b;  // a = a + b
        a -= b;

        

    }

    
}