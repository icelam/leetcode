class Solution {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> result = new ArrayList<>();

    for (int num = left; num <= right; num++) {
      boolean isSelfDividing = true;

      for (int digits = num; digits > 0 && isSelfDividing; digits /= 10) {
        int currentDigit = digits % 10;
        isSelfDividing = currentDigit != 0 && num % currentDigit == 0;
      }

      if (isSelfDividing) {
        result.add(num);
      }
    }

    return result;
  }
}
