class Solution {

  public String repeatLimitedString(String s, int repeatLimit) {
    int[] frequency = new int[26];
    StringBuilder builder = new StringBuilder();

    for (char c: s.toCharArray()) {
      frequency[c - 'a']++;
    }

    int strike = 0;
    int pointer1 = 25;
    int pointer2 = 24;

    while (pointer1 >= 0 && pointer2 >= 0) {
      if (frequency[pointer1] == 0) {
        strike = 0;
        pointer1--;
      } else if (strike < repeatLimit) {
        frequency[pointer1]--;
        builder.append((char) (pointer1 + 'a'));
        strike++;
      } else if (pointer2 >= pointer1 || frequency[pointer2] == 0) {
        pointer2--;
      } else {
        frequency[pointer2]--;
        builder.append((char) (pointer2 + 'a'));
        strike = 0;
      }
    }

    return builder.toString();
  }
}
