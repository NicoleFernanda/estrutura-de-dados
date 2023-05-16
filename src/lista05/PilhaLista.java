package lista05;

import lista03.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T>{
	
	private ListaEncadeada<T> lista = new ListaEncadeada<T>();

	@Override
	public void push(T novo) {
		lista.inserir(novo);
	}

	@Override
	public T pop() {
		T valor;
		valor = peek();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new PilhaVaziaException();
		}
		return lista.getPrimeiro().getInfo();
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<T>();
		//ou as outras op��es (como em PilhaVetor)
		
	}

	@Override
	public String toString() {
		return lista.toString();
	}
	
	

}
