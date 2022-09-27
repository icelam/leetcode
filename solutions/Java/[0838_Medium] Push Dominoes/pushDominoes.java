class Solution {
  public String pushDominoes(String dominoes) {
    char[] dominoeStack = dominoes.toCharArray();

    int start = 0;
    int end = 0;
    char previousDirection = dominoeStack[0];

    while (start != dominoeStack.length - 1) {
      int currentIndex = start + 1;
      char currentDirection = '.';

      while (currentIndex < dominoeStack.length) {
        boolean isLastIndex = currentIndex == dominoeStack.length - 1;
        boolean isNotPushed = dominoeStack[currentIndex] == '.';

        if (!isLastIndex && isNotPushed) {
          currentIndex++;
          continue;
        }

        currentDirection = dominoeStack[currentIndex];
        end = currentIndex;
        break;
      }

      if (
        previousDirection == 'R'
        && (currentDirection == 'R' || currentDirection == '.')
      ) {
        for (int i = start; i <= end; i++) {
          dominoeStack[i] = previousDirection;
        }
      } else if (
        currentDirection == 'L'
        && (previousDirection == 'L' || previousDirection == '.')
      ) {
        for (int i = end; i >= start; i--) {
          dominoeStack[i] = currentDirection;
        }
      } else if (previousDirection == 'R' && currentDirection == 'L') {
        int length = (end - start) + 1;

        for (int i = start; i < start + (length / 2); i++) {
          dominoeStack[i] = previousDirection;
        }

        for (int i = start + (length / 2) + (length % 2); i <= end; i++) {
          dominoeStack[i] = currentDirection;
        }
      }

      previousDirection = currentDirection;
      start = end;
    }

    return new String(dominoeStack);
  }
}
