class Solution {
  public int shipWithinDays(int[] weights, int days) {
    int max = 0;
    int sum = 0;

    for (int w: weights) {
        max = Math.max(max, w);
        sum += w;
    }

    int left = max;
    int right = sum;

    while (left < right) {
      int middle = (left + right) / 2;
      int daysNeeded = 1;
      int currentWeight = 0;

      for (int weight: weights) {
        if (currentWeight + weight > middle) {
          daysNeeded++;
          currentWeight = 0;
        }

        currentWeight += weight;
      }

      if (daysNeeded <= days) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }

    return left;
  }
}
