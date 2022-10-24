class Solution {
  private int result;

  private void backtrack(List<String> words, int[] count, int start) {
    for (int i = start; i < words.size(); i++) {
      if (i >= words.size()) {
        return;
      }

      char[] currentWord = words.get(i).toCharArray();

      for (char c: currentWord) {
        count[c - 'a']++;
      }

      boolean isAllCharacterUnique = true;
      int currentLength = 0;

      for (int n: count) {
        currentLength += n;

        if (n > 1) {
          isAllCharacterUnique = false;
          break;
        }
      }

      if (isAllCharacterUnique) {
        result = Math.max(currentLength, result);
        backtrack(words, count, i + 1);
      }

      for (char c: currentWord) {
        count[c - 'a']--;
      }
    }
  }

  public int maxLength(List<String> arr) {
    result = 0;

    for (int i = 0; i < arr.size(); i++) {
      int[] count = new int[26];
      backtrack(arr, count, i);
    }
    return result;
  }
}
