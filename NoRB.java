public class NoRB{
    int info;
    NoRB esquerda, direita, pai;
    Cor cor;

    public NoRB(int info){
        this.info = info;
        this.cor = Cor.VERMELHO;
        this.direita = null;
        this.pai = null;
    }
}