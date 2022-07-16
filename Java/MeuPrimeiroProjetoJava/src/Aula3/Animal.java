package Aula3;

public class Animal {
    private String nome;
    private String especie;
    private int idade;

    public Animal(String nome, String especie, int idade){
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
    }

    public void vacinar(){
        System.out.println("O animal "+ getNome() + " foi vacinado");
    }
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade < 0){
            idade *= -1;
            System.out.println("Não existe idade negativa");
        }else{
            this.idade = idade;
        }

    }
}
