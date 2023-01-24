class Solution {
  public int getNextStopFromBoard(int[][] board, int index) {
    int n = board.length;
    int zeroIndexedIndex = index - 1;
    int row = n - (zeroIndexedIndex / n) - 1;
    boolean isReversed = n % 2 == 1 && row % 2 == 0 || n % 2 == 0 && row % 2 == 1;
    int column = isReversed ? zeroIndexedIndex % n : n - (zeroIndexedIndex % n) - 1;

    return board[row][column] == -1 ? index : board[row][column];
  }

  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    int start = 1;
    int destination = n * n;

    int[] stepUsed = new int[n * n + 1];

    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);

    while (!queue.isEmpty()) {
      int currentStop = queue.remove();

      if (currentStop == n * n) {
        return stepUsed[currentStop];
      }

      int maxReachableStop = Math.min(currentStop + 6, n * n);
      for (int nextStop = currentStop + 1; nextStop <= maxReachableStop; nextStop++) {
        int nextStopAfterClimbing = getNextStopFromBoard(board, nextStop);

        // For BFS, if a node is visited before, that means the current path is a longer one and can be ignored
        if (stepUsed[nextStopAfterClimbing] != 0 || nextStopAfterClimbing == 1) {
          continue;
        }

        stepUsed[nextStopAfterClimbing] = stepUsed[currentStop] + 1;
        queue.add(nextStopAfterClimbing);
      }
    }

    return -1;
  }
}
