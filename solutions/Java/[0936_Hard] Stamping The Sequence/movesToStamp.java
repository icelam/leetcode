class Solution {
  private static char PLACEHOLDER_CHAR = '?';

  private boolean canStamp(char[] targetChars, char[] stampChars, int start) {
    for (int i = 0; i < stampChars.length; i++) {
      if (targetChars[i + start] != PLACEHOLDER_CHAR && targetChars[i + start] != stampChars[i]) {
        return false;
      }
    }

    return true;
  }

  private void removeMatch(char[] chars, int stampLength, int start) {
    for (int i = 0; i < stampLength; i++) {
      if (chars[start + i] != PLACEHOLDER_CHAR) {
        chars[start + i] = PLACEHOLDER_CHAR;
      }
    }
  }

  public boolean isAllFilled(char[] chars) {
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] != PLACEHOLDER_CHAR) {
        return false;
      }
    }

    return true;
  }

  public int[] movesToStamp(String stamp, String target) {
    char[] stampChars = stamp.toCharArray();
    char[] targetChars = target.toCharArray();
    boolean[] visited = new boolean[targetChars.length];
    int placeholderCount = 0;

    List<Integer> indices = new ArrayList<>();

    while (!isAllFilled(targetChars)) {
      boolean replaced = false;

      for (int i = 0; i <= targetChars.length - stampChars.length; i++) {
        if (!visited[i] && canStamp(targetChars, stampChars, i)) {
          removeMatch(targetChars, stampChars.length, i);
          replaced = true;
          visited[i] = true;
          indices.add(i);

          if (isAllFilled(targetChars)) {
            break;
          }
        }
      }

      if (!replaced) {
        return new int[0];
      }
    }

    Collections.reverse(indices);

    return indices
      .stream()
      .mapToInt(Integer::intValue)
      .toArray();
  }
}
