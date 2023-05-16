package lista01;

public class ListaEstatica {
	private int info[];
	private int tamanho;
	
	public ListaEstatica() {
		info = new int[10];
		tamanho = 0;
	}
	
	public void inserir(int valor) {
		if (tamanho == info.length) { //todas as posições estão sendo utilizadas
			redimensionar();          //redimensiona então
		}
		
		info[tamanho] = valor;
		tamanho++;
	}
	
	private void redimensionar() {
		int novo[] = new int[info.length + 10];
		
		for (int i = 0; i < info.length; i++) {
			novo[i] = info[i];
		}
		
		info = novo; //info agora trocou de tamanho
	}
	
	public void exibir() {
		for (int i = 0; i < tamanho; i++) {
			System.out.println("[" + i + "] = " + info[i]);
		}
	}
	
	public int buscar(int valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
			
		}
		
		return -1;
	}
	
	public void retirar(int valor) {
		int posicao = buscar(valor); //buscar a posicao do valor que eu quero
		
		if (posicao > -1) {
			for (int i = posicao + 1; i < tamanho; i++) {//indice do elemento depois do qual eu quero excluir, pq eu quero que ele tome o luar do que vai retirar
				info[i - 1] = info[i]; //a posicao do proxima toma o lugar do valor que eu quero
			}
			
			tamanho--;
		}
		
	}
	
	
	
	public void liberar() { //limpar a estrutura, de forma que o vetor tenha que ser redimensionado novamente para 10 posicoes;
		info = new int[10];
		tamanho = 0;
	}                                                                                              
	
	public int obterElemento(int posicao) {
		if((posicao >= 0) && (posicao > tamanho)) {
			return(info[posicao]);
		} else {
			throw new IndexOutOfBoundsException();
		}
		
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}

	public int getTamanho() {
		return tamanho;
	}

	@Override
	public String toString() {
		String resultado = "";
		
		for (int i = 0; i < tamanho; i++) {
			if (i > 0) {
				resultado = resultado + ", ";
			}
			
			resultado = resultado + info[i];
		}
		
		return resultado;
	}
	
}
