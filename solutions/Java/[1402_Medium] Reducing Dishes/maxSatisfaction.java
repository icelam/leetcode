class Solution {
  public int calculateSatisfaction(int[] satisfaction, int n, int start) {
    int currentDish = start;
    int time = 1;
    int sum = 0;

    while (currentDish < n) {
      sum += satisfaction[currentDish] * time;
      currentDish++;
      time++;
    }

    return sum;
  }

  public int maxSatisfaction(int[] satisfaction) {
    int n = satisfaction.length;
    Arrays.sort(satisfaction);

    if (satisfaction[n - 1] <= 0) {
      return 0;
    }

    int maxSatisfaction = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int totalSatisfaction = calculateSatisfaction(satisfaction, n, i);

      if (totalSatisfaction < maxSatisfaction) {
        break;
      }

      maxSatisfaction = totalSatisfaction;
    }

    return maxSatisfaction;
  }
}
