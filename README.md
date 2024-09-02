# Projeto de Grafos em Java

## Visão Geral do Projeto

Este projeto implementa a estrutura de grafos em Java, oferecendo funcionalidades para manipulação, visualização e execução de algoritmos básicos sobre grafos. O projeto utiliza a biblioteca **JGraphX** para visualização gráfica, permitindo que o grafo seja representado visualmente em uma interface gráfica baseada em Swing.

## Funcionalidades Principais

1. **Manipulação de Grafos**:
   - Inserção e remoção de vértices.
   - Inserção e remoção de arestas (grafo não direcionado).
   - Conversão do grafo para uma matriz de adjacências.

2. **Algoritmos de Grafos**:
   - **Verificação de Conectividade**: Verifica se o grafo é conexo, ou seja, se todos os vértices estão conectados.

3. **Visualização Gráfica**:
   - Visualização do grafo em uma interface gráfica com os vértices dispostos em um layout circular.
   - Exibição das arestas com os pesos correspondentes.

4. **Cálculo do Grau de um Vértice**:
   - Permite calcular o grau (número de arestas conectadas) de um vértice específico.

## Tecnologias Utilizadas

- **Java SE 8+**: Linguagem de programação principal utilizada no projeto.
- **Swing**: Biblioteca gráfica nativa do Java para construção da interface de visualização.
- **JGraphX**: Biblioteca externa utilizada para manipulação e visualização de grafos.

## Estrutura do Projeto

### Classes Principais

- **Grafo**: Classe principal que contém a estrutura do grafo, métodos para manipulação e algoritmos.
- **Aresta**: Classe auxiliar que representa as arestas do grafo, armazenando o vértice de destino e o peso da aresta.

### Métodos Importantes

- `inserirVertice(int id)`: Adiciona um vértice ao grafo.
- `inserirAresta(int origem, int destino, int peso)`: Adiciona uma aresta não direcionada entre dois vértices.
- `removerVertice(int id)`: Remove um vértice do grafo e todas as suas arestas.
- `removerAresta(int origem, int destino)`: Remove uma aresta entre dois vértices.
- `visualizarGrafo()`: Exibe o grafo em uma interface gráfica utilizando JGraphX.
- `verificarConexo()`: Verifica se o grafo é conexo.
- `calcularGrauVertice(int vertice)`: Calcula o grau de um vértice específico.
- `converterParaMatrizAdjacencia()`: Converte o grafo para uma matriz de adjacência.

## Requisitos

- **JDK 8+**: O projeto requer o Java Development Kit versão 8 ou superior.
- **JGraphX**: A biblioteca JGraphX precisa ser adicionada ao classpath do projeto.

## Instalação

1. Clone o repositório para o seu ambiente local.
   ```bash
   git clone https://github.com/Claudemiro-Nogueira/Grafo-Felipe.git

## Link do Video
1. https://youtu.be/gt63Ut5KEWU
