class Solution {
  public boolean isPerfectSquare(int num) {
    int left = 1;
    int right = 46340;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (middle * middle == num) {
        return true;
      }

      if (num < middle * middle) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return false;
  }
}
