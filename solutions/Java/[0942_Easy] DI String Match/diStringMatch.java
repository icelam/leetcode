class Solution {
  public int[] diStringMatch(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int[] result = new int[n + 1];
    int rangeLow = 0;
    int rangeHigh = n;

    // Greedy
    for (int i = 0; i < n; i++) {
      // 'I' = next num increased
      // Select smallest value of remaining nums
      if (characters[i] == 'I') {
        result[i] = rangeLow;
        rangeLow++;
        continue;
      }

      // 'D' = next num decreased
      // Select lagest value of remaining nums
      result[i] = rangeHigh;
      rangeHigh--;
    }

    result[n] = rangeLow;

    return result;
  }
}
