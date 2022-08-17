class Solution {
  private static String[] morseCode = new String[]{
    ".-",
    "-...",
    "-.-.",
    "-..",
    ".",
    "..-.",
    "--.",
    "....",
    "..",
    ".---",
    "-.-",
    ".-..",
    "--",
    "-.",
    "---",
    ".--.",
    "--.-",
    ".-.",
    "...",
    "-",
    "..-",
    "...-",
    ".--",
    "-..-",
    "-.--",
    "--.."
  };

  public int uniqueMorseRepresentations(String[] words) {
    HashSet<String> encodedWords = new HashSet<>();

    for (String w: words) {
      char[] chars = w.toCharArray();
      StringBuilder encodedWord = new StringBuilder();

      for (char c: chars) {
        encodedWord.append(morseCode[c - 'a']);
      }

      encodedWords.add(encodedWord.toString());
    }

    return encodedWords.size();
  }
}
