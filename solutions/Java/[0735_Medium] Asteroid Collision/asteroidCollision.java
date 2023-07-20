class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> remaining = new Stack<>();

    for (int currentAsteroid: asteroids) {
      boolean isExists = true;

      while (
        !remaining.isEmpty()
        && remaining.peek() > 0
        && currentAsteroid < 0
      ) {
        int previousSize = remaining.peek();
        int currentSize = currentAsteroid * -1;

        if (previousSize <= currentSize) {
          remaining.pop();
        }

        if (previousSize >= currentSize) {
          isExists = false;
          break;
        }
      }

      if (isExists) {
        remaining.add(currentAsteroid);
      }
    }


    int[] result = new int[remaining.size()];

    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = remaining.pop();
    }

    return result;
  }
}
