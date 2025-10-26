Implementação de Árvores de Busca Balanceadas: AVL e Rubro-Negra
Este projeto contém implementações em Java de duas árvores binárias de busca autobalanceadas clássicas: a Árvore AVL e a Árvore Rubro-Negra.

O programa permite ao usuário, no momento da execução, escolher qual tipo de árvore deseja instanciar. Em seguida, o usuário pode interagir com a árvore selecionada através de um menu no console para inserir, remover e buscar elementos, observando a estrutura da árvore se auto-ajustar após cada operação.

Funcionalidades
Design Polimórfico: Utiliza uma interface IArvore para definir um contrato comum.

Árvore AVL: Implementa inserção, remoção e busca com balanceamento baseado em altura (rotações LL, RR, LR, RL).

Árvore Rubro-Negra: Implementa inserção, remoção e busca com balanceamento baseado em cores (regras de 5 pontos).

Menu Interativo: Permite testar as operações em tempo real.

Visualização Estrutural: Imprime uma representação visual da árvore (com alturas/cores) após cada modificação, facilitando a depuração e o aprendizado.

Estrutura dos Arquivos
Para que o projeto funcione, todos os arquivos .java a seguir devem estar localizados no mesmo diretório (pasta).

/SeuProjeto
|-- IArvore.java
|-- ArvoreAVL.java
|-- Cor.java           
|-- NoRB.java
|-- ArvoreRubroNegra.java
|-- Main.java


Como Compilar e Executar
Você precisará ter o JDK (Java Development Kit) instalado em seu sistema e configurado no PATH do seu terminal.

1. Abra um Terminal
Navegue (usando o comando cd) até o diretório onde você salvou todos os arquivos .java do projeto.

Bash

# Exemplo:
cd C:\Caminho\Para\SeuProjeto
2. Compile o Projeto
Para compilar, você só precisa executar o compilador javac no arquivo Main.java. O compilador Java encontrará e compilará automaticamente todas as outras classes que o Main.java utiliza (como ArvoreAVL, NoRB, IArvore, etc.).

Bash

javac Main.java
Se tudo estiver correto, não aparecerá nenhuma mensagem de erro, e você verá vários arquivos .class aparecerem na sua pasta (como Main.class, ArvoreAVL.class, etc.).

3. Execute o Programa
Após a compilação, você pode executar o programa usando o comando java, seguido apenas do nome da classe que contém o método main (neste caso, Main), sem a extensão .java ou .class.

Bash

java Main
4. Como Usar
Ao executar o programa, você será recebido com um menu:

Escolha a Árvore: Primeiro, digite 1 para AVL ou 2 para Rubro-Negra e pressione Enter.

Use o Menu de Opções:

(1) Inserir Valor: Pede um número para inserir na árvore.

(2) Remover Valor: Pede um número para remover da árvore.

(3) Buscar Valor: Pede um número e informa se ele está ou não na árvore.

(4) Imprimir Árvore (Manual): Imprime a estrutura atual da árvore.

(0) Sair: Encerra o programa.

Após cada Inserção ou Remoção, a estrutura atualizada da árvore será impressa automaticamente, permitindo que você veja as rotações e mudanças de cor/altura em ação.