public class Condicional {
    public static void main(String[] args) {

        boolean condicao = false;

        if(condicao){
            System.out.println("Passou por aqui");
        }else{
            System.out.println("Passou pelo else");
        }

        int nota = 80;
        int media = 60;
        int falta = 4;
        int maxfalta = 5;

        if(nota >= media && falta <= maxfalta){
            System.out.println("Aprovado");
        }else if(nota >= 40){
            System.out.println("Recuperação");
        }else{
            System.out.println("Reprovado");
        }
        

        // condição ternária

        String resultado = "";

        resultado = (nota > media) ? "Aprovado" : "Reprovado";
        System.out.println(resultado);


        int posicao = 5;

        switch(posicao){
            case 1:
                System.out.println("Chegou em primeiro lugar");
                break;
            case 2:
                System.out.println("Chegou em segundo lugar");
                break;
            case 3:
                System.out.println("Chegou em terceiro lugar");
                break;
            case 4: case 5: case 6:
                System.out.println("Premiação de participação");
                break;
            default:
                System.out.println("Não subiu ao pódio");
        }



    }
}
