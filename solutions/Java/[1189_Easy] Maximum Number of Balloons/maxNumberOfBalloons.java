class Solution {
  public int maxNumberOfBalloons(String text) {
    int[] frequency = new int[26];

    for (char c: text.toCharArray()) {
      frequency[c - 'a']++;
    }

    int result = frequency['b' - 'a'];
    result = Math.min(result, frequency['a' - 'a']);
    result = Math.min(result, frequency['l' - 'a'] / 2);
    result = Math.min(result, frequency['o' - 'a'] / 2);
    result = Math.min(result, frequency['n' - 'a']);

    return result;
  }
}

