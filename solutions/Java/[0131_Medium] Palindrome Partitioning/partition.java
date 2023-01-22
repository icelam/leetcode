class Solution {
  public boolean isPalindrome(String s, int start, int end) {
    char[] characters = s.toCharArray();

    while (start < end) {
      if (characters[start] != characters[end]) {
        return false;
      }

      start++;
      end--;
    }

    return true;
  }

  public void backtrack(String s, int length, int start, List<String> substrings, List<List<String>> result) {
    if (start >= length) {
      result.add(new ArrayList<>(substrings));
      return;
    }

    for (int end = start; end < length; end++) {
      if (isPalindrome(s, start, end)) {
        substrings.add(s.substring(start, end + 1));
        backtrack(s, length, end + 1, substrings, result);
        substrings.remove(substrings.size() - 1);
      }
    }
  }

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    backtrack(s, s.length(), 0, new ArrayList<String>(), result);
    return result;
  }
}
