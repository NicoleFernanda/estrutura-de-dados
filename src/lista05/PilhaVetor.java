package lista05;

import java.util.Arrays;

public class PilhaVetor <T> implements Pilha <T>{
	private T info[];
	private int limite;
	private int tamanho;
		
	public PilhaVetor(int limite) {
		info = (T[]) new Object[limite];//instancia um vetor capaz de guardar objetos
		this.limite = limite;
		this.tamanho = 0;
	}

	@Override
	public void push(T novo) {
		// TODO Auto-generated method stub
		if (this.tamanho == this.limite) {
			throw new PilhaCheiaException();
		} else {
			this.info[tamanho] = novo;
			this.tamanho++;
		}
		
	}

	@Override
	public T pop() {
		T valor = peek();
		info[tamanho - 1] = null;
		tamanho--;
		return null;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new PilhaVaziaException();
		}
		
		return info[tamanho - 1]; //retorna o ultimo que eu adicionei, já que ao adicionar é somado 1 ao tamanho
	}

	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	@Override
	public void liberar() {
		info = (T[]) new Object[this.limite];
		tamanho = 0;
		
		/* 2a opção
		 while (!estaVazia()) { //quando desempilhar o ultimo, vai retornar estaVazia = true e vai parar o loop
		  	pop();
		 } 
		 */
		
		/* 3a opção (desempilha enquanto for possível)
		 try {
		 	while (true) {
		  	pop();
		 }
		 } catch(PilhaVaziaException e) {
		 
		 }
		 
		 */
		
		
	}
	
	public void concatenar(PilhaVetor<T> segunda) {
		for (int i = 0; i < segunda.tamanho; i++) {
			this.push(segunda.info[i]);
		}
	}

	@Override
	public String toString() {
		String resultado = "";
		
		for (int i = (tamanho - 1); i >= 0; i--) {
			resultado += info[i].toString();
			
			if (i > 0) {
				resultado = resultado + " ,";
			}
		}
		
		return resultado;
		
	}

}
