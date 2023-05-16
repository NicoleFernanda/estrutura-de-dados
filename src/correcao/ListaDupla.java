package correcao;

/*
nos nao conseguimos percorrer a estrutura de dados na ordem que elas foram colocads
em uma lista circular, o seu ultimo item tem como seu proximo, o primeiro;
se inserir pelo final, consegue acessar os dados na ordem que foram inseridos
em resumo, fazer o contrario da lista encadeada da lista 03
consegue percorrer pelo fim ou pelo come�o
 
 */
public class ListaDupla <T> {
	
	private NoListaDupla<T> primeiro;
	
	public ListaDupla() {
		this.primeiro = null;
	}

	public NoListaDupla<T> getPrimeiro() {
		return primeiro;
	} 
	
	public void inserir(T valor) {
		NoListaDupla<T> novo = new NoListaDupla<T>();
		novo.setInfo(valor);
		novo.setProximo(getPrimeiro());
		novo.setAnterior(null);//ja coloco que o primeiro elemento não terá anterior
		
		if (getPrimeiro() != null) { //se nao for null, significa que tem mais elementos na lista
			this.primeiro.setAnterior(novo);
		}
		
		this.primeiro = novo;

	}

	public NoListaDupla<T> buscar(T valor) {
		NoListaDupla<T> busca = new NoListaDupla<T>();
		busca = getPrimeiro();
		
		while(busca != null) { //enquanto a lista nn terminou
			if(busca.getInfo().equals(valor)) {
				return busca;
			} else {
				busca = busca.getProximo();
			}
		}
		
		return null;
	}
	
	public void retirar(T valor) {
		NoListaDupla<T> excluir = buscar(valor);
		
		if (excluir != null) { //encontrou
			if(excluir == getPrimeiro()) { //se for o primeiro elemento, eu só vou tirar a informação do anterior (atributo anterior) ao primeiro
				this.primeiro = excluir.getProximo();//para que ele seja de fato o primeiro e não referencie nenhum objeto no atributo anterior, já que não há elemento anterior ao primeiro
			} else {
				excluir.getAnterior().setProximo(excluir.getProximo());//o ultimo entra nesse caso
			}
			
			//o ultimo nao entra nesse caso
			if (excluir.getProximo() != null) { //caso não seja o ultimo
				excluir.getProximo().setAnterior(excluir.getAnterior());
			}
		}

	}
	
	//exibir na mesma ordem que ele adicionou
	public void exibirOrdemInversa() {
		NoListaDupla<T> p = obterUltimo();
		
		
		while(p != null) { //enquando a lista nn terminar
			System.out.println(p.getInfo());
			p = p.getAnterior();
		}
	
	}
	
	private NoListaDupla<T> obterUltimo() {
		NoListaDupla<T> ultimo = getPrimeiro();
		NoListaDupla<T> p = getPrimeiro();
		
		while(p != null) {
			ultimo = p;
			p = p.getProximo();
		}
		
		return ultimo;
	}
	
	public void liberarProfessor() {
		NoListaDupla<T> p = getPrimeiro();
		
		while (p != null) {
			p.setAnterior(null);
			NoListaDupla<T> backup;
			backup = p.getProximo();
			p.setProximo(null);
			p = backup;
		}
		
		this.primeiro = null;

	}
	
	public void liberarNicole() {
		NoListaDupla<T> no = new NoListaDupla<T>();
		no = getPrimeiro();
		
		while(no != null) { //enquanto a lista nn terminou
			no.setAnterior(null);
			no = no.getProximo();
			no.getAnterior().setProximo(null);
		}
		
		primeiro = null;
	}

	@Override
	public String toString() {
		
		String resultado = "";
		
		NoListaDupla<T> no = getPrimeiro();
		
		while (no != null) {
			if(no != getPrimeiro()) {
				resultado = resultado + ", ";
			}
			
			resultado = resultado + no.getInfo().toString();
			no = no.getProximo();
			
		}
		
		return resultado;
	}
	
	

}

