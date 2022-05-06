class Solution {
  public String removeDuplicates(String s, int k) {
    StringBuilder result = new StringBuilder(s);
    int[] count = new int[s.length()];

    for (int i = 0; i < result.length(); i++) {
      if (i == 0 || result.charAt(i - 1) != result.charAt(i)) {
        count[i] = 1;
        continue;
      }

      count[i] = count[i - 1] + 1;
      if (count[i] == k) {
        result.delete(i - k + 1, i + 1);
        i = i - k;
      }
    }

    return result.toString();
  }
}
