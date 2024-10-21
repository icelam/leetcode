class Solution {
  int result = 0;

  private void backtrack(String s, int start, Set<String> visited, int currentCount) {
    if (currentCount + (s.length() - start) <= result) {
      return;
    }

    if (start == s.length()) {
      result = Math.max(result, currentCount);
      return;
    }

    for (int end = start + 1; end <= s.length(); ++end) {
      String substring = s.substring(start, end);
      if (!visited.contains(substring)) {
        visited.add(substring);
        backtrack(s, end, visited, currentCount + 1);
        visited.remove(substring);
      }
    }
  }

  public int maxUniqueSplit(String s) {
    backtrack(s, 0, new HashSet<>(), 0);
    return result;
  }
}
