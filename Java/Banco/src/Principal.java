public class Principal {

    public static void main(String[] args) {
//        Conta c1 = new Conta("Tatiana","123456", "123X", 500);
//        Conta c2 = new Conta("Manuela","123457", "123X", 550);

//
//        ContaCorrente c1 = new ContaCorrente("Tatiana", "123456", "123X", 500);
//        ContaCorrente c2 = new ContaCorrente("Manuela", "123457", "123X", 550);
//
//        c1.mostrarDados();
//        c2.mostrarDados();
//
//        c1.sacar(100);
//        c2.sacar(200);
//
//        c1.depositar(235.76);
//
//        ContaEspecial ce1 = new ContaEspecial("Barbára", "123458",
//                "X123", 200, 500);
//        ce1.mostrarDados();
//        //ce1.sacar(300);
//        ce1.sacar(400);
//
//        ce1.depositar(500);

        ContaCorrente cc1 = new ContaCorrente("Fernando","12345","123",500);
        ContaPoupanca cp1 = new ContaPoupanca("Rafael","12346","123",500);
        ContaEspecial ce1 = new ContaEspecial("Carolina","123458", "123",500,500);

        cc1.sacar(250); //250
        cp1.sacar(350); //150
        ce1.sacar(600);

        cc1.depositar(500); //750
        cp1.depositar(1000); //1150
        ce1.depositar(1000);

    }
}
