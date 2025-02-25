class Solution {
  private static int MOD = (int) (1e9 + 7);

  public int numOfSubarrays(int[] arr) {
    int n = arr.length;
    int result = 0;
    int sum = 0;
    int[] frequency = new int[2];
    frequency[0]++;

    for (int i = 0; i < n; i++) {
      sum += arr[i];

      if (sum % 2 == 0) {
        result += frequency[1];
      } else {
        result += frequency[0];
      }

      result %= MOD;
      frequency[sum % 2]++;
    }

    return result;
  }
}
