class Solution {
  public int firstUniqChar(String s) {
    int[] allCounts = new int[26];
    char[] chars = s.toCharArray();

    for (char c: chars) {
      allCounts[c - 'a']++;
    }

    int result = Integer.MAX_VALUE;

    for (int i = 0; i < chars.length; i++) {
      if (allCounts[chars[i] - 'a'] == 1) {
        result = Math.min(result, i);
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
