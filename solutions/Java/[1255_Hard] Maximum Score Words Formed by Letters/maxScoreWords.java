class Word {
  private String word;
  private int[] frequency;
  private int score;

  public Word(String word, int[] scoreMap) {
    this.word = word;
    frequency = new int[26];

    for (char c: word.toCharArray()) {
      frequency[c - 'a']++;
      score += scoreMap[c - 'a'];
    }
  }

  @Override public String toString() {
    return word + "=" + score;
  }

  public boolean isValid(int[] availableLetters) {
    boolean canFormByLetters = true;

    for (int i = 0; i < 26; i++) {
      if (frequency[i] > availableLetters[i]) {
        return false;
      }
    }

    return true;
  }

  public int getScore() {
    return score;
  }

  public int[] getFrequency() {
    return frequency;
  }
}

class Solution {
  private int backtrack(List<Word> words, int[] availableLetters, int index, int score) {
    if (index == words.size()) {
      return score;
    }

    int maxScore = 0;
    Word currentWord = words.get(index);

    // Take word if possible
    if (currentWord.isValid(availableLetters)) {
      int[] wordFrequency = currentWord.getFrequency();

      for (int i = 0; i < 26; i++) {
        availableLetters[i] -= wordFrequency[i];
      }

      int scoreAfterTake = backtrack(words, availableLetters, index + 1, score + currentWord.getScore());

      if (scoreAfterTake > maxScore) {
        maxScore = scoreAfterTake;
      }

      for (int i = 0; i < 26; i++) {
        availableLetters[i] += wordFrequency[i];
      }
    }

    // Skip taking word to see if we have better choice
    int scoreWithoutTake = backtrack(words, availableLetters, index + 1, score);

    if (scoreWithoutTake > maxScore) {
      maxScore = scoreWithoutTake;
    }

    return maxScore;
  }

  public int maxScoreWords(String[] words, char[] letters, int[] score) {
    int n = words.length;
    int[] availableLetters = new int[26];
    List<Word> validWords = new ArrayList<>();

    // Count letter frequency
    for (int letter: letters) {
      availableLetters[letter - 'a']++;
    }

    // Filter words to optimize backtrack performance
    for (String w: words) {
      Word currentWord = new Word(w, score);

      if (currentWord.isValid(availableLetters) && currentWord.getScore() > 0) {
        validWords.add(currentWord);
      }
    }

    return backtrack(validWords, availableLetters, 0, 0);
  }
}
