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
  /**
   * Kruskal’s algorithm
   * Sort edges in ascending order of weight.
   * Add next edge to T unless doing so would create a cycle.
   */
  public int kruskalMstWeight(List<Edge> edges, int size) {
    Collections.sort(edges);

    int weight = 0;
    int count = 0;
    UnionFind uf = new UnionFind(size);

    for (int i = 0; i < edges.size() && count < size - 1; i++) {
      Edge currentEdge = edges.get(i);

      if (uf.union(currentEdge.getVertex1(), currentEdge.getVertex2())) {
        weight += currentEdge.getWeight();
        count++;
      }
    }

    return weight;
  }

  /** Manhattan distance = (x1 - x2) + (y1 - y2) */
  public int calculateManhattanDistance(int[]point1, int[] point2) {
    return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
  }

  public int minCostConnectPoints(int[][] points) {
    List<Edge> edges = new ArrayList<>();

    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        int weight = calculateManhattanDistance(points[i], points[j]);
        edges.add(new Edge(i, j, weight));
      }
    }

    return kruskalMstWeight(edges, points.length);
  }
}
