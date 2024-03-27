class Solution {
  public int countKeyChanges(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int changeCount = 0;

    for (int i = 1; i < n; i++) {
      int keyDiff = Math.abs(characters[i - 1] - characters[i]);

      if (keyDiff != 0 && keyDiff != 32) {
        changeCount++;
      }
    }

    return changeCount;
  }
}
