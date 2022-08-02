class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int rowSize = matrix.length;
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

    for (int i = 0; i < rowSize; i++) {
      pq.offer(new int[]{matrix[i][0], i, 0});
    }

    for (int i = 0; i < k - 1; i++) {
      int[] current = pq.poll();

      if (current[2] != rowSize - 1) {
        pq.offer(new int[]{matrix[current[1]][current[2] + 1], current[1], current[2] + 1});
      }
    }

    return pq.poll()[0];
  }
}
