class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
    int length = strs.length;
    int[][] memo = new int[m + 1][n + 1];

    for (String s: strs) {
      int numberOfZeros = 0;
      int numberOfOnes = 0;

      for (char c: s.toCharArray()) {
        if (c == '0') {
          numberOfZeros++;
        } else {
          numberOfOnes++;
        }
      }

      for (int i = m; i >= numberOfZeros; i--) {
        for (int j = n; j >= numberOfOnes; j--) {
          if (numberOfOnes <= j && numberOfZeros <= i) {
            memo[i][j] = Math.max(
              memo[i][j],
              memo[i - numberOfZeros][j - numberOfOnes] + 1
            );
          }
        }
      }
    }

    return memo[m][n];
  }
}

