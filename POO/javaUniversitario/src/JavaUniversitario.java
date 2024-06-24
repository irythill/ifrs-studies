public class JavaUniversitario {
    private String nome;
    private int matricula;
    private String curso;

    public void universitarioInfo (String nome, int matricula, String curso){
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public void showUniversitario(){
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
    }
}
