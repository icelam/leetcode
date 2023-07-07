class Solution {
  private int booleanToBinary(char c) {
    return c == 'F' ? 0 : 1;
  }

  public int maxConsecutiveAnswers(String answerKey, int k) {
    char[] answers = answerKey.toCharArray();
    int n = answers.length;
    int right = 0;
    int left = 0;
    int maxLength = 0;
    int[] count = new int[2];

    while (right < n) {
      count[booleanToBinary(answers[right])]++;
      right++;

      if (Math.min(count[0], count[1]) <= k) {
        maxLength = Math.max(maxLength, count[0] + count[1]);
      }

      while (left <= right && Math.min(count[0], count[1]) > k) {
        count[booleanToBinary(answers[left])]--;
        left++;
      }
    }

    return maxLength;
  }
}
