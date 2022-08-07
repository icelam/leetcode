class Solution {
  public int mySqrt(int x) {
    if (x <= 1) {
      return x;
    }

    int left = 1;
    int right = x / 2;

    while (left <= right) {
      int middle = left + (right - left) / 2;
      long square = (long) middle * middle;
      long nextSquare = (long) (middle + 1) * (middle + 1);

      if (x >= square && x < nextSquare) {
        return middle;
      }

      if (square > x) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return -1;
  }
}
