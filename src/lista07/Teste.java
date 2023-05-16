package lista07;

public class Teste {
    public static void main(String[] args) {
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);

        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);

        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);

        NoArvoreBinaria no = arvore.raiz;
        NoArvoreBinaria bp = arvore.raiz;
        int total = 1;
        boolean temp = true;

        //lado esquerdo

//        for (int i = 0; i > -1; i++) {
//            if (no.getEsquerda() != null) { //significa que a arvore cresce para a esquerda
//                bp = no;
//                no = no.getEsquerda();
//                temp = true;
//                total++;
//                System.out.println(no.getInfo());
//            } else if (no.getDireita() != null) { //significa que cresce para a direita
//                bp = no;
//                no = no.getDireita();
//                temp = true;
//                total++;
//                System.out.println(no.getInfo());
//            } else {
//                temp = false;
//            }
//
//            if (temp == false) {
//                if (bp.getDireita() != null) {
//                    no = bp.getDireita();
//                    total++;
//                    System.out.println(no.getInfo());
//                    temp = true;
//                    bp = no;
//                } else {
//                    break;
//                }
//            }
//
//
//        }
//
//        //lado direito
//
//        /*
//        NoArvoreBinaria no = arvore.raiz;
//        NoArvoreBinaria bp = arvore.raiz;
//        int total = 0;
//        boolean temp = true;
//        */
//
//        no = arvore.raiz;
//        bp = arvore.raiz;
//        temp = true;
//
//        for (int i = 0; i > -1; i++) {
//            if (no.getDireita() != null) { //significa que cresce para a direita
//                bp = no;
//                no = no.getDireita();
//                temp = true;
//                total++;
//                System.out.println(no.getInfo());
//            } else if (no.getEsquerda() != null) { //significa que a arvore cresce para a esquerda
//                bp = no;
//                no = no.getEsquerda();
//                temp = true;
//                total++;
//                System.out.println(no.getInfo());
//            } else {
//                temp = false;
//            }
//
//            if (temp == false) {
//                if (bp.getDireita() != null) {
//                    no = bp.getDireita();
//                    total++;
//                    System.out.println(no.getInfo());
//                    temp = true;
//                    bp = no;
//                } else {
//                    break;
//                }
//            }
//
//
//        }


        System.out.println("total = " + arvore.contarNos());


        NoArvoreBinaria<Integer> no21 = new NoArvoreBinaria<>(2);

        NoArvoreBinaria<Integer> no31 = new NoArvoreBinaria<>(3);

        NoArvoreBinaria<Integer> no11 = new NoArvoreBinaria<>(1, no21, no31);

        ArvoreBinaria<Integer> arvore1 = new ArvoreBinaria<>();
        arvore1.setRaiz(no11);

        //System.out.println("nos arvore 01 = " + arvore1.contarNos());


        NoArvoreBinaria<Integer> no12 = new NoArvoreBinaria<>(1);

        ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<>();
        arvore2.setRaiz(no12);
        //System.out.println("nos arvore 02 = " + arvore2.contarNos());

    }
}