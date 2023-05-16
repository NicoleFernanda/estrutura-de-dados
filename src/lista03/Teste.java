package lista03;

public class Teste {
	public static void main(String[] args) {
		ListaEncadeada<Integer> l = new ListaEncadeada<>();
		l.inserir(1);
		l.inserir(2);
		l.inserir(3);
		System.out.println("lista vazia ? " + l.estaVazia());
		l.retirar(1);
		l.retirar(2);
		l.retirar(3);
		System.out.println("lista vazia ? " + l.estaVazia());
		l.inserir(1);
		l.inserir(2);
		l.inserir(3);
		System.out.println(l.buscar(1).getInfo());
		System.out.println(l.buscar(5));
		System.out.println("retira o 1 ");
		l.retirar(1);
		System.out.println("obter comprimento : " + l.obterComrpimento());
		l.exibir();
		System.out.println("retira o 2 ");
		l.retirar(2);
		l.exibir();
		System.out.println("retira o 3 ");
		l.retirar(3);
		l.exibir();
		System.out.println("lista vazia ? " + l.estaVazia());
		System.out.println("obter comprimento : " + l.obterComrpimento());
		l.inserir(1);
		l.inserir(2);
		l.inserir(3);
		System.out.println(l.buscar(1).getInfo());
	}
}
