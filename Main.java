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