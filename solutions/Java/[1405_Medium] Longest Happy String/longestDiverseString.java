class Solution {
  private char convertIndexToChar(int x) {
    return (char) (x + 'a');
  }

  public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
    StringBuilder builder = new StringBuilder();

    if (a > 0) {
      pq.add(new int[]{0, a});
    }

    if (b > 0) {
      pq.add(new int[]{1, b});
    }

    if (c > 0) {
      pq.add(new int[]{2, c});
    }

    while (!pq.isEmpty()) {
      int[] currentPair = pq.remove();
      char character = convertIndexToChar(currentPair[0]);

      if (
        builder.length() >= 2
        && builder.charAt(builder.length() - 1) == character
        && builder.charAt(builder.length() - 2) == character
      ) {
        if (pq.isEmpty()) {
          break;
        }

        int[] secondMostPair = pq.remove();
        builder.append(convertIndexToChar(secondMostPair[0]));

        if (secondMostPair[1] - 1 > 0) {
          pq.add(new int[]{secondMostPair[0], secondMostPair[1] - 1});
        }
      } else {
        builder.append(character);
        currentPair[1]--;
      }

      if (currentPair[1] > 0) {
        pq.add(currentPair);
      }
    }

    return builder.toString();
  }
}
