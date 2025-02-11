class Solution {
  private boolean isPartFound(Stack<Character> stack, char[] partCharacters) {
    Stack<Character> remainingCharacters = new Stack<>();
    remainingCharacters.addAll(stack);

    for (int partIndex = partCharacters.length - 1; partIndex >= 0; partIndex--) {
      if (remainingCharacters.isEmpty() || remainingCharacters.peek() != partCharacters[partIndex]) {
        return false;
      }

      remainingCharacters.pop();
    }

    return true;
  }

  public String removeOccurrences(String s, String part) {
    Stack<Character> stack = new Stack<>();
    char[] characters = s.toCharArray();
    char[] partCharacters = part.toCharArray();
    int n = characters.length;
    int m = partCharacters.length;

    for (int index = 0; index < n; index++) {
      stack.push(characters[index]);

      if (stack.size() >= m && isPartFound(stack, partCharacters)) {
        for (int j = 0; j < m; j++) {
          stack.pop();
        }
      }
    }

    StringBuilder builder = new StringBuilder();

    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }

    builder.reverse();
    return builder.toString();
  }
}
