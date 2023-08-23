class Solution {
  public String reorganizeString(String s) {
    char[] characters = s.toCharArray();
    int[] frequency = new int[26];

    for (char c: characters) {
      frequency[c - 'a']++;
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    for (char i = 0; i < 26; i++) {
      if (frequency[i] > 0) {
        pq.add(new int[] {i + 'a', frequency[i]});
      }
    }

    StringBuilder builder = new StringBuilder();
    char previous = 'a';

    while (!pq.isEmpty()) {
      int[] pair1 = pq.remove();
      char c1 = (char) pair1[0];

      if (builder.length() == 0 || c1 != previous) {
        builder.append(c1);
        pair1[1]--;
        previous = c1;

        if (pair1[1] > 0) {
          pq.offer(pair1);
        }

        continue;
      }

      if (pq.isEmpty()) {
        return "";
      }

      int[] pair2 = pq.remove();
      char c2 = (char) pair2[0];

      builder.append(c2);
      pair2[1]--;
      previous = c2;

      if (pair2[1] > 0) {
        pq.offer(pair2);
      }

      pq.offer(pair1);
    }

    return builder.toString();
  }
}
