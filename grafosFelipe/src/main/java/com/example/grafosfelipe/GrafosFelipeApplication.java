package com.example.grafosfelipe;

import com.example.grafosfelipe.grafos.Grafo;

import java.util.Scanner;


public class GrafosFelipeApplication {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("                    Menu de Operações");
            System.out.println("===========================================================");
            System.out.println("1. Inserir Vértice");
            System.out.println("2. Inserir Aresta");
            System.out.println("3. Remover Vértice");
            System.out.println("4. Remover Aresta");
            System.out.println("5. Visualizar Grafo");
            System.out.println("6. Calcular Grau de um Vértice");
            System.out.println("7. Verificar se o Grafo é Conexo");
            System.out.println("8. Converter para Matriz de Adjacência");
            System.out.println("9. Sair");
            System.out.println("===========================================================");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do vértice: ");
                    int idVertice = scanner.nextInt();
                    grafo.inserirVertice(idVertice);
                    break;

                case 2:
                    System.out.print("Digite o ID do vértice de origem: ");
                    int origem = scanner.nextInt();
                    System.out.print("Digite o ID do vértice de destino: ");
                    int destino = scanner.nextInt();
                    System.out.print("Digite o peso da aresta: ");
                    int peso = scanner.nextInt();
                    grafo.inserirAresta(origem, destino, peso);
                    break;

                case 3:
                    System.out.print("Digite o ID do vértice a ser removido: ");
                    int idVerticeRemover = scanner.nextInt();
                    grafo.removerVertice(idVerticeRemover);
                    break;

                case 4:
                    System.out.print("Digite o ID do vértice de origem: ");
                    int origemRemover = scanner.nextInt();
                    System.out.print("Digite o ID do vértice de destino: ");
                    int destinoRemover = scanner.nextInt();
                    grafo.removerAresta(origemRemover, destinoRemover);
                    break;

                case 5:
                    grafo.visualizarGrafo();
                    break;

                case 6:
                    System.out.print("Digite o ID do vértice: ");
                    int idGrau = scanner.nextInt();
                    int grau = grafo.calcularGrauVertice(idGrau);
                    if (grau != -1) {
                        System.out.println("Grau do vértice " + idGrau + ": " + grau);
                    }
                    break;

                case 7:
                    boolean conexo = grafo.verificarConexo();
                    System.out.println("O grafo é conexo? " + (conexo ? "Sim" : "Não"));
                    break;

                case 8:
                    int[][] matriz = grafo.converterParaMatrizAdjacencia();
                    System.out.println("Matriz de Adjacência:");
                    for (int[] linha : matriz) {
                        for (int valor : linha) {
                            System.out.print(valor + " ");
                        }
                        System.out.println();
                    }
                    break;


                case 9:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }



        
}


