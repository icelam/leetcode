class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int originNode = 0;
    int destinationNode = graph.length - 1;

    List<List<Integer>> result = new ArrayList<>();
    Queue<List<Integer>> queue = new LinkedList<>();
    queue.add(List.of(originNode));

    while (!queue.isEmpty()) {
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        List<Integer> path = queue.remove();
        int previousNode = path.get(path.size() - 1);

        if (previousNode == destinationNode) {
          result.add(path);
          continue;
        }

        int[] neighbors = graph[previousNode];

        for (int nextNode: neighbors) {
          List<Integer> list = new ArrayList<>(path);
          list.add(nextNode);
          queue.add(list);
        }
      }
    }

    return result;
  }
}
