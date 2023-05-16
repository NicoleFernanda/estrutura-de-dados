package lista04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void test01() {
		ListaDupla<Integer> c1 = new ListaDupla<>();
		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);

		assertEquals("20, 15, 10, 5", c1.toString());
	}

	@Test
	void test02() {
		ListaDupla<Integer> c1 = new ListaDupla<>();

		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);

		assertEquals(20, c1.buscar(20).getInfo());
	}

	@Test
	void test03() {
		ListaDupla<Integer> c1 = new ListaDupla<>();

		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);

		assertEquals(10, c1.buscar(10).getInfo());
	}
	
	@Test
	void test04() {
		ListaDupla<Integer> c1 = new ListaDupla<>();
	
		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);
		
		c1.retirar(20);
		
		assertEquals("15, 10, 5", c1.toString());

	}
	
	@Test
	void test05() {
		ListaDupla<Integer> c1 = new ListaDupla<>();

		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);
		
		c1.retirar(10);
		
		assertEquals("20, 15, 5", c1.toString());
	}
	
	@Test
	void test06() {
		ListaDupla<Integer> c1 = new ListaDupla<>();

		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);
		
		c1.retirar(5);
		
		assertEquals("10, 15, 20", c1.retornaInverso());
	}
	
	@Test
	void test07() {
		ListaDupla<Integer> c1 = new ListaDupla<>();

		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);
		
		c1.liberar();
		assertEquals("", c1.retornaInverso());
		
	}
	
	@Test
	void test08() {
		ListaDupla<Integer> c1 = new ListaDupla<>();

		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);
		
		c1.liberar();
		assertEquals(null, c1.getPrimeiro());
		assertEquals(null, c1.buscar(5));
		assertEquals(null, c1.buscar(10));
		assertEquals(null, c1.buscar(15));
		assertEquals(null, c1.buscar(20));
		
		
	}
	
	@Test
	void test09() {
		ListaDupla<Integer> c1 = new ListaDupla<>();

		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);
		
		c1.retirar(5);
		c1.retirar(10);
		c1.retirar(15);
		c1.retirar(20);
		
		assertNull(c1.getPrimeiro());
	}
	
	@Test
	void test10() {
		ListaDupla<Integer> c1 = new ListaDupla<>();
		
		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);
		
		NoListaDupla<Integer> no5 = c1.buscar(5);
		NoListaDupla<Integer> no10 = c1.buscar(10);
		NoListaDupla<Integer> no15 = c1.buscar(15);
		NoListaDupla<Integer> no20 = c1.buscar(20);
		
		
		c1.liberar();
		assertNull(c1.getPrimeiro());
	}
	
	@Test
	void test11() {
		ListaDupla<Integer> c1 = new ListaDupla<>();
		
		c1.inserir(5);
		c1.inserir(10);
		c1.inserir(15);
		c1.inserir(20);
		
		ListaDupla<Integer> c2 = c1.clonar();
		assertEquals(c1.toString(), c2.toString());
		c1.liberar();
		assertEquals("20, 15, 10, 5", c2.toString());
		assertNull(c1.getPrimeiro());
		assertEquals("", c1.toString());
	}

}
