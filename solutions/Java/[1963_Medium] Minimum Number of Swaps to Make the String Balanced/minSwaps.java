class Solution {
  private static char OPEN_IDENTIFIER = '[';
  private static char CLOSE_IDENTIFIER = ']';

  public int minSwaps(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    Stack<Integer> openIndices = new Stack<>();

    for (int i = 0; i < n; i++) {
      if (characters[i] == OPEN_IDENTIFIER) {
        openIndices.add(i);
      }
    }

    int openCount = 0;
    int closeCount = 0;
    int swapCount = 0;

    for (int i = 0; i < n / 2; i++) {
      if (characters[i] == OPEN_IDENTIFIER) {
        openCount++;
      } else if (closeCount + 1 > openCount) {
        int lastOpenIndex = openIndices.pop();
        char temp = characters[i];
        characters[i] = characters[lastOpenIndex];
        characters[lastOpenIndex] = temp;
        swapCount++;
        openCount++;
      } else {
        closeCount++;
      }
    }

    System.out.println(new String(characters));

    return swapCount;
  }
}
