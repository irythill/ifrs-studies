public class Henrique {
    private String nome;
    private int idade;
    private String peso;
    private Double altura;
    private String profissao;
    private String faculdade;

    public Henrique(String nome, int idade, String peso, Double altura, String profissao, String faculdade){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.profissao = profissao;
        this.faculdade = faculdade;
    }

    public void infoHenrique(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("Profissão: " + profissao);
        System.out.println("Faculdade: " + faculdade);
    }
}
