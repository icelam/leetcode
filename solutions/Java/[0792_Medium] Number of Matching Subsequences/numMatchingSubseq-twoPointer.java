class Solution {
  public boolean searchSubSequence(char[] sChars, char[] wChars) {
    int i = 0;
    int j = 0;

    while (i < wChars.length && j < sChars.length) {
      boolean isCharMatch = wChars[i] == sChars[j];
      j++;

      if (isCharMatch) {
        if (i == wChars.length - 1) {
          return true;
        }

        i++;
      }
    }

    return false;
  }

  public int numMatchingSubseq(String s, String[] words) {
    HashMap<String, Boolean> memo = new HashMap<>();
    char[] sChars = s.toCharArray();

    int result = 0;

    for (String w: words) {
      char[] wChars = w.toCharArray();

      if (memo.containsKey(w)) {
        result += memo.get(w) ? 1 : 0;
        continue;
      }

      boolean isMatching = searchSubSequence(sChars, wChars);
      memo.put(w, isMatching);
      result += isMatching ? 1 : 0;
    }

    return result;
  }
}
