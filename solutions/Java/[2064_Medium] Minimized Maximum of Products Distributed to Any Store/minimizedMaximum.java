class Solution {
  private boolean canDistribute(int n, int[] quantities, int distribute) {
    for (int currentQuantity: quantities) {
      // Round up using (x + y - 1) / y formula
      n -= (currentQuantity + distribute - 1) / distribute;

      if (n < 0) {
        return false;
      }
    }

    return true;
  }

  public int minimizedMaximum(int n, int[] quantities) {
    int maxQuantity = Integer.MIN_VALUE;

    for (int currentQuantity: quantities) {
      maxQuantity = Math.max(maxQuantity, currentQuantity);
    }

    int left = 1;
    int right = maxQuantity;
    int maxDistributeQuantity = 0;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (canDistribute(n, quantities, middle)) {
        maxDistributeQuantity = middle;
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return maxDistributeQuantity;
  }
}
