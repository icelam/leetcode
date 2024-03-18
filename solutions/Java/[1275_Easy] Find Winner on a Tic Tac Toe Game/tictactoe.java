class Solution {
  public boolean hasWin(int[][] board, int player) {
    return (
      board[0][0] == player && board[0][1] == player && board[0][2] == player
      || board[1][0] == player && board[1][1] == player && board[1][2] == player
      || board[2][0] == player && board[2][1] == player && board[2][2] == player
      || board[0][0] == player && board[1][0] == player && board[2][0] == player
      || board[0][1] == player && board[1][1] == player && board[2][1] == player
      || board[0][2] == player && board[1][2] == player && board[2][2] == player
      || board[0][0] == player && board[1][1] == player && board[2][2] == player
      || board[2][0] == player && board[1][1] == player && board[0][2] == player
    );
  }

  public String tictactoe(int[][] moves) {
    int[][] board = new int[3][3];

    for (int i = 0; i < moves.length; i++) {
      board[moves[i][0]][moves[i][1]] = i % 2 == 0 ? 1 : 2;
    }

    boolean isCompleted = moves.length == 9;
    boolean hasPlayerAWin = hasWin(board, 1);
    boolean hasPlayerBWin = hasWin(board, 2);

    if (isCompleted && !hasPlayerAWin && !hasPlayerBWin) {
      return "Draw";
    }

    if (hasPlayerAWin) {
      return "A";
    }

    if (hasPlayerBWin) {
      return "B";
    }

    return "Pending";
  }
}
