class Solution {
  public int maxPower(String s) {
    char[] characters = s.toCharArray();
    char previousChar = characters[0];
    int currentCount = 0;
    int maxCount = 0;

    for (char c: characters) {
      if (previousChar != c) {
        if (currentCount > maxCount) {
          maxCount = currentCount;
        }
        currentCount = 0;
        previousChar = c;
      }

      currentCount++;
    }

    return currentCount > maxCount ? currentCount : maxCount;
  }
}
