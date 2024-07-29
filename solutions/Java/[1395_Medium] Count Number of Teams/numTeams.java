class Solution {
  public int numTeams(int[] rating) {
    int n = rating.length;
    int result = 0;

    for (int j = 1; j < n - 1; j++) {
      int[] iCount = new int[2];
      int[] kCount = new int[2];

      for (int i = 0; i < j; i++) {
        if (rating[i] < rating[j]) {
          iCount[0]++;
        } else if (rating[i] > rating[j]) {
          iCount[1]++;
        }
      }

      for (int k = j + 1; k < n; k++) {
        if (rating[k] < rating[j]) {
          kCount[0]++;
        } else if (rating[k] > rating[j]) {
          kCount[1]++;
        }
      }

      result += iCount[0] * kCount[1] + iCount[1] * kCount[0];
    }

    return result;
  }
}
