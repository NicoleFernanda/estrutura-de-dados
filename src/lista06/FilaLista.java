package lista06;

public class FilaLista<T> implements Fila<T> {
	ListaEncadeada<T> lista;
	
	public FilaLista() {
		lista = new ListaEncadeada<T>();
	}

	@Override
	public void inserir(T valor) {
		lista.inserir(valor);
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new FilaVaziaException();
		}
		
		return lista.getPrimeiro().getInfo();
	}

	@Override
	public T retirar() {
		T valor;
		valor = peek();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<T>();
		
	}

}
