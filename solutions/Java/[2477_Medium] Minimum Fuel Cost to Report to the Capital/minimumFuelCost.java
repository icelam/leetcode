class Solution {
  private long result;

  public long dfs(int currentNode, int parentNode, Map<Integer, List<Integer>> map, int seats) {
    int numberOfRepresentives = 1;

    if (!map.containsKey(currentNode)) {
      return numberOfRepresentives;
    }

    for (int childNode : map.get(currentNode)) {
      if (childNode != parentNode) {
        numberOfRepresentives += dfs(childNode, currentNode, map, seats);
      }
    }

    if (currentNode != 0) {
      result += Math.ceil((double) numberOfRepresentives / seats);
    }

    return numberOfRepresentives;
  }

  public long minimumFuelCost(int[][] roads, int seats) {
    int n = roads.length;
    HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

    for (int[] edge: roads) {
      int a = edge[0];
      int b = edge[1];
      adjacencyList.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
      adjacencyList.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
    }

    dfs(0, -1, adjacencyList, seats);
    return result;
  }
}
