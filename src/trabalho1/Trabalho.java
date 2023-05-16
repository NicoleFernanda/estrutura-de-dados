package trabalho1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import lista03.ListaEncadeada;
import lista05.PilhaLista;

public class Trabalho {

    private ListaEncadeada<String> tagsInicio = new ListaEncadeada<String>();

    public Trabalho(String path) {
        String conteudo = recebeArquivo(path);
        conteudo = conteudo.replaceAll("[\n\r]+", "");
        quebraString(conteudo);
        contagem();
    }

    public String recebeArquivo(String path) {
        String content = "nada";
        try {
            // Especifica o caminho do arquivo HTML
            // - String path = "C:\\testeHTML\\apenas.html";
            content = new String(Files.readAllBytes(Paths.get(path)));
            // Lê (tranforma) todos o conteudo do arquivo em uma String
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public void quebraString(String arquivo) {

        PilhaLista<String> pilha = new PilhaLista<String>(); // Pras tags com fechamento
        PilhaLista<String> others = new PilhaLista<String>();

        int limite = arquivo.length();
        int indice = 0;
        char c = arquivo.charAt(indice);

        while(indice < limite){

            //Verificar se é uma tag de início
            if(c == '<' && arquivo.charAt(indice+1) != '/'){

                String tag = "";

                indice++;
                c = arquivo.charAt(indice); //Pego a primeira letra efetivamente

                while(true){

                    System.out.println("Entrou no loop tag inicio: " + c);
                    tag = tag + c; //Guardo a letra;

                    indice++; //Aumento a posição;
                    c = arquivo.charAt(indice); //C recebe a proxima letra

                    if(c == '>' || c == ' '){
                        // Se for um sinal que fecha a tag ou se for um espaço vazio indicando que a seguir temos um atriuto, paramos o loop
                        System.out.println("Parou o loop tag inicio");
                        break; 
                    } 
                }

                //Assim que o loop para, eu transformo a tag toda em minuscula, pra ser case insensitive
                tag = tag.toLowerCase();
                //Guardo/contabilizo a tag na lista encadeada;
                tagsInicio.inserir(tag);
                System.out.println("Inseri tag na lista");

                // Verrifico se a tag é uma tag com fechamento ou não, pra saber em qual pilha colocar
                if(verificaException(tag) == true){
                    others.push(tag);
                } else if (verificaException(tag) == false){
                    pilha.push(tag);
                }
            }

            //Caso não seja uma tag de início, verificamos se pode ser uma tag de fim
            if(c == '<' && arquivo.charAt(indice+1) == '/'){

                String fechamento = "";

                indice++; //Aqui eu pego o próximo do '<', que vai ser a '/'
                indice++; //Aqui eu pego efetivamente a primeira letra
                c = arquivo.charAt(indice);

                while(true){

                    System.out.println("Entrou no loop tag fim: " + c);
                    fechamento = fechamento + c;

                    indice++; //Aumento a posição;
                    c = arquivo.charAt(indice); //C recebe a proxima letra

                    if(c == '>'){
                        //Chaeguei no final da tag
                        System.out.println("Saiu do loop tag fim");
                        break;
                    }
                }
                //Comparar se essa tag de fechamento corresponde à ultima tag que foi empilhada
                if(fechamento.equals(pilha.peek())){
                    //Se bater eu tiro o ultimo valor
                    pilha.pop();
                    System.out.println("Tudo certo");
                } else if(!fechamento.equals(pilha.peek())){
                    System.out.println("Algo de errado não está certo");
                }
            }

            //Se não foi nenhum dos casos acima, pego a próxima letra
            if(indice < limite-1)
            indice++;
            c = arquivo.charAt(indice);

        }

    }

    private boolean verificaException(String tag){

        //  input, link, param, source e !DOCTYPE
        if( tag.equals("meta") || tag.equals("base") || tag.equals("br") ||tag.equals("col") || tag.equals("command") ||
            tag.equals("embed") || tag.equals("hr") || tag.equals("img") || tag.equals("input") || tag.equals("link") ||
            tag.equals("param") || tag.equals("source") || tag.equals("!doctype")){
                return true;
        } else {
            return false;
        }
    }

    //Pra tentar contabilizar as tags
    public void contagem(){

        // Duas pilhas, uma pra guardar a tag, outra pra guardar a quantidade em que ela foi utilizada
        PilhaLista<String> guardaTags = new PilhaLista<String>();
        PilhaLista<String> qtdeTags = new PilhaLista<String>();

        String analisar = "";
        int qtde = 0;

        while(tagsInicio.estaVazia() != true){

            System.out.println("entrou no loop da lista");
            analisar = tagsInicio.getPrimeiro().getInfo(); //Pego a primeira tag da lista, vou procurando e retirando

            while(tagsInicio.buscar(analisar) != null){ // Se eu buscar por aquele valor novamente e ele existir...
                System.out.println("entrou  no loop da retirada");
                tagsInicio.retirar(analisar);
                qtde++;
            }

            String quantidade = qtde + "";
            guardaTags.push(analisar);
            qtdeTags.push(quantidade);

            qtde = 0;

        }

       while(guardaTags.estaVazia() == false && qtdeTags.estaVazia() == false){

        System.out.println("TAG: " + guardaTags.peek() + " / QTDE: " + qtdeTags.peek());
        System.out.println(" ");

        guardaTags.pop();
        qtdeTags.pop();

       }
    } 
    

}
