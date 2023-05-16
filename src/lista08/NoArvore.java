package lista08;

public class NoArvore<T> {
	T info;
	NoArvore <T> proximo;//irmao
	NoArvore <T> primeiro;//filho
	
	public NoArvore(T info) {
		
	}
	//filho nao conhece o pai, o pai conhece o filho

	public void inserirFilho(NoArvore<T> sa) { //     no     no a direita     no a direita
		sa.proximo = primeiro;
		primeiro = sa;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoArvore<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoArvore<T> proximo) {
		this.proximo = proximo;
	}

	public NoArvore<T> getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(NoArvore<T> primeiro) {
		this.primeiro = primeiro;
	}
	
	

}
