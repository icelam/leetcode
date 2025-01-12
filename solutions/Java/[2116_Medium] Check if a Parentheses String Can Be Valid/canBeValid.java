class Solution {
  public boolean canBeValid(String s, String locked) {
    int n = s.length();

    if (n % 2 == 1) {
      return false;
    }

    char[] characters = s.toCharArray();
    char[] lockedState = locked.toCharArray();
    int canChangeCount = 0;

    for (int i = 0; i < n; i++) {
      if (characters[i] == '(' || lockedState[i] == '0') {
        canChangeCount++;
      } else if (canChangeCount > 0) {
        canChangeCount--;
      } else {
        return false;
      }
    }

    canChangeCount = 0;

    for (int i = n - 1; i >= 0; i--) {
      if (characters[i] == ')' || lockedState[i] == '0') {
        canChangeCount++;
      } else if (canChangeCount > 0) {
        canChangeCount--;
      } else {
        return false;
      }
    }

    return true;
  }
}
