class Solution {
  public int[] getOrder(int[][] tasks) {
    int n = tasks.length;
    int[][] queue = new int[n][3];

    for (int i = 0; i < n; i++) {
      queue[i] = new int[]{tasks[i][0], tasks[i][1], i};
    }

    Arrays.sort(queue, (a, b) -> a[0] - b[0]);

    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (
      a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]
    ));

    int[] order = new int[n];
    int currentTime = 0;
    int nextQueueItem = 0;
    int index = 0;

    while (nextQueueItem < n) {
      if (currentTime < queue[nextQueueItem][0] && heap.isEmpty()) {
        currentTime = queue[nextQueueItem][0];
      }

      while (nextQueueItem < n && currentTime >= queue[nextQueueItem][0]) {
        heap.add(queue[nextQueueItem]);
        nextQueueItem++;
      }

      while (!heap.isEmpty()) {
        int[] nextJob = heap.remove();
        order[index++] = nextJob[2];
        index++;
        currentTime += nextJob[1];

        if (nextQueueItem < n && currentTime >= queue[nextQueueItem][0]) {
          break;
        }
      }
    }

    return order;
  }
}
