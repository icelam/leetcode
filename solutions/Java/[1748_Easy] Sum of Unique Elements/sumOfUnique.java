class Solution {
  public int sumOfUnique(int[] nums) {
    int[] frequency = new int[101];
    int result = 0;

    for (int n: nums) {
      frequency[n]++;
    }

    for (int i = 1; i <= 100; i++) {
      if (frequency[i] == 1) {
        result += i;
      }
    }

    return result;
  }
}
