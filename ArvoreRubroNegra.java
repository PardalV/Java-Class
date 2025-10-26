public class ArvoreRubroNegra implements IArvore{
    private NoRB raiz;
    public ArvoreRubroNegra(){
        this.raiz = null;
    }
    @Override
    public void inserir(int valor){

    }
    @Override
    public void remover(int valor){

    }
    @Override
    public boolean buscar(int valor){

    }
    @Override
    public void imprimir(){
        
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
}