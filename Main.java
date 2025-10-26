import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IArvore minhaArvore; 

        System.out.println("=========================================");
        System.out.println("  Seja bem-vindo ao Testador de Árvores");
        System.out.println("=========================================");
        System.out.println("Escolha o tipo de árvore para criar:");
        System.out.println("(1) Árvore AVL");
        System.out.println("(2) Árvore Rubro-Negra");
        System.out.print("Sua escolha: ");
        
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            minhaArvore = new ArvoreAVL();
            System.out.println(">>> Árvore AVL criada com sucesso! <<<");
        } else {
            minhaArvore = new ArvoreRubroNegra();
            System.out.println(">>> Árvore Rubro-Negra criada com sucesso! <<<");
        }
        
        System.out.println(); 
        minhaArvore.imprimir(); 

        boolean executando = true;
        while (executando) {
            System.out.println("\n--- MENU DE OPÇÕES ---");
            System.out.println("(1) Inserir Valor");
            System.out.println("(2) Remover Valor");
            System.out.println("(3) Buscar Valor");
            System.out.println("(4) Imprimir Árvore (Manual)");
            System.out.println("(0) Sair");
            System.out.print("Sua opção: ");
            
            int opcao = scanner.nextInt();
            int valor; 

            switch (opcao) {
                case 1:
                    System.out.print("  Digite o valor para INSERIR: ");
                    valor = scanner.nextInt();
                    minhaArvore.inserir(valor);
                    System.out.println("  '" + valor + "' inserido. Estado atual da árvore:");
                    minhaArvore.imprimir(); 
                    break;
                    
                case 2:
                    System.out.print("  Digite o valor para REMOVER: ");
                    valor = scanner.nextInt();
                    minhaArvore.remover(valor);
                    System.out.println("  '" + valor + "' removido. Estado atual da árvore:");
                    minhaArvore.imprimir(); 
                    break;
                    
                case 3:
                    System.out.print("  Digite o valor para BUSCAR: ");
                    valor = scanner.nextInt();
                    boolean encontrado = minhaArvore.buscar(valor);
                    if (encontrado) {
                        System.out.println("  >>> RESULTADO: O valor " + valor + " FOI encontrado!");
                    } else {
                        System.out.println("  >>> RESULTADO: O valor " + valor + " NÃO foi encontrado.");
                    }
                    break;
                    
                case 4:
                    System.out.println("  Imprimindo árvore manualmente:");
                    minhaArvore.imprimir();
                    break;
                    
                case 0:
                    executando = false;
                    System.out.println("Encerrando o programa... Obrigado!");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        
        scanner.close();
    }
}