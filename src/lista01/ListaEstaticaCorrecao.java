package lista01;

public class ListaEstaticaCorrecao {
	
	private int[] info;
	private int tamanho;

	/**
	 * Cria uma lista vazia
	 */
	public ListaEstaticaCorrecao() {
		info = new int[10];
		tamanho = 0;
	}
	
	
	/**
	 * Adiciona um valor na lista
	 * @param valor Dado a ser adicionado
	 */
	public void inserir(int valor) {
		if (tamanho == info.length) {
			redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}
	

	/**
	 * Provoca um pseudo redimensionamento do vetor info
	 */
	private void redimensionar() {
		int[] novo = new int[info.length + 10];

		for (int i=0; i<info.length; i++) {
			novo[i] = info[i];
		}
		
		info = novo;
	}	
	
	
	/**
	 * Exibe o conte�do da lista
	 */
	public void exibir() {
		for (int i=0; i<tamanho; i++) {
			System.out.println(info[i]);
		}
	}
	
	
	/**
	 * Procura na lista um determinado valor
	 * @param valor Dado a ser pesquisado
	 * @return posi��o do valor na lista. Caso n�o seja encontrado
	 * retorna -1.
	 */
	public int buscar(int valor) {
		for (int i=0; i<tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * Retira um dado da lista
	 * @param valor Dado a ser removido
	 */
	public void retirar(int valor) {
		int posicao = buscar(valor);
		
		if (posicao > -1) {
			for (int i=posicao+1; i<tamanho; i++) {
				info[i-1] = info[i];
			}
			
			tamanho--;
		}
	}
	
	
	/**
	 * limpa a estrutura de dados, de forma que a 
	 * lista esteja vazia
	 */
	public void liberar() {
		info = new int[10];
		tamanho = 0;
	}
	
	
	/**
	 * Retorna o dado armazenado numa determinada posi��o
	 * da lista.
	 * @param posicao Posi��o do dado
	 * @return Dado localizado
	 */
	public int obterElemento(int posicao) {
		if (posicao >= 0 && (posicao < tamanho)) {
			return info[posicao];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	
	/**
	 * Avalia se a lista est� vazia ou contem dados armazenados.
	 * @return true se a lista estiver vazia, sen�o false.
	 */
	public boolean estaVazia() {
		return tamanho==0;
	}
	
	
	/**
	 * Retorna o tamanho atual da lista, isto �,
	 * a quantidade de dados j� armazenados na estrutura de dados
	 * @return Quantidade de dados armazenados
	 */
	public int getTamanho() {
		return tamanho;
	}
	
	
	/**
	 * Retorna string contendo os dados armazenados na lista
	 */
	@Override
	public String toString() {
		String resultado = "";
		
		for (int i=0; i<tamanho; i++) {
			if (i > 0) {
				resultado += ",";
			}
			resultado += info[i]; 
		}
		
		return resultado;
	}


}