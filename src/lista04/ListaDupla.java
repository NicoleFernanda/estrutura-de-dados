package lista04;


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
	
	
	public void exibirOrdemInversa() {
		NoListaDupla<T> n = new NoListaDupla<T>();
		n = getPrimeiro();
		
		while(n != null) { //enquando a lista nn terminar
			
			if (n.getProximo() == null) { //significa que parou no último
				
				while(n != null) { //fazer até chegar no primeiro (primeiro tem anterior = null)
					System.out.print(n.getInfo().toString()); //imprimo
					 //pego o anterior do atual até chegar no primeiro da lista
					
					if (n.getAnterior() != null) {
						System.out.print(", ");
					} 
					n = n.getAnterior();
				}
								
				break;
			}
			
			n = n.getProximo();
		}
		
	
	}
	
	//nao foi pedido pelo professor, eu quem criei
	public String retornaInverso() {
		NoListaDupla<T> n = new NoListaDupla<T>();
		n = getPrimeiro();
		
		String retorno = "";
		
		while(n != null) { //enquando a lista nn terminar
			
			if (n.getProximo() == null) { //significa que parou no último
				
				while(n != null) { //fazer até chegar no primeiro (primeiro tem anterior = null)
					retorno = retorno + n.getInfo().toString(); //imprimo
					 //pego o anterior do atual até chegar no primeiro da lista
					
					if (n.getAnterior() != null) {
						retorno = retorno + ", ";
					} 
					n = n.getAnterior();
				}
								
				break;
			}
			
			n = n.getProximo();
		}
		
		return retorno;
	}
	
	public void liberar() {
		NoListaDupla<T> no = getPrimeiro();
		
		while (no != null) {
			this.primeiro = no;
			primeiro.setAnterior(null);

			if (primeiro.getProximo() == null) {
				this.primeiro = null;
				break;
			}

			no = no.getProximo();
			no.getAnterior().setProximo(null);
		}

	}
	
	public ListaDupla<T> clonar() {
		ListaDupla <T> clonada = new ListaDupla<T>();
		NoListaDupla<T> n = getPrimeiro();

		while (n != null) { // enquanto a lista nao terminar

			if (n.getProximo() == null) { // significa que parou no ultimo n�

				while (n != null) { // fazer at� chegar no primeiro (primeiro tem anterior = null)
					clonada.inserir(n.getInfo()); // coloco na minha lista clonada o - primeiro item que foi inserido - o ultimo da lista
					// pego o anterior do atual at� chegar no primeiro da lista
					n = n.getAnterior();
				}
				
				break; //para quando chegar no this.primeiro
			}

			n = n.getProximo();
		}
		
		return clonada;
	}
	
	private NoListaDupla<T> retornaNos() {
		return null;
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
