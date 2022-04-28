class UnionFind {
  private int[] group;
  private int[] rank;

  public UnionFind(int size) {
    group = new int[size];
    rank = new int[size];

    for (int i = 0; i < size; i++) {
      group[i] = i;
    }
  }

  public int find(int vertex) {
    if (group[vertex] != vertex) {
      group[vertex] = find(group[vertex]);
    }
    return group[vertex];
  }

  public boolean union(int vertex1, int vertex2) {
    int group1 = find(vertex1);
    int group2 = find(vertex2);

    if (group1 == group2) {
      return false;
    }

    if (rank[group1] > rank[group2]) {
      group[group2] = group1;
    } else if (rank[group1] < rank[group2]) {
      group[group1] = group2;
    } else {
      group[group1] = group2;
      rank[group2] += 1;
    }

    return true;
  }
}

class Edge implements Comparable<Edge> {
  private int vertex1;
  private int vertex2;
  private int weight;

  public Edge(int vertex1, int vertex2, int weight) {
    this.vertex1 = vertex1;
    this.vertex2 = vertex2;
    this.weight = weight;
  }

  public int getVertex1() {
    return vertex1;
  }

  public int getVertex2() {
    return vertex2;
  }

  public int getWeight() {
    return weight;
  }

  public int compareTo(Edge that) {
    return Integer.compare(this.weight, that.weight);
  }
}

class Solution {
  public int getHeight(int n, int[][] heights) {
    int columnSize = heights[0].length;
    return heights[n / columnSize][n % columnSize];
  }

  public int minimumEffortPath(int[][] heights) {
    int rowSize = heights.length;
    int columnSize = heights[0].length;
    int matrixSize = rowSize * columnSize;
    List<Edge> allEdges = new ArrayList<>();

    for (int i = 0; i < matrixSize; i++) {
      int vertex1 = i + 1;
      int vertex2 = i + columnSize;

      if (vertex1 < matrixSize && vertex1 % columnSize != 0) {
        int weight = Math.abs(getHeight(i, heights) - getHeight(vertex1, heights));
        allEdges.add(new Edge(i, vertex1, weight));
      }

      if (vertex2 < matrixSize) {
        int weight = Math.abs(getHeight(i, heights) - getHeight(vertex2, heights));
        allEdges.add(new Edge(i, vertex2, weight));
      }
    }

    Collections.sort(allEdges);

    UnionFind uf = new UnionFind(matrixSize);
    int result = 0;

    for (Edge edge: allEdges) {
      uf.union(edge.getVertex1(), edge.getVertex2());

      if (uf.find(0) == uf.find(matrixSize - 1)) {
        result = edge.getWeight();
        break;
      }
    }

    return result;
  }
}
