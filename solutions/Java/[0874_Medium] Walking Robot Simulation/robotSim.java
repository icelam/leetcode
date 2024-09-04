class Solution {
  private static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int robotSim(int[] commands, int[][] obstacles) {
    HashSet<String> obstaclesCoordinate = new HashSet<>();
    int currentDirection = 0;
    int[] currentCoordinate = new int[2];
    int maxDistance = 0;

    for (int[] coordinate: obstacles) {
      obstaclesCoordinate.add(coordinate[1] + "," + coordinate[0]);
    }

    for (int operation: commands) {
      if (operation > 0) {
        for (int i = 0; i < operation; i++) {
          if (obstaclesCoordinate.contains((currentCoordinate[1] + directions[currentDirection][0]) + "," + (currentCoordinate[0] + directions[currentDirection][1]))) {
            break;
          }
          currentCoordinate[1] += directions[currentDirection][0];
          currentCoordinate[0] += directions[currentDirection][1];
          maxDistance = Math.max(maxDistance, currentCoordinate[0] * currentCoordinate[0] + currentCoordinate[1] * currentCoordinate[1]);
        }
      } else if (operation < 0) {
        currentDirection += operation == -1 ? 1 : -1;
        currentDirection %= directions.length;
        if (currentDirection < 0) {
          currentDirection += 4;
        }
      }
    }

    return maxDistance;
  }
}
