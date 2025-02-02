class Solution {
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    int n = classes.length;

    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
      long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
      long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);

      if (val1 == val2) {
        return 0;
      }

      return val1 < val2 ? 1 : -1;
    });

    for (int[] info : classes) {
      pq.offer(new int[] {info[0], info[1]});
    }

    for (int i = 0; i < extraStudents; i++) {
      int[] currentClass = pq.remove();
      int pass = currentClass[0];
      int total = currentClass[1];
      pq.offer(new int[] {pass + 1, total + 1});
    }

    double result = 0;

    for (int i = 0; i < classes.length; i++) {
      int[] currentClass = pq.remove();
      double pass = currentClass[0];
      double total = currentClass[1];
      result += pass / total;
    }

    return result / n;
  }
}
