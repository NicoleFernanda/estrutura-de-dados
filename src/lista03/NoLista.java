package lista03;

public class NoLista <T> {
	
	private T info;
	private NoLista<T> proximo; //o ultimo elemento (primeiro que doi adicionado) nao tem proximo
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NoLista<T> getProximo() {
		return proximo;
	}
	public void setProximo(NoLista<T> proximo) {
		this.proximo = proximo;
	}

}
