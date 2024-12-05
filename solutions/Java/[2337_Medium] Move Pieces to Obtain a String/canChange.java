class Solution {
  public boolean canChange(String start, String target) {
    // As L cannot move over R and R cannot move over L, both string should be equal after removing all _
    if (!start.replace("_", "").equals(target.replace("_", ""))) {
      return false;
    }

    int n = start.length();
    char[] startCharacters = start.toCharArray();
    char[] targetCharacters = target.toCharArray();

    for (int i = 0, j = 0; i < n; i++) {
      if (startCharacters[i] == '_') {
        continue;
      }

      while (targetCharacters[j] == '_') {
        j++;
      }

      if (i != j && (startCharacters[i] == 'L') == (i < j)) {
        return false;
      }

      j++;
    }

    return true;
  }
}
