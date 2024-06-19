class Solution {
  private boolean canMake(int[] bloomDay, int bouquetsNeeded, int bouquetSize, int currentDate) {
    int flowersCount = 0;
    int bouquetsCount = 0;
    int n = bloomDay.length;

    for (int i = 0; i < n; i++) {
      // Flower is not bloomed, since we need k adjacent (continuois) flowers
      // to make single bouquet, reset flower count
      if (bloomDay[i] > currentDate) {
        flowersCount = 0;
        continue;
      }

      flowersCount++;

      // Take and make bouquet if flowers is enough
      if (flowersCount == bouquetSize) {
        bouquetsCount++;
        flowersCount = 0;

        if (bouquetsCount == bouquetsNeeded) {
          return true;
        }
      }
    }

    return false;
  }

  public int minDays(int[] bloomDay, int m, int k) {
    int n = bloomDay.length;

    if (m > n / k) {
      return -1;
    }

    int left = Integer.MAX_VALUE;
    int right = Integer.MIN_VALUE;

    for (int date: bloomDay) {
      if (date < left) {
        left = date;
      }

      if (date > right) {
        right = date;
      }
    }

    while (left < right) {
      int middle = left + (right - left) / 2;

      if (canMake(bloomDay, m, k, middle)) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }

    return left;
  }
}
