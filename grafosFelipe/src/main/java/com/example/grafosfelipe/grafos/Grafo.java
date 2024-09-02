package com.example.grafosfelipe.grafos;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;
import java.util.*;


public class Grafo {
    private Map<Integer, List<Aresta>> adjacencias;
    private int numVertices;

    public Grafo() {
        adjacencias = new HashMap<>();
        numVertices = 0;
    }

    public void inserirVertice(int id) {
        if (!adjacencias.containsKey(id)) {
            adjacencias.put(id, new ArrayList<>());
            numVertices++;
        }
    }

    public void inserirAresta(int origem, int destino, int peso) {
        adjacencias.get(origem).add(new Aresta(destino, peso));
        adjacencias.get(destino).add(new Aresta(origem, peso)); // Grafo não direcionado
    }

    public void removerVertice(int id) {
        adjacencias.values().forEach(list -> list.removeIf(aresta -> aresta.destino == id));
        adjacencias.remove(id);
        numVertices--;
    }

    public void removerAresta(int origem, int destino) {
        adjacencias.get(origem).removeIf(aresta -> aresta.destino == destino);
        adjacencias.get(destino).removeIf(aresta -> aresta.destino == origem);
    }

    // Método para visualizar o grafo como texto
    public void visualizarGrafo() {
        mxGraph jgxAdapter = new mxGraph();
        Object parent = jgxAdapter.getDefaultParent();

        jgxAdapter.getModel().beginUpdate();
        try {
            // Mapeamento de vértices para os objetos visuais
            Map<Integer, Object> vertexMap = new HashMap<>();

            // Adicionar vértices ao gráfico
            for (Integer vertice : adjacencias.keySet()) {
                Object v = jgxAdapter.insertVertex(parent, null, vertice, 0, 0, 50, 50);
                vertexMap.put(vertice, v);
            }

            // Adicionar arestas ao gráfico
            for (Map.Entry<Integer, List<Aresta>> entry : adjacencias.entrySet()) {
                Integer origem = entry.getKey();
                for (Aresta aresta : entry.getValue()) {
                    Integer destino = aresta.destino;
                    jgxAdapter.insertEdge(parent, null, aresta.peso, vertexMap.get(origem), vertexMap.get(destino));
                }
            }
        } finally {
            jgxAdapter.getModel().endUpdate();
        }

        // Organizar os vértices em um layout circular
        mxCircleLayout layout = new mxCircleLayout(jgxAdapter);
        layout.execute(jgxAdapter.getDefaultParent());

        // Exibir o gráfico em um JFrame
        JFrame frame = new JFrame("Visualização do Grafo");
        mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
        frame.getContentPane().add(graphComponent);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

    }

    // Método para calcular o grau de um vértice específico
    public int calcularGrauVertice(int vertice) {
        if (adjacencias.containsKey(vertice)) {
            return adjacencias.get(vertice).size();
        } else {
            System.out.println("Vértice não encontrado.");
            return -1;
        }
    }

    // Método para verificar se o grafo é conexo
    public boolean verificarConexo() {
        if (adjacencias.isEmpty()) {
            return true; // Grafo vazio é considerado conexo
        }

        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> fila = new LinkedList<>();

        // Pegar qualquer vértice para iniciar a busca
        int verticeInicial = adjacencias.keySet().iterator().next();
        fila.add(verticeInicial);
        visitados.add(verticeInicial);

        while (!fila.isEmpty()) {
            int verticeAtual = fila.poll();
            for (Aresta aresta : adjacencias.get(verticeAtual)) {
                if (!visitados.contains(aresta.destino)) {
                    visitados.add(aresta.destino);
                    fila.add(aresta.destino);
                }
            }
        }

        // O grafo é conexo se todos os vértices foram visitados
        return visitados.size() == adjacencias.size();
    }

    // Método para converter para matriz de adjacências
    public int[][] converterParaMatrizAdjacencia() {
        int n = adjacencias.size();
        int[][] matrizAdjacencia = new int[n][n];

        List<Integer> vertices = new ArrayList<>(adjacencias.keySet());
        Map<Integer, Integer> indiceVertice = new HashMap<>();

        // Atribuir um índice a cada vértice
        for (int i = 0; i < vertices.size(); i++) {
            indiceVertice.put(vertices.get(i), i);
        }

        // Preencher a matriz de adjacência
        for (int origem : adjacencias.keySet()) {
            for (Aresta aresta : adjacencias.get(origem)) {
                int i = indiceVertice.get(origem);
                int j = indiceVertice.get(aresta.destino);
                matrizAdjacencia[i][j] = aresta.peso;
            }
        }

        return matrizAdjacencia;
    }






}
