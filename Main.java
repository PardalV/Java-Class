public class Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escolha o tipo de Arvore:");
		System.out.println("(1) Árvore AVL");
		System.out.println("(2) Árvore Rubro-Negra");
		int escolha = scanner.nextInt();
		IArvore minhaArvore;
		if(escolha == 1){
			minhaArvore = new ArvoreAVL();
			System.out.println("Árvore AVL criada.");
		} else {
			minhaArvore = new ArvoreRubroNegra();
			System.out.println("Árvore Rubro-Negra criada.");
		}

	}
}