class Solution {
  public int minSetSize(int[] arr) {
    int minValue = 1000000;
    int maxValue = 1;
    int length = arr.length;

    for (int m: arr) {
      minValue = Math.min(minValue, m);
      maxValue = Math.max(maxValue, m);
    }

    int[] count = new int[maxValue - minValue + 1];

    for (int n: arr) {
      count[n - minValue]++;
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    for (int j = 0; j < count.length; j++) {
      if (count[j] > 0) {
        pq.add(new int[]{j + minValue, count[j]});
      }
    }

    int result = 0;
    int remaining = length;
    int halfLength = length >> 1;

    while (remaining > halfLength) {
      int[] largestSet = pq.remove();
      remaining -= largestSet[1];
      result++;
    }

    return result;
  }
}
