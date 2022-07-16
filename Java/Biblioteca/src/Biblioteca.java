public class Biblioteca {
    public static void main(String[] args) {
        LivroFisico l1 = new LivroFisico("kafta", 2);

        System.out.println(l1.verificarDisponibilidade());
        l1.emprestarLivro();
        l1.emprestarLivro();
        System.out.println(l1.verificarDisponibilidade());

        Ebook e1 = new Ebook("meu pé de laranja lima");
        System.out.println(e1.verificarDisponibilidade());
        e1.emprestarLivro();
        e1.emprestarLivro();
        System.out.println(e1.verificarDisponibilidade());

    }
}
