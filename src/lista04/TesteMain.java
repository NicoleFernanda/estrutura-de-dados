package lista04;

public class TesteMain<T> {
    public static void main(String[] args) {

        ListaDupla<Integer> c1 = new ListaDupla<>();
        NoListaDupla<Integer> um = new NoListaDupla<>();
        System.out.println("Bom dia");
        c1.inserir(5);
        c1.inserir(10);
        c1.inserir(15);
        c1.inserir(20);
        System.out.println(c1.buscar(16));
        System.out.println(c1);
        
        
        System.out.println("ordem inversa");
        c1.exibirOrdemInversa();
//        System.out.println(c1.buscar(20)); //buscar elemento //se tirar o ToString, teria que colocar um getInfo no fim
//        System.out.println("retirei o 20 da lista");
//        c1.retirar(20); //remover elementos
//        System.out.println("o que encontrou após buscar o 20 na lista = " + c1.buscar(20));
        System.out.println("\nliberando");
        c1.liberar(); // liberar lista (boto todos os valores como null)
        System.out.println("exibe lista = " + c1);
        System.out.println("fim");
        System.out.println(c1.getPrimeiro());
        System.out.println("fim");
//        System.out.println("após liberar lista, procuro todos os meus itens restantes dela: ");
//        System.out.println(c1.buscar(5));
//        System.out.println(c1.buscar(10));
//        System.out.println(c1.buscar(15));
//        System.out.println("insiro novamente\nordem inversa:");
//        c1.inserir(5);
//        c1.inserir(10);
//        c1.inserir(15);
//        c1.inserir(20);
//        
//        c1.exibirOrdemInversa(); //exibir ordem inversa
//        System.out.println(c1.toString()); //ixibir valores
        
        /*
		 VARIAÇÕES DO METODO LIBERAR: 
		 01)
		 		
		 if (getPrimeiro() != null) {
			no = getPrimeiro();
			
			while (no != null) { // enquanto a lista nn terminou
				no.setAnterior(null);
				
				if (no.getProximo() == null) {
					no = null;
					break;
				}
				
				no = no.getProximo(); //ou colocar uma verificacao aqui se no é null
				no.getAnterior().setProximo(null);
			}
		}
		
		primeiro = null;
		
		02)
		
		if (getPrimeiro() != null) {
			
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

		 */

    }

}
