public class No{
	int info;
	No esquerda;
	No direita;
	public No(int info){
		this.info = info;
		esquerda = null;
		direita = null;
	}
}

public class ArvoreBi{
	private No raiz;
	public ArvoreBi(){
		this.raiz = null;
	}
	public void inserir(int valor){
		raiz = inserirRecursivo(raiz, valor);
	}
	private No inserirRecursivo(No noAtual, int valor){
		if(noAtual == null){
			No rec = new No(valor);
			return rec;
			//Fazer um get la em No para o valor
		} else if(valor < noAtual.info){
			noAtual.esquerda = inserirRecursivo(noAtual.esquerda, valor);
		} else if(valor > noAtual.info){
			noAtual.direita = inserirRecursivo(noAtual.direita, valor);
		}
		return noAtual;
	}
	public void imprimirEmOrderm(){
		System.out.println("Imprimindo em ordem crescente:");
		imprimirEmOrdermRecursivo(this.raiz);
		System.out.println();
	}
	private void imprimirEmOrdermRecursivo(No noAtual){
		if(noAtual == null){
			return;
		}
		imprimirEmOrdermRecursivo(noAtual.esquerda);
		System.out.print(noAtual.info + " ");
		imprimirEmOrdermRecursivo(noAtual.direita);
	}
}