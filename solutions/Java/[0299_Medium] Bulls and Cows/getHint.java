class Solution {
  public String getHint(String secret, String guess) {
    char[] secretCharacters = secret.toCharArray();
    char[] guessCharacters = guess.toCharArray();

    int length = secret.length();

    int[] unmatchedSecretCharacters = new int[10];
    int[] unmatchedGuessCharacters = new int[10];
    int bulls = 0;
    int cows = 0;

    for (int i = 0; i < length; i++) {
      if (secretCharacters[i] == guessCharacters[i]) {
        bulls++;
      } else {
        unmatchedSecretCharacters[secretCharacters[i] - '0']++;
        unmatchedGuessCharacters[guessCharacters[i] - '0']++;
      }
    }

    for (int j = 0; j < 10; j++) {
      cows += Math.min(unmatchedSecretCharacters[j], unmatchedGuessCharacters[j]);
    }

    StringBuilder result = new StringBuilder();
    result.append(bulls);
    result.append("A");
    result.append(cows);
    result.append("B");

    return result.toString();
  }
}
