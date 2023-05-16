package lista06;

import java.util.Arrays;

//primeiro a chegar é o primeiro a sair FIFO
//ao tirar o
//tamanho + inicio - limite se tamanho + inicio >= limite (significa que estamos usando o vetor de forma circular) - indice de onde devo adicioonar
//tamanho + inicio para sabermos onde precisamos colocar o novo valor.
//se tamanho = limite - nao tem espaco disponivel]
//(inicio + tamanho) % limite = pra descobrir a posicao
public class FilaVetor<T> implements Fila<T> {
	private T info[];
	private int limite;
	private int tamanho;
	private int inicio; //para saber onde a lista está comecando ao retirar numeros do inicio da lista
	
	public FilaVetor(int limite) {
		info = (T[]) new Object[limite];//instancia um vetor capaz de guardar objetos
		this.limite = limite;
		this.tamanho = 0;
		this.inicio = 0;
	}
	
	@Override
	public void inserir(T valor) {
		if (this.tamanho == this.limite) {
			throw new FilaCheiaException();
		}
		
		int posicao = (this.inicio + this.tamanho) % this.limite;
		
//		posicao = inico + tamanho;
//		if posicao >= limite
//			posicao -= limite;
//		
		
		info[posicao] = valor;
		this.tamanho++;
	}

	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	@Override
	public T peek() {//retorna a primeira
		
		if (estaVazia()) {
			throw new FilaVaziaException();
		}
		
		return info[this.inicio];
	}

	@Override
	public T retirar() {
		T valor = peek();
		info[inicio] = null;
		inicio = (inicio + 1) % limite; //recalculo do inicio
		tamanho--;
		return valor;
	}

	@Override
	public void liberar() {
		info = (T[]) new Object[limite];
		this.tamanho = 0;
		//pode ou nao reiniciar o inicio
	}
	
	public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> nova) {
		int limiteConcatenada = this.limite + nova.limite;
		
		FilaVetor<T> concatenada = new FilaVetor<T>(limiteConcatenada);
		int indice = this.inicio;
		
		for (int i = 0; i < this.tamanho; i++) {
			T valor = info[indice];
			concatenada.inserir(valor);
			indice = (indice + 1) % this.limite;
		}
		
		indice = nova.inicio;
		
		for (int i = 0; i < nova.tamanho; i++) {
			T valor = info[indice];
			concatenada.inserir(valor);
			indice = (indice + 1) % nova.limite;
		}
		
		return concatenada;
	}

	@Override
	public String toString() {
		
		String retorno = "";
		
		int indice = inicio;
		
		for (int i = 0; i < tamanho; i++) {
			if (i < 0) {
				retorno = retorno + " ,";
			}
			
			retorno = retorno + info[indice];
			indice = (indice + 1) % limite;
		}
		
		return retorno;
	}
	
	

}
