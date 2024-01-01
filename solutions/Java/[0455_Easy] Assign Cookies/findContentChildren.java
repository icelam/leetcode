class Solution {
  public int findContentChildren(int[] g, int[] s) {
    int m = g.length;
    int n = s.length;
    int i = 0;
    int j = 0;
    Arrays.sort(g);
    Arrays.sort(s);

    while (i < n && j < m) {
      if (s[i] >= g[j]) {
        j++;
      }

      i++;
    }

    return j;
  }
}
