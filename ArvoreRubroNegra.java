public class ArvoreRubroNegra implements IArvore{
    private NoRB raiz;
    public ArvoreRubroNegra(){
        this.raiz = null;
    }
    @Override
    public void inserir(int valor){
        NoRB z = new NoRB(valor);

        NoRB y = null;
        NoRB x = this.raiz;
        while (x != null){
            y = x;
            if(z.info < x.info){
                x = x.esquerda;
            } else {
                x = x.direita;
            }
        }
        z.pai = y;
        if(y == null){
            this.raiz = z;
        } else if(z.info < y.info){
            y.esquerda = z;
        } else {
            y.direita = z;
        }
        corrigirInsercao(z);
        this.raiz.cor = Cor.PRETO;
    }
    @Override
    public void remover(int valor){

    }
    @Override
    public boolean buscar(int valor){
        return buscarRecursivo(this.raiz, valor);
    }
    @Override
    public void imprimir(){
        System.out.println("--- Estrutura da Árvore R-N ---");
    if (raiz == null) {
        System.out.println("[Árvore Vazia]");
    } else {
        imprimirEstruturaRecursivo(this.raiz, "", true);
    }
    System.out.println("---------------------------------");
    }
    private void rotacaoEsquerda(NoRB x){
        NoRB y = x.direita;
        x.direita = y.esquerda;
        if(y.esquerda != null){
            y.esquerda.pai = x;
        }
        y.pai = x.pai;
        if(x.pai == null){
            this.raiz = y;
        } else if(x == x.pai.esquerda){
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }
        y.esquerda = x;
        x.pai = y;
    }
    private void rotacaoDireita(NoRB y){
        NoRB x = y.esquerda;
        y.esquerda = x.direita;
        if(x.direita != null){
            x.direita.pai = y;
        }
        x.pai = y.pai;
        if (y.pai == null){
            this.raiz = x;
        } else if(y == y.pai.esquerda){
            y.pai.esquerda = x;
        }else {
            y.pai.direita = x;
        }
        x.direita = y;
        y.pai = x;
    }
    private Cor getCor(NoRB no){
        if(no == null){
            return Cor.PRETO;
        }
        return no.cor;
    }

    private void corrigirInsercao(NoRB z){
        while (z != raiz && getCor(z.pai) == Cor.VERMELHO){
            NoRB avo = z.pai.pai;
            NoRB tio;

            if(z.pai == avo.esquerda){
                tio = avo.direita;
                if(getCor(tio) == Cor.VERMELHO){
                    z.pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    z = avo;
                } else {
                    if (z == z.pai.direita){
                        z = z.pai;
                        rotacaoEsquerda(z);
                    }
                    z.pai.cor = Cor.PRETO;
                    z.pai.pai.cor = Cor.VERMELHO;
                    rotacaoDireita(z.pai.pai);
                }
            } else {
                tio = avo.esquerda;
                if(getCor(tio) == Cor.VERMELHO){
                    z.pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    z = avo;
                } else {
                    if(z == z.pai.esquerda){
                        z = z.pai;
                        rotacaoDireita(z);
                    }
                    z.pai.cor = Cor.PRETO;
                    z.pai.pai.cor = Cor.VERMELHO;
                    rotacaoEsquerda(z.pai.pai);
                }
            }
        }
    }
    private boolean buscarRecursivo(NoRB noAtual, int valor){
        if(noAtual == null){
            return false;
        }
        if(valor == noAtual.info){
            return true;
        }
        if(valor < noAtual.info){
            return buscarRecursivo(noAtual.esquerda, valor);
        } else {
            return buscarRecursivo(noAtual.direita, valor);
        }
    }
    private void imprimirEstruturaRecursivo(NoRB no, String indent, boolean isUltimo) {
    if (no == null) {
        
        return;
    }

    
    String cor = (no.cor == Cor.VERMELHO) ? "V" : "P";
    
    
    System.out.print(indent);
    if (isUltimo) {
        System.out.print("└── ");
        indent += "    "; 
    } else {
        System.out.print("├── ");
        indent += "│   "; 
    }
    System.out.println(no.info + "(" + cor + ")");

    imprimirEstruturaRecursivo(no.esquerda, indent, false);
    imprimirEstruturaRecursivo(no.direita, indent, true);
    }
}