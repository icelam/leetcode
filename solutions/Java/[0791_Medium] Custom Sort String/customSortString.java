class Solution {
  public String customSortString(String order, String s) {
    // [char code, rank, frequency]
    int[][] map = new int[26][3];
    int currentRank = 1;

    for (char c: order.toCharArray()) {
      map[c - 'a'][1] = currentRank;
      currentRank++;
    }

    for (int i = 0; i < 26; i++) {
      map[i][0] = i;

      if (map[i][1] == 0) {
        map[i][1] = currentRank;
        currentRank++;
      }
    }

    for (char c: s.toCharArray()) {
      map[c - 'a'][2]++;
    }

    Arrays.sort(map, (a, b) -> a[1] - b[1]);

    StringBuilder builder = new StringBuilder();

    for (int[] pair: map) {
      char nextChar = (char) ('a' + pair[0]);

      for (int i = 0; i < pair[2]; i++) {
        builder.append(nextChar);
      }
    }

    return builder.toString();
  }
}
