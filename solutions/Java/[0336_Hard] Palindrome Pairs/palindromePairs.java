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

  public String reverseString(String s) {
    StringBuilder builder = new StringBuilder(s);
    return builder.reverse().toString();
  }

  public List<List<Integer>> palindromePairs(String[] words) {
    int wordsLength = words.length;
    List<List<Integer>> result = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < words.length; i++) {
      String w = words[i];
      map.put(w, i);
    }

    // Case 1: s1.length == 0: check if s2 is palindrome
    if (map.containsKey("")) {
      int s1Index = map.get("");

      for (int i = 0; i < wordsLength; i++) {
        if (i != s1Index && isPalindrome(words[i], 0, words[i].length() - 1)) {
          result.add(Arrays.asList(s1Index, i));
          result.add(Arrays.asList(i, s1Index));
        }
      }
    }

    // Case 2: s1.length == s2.length: s2 is reverse of s1
    for (int i = 0; i < wordsLength; i++) {
      String s1 = reverseString(words[i]);

      if (map.containsKey(s1)) {
        int s2Index = map.get(s1);
        if (i != s2Index) {
          result.add(Arrays.asList(i, s2Index));
        }
      }
    }

    // Case 3: s1.length > s2.length: First part of s1 is equal to reverse of s2, the last part of s1 is palindrome
    // Case 4: s1.length < s2.length: Last part of s2 is equal to reverse of s1, the first part of s2 is palindrome
    for (int i = 0; i < wordsLength; i++) {
      String s1 = words[i];

      if (s1.equals("")) {
        continue;
      }

      int s1Length = s1.length();

      for (int s2Length = 1; s2Length < s1Length; s2Length++) {
        String reversedS1 = reverseString(s1);

        if (isPalindrome(s1, 0, s2Length - 1)) {
          String s1Left = reversedS1.substring(0, s1Length - s2Length);

          if (map.containsKey(s1Left)) {
            int s2Index = map.get(s1Left);

            if (s2Index != i) {
              result.add(Arrays.asList(s2Index, i));
            }
          }
        }

        if (isPalindrome(s1, s2Length, s1Length - 1)) {
          String s1Right = reversedS1.substring(s1Length - s2Length);

          if (map.containsKey(s1Right)) {
            int s2Index = map.get(s1Right);

            if (s2Index != i) {
              result.add(Arrays.asList(i, s2Index));
            }
          }
        }
      }
    }

    return result;
  }
}
