class Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    int[] licensePlateFrequency = new int[26];
    String result = "";

    for (char c: licensePlate.toCharArray()) {
      if (Character.isLetter(c)) {
        if (Character.isUpperCase(c)) {
          licensePlateFrequency[c - 'A']++;
        } else {
          licensePlateFrequency[c - 'a']++;
        }
      }
    }

    for (String w: words) {
      int[] wordFrequency = new int[26];

      for (char c: w.toCharArray()) {
        wordFrequency[c - 'a']++;
      }

      boolean isCompleting = true;

      for (int i = 0; i < 26; i++) {
        if (licensePlateFrequency[i] > wordFrequency[i]) {
          isCompleting = false;
          break;
        }
      }

      if (isCompleting && (result.length() == 0 || w.length() < result.length())) {
        result = w;
      }
    }

    return result;
  }
}
