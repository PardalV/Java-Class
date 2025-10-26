public class ArvoreAVL implements IArvore{
    private NoAVL raiz;

    //Metodos que precisam de Override
    @Override
    public void inserir(int valor){
        raiz = inserirRecursivo(NoAVL noAtual, int valor);
    }
    @Override
    public void remover(int valor){
        this.raiz = removerRecursivo(this.raiz, valor);
    }
    @Override
    public boolean buscar(int valor){
        return buscarRecursivo(this.raiz, valor);
    }
    @Override
    public void imprimir(){
        System.out.println("--- Árvore AVL (Impressão em-ordem) ---");
        if(this.raiz = null){
            System.out.println("[ÁRVORE VAZIA]");
        } else {
            imprimirEmOrdermRecursivo(this.raiz);
        }
        System.out.println("\n-----------------------------------------");
        
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
    public NoAVL rotacaoDireita(NoAVL y){
        NoAVL x = y.esquerda;
        NoAVL k = x.direita;
        x.direita = y;
        y.esquerda = k;
        atualizarAltura(y);
        atualizarAltura(x);
        return x;
    }
    public NoAVL rotacaoEsquerda(NoAVL x){
        NoAVL y = x.direita;
        NoAVL j = y.esquerda;
        y.esquerda = x;
        x.direita = j;
        atualizarAltura(x);
        atualizarAltura(y);
        return y;
    }
    private NoAVL inserirRecursivo(NoAVL noAtual, int valor){
        if(noAtual == null){
            NoAVL rec = new NoAVL(valor);
            return rec;
        } 
        if(valor < noAtual.info){
            noAtual.esquerda = inserirRecursivo(noAtual.esquerda, valor);
        } else if (valor > noAtual.info){
            noAtual.direita = inserirRecursivo(noAtual.direita, valor);
        } else {
            return noAtual;
        }
        atualizarAltura(noAtual);
        int fb = getFatorBalanceamento(noAtual);
        if(fb > 1){
            if(valor < noAtual.esquerda.info){
                return rotacaoDireita(noAtual);
            } else if (valor > noAtual.esquerda.info){
                noAtual.esquerda = rotacaoEsquerda(noAtual.esquerda);
                return rotacaoDireita(noAtual);
            }
        } else if(fb < -1){
            if(valor > noAtual.direita.info){
                return rotacaoEsquerda(noAtual);
            } else if(valor < noAtual.direita.info){
                noAtual.direita = rotacaoDireita(noAtual.direita);
                return rotacaoEsquerda(noAtual);
            }
        }
        return noAtual;

    }
    private boolean buscarRecursivo(NoAVL noAtual, int valor){
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
    private NoAVL removerRecursivo(NoAVL noAtual, int valor){
        if(noAtual == null){
            return noAtual;
        }
        if(valor < noAtual.info){
            noAtual.esquerda = removerRecursivo(noAtual.esquerda, valor);
        } else if(valor > noAtual.info){
            noAtual.direita = removerRecursivo(noAtual.direita, valor);
        } else {
            if(noAtual.esquerda == null){
                return noAtual.direita;
            } else if(noAtual.direita == null){
                return noAtual.esquerda;
            }
            NoAVL sucessor = encontrarMenorValor(noAtual.direita);
            noAtual.info = sucessor.info;
            noAtual.direita = removerRecursivo(noAtual.direita, sucessor.info);
        }
        atualizarAltura(noAtual);
        int fb = getFatorBalanceamento(noAtual);
        if(fb > 1){
            if(getFatorBalanceamento(noAtual.esquerda) >= 0){
                return rotacaoDireita(noAtual);
            } else {
                noAtual.esquerda = rotacaoEsquerda(noAtual.esquerda);
                return rotacaoDireita(noAtual);
            }
        }
        if (fb < -1){
            if(getFatorBalanceamento(noAtual.direita) <= 0){
                return rotacaoEsquerda(noAtual);
            } else {
                noAtual.direita = rotacaoDireita(noAtual.direita);
                return rotacaoEsquerda(noAtual);
            }
        }
        return noAtual;
    }
    private NoAVL encontrarMenorValor(NoAVL no){
        NoAVL atual = no;
        while(atual.esquerda != null){
            atual = atual.esquerda;
        }
        return atual;
    }
    private void imprimirEmOrdermRecursivo(NoAVL noAtual){
        if(noAtual == null){
            return
        }
        imprimirEmOrdermRecursivo(noAtual.esquerda);
        System.out.print(noAtual.info + " ");
        imprimirEmOrdermRecursivo(noAtual.direita);
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