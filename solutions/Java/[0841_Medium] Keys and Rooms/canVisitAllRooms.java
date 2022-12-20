class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int numberOfRooms = rooms.size();
    boolean[] visited = new boolean[numberOfRooms];

    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    while (!queue.isEmpty()) {
      int key = queue.remove();

      for (int nextKey: rooms.get(key)) {
        if (!visited[nextKey]) {
          queue.add(nextKey);
        }
      }

      visited[key] = true;
    }

    for (boolean hasVisited: visited) {
      if (!hasVisited) {
        return false;
      }
    }

    return true;
  }
}
