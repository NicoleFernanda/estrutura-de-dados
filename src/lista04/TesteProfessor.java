package lista04;

import static org.junit.Assert.*;

import org.junit.Test;


public class TesteProfessor {

	private ListaDupla<Integer> lista = new ListaDupla<>();

	// caso 1
	@Test
	public void testInclusao() {
		lista.inserir(5); //  lista.inserir(new Integer(5))
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		NoListaDupla<Integer> no;
		int valor;

		no = lista.getPrimeiro();
		valor = no.getInfo();
		assertEquals(20, valor);

		no = no.getProximo();
		valor = no.getInfo();
		assertEquals(15, valor);

		no = no.getProximo();
		valor = no.getInfo();
		assertEquals(10, valor);

		no = no.getProximo();
		valor = no.getInfo();
		assertEquals(5, valor);

		NoListaDupla<Integer> ultimo = no;

		no = no.getProximo();
		assertEquals(null, no);

		// percorre do �ltimo at� o primeiro
		valor = ultimo.getInfo();
		assertEquals(5, valor);

		no = ultimo.getAnterior();
		valor = no.getInfo();
		assertEquals(10, valor);

		no = no.getAnterior();
		valor = no.getInfo();
		assertEquals(15, valor);

		no = no.getAnterior();
		valor = no.getInfo();
		assertEquals(20, valor);

		no = no.getAnterior();
		assertEquals(null, no);
	}

	// caso 2
	@Test
	public void testBuscarInicio() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		NoListaDupla<Integer> no = lista.buscar(20);
		assertEquals(new Integer(20), no.getInfo());
	}

	// caso 3
	@Test
	public void testBuscarMeio() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		NoListaDupla<Integer> no = lista.buscar(10);
		assertEquals(new Integer(10), no.getInfo());
	}

	// caso 4
	@Test
	public void testRetirarInicio() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		lista.retirar(20);

		NoListaDupla<Integer> no;
		int valor;

		no = lista.getPrimeiro();
		valor = no.getInfo();
		assertEquals(15, valor);

		no = no.getProximo();
		valor = no.getInfo();
		assertEquals(10, valor);

		no = no.getProximo();
		valor = no.getInfo();
		assertEquals(5, valor);

		NoListaDupla<Integer> ultimo = no;

		no = no.getProximo();
		assertEquals(null, no);

		// percorre do �ltimo at� o primeiro
		valor = ultimo.getInfo();
		assertEquals(5, valor);

		no = ultimo.getAnterior();
		valor = no.getInfo();
		assertEquals(10, valor);

		no = no.getAnterior();
		valor = no.getInfo();
		assertEquals(15, valor);

		no = no.getAnterior();
		assertEquals(null, no);
	}

	// caso 5
	@Test
	public void testRetirarMeio() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		lista.retirar(10);

		NoListaDupla<Integer> no;
		int valor;

		no = lista.getPrimeiro();
		valor = no.getInfo();
		assertEquals(20, valor);

		no = no.getProximo();
		valor = no.getInfo();
		assertEquals(15, valor);

		no = no.getProximo();
		valor = no.getInfo();
		assertEquals(5, valor);

		NoListaDupla<Integer> ultimo = no;

		no = no.getProximo();
		assertEquals(null, no);

		// percorre do �ltimo at� o primeiro
		valor = ultimo.getInfo();
		assertEquals(5, valor);

		no = ultimo.getAnterior();
		valor = no.getInfo();
		assertEquals(15, valor);

		no = no.getAnterior();
		valor = no.getInfo();
		assertEquals(20, valor);

		no = no.getAnterior();
		assertEquals(null, no);
	}

	// caso 6
	@Test
	public void testRetirarFim() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		lista.retirar(5);

		NoListaDupla<Integer> no;
		int valor;

		no = lista.getPrimeiro();
		valor = no.getInfo();
		assertEquals(20, valor);

		no = no.getProximo();
		valor = no.getInfo();
		assertEquals(15, valor);

		no = no.getProximo();
		valor = no.getInfo();
		assertEquals(10, valor);

		NoListaDupla<Integer> ultimo = no;

		no = no.getProximo();
		assertEquals(null, no);

		// percorre do �ltimo at� o primeiro
		valor = ultimo.getInfo();
		assertEquals(10, valor);

		no = ultimo.getAnterior();
		valor = no.getInfo();
		assertEquals(15, valor);

		no = no.getAnterior();
		valor = no.getInfo();
		assertEquals(20, valor);

		no = no.getAnterior();
		assertEquals(null, no);
	}
	
	// caso 7
	@Test
	public void testLiberar() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		NoListaDupla<Integer> no5  = lista.buscar(5);
		NoListaDupla<Integer> no10 = lista.buscar(10);
		NoListaDupla<Integer> no15 = lista.buscar(15);
		NoListaDupla<Integer> no20 = lista.buscar(20);
		
		lista.liberar();
		
		assertNull(no5.getAnterior());
		assertNull(no5.getProximo());
		
		assertNull(no10.getAnterior());
		assertNull(no10.getProximo());
		
		assertNull(no15.getAnterior());
		assertNull(no15.getProximo());
		
		assertNull(no20.getAnterior());
		assertNull(no20.getProximo());
		
		assertNull(lista.getPrimeiro());
	}

}
