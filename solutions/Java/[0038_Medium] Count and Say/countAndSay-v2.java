class Solution {
  public String countAndSay(int n) {
    String s = "1";

    for (int i = 2; i <= n; i++) {
      StringBuilder builder = new StringBuilder();
      char previousChar = s.charAt(0);
      int streak = 0;

      for (int j = 0; j < s.length(); j++) {
        char currentChar = s.charAt(j);

        if (currentChar == previousChar) {
          streak++;
        } else {
          builder.append(streak);
          builder.append(previousChar);
          streak = 1;
        }

        previousChar = currentChar;
      }

      builder.append(streak);
      builder.append(previousChar);

      s = builder.toString();
    }

    return s;
  }
}
