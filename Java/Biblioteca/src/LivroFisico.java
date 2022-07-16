public class LivroFisico extends Livro{


    public LivroFisico(String nome, int quantidade) {
        super(nome, quantidade);
    }

    @Override
    public boolean verificarDisponibilidade() {
        if(getQuantidade() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void emprestarLivro() {
        if (this.verificarDisponibilidade()){
            setQuantidade(getQuantidade() - 1);
            System.out.println("O livro " + getNome() +
                    "foi emprestado como sucesso");
        }else{
            System.out.println("O Livro " + getNome() +
                    " está indisponível!");
        }
    }
}
