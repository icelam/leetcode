class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private boolean isWall(char c) {
    return c == '#';
  }

  private boolean isStartingPoint(char c) {
    return c == '@';
  }

  private boolean isKey(char c) {
    return c >= 'a' && c <= 'f';
  }

  private boolean isLock(char c) {
    return c >= 'A' && c <= 'F';
  }

  private boolean canOpenLock(String ownedKeys, char lock) {
    char[] keys = ownedKeys.toCharArray();

    for (char k: keys) {
      if (k - lock == 32) {
        return true;
      }
    }

    return false;
  }

  private boolean isKeyOwned(String ownedKeys, char targetKey) {
    char[] keys = ownedKeys.toCharArray();

    for (char k: keys) {
      if (targetKey == k) {
        return true;
      }
    }

    return false;
  }

  public int shortestPathAllKeys(String[] grid) {
    int height = grid.length;
    int width = grid[0].length();

    char[][] map = new char[height][width];
    for (int row = 0; row < height; row++) {
      map[row] = grid[row].toCharArray();
    }

    Set<String> visited = new HashSet<>();
    Queue<Pair<int[], String>> queue = new LinkedList<>();
    int numberOfKeys = 0;
    boolean isStartingPointLocated = false;

    for (int row = 0; row < height && (numberOfKeys < 6 || !isStartingPointLocated); row++) {
      for (int column = 0; column < width && (numberOfKeys < 6 || !isStartingPointLocated); column++) {
        if (isKey(map[row][column]) && map[row][column] - 'a' + 1 > numberOfKeys) {
          numberOfKeys = map[row][column] - 'a' + 1;
        }

        if (isStartingPoint(map[row][column])) {
          queue.add(new Pair<>(new int[]{row, column}, ""));
          isStartingPointLocated = true;
        }
      }
    }

    int steps = 0;

    while (!queue.isEmpty()) {
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        Pair<int[], String> currentRoom = queue.remove();
        int[] cordinate = currentRoom.getKey();
        int row = cordinate[0];
        int column = cordinate[1];
        String ownedKeys = currentRoom.getValue();
        String state = row + "-" + column + "-" + ownedKeys;

        if (visited.contains(state)) {
          continue;
        }

        visited.add(state);

        if (ownedKeys.length() == numberOfKeys) {
          return steps;
        }

        for (int[] d : directions) {
          int newRow = row + d[0];
          int newColumn = column + d[1];
          String newState = newRow + ", " + newColumn + ": " + ownedKeys;
          Pair<int[], String> nextRoom = new Pair<>(new int[]{newRow, newColumn}, ownedKeys);

          if (
            visited.contains(newState)
            || !isValidPosition(newRow, newColumn, height, width)
            || isWall(map[newRow][newColumn])
            || (isLock(map[newRow][newColumn]) && !canOpenLock(ownedKeys, map[newRow][newColumn]))
          ) {
            continue;
          }

          if (
            isKey(map[newRow][newColumn])
            && !isKeyOwned(ownedKeys, map[newRow][newColumn])
          ) {
            queue.add(new Pair<>(new int[]{newRow, newColumn}, ownedKeys + map[newRow][newColumn]));
            continue;
          }

          queue.add(new Pair<>(new int[]{newRow, newColumn}, ownedKeys));
        }
      }

      steps++;
    }

    return -1;
  }
}
