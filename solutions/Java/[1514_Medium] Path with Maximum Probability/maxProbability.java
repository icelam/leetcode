class Solution {
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    Map<Integer, List<Pair<Integer, Double>>> adjacencyList = new HashMap<>();
    boolean[] visited = new boolean[n];

    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];

      adjacencyList.putIfAbsent(edge[0], new ArrayList<>());
      adjacencyList.get(edge[0]).add(new Pair<>(edge[1], succProb[i]));

      adjacencyList.putIfAbsent(edge[1], new ArrayList<>());
      adjacencyList.get(edge[1]).add(new Pair<>(edge[0], succProb[i]));
    }

    PriorityQueue<Pair<Integer, Double>> heap = new PriorityQueue<>(
      new Comparator<Pair<Integer, Double>>() {
        public int compare(Pair<Integer, Double> o1, Pair<Integer, Double> o2) {
          double value1 = o1.getValue();
          double value2 = o2.getValue();

          return value1 < value2 ? 1 : value1 > value2 ? -1 : 0;
        }
      }
    );

    heap.add(new Pair<>(start, 1.0));

    while (!heap.isEmpty()) {
      Pair<Integer, Double> currentPair = heap.remove();
      int currentNode = currentPair.getKey();
      double currentProbablity = currentPair.getValue();

      if (visited[currentNode]) {
        continue;
      }

      visited[currentNode] = true;

      if (currentNode == end) {
        return currentProbablity;
      }

      if (!adjacencyList.containsKey(currentNode)) {
        continue;
      }

      for (Pair<Integer, Double> nextPair: adjacencyList.get(currentNode)) {
        int nextNode = nextPair.getKey();
        double nextProbablity = nextPair.getValue();

        if (visited[nextNode]) {
          continue;
        }

        heap.add(new Pair<>(nextNode, currentProbablity * nextProbablity));
      }
    }

    return 0;
  }
}
