class Solution {
  public String finalString(String s) {
    int left = 0;
    int right = 0;
    char[] characters = s.toCharArray();
    int n = characters.length;
    StringBuilder builder = new StringBuilder();

    while (left < n) {
      while (right < n && characters[right] != 'i') {
        right++;
      }

      int nextLeft = right;

      while (nextLeft < n && characters[nextLeft] == 'i') {
        nextLeft++;
      }

      int iStreak = nextLeft - right;

      if (iStreak % 2 == 1) {
        for (int i = 0, j = right - 1; i < j; i++, j--) {
          char temp = characters[i];
          characters[i] = characters[j];
          characters[j] = temp;
        }
      }

      left = nextLeft;
      right = nextLeft;
    }

    for (char c: characters) {
      if (c != 'i') {
        builder.append(c);
      }
    }

    return builder.toString();
  }
}
