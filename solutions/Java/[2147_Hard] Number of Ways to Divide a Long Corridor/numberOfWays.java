class Solution {
  private static int MOD = (int) (1e9 + 7);

  public int numberOfWays(String corridor) {
    char[] items = corridor.toCharArray();
    int n = items.length;
    // Base case = 1, which is: If there is even number of chairs,
    // you will at least have 1 way to divide the corridor
    long result = 1;
    int seatCount = 0;
    int left = 0;

    for (int right = 0; right < n; right++) {
      if (items[right] == 'S') {
        if (seatCount < 2) {
          left = right;
        } else {
          // 1. Number of possible cuts between two 2 seats blocks = number of trees + 1
          // 2. No matter how many plants are located at the end of corridor,
          //    you won't put dividers between them as there are no more seats up coming
          result *= right - left;
          result %= MOD;
          seatCount = 0;
        }

        seatCount++;
      }
    }

    // 1. There is no way to cut corridor with odd number of chairs
    // 2. There is no way to cut the corridor if there is no chair, e.g. "P"
    if (seatCount < 2) {
      return 0;
    }

    return (int) result;
  }
}
