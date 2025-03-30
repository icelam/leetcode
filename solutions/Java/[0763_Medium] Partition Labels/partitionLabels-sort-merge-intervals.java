class Solution {
  public List<Integer> partitionLabels(String s) {
    int n = s.length();
    int[][] ranges = new int[26][2];
    char[] characters = s.toCharArray();

    for (int[] pair: ranges) {
      Arrays.fill(pair, -1);
    }

    for (int i = 0; i < n; i++) {
      char c = characters[i];

      if (ranges[c - 'a'][0] == -1) {
        ranges[c - 'a'][0] = i;
      }

      ranges[c - 'a'][1] = i;
    }

    Arrays.sort(ranges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    List<Integer> result = new ArrayList<>();
    int i = 0;

    while (ranges[i][0] == -1) {
      i++;
    }

    int min = ranges[i][0];
    int max = ranges[i][1];

    // Merge range pairs
    for (; i < 26; i++) {
      if (ranges[i][0] <= max) {
        min = Math.min(min, ranges[i][0]);
        max = Math.max(max, ranges[i][1]);
      } else {
        result.add(max - min + 1);
        min = ranges[i][0];
        max = ranges[i][1];
      }
    }

    // Handle last range pair
    result.add(max - min + 1);

    return result;
  }
}
