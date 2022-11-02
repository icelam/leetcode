class Solution {
  public boolean isNeighbour(String gene1, String gene2) {
    int diffCount = 0;

    for (int i = 0; i < 8; i++) {
      if (gene1.charAt(i) != gene2.charAt(i)) {
        diffCount++;
      }
    }

    return diffCount == 1;
  }

  public int minMutation(String start, String end, String[] bank) {
    int result = Integer.MIN_VALUE;
    Map<String, List<String>> directedEdges = new HashMap<>();

    HashSet<String> set = new HashSet<>();
    set.add(start);
    for (String gene: bank) {
      set.add(gene);
    }

    if (!set.contains(end)) {
      return -1;
    }

    for (String gene1: set) {
      directedEdges.putIfAbsent(gene1, new ArrayList<>());

      for (String gene2: set) {
        if (isNeighbour(gene1, gene2)) {
          directedEdges.get(gene1).add(gene2);
        }
      }
    }

    HashSet<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(start);

    int depth = 0;

    while (!queue.isEmpty()) {
      int batchSize = queue.size();
      depth++;

      for (int i = 0; i < batchSize; i++) {
        String currentGene = queue.remove();
        visited.add(currentGene);

        for (String neighbor: directedEdges.get(currentGene)) {
          if (neighbor.equals(end)) {
            return depth;
          }

          if (!visited.contains(neighbor)) {
            queue.add(neighbor);
          }
        }
      }
    }

    return -1;
  }
}
