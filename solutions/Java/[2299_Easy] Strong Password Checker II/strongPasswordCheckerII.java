class Solution {
  public boolean strongPasswordCheckerII(String password) {
    int n = password.length();

    if (n < 8) {
      return false;
    }

    boolean hasLowerCaseLetters = false;
    boolean hasUpperCaseLetters = false;
    boolean hasDigits = false;
    boolean hasSpecialCharacters = false;

    for (int i = 0; i < n; i++) {
      char c = password.charAt(i);

      if (i < n - 1 && c == password.charAt(i + 1)) {
        return false;
      }

      if (Character.isLowerCase(c)) {
        hasLowerCaseLetters = true;
      } else if (Character.isUpperCase(c)) {
        hasUpperCaseLetters = true;
      } else if (Character.isDigit(c)) {
        hasDigits = true;
      } else {
        hasSpecialCharacters = true;
      }
    }

    return (
      hasLowerCaseLetters
      && hasUpperCaseLetters
      && hasDigits
      && hasSpecialCharacters
    );
  }
}
