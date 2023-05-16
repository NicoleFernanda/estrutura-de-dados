package lista02;

public class ListaEstatica <T>{
	
	private T info[];
	private int tamanho;
	
	public ListaEstatica() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}
	
	public void inserir(T valor) {
		if (tamanho == info.length) { //todas as posi��es est�o sendo utilizadas
			redimensionar();          //redimensiona ent�o
		}
		
		info[tamanho] = valor;
		tamanho++;
	}
	
	private void redimensionar() {
		T novo[] = (T[]) new Object[info.length + 10];
		
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
	
	public int buscar(T valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i].equals(valor)) {
				return i;
			}
			
		}
		
		return -1;
	}
	
	public void retirar(T valor) {
		int posicao = buscar(valor); //buscar a posicao do valor que eu quero
		
		if (posicao > -1) {
			for (int i = posicao + 1; i < tamanho; i++) {//indice do elemento depois do qual eu quero excluir, pq eu quero que ele tome o luar do que vai retirar
				info[i - 1] = info[i]; //a posicao do proxima toma o lugar do valor que eu quero
			}
			
			tamanho--;
			info[tamanho] = null;
		}
		
	}
	
	
	
	public void liberar() { //limpar a estrutura, de forma que o vetor tenha que ser redimensionado novamente para 10 posicoes;
		info = (T[]) new Object [10];
		
		tamanho = 0;
	} 
	
	public T obterElemento(int posicao) {
		if(posicao < tamanho) {
			return(info[posicao]);
		} else {
			throw new IndexOutOfBoundsException();
		}
		
	}
	
	public void inverter() {
		
		int esquerda = 0;
		int direita = tamanho - 1;
		int qtdTrocas = tamanho / 2;
		T backup;
		
		while(qtdTrocas > 0) {
			backup = info[esquerda];
			info[esquerda] = info[direita];
			info[direita] = backup;
			
			esquerda++;
			direita--;
			qtdTrocas--;
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
