class Solution {
  public int numUniqueEmails(String[] emails) {
    HashSet<String> set = new HashSet<>();

    for (String email: emails) {
      StringBuilder builder = new StringBuilder();
      char[] characters = email.toCharArray();

      boolean shouldSkip = false;
      boolean isDomain = false;

      for (char c: characters) {
        if (c == '@') {
          isDomain = true;
        }

        if (!isDomain) {
          if ((c == '.' || shouldSkip)) {
            continue;
          }

          if (c == '+') {
            shouldSkip = true;
            continue;
          }
        }

        builder.append(c);
      }

      set.add(builder.toString());
    }

    return set.size();
  }
}
