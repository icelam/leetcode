class Solution {
  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
   int n = arr.length;
    // Comparison of a / b < c / d can be replaced by a × d < b × c
    // to avoid precision issue and better performance
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]);

    // Initialize priority queue with (0, 1) ... (0, n - 1),
    // where later in each iteration we will replace the value of i one by one
    for (int j = 1; j < n; j++) {
      pq.add(new int[]{0, j});
    }

    for (int i = k; i > 1; i--) {
      int[] currentFraction = pq.remove();
      int indexI = currentFraction[0];
      int indexJ = currentFraction[1];

      // If next index is still smaller than J,
      // since arr is strictly increasing according to constraints
      if (indexI + 1 < indexJ) {
        pq.add(new int[]{indexI + 1, indexJ});
      }
    }

    int[] result = pq.remove();
    return new int[]{arr[result[0]], arr[result[1]]};
  }
}
