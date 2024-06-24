public class Container <T>{
    private T valor;

    public Container(){}

    public Container(T valor){
        this.valor = valor;
    }

    public T getValor(){
        return valor;
    }

    public void setValor(){
        this.valor = valor;
    }
}
