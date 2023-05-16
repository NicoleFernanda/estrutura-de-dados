package lista07;

public class ArvoreBinaria <T> {

    NoArvoreBinaria<T> raiz;
    
    public ArvoreBinaria() {
        setRaiz(null);
    }

    public boolean estaVazia() {
        return (this.raiz == null);
    }

    public boolean pertence(T info) {
        return pertence(this.raiz, info);
    }

    private boolean pertence (NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        }

        //esse e o de baixo são a mesma coisa
//        } else {
//        	if (no.getInfo().equals(info)) {
//        		return true;
//        	} else if (pertence(no.getEsquerda(), info)) {
//        		return true;
//        	} else if (pertence(no.getDireita(), info)) {
//        		return true;
//        	}else {
//        		return false;
//        	}
//        }
        
        //	pre ordem
        return (
                (no.getInfo().equals(info)) ||
                (pertence(no.getEsquerda(), info)) ||
                (pertence(no.getDireita(), info))
                );
        
        //simetric é no meio e pos ordem é depois
        
        /*	simetrica
         return (
                (pertence(no.getEsquerda(), info)) ||
                (no.getInfo().equals(info)) ||
                (pertence(no.getDireita(), info))
                );
         
         * 	pos ordem
         return (
                (pertence(no.getDireita(), info)) ||
                (pertence(no.getEsquerda(), info)) ||
                (no.getInfo().equals(info))
                );
        
         * */
        
        
        
    }

    public int contarNos() {
        return contarNos(this.raiz);
    }

    private int contarNos(NoArvoreBinaria<T> x) {
        
    	if (x == null) {
    		return 0;
    	} else { 
    		return 1 + contarNos(x.getEsquerda()) + contarNos(x.getDireita());
    	}
    	
    }

    private String arvorePre(NoArvoreBinaria<T> x) {
    	
    	if (x == null) {
    		return "<>";
    	} else {
    		return "<" + 
    				arvorePre(x.getEsquerda()) +
    				arvorePre(x.getDireita()) +
    				">";
    	}
    	
    }

    @Override
    public String toString() {
        return arvorePre(this.raiz);
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }
}