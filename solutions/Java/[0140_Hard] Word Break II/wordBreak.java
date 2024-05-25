class Solution {
  private List<String> result;

  private void backtrack(char[] characters, HashSet<String> dict, int index, StringBuilder sentence) {
    if (index == characters.length) {
      result.add(sentence.toString());
      return;
    }

    StringBuilder word = new StringBuilder();

    // Check upcoming 10 characters since "1 <= wordDict[i].length <= 10"
    for (int i = index; i < index + 10 && i < characters.length; i++) {
      word.append(characters[i]);

      if (!dict.contains(word.toString())) {
        continue;
      }

      int sentenceLength = sentence.length();

      if (sentenceLength > 0) {
        sentence.append(' ');
      }

      sentence.append(word.toString());
      backtrack(characters, dict, i + 1, sentence);
      sentence.setLength(sentenceLength);
    }
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    HashSet<String> dict = new HashSet<>();
    result = new ArrayList<String>();

    for (String word: wordDict) {
      dict.add(word);
    }

    backtrack(s.toCharArray(), dict, 0, new StringBuilder());

    return result;
  }
}
