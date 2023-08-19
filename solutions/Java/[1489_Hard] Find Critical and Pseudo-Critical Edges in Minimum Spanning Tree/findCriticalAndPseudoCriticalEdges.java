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
  private int index;
  private int vertex1;
  private int vertex2;
  private int weight;

  public Edge(int index, int vertex1, int vertex2, int weight) {
    this.index = index;
    this.vertex1 = vertex1;
    this.vertex2 = vertex2;
    this.weight = weight;
  }

  public int getIndex() {
    return index;
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
  public int kruskalMstWeight(UnionFind uf, List<Edge> edges, int size) {
    Collections.sort(edges);

    int weight = 0;
    int count = 0;

    for (int i = 0; i < edges.size() && count < size - 1; i++) {
      Edge currentEdge = edges.get(i);

      if (uf.union(currentEdge.getVertex1(), currentEdge.getVertex2())) {
        weight += currentEdge.getWeight();
        count++;
      }
    }

    return weight;
  }

  public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
    List<Edge> edgeList = new ArrayList<>();

    for (int i = 0; i < edges.length; i++) {
      edgeList.add(new Edge(i, edges[i][0], edges[i][1], edges[i][2]));
    }

    // Step 1: Calculate min MST weight
    int minMstWeight = kruskalMstWeight(new UnionFind(n), edgeList, n);

    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    result.add(new ArrayList<>());

    List<Edge> tempEdgeList = new ArrayList<>(edgeList);

    // Step 2: check if edge is critical edge
    // A critical edge is an edge that, if removed from the graph, would increase the MST weight.
    // It means that the edge appears in every MST.
    for (Edge e : edgeList) {
      tempEdgeList.remove(e);

      if (minMstWeight != kruskalMstWeight(new UnionFind(n), tempEdgeList, n)) {
        result.get(0).add(e.getIndex());
      }

      tempEdgeList.add(e);
    }

    // Step 3: check if edge is pseudo-critical edges
    // A pseudo-critical edge is that which can appear in some MSTs but not all.
    for (Edge e : edgeList) {
      if (result.get(0).contains(e.getIndex())) {
        continue;
      }

      // Pre-add edge into tree, if min MST weight does not change, it is a pseudo-critical edges
      UnionFind uf = new UnionFind(n);
      uf.union(e.getVertex1(), e.getVertex2());

      if (minMstWeight == kruskalMstWeight(uf, tempEdgeList, n) + e.getWeight()) {
        result.get(1).add(e.getIndex());
      }
    }

    return result;
  }
}
