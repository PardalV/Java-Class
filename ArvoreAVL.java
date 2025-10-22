public class ArvoreAVL implements IArvore{
    private NoAVL raiz;

    //Metodos que precisam de Override
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

    //Métodos Auxiliares
    public int getAltura(NoAVL no){
        if(no == null){
            return 0;
        } else {
            return no.altura;
        }
    }
    public int getFatorBalanceamento(NoAVL no){
        if(no == null){
            return 0;
        } else {
            return getAltura(no.esquerda) - getAltura(no.direita);
        }
    }
    public void atualizarAltura(NoAVL no){
        no.altura = 1 + Math.max(getAltura(no.esquerda), getAltura(no.direita));
    }

    //Rotações 
    public NoAVL rocacaoDireita(NoAVL y){
        NoAVL aux = y;
        NoAVL x = y.esquerda;
        NoAVL k = x.direita;
        y = x;
        y.direita = aux;
        aux.esquerda = k;
    }
}

class NoAVL{
    int info;
    NoAVL esquerda, direita;
    int altura;

    public NoAVL(int info){
        this.info = info;
        this.altura = 1;
    }
}