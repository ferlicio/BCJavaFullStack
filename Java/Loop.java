public class Loop {
    public static void main(String[] args) {
        // loop For

        for(int cont = 0; cont < 10; cont++){
            System.out.println(cont + " - Java");
        }

        int cont = 11;
        //int max = 10;

        while(cont <= 10){
            System.out.println(cont + " - Java");
             cont ++;
        }

        cont = 11;
        do{
            System.out.println(cont + " - Extensão Java");
            cont ++;
        }while(cont <=10);
    }
}
