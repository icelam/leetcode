class Solution {
  public int distanceFromOrigin(int[] point) {
    // Euclidean distance = Math.sqrt(Math.pow(x1 - x2) + Math.pow(y1 - y2)))
    return (point[0] * point[0]) + (point[1] * point[1]);
  }

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (
       distanceFromOrigin(a) - distanceFromOrigin(b)
    ));

    for (int[] point: points) {
      priorityQueue.add(point);
    }

    int[][] result = new int[k][2];

    for (int i = 0; i < k; i++) {
      result[i] = priorityQueue.remove();
    }

    return result;
  }
}
