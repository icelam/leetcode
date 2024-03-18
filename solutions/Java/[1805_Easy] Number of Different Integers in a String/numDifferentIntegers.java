class Solution {
  public int numDifferentIntegers(String word) {
    StringBuilder currentInteger = new StringBuilder();
    boolean isPreviousCharDigit = false;
    HashSet<String> set = new HashSet<>();

    for (char c: word.toCharArray()) {
      boolean isDigit = Character.isDigit(c);

      if (isDigit) {
        if (!(currentInteger.length() == 0 && c == '0')) {
          currentInteger.append(c);
        }
      } else if (isPreviousCharDigit) {
        set.add(currentInteger.toString());
        currentInteger.delete(0, currentInteger.length());
      }

      isPreviousCharDigit = isDigit;
    }

    if (isPreviousCharDigit) {
      set.add(currentInteger.toString());
    }

    return set.size();
  }
}
