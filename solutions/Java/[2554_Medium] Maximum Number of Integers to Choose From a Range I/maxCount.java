class Solution {
  public int maxCount(int[] banned, int n, int maxSum) {
    int result = 0;
    HashSet<Integer> set = new HashSet<>();

    for (int value: banned) {
      set.add(value);
    }

    for (int i = 1; i <= n; i++) {
      if (i > maxSum) {
        break;
      }

      if (!set.contains(i)) {
        maxSum -= i;
        result++;
      }
    }

    return result;
  }
}
