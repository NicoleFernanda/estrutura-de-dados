package correcao;


//proximo e anterior
/*
 * nos nao conseguimos percorrer a estrutura de dados na ordem que elas foram colocads
 em uma lista circular, o seu ultimo item tem como seu proximo, o primeiro;
se inserir pelo final, consegue acessar os dados na ordem que foram inseridos
em resumo, fazer o contrario da lista encadeada da lista 03
 
 */
public class NoListaDupla <T> {
	
	private NoListaDupla<T> anterior; 
	private T info;
	private NoListaDupla<T> proximo;
	
	public NoListaDupla<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(NoListaDupla<T> anterior) {
		this.anterior = anterior;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NoListaDupla<T> getProximo() {
		return proximo;
	}
	public void setProximo(NoListaDupla<T> proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {
		return info + "";
	}

}
