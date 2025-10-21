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
	private void imprimirEmOrdermRecursivo(No atual){
		if(noAtual == null){
			return;
		}
		imprimirEmOrdermRecursivo(noAtual.esquerda);
		System.out.print(noAtual.info + " ");
		imprimirEmOrdermRecursivo(noAtual.direita);
	}
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		ArvoreBi minhaArvore = new ArvoreBi();

		minhaArvore.inserir(50);
		minhaArvore.inserir(30);
		minhaArvore.inserir(70);
		minhaArvore.inserir(20);
		minhaArvore.inserir(40);
		minhaArvore.inserir(60);
		minhaArvore.inserir(80);
		minhaArvore.imprimirEmOrderm();
	}
}