class Solution {
  public int countSeniors(String[] details) {
    int olderThanSixty = 0;

    for (String passenger: details) {
      if ((passenger.charAt(11) - '0') * 10 + (passenger.charAt(12) - '0') > 60) {
        olderThanSixty++;
      }
    }

    return olderThanSixty;
  }
}
