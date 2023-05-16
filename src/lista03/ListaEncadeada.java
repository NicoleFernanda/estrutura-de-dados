package lista03;

public class ListaEncadeada <T> {
	private NoLista<T> primeiro; //se primeiro = null, a lista est� vazia

	public ListaEncadeada() {
		this.primeiro = null; //dispens�vel em java
	}
	
	public NoLista<T> getPrimeiro() {
		return primeiro; 
	}
	
	public void inserir(T info) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(info);
		novo.setProximo(getPrimeiro());
		this.primeiro = novo;
	}
	
	public boolean estaVazia() {
		return (this.primeiro == null);
	}
	
	public NoLista<T> buscar(T info) {
		NoLista<T> p = getPrimeiro();
		
		while(p != null) { //enqaunto a lista nn termineou
			
			if(p.getInfo().equals(info)) {
				return p;
			} else {
				p = p.getProximo();
			}
			
			
		}
		
		return null;
	}
	
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = getPrimeiro();
		
		//vai pesquisar enquanto nao encontrar ou p estiver diferente de null
		while((p != null) && (!p.getInfo().equals(valor))) {
			anterior = p; //sempre guarda o valor do anterior antes de mudar o atual, para saber onde trocar a liga��o do parametro proximo
			p = p.getProximo();
		}
		
		//efetivar retiradad
		if(p != null) { //se estiver null, nao encontrou o objeto
			if(p == primeiro) {
				primeiro = primeiro.getProximo(); //o primeiro ainda nao tem anterior, entao eu s� troco o parametro de primeiro para que ele seja o "segundo" da lista
			} else {
				anterior.setProximo(p.getProximo()); //faz o anterior do qual eu quero tirar se ligar com o seguinte do qual eu tirei
			}
		}
		
	}
	
	public void exibir() {
		NoLista<T> p = getPrimeiro();
		
		while (p != null) {
			System.out.println(p.getInfo());
			p = p.getProximo();
		}
	}
	
	//esse metodo daria para ser trocado por uma variavel tamanho, a qual somaria quando um objeto seu inserido e subtraido ao ser retirado
	public int obterComrpimento() {
		int qtdeNos = 0;
		NoLista<T> p = getPrimeiro();
		
		while(p != null) {
			qtdeNos++;
			p = p.getProximo();
		}
		return qtdeNos;
	}
	
	public NoLista<T> obterNo(int index) {
		
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		NoLista<T> p = getPrimeiro();
		
		while((p != null) && (index > 0)) { //exemplo: 1) bola 2) celular 3) casal -- sabendo que casal foi o primeiro que eu botei, mas a bola esta na primeira posicao
											//quero o casal e coloco index = 2
			index--;						//diminui index 
			p = p.getProximo(); //pego o proximo do qual eu estou trabalhando //pega o que vem depois de bola = celular
		}
		
		if (p == null) {
			throw new IndexOutOfBoundsException();
		}
		
		return p;
		
	}

	@Override
	public String toString() {
		String resultado = "";
		
		NoLista<T> p = getPrimeiro();
		
		while (p != null) {
			if(p != getPrimeiro()) {
				resultado = resultado + ", ";
			}
			
			resultado = resultado + p.getInfo().toString();
			p.getProximo();
			
		}
		
		return resultado;
	}	
}