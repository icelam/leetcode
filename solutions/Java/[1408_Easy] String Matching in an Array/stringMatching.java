class Solution {
  private boolean isSubstring(String s, String target) {
    int i = 0;
    int j = 0;

    char[] characters = s.toCharArray();
    char[] targetChars = target.toCharArray();

    while (i < s.length() && j < target.length()) {
      if (characters[i] == targetChars[j]) {
        i++;
        j++;
      } else {
        i = i - j + 1;
        j = 0;
      }
    }

    return j == target.length();
  }

  public List<String> stringMatching(String[] words) {
    List<String> result = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (!words[i].equals(words[j]) && isSubstring(words[j], words[i])) {
          result.add(words[i]);
          break;
        }
      }
    }

    return result;
  }
}
