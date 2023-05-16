package lista07;

public class NoArvoreBinaria <T> {
    T info;
    NoArvoreBinaria<T> esquerda;
    NoArvoreBinaria<T> direita;

    public NoArvoreBinaria(T info) {
        setInfo(info);
        setEsquerda(null);
        setDireita(null);
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esquerda, NoArvoreBinaria<T> direita) {
        setInfo(info);
        setEsquerda(esquerda);
        setDireita(direita);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }
}