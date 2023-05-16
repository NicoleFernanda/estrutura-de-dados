package lista08;

public class Arvore<T> {
	NoArvore <T> raiz;
	
	public Arvore() {
		
	}
	
	public boolean pertence(T info) {
		if (raiz == null) {
			return false;
		}
		return pertence(raiz, info);
	}
	
	private boolean pertence (NoArvore<T> no, T info) {
        if (no == null) {
            return false;
        }
        
        return (
                (no.getInfo().equals(info)) ||
                (pertence(no.getPrimeiro(), info)) ||
                (pertence(no.getProximo(), info))
                );
        
    }

	public NoArvore<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}
	
	

}
