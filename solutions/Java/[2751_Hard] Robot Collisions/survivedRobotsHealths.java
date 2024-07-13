class Solution {
  public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    int n = positions.length;
    Integer[] id = new Integer[n];
    char[] robotDirections = directions.toCharArray();

    for (int i = 0; i < n; i++) {
      id[i] = i;
    }

    Arrays.sort(id, (i, j) -> positions[i] - positions[j]);

    Stack<Integer> robotsMovingRight = new Stack<>();

    for (int currentRobot: id) {
      if (robotDirections[currentRobot] == 'R') {
        robotsMovingRight.push(currentRobot);
        continue;
      }

      while (!robotsMovingRight.isEmpty()) {
        int previousRobot = robotsMovingRight.peek();

        if (healths[previousRobot] > healths[currentRobot]) {
          healths[previousRobot]--;
          healths[currentRobot] = 0;
          break;
        } else if (healths[previousRobot] == healths[currentRobot]) {
          robotsMovingRight.pop();
          healths[previousRobot] = 0;
          healths[currentRobot] = 0;
          break;
        } else {
          robotsMovingRight.pop();
          healths[previousRobot] = 0;
          healths[currentRobot]--;
        }
      }
    }

    List<Integer> result = new ArrayList<>();

    for (int currentHealth: healths) {
      if (currentHealth > 0) {
        result.add(currentHealth);
      }
    }

    return result;
  }
}
