public class Main {
    public static void main(String[] args) {
        Container<Integer> containerInteiro = new Container<>(15);
        System.out.println("Inteiros do container: " + containerInteiro.getValor());

        Container<Double> containerDouble = new Container<>(2.15);
        System.out.println("Valores double do container: " + containerDouble.getValor());

        Container<String> containerString = new Container<>("bôa - duvet");
        System.out.println("String armazenada no container: " + containerString.getValor());
    }
}
