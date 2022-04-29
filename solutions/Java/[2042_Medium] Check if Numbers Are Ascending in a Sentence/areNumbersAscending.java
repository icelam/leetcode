class Solution {
  public boolean areNumbersAscending(String s) {
    String[] parts = s.split(" ");
    int previous = -1;

    for (String p: parts) {
      if (p.charAt(0) >= '0' && p.charAt(0) <= '9') {
        int current = 0;

        for (int i = p.length() - 1, j = 1; i >= 0; i--, j *= 10) {
          current += (p.charAt(i) - '0') * j;
        }

        if (current <= previous) {
          return false;
        }

        previous = current;
      }
    }

    return true;
  }
}
