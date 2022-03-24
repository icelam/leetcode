class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    int[] pCharacters = new int[26];
    int[] sCharacters = new int[26];

    // First window
    for (int i = 0; i < p.length(); i++) {
      pCharacters[p.charAt(i) - 'a']++;

      if (i < s.length()) {
        sCharacters[s.charAt(i) - 'a']++;
      }
    }

    for (int j = p.length() - 1; j < s.length(); j++) {
      if (j >= p.length()) {
        sCharacters[s.charAt(j) - 'a']++;
        sCharacters[s.charAt(j - p.length()) - 'a']--;
      }

      boolean isAnagrams = true;

      for (int k = 0; k < 26; k++) {
        if (pCharacters[k] != sCharacters[k]) {
          isAnagrams = false;
          break;
        }
      }

      if (isAnagrams) {
        result.add(j - (p.length() - 1));
      }
    }

    return result;
  }
}
