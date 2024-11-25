class Solution {
  private final int[][] availableMoves = {
    {1, 3},
    {0, 2, 4},
    {1, 5},
    {0, 4},
    {3, 5, 1},
    {4, 2}
  };

  private static int BOARD_HEIGHT = 2;
  private static int BOARD_WIDTH = 3;
  private static String TARGET_BOARD = "123450";

  private char[] swap(char[] state, int i, int j) {
    char temp = state[i];
    state[i] = state[j];
    state[j] = temp;
    return state;
  }

  private void dfs(char[] state, Map<String, Integer> visited, int indexOfZero, int moves) {
    String key = new String(state);

    if (visited.containsKey(key) && visited.get(key) <= moves) {
      return;
    }

    visited.put(key, moves);

    for (int nextMove : availableMoves[indexOfZero]) {
      swap(state, indexOfZero, nextMove);
      dfs(state, visited, nextMove, moves + 1);
      swap(state, nextMove, indexOfZero);
    }
  }

  public int slidingPuzzle(int[][] board) {
    char[] flatternedBoard = new char[BOARD_HEIGHT * BOARD_WIDTH];
    int zeroPosition = 0;

    for (int row = 0; row < BOARD_HEIGHT; row++) {
      for (int column = 0; column < BOARD_WIDTH; column++) {
        int index = row * BOARD_WIDTH + column;
        flatternedBoard[index] = (char) ('0' + board[row][column]);

        if (board[row][column] == 0) {
          zeroPosition = index;
        }
      }
    }

    HashMap<String, Integer> visited = new HashMap<>();
    dfs(flatternedBoard, visited, zeroPosition, 0);
    return visited.getOrDefault(TARGET_BOARD, -1);
  }
}
