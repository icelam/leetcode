class Solution {
  public int minMaxDifference(int num) {
    int[] digits = new int[9];
    int digitsPointer = digits.length - 1;
    int maxNum = 0;
    int minNum = 0;

    while (num > 0) {
      digits[digitsPointer] = num % 10;
      num /= 10;
      digitsPointer--;
    }

    int start = digitsPointer + 1;
    int firstNon9Index = start;
    int firstNonZeroIndex = start;

    while (firstNon9Index < 8 && digits[firstNon9Index] == 9) {
      firstNon9Index++;
    }

    while (firstNonZeroIndex < 8 && digits[firstNonZeroIndex] == 0) {
      firstNonZeroIndex++;
    }

    int numToReplaceToMakeNumMax = digits[firstNon9Index];
    int numToReplaceToMakeNumMin = digits[firstNonZeroIndex];

    for (int i = start; i < 9; i++) {
      maxNum *= 10;
      maxNum += digits[i] == numToReplaceToMakeNumMax ? 9 : digits[i];
      minNum *= 10;
      minNum += digits[i] == numToReplaceToMakeNumMin ? 0 : digits[i];
    }

    return maxNum - minNum;
  }
}
