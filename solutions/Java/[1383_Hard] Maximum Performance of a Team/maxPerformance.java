class Solution {
  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    int[][] engineers = new int[n][2];

    for (int i = 0; i < n; i++) {
      engineers[i] = new int[] {efficiency[i], speed[i]};
    }

    Arrays.sort(engineers, (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

    PriorityQueue<Integer> speedOfSelectedEngineers = new PriorityQueue<>(k);
    long performance = 0;
    long totalSpeed = 0;

    for (int i = 0; i < n; i++) {
      if (speedOfSelectedEngineers.size() >= k) {
        int currentLeastSpeed = speedOfSelectedEngineers.remove();
        totalSpeed -= currentLeastSpeed;
      }

      speedOfSelectedEngineers.add(engineers[i][1]);
      totalSpeed += engineers[i][1];

      performance = Math.max(performance, totalSpeed * engineers[i][0]);
    }

    return (int) (performance % 1000000007);
  }
}
