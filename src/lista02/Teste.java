package lista02;

public class Teste {
	public static void main(String[] args) {
		ListaEstatica<Integer> l = new ListaEstatica<>();
		l.inserir(1);
		l.inserir(2);
		l.inserir(3);
		System.out.println("lista : " + l);
		System.out.println("retirar valor 1 da lista");
		l.retirar(1);
		System.out.println("imprimir lista: " + l);
		System.out.println("liberar lista");
		l.liberar();
		System.out.println("imprimir lista: " + l);
		System.out.println("lista esta vazia ? " + l.estaVazia());
		System.out.println("adiciona na lista ");
		l.inserir(1);
		l.inserir(2);
		l.inserir(3);
		l.inserir(4);
		l.inserir(5);
		l.inserir(6);
		System.out.println("lista esta vazia ? " + l.estaVazia());
		System.out.println("inverter");
		l.inverter();
		System.out.println("imprimir lista: " + l);
		System.out.println("obter elemento da lista (existente) de indice 3 : " + l.obterElemento(3));
		l.exibir();
		l.retirar(1);
		l.retirar(2);
		l.retirar(3);
		l.retirar(4);
		l.retirar(5);
		l.retirar(6);
		System.out.println("lista esta vazia ? " + l.estaVazia());
		System.out.println("obter elemento da lista (nao existente) de indice 12 : " + l.obterElemento(12));
	}
}
