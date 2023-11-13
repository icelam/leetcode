class Solution {
  private char[] orderedVowels = new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

  private boolean isVowel(Character c) {
    for (char vowel: orderedVowels) {
      if (c == vowel) {
        return true;
      }
    }

    return false;
  }

  public String sortVowels(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    HashMap<Character, Integer> vowelFrequency = new HashMap<>();
    int vowelCount = 0;

    for (char c: characters) {
      if (isVowel(c)) {
        vowelFrequency.put(c, vowelFrequency.getOrDefault(c, 0) + 1);
        vowelCount++;
      }
    }

    if (vowelCount == 0) {
      return s;
    }

    StringBuilder builder = new StringBuilder();
    int i = 0;

    for (char c: characters) {
      if (isVowel(c)) {
        while (vowelFrequency.getOrDefault(orderedVowels[i], 0) == 0) {
          i++;
        }

        builder.append(orderedVowels[i]);
        vowelFrequency.put(orderedVowels[i], vowelFrequency.get(orderedVowels[i]) - 1);
      } else {
        builder.append(c);
      }
    }

    return builder.toString();
  }
}
