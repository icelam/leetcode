class Solution {
  private char[] previousWheelNum = new char[]{'9', '0', '1', '2', '3', '4', '5', '6', '7', '8'};

  private char[] nextWheelNum = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

  public int openLock(String[] deadends, String target) {
    String startNum = "0000";
    int step = 0;

    if (startNum.equals(target)) {
      return step;
    }

    Set<String> dead = new HashSet<String>();

    for (String num : deadends) {
      dead.add(num);
    }

    if (dead.contains(startNum)) {
      return -1;
    }

    Queue<String> queue = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();
    queue.add(startNum);

    while (!queue.isEmpty()) {
      int batchSize = queue.size();
      step++;

      for (int i = 0; i < batchSize; i++) {
        String num = queue.remove();
        char[] characters = num.toCharArray();
        List<String> nextPossibleNums = new ArrayList<>();

        for (int j = 0; j < 4; j++) {
          char c = characters[j];
          int digit = c - '0';
          characters[j] = previousWheelNum[digit];
          nextPossibleNums.add(new String(characters));
          characters[j] = nextWheelNum[digit];
          nextPossibleNums.add(new String(characters));
          characters[j] = c;
        }

        for (String nextNum : nextPossibleNums) {
          if (visited.contains(nextNum) || dead.contains(nextNum)) {
            continue;
          }

          if (nextNum.equals(target)) {
            return step;
          }

          queue.offer(nextNum);
          visited.add(nextNum);
        }
      }
    }

    return -1;
  }
}
