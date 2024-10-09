class Solution {
  public String reformat(String s) {
    int alphabetCount = 0;
    int digitCount = 0;
    int[] alphabetFrequency = new int[26];
    int[] digitFrequency = new int[10];

    for (char c: s.toCharArray()) {
      if (Character.isDigit(c)) {
        digitFrequency[c - '0']++;
        digitCount++;
      } else {
        alphabetFrequency[c - 'a']++;
        alphabetCount++;
      }
    }

    if (Math.abs(alphabetCount - digitCount) > 1) {
      return "";
    }

    StringBuilder builder = new StringBuilder();
    int alphabetPointer = 0;
    int digitPointer = 0;

    while (alphabetCount > 0 && digitCount > 0) {
      while (alphabetFrequency[alphabetPointer] == 0) {
        alphabetPointer++;
      }

      while (digitFrequency[digitPointer] == 0) {
        digitPointer++;
      }

      builder.append((char) (alphabetPointer + 'a'));
      alphabetFrequency[alphabetPointer]--;
      alphabetCount--;

      builder.append(digitPointer);
      digitFrequency[digitPointer]--;
      digitCount--;
    }

    if (digitCount > 0) {
      while (digitFrequency[digitPointer] == 0) {
        digitPointer++;
      }

      builder.insert(0, digitPointer);
    }

    if (alphabetCount > 0) {
      while (alphabetFrequency[alphabetPointer] == 0) {
        alphabetPointer++;
      }

      builder.append((char) (alphabetPointer + 'a'));
    }

    return builder.toString();
  }
}
