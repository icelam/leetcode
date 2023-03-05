class Solution {
  private Map<Integer, HashSet<Integer>> findEdges(int arr[]) {
    Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
    int left = 0;

    // Find boundaries of continuous subarray with same value, as there is no use jumping to indices in-between
    // e.g. [0,1,1,1,1,7,8,9,8,7,7,7,7,7,7,9] -> You wouldn't consider jumping to middle of 1s or 7s
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != arr[i - 1]) {
        map.putIfAbsent(arr[left], new HashSet<>());
        map.get(arr[left]).add(left);
        map.get(arr[left]).add(i - 1);
        left = i;
      }
    }

    map.putIfAbsent(arr[left], new HashSet<>());
    map.get(arr[left]).add(left);
    map.get(arr[left]).add(arr.length - 1);

    return map;
  }

  public int minJumps(int[] arr) {
    Map<Integer, HashSet<Integer>> map = findEdges(arr);
    int destination = arr.length - 1;
    int distance = 0;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[arr.length];
    queue.add(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        int currentNode = queue.remove();

        if (currentNode == destination) {
          return distance;
        }

        for (int neighborNode: map.get(arr[currentNode])) {
          if (!visited[neighborNode]) {
            queue.add(neighborNode);
            visited[neighborNode] = true;
          }
        }

        // Remove checked neighbors as we don't need to check again for visited,
        // as it is time consuming for test cases like [1,2,1,2,1,2,1,2...] which
        // generates long list of neighbor with same value
        map.get(arr[currentNode]).clear();

        if (currentNode != 0 && !visited[currentNode - 1]) {
          queue.add(currentNode - 1);
          visited[currentNode - 1] = true;
        }

        if (!visited[currentNode + 1]) {
          queue.add(currentNode + 1);
          visited[currentNode + 1] = true;
        }
      }

      distance++;
    }

    return -1;
  }
}
