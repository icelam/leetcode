class Solution {
  private ArrayList<String> result = new ArrayList<>();

  private void backtrack(int n, StringBuilder builder) {
    if (builder.length() == n) {
      result.add(builder.toString());
      return;
    }

    for (char c = 'a'; c <= 'c'; c++) {
      if (builder.length() > 0 && builder.charAt(builder.length() - 1) == c) {
        continue;
      }

      builder.append(c);
      backtrack(n, builder);
      builder.deleteCharAt(builder.length() - 1);
    }
  }

  public String getHappyString(int n, int k) {
    backtrack(n, new StringBuilder());

    if (result.size() < k) {
      return "";
    }

    Collections.sort(result);
    return result.get(k - 1);
  }
}
