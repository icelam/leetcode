class Solution {
  public boolean winnerOfGame(String colors) {
    char[] pieces = colors.toCharArray();
    int n = pieces.length;
    int count = 0;
    int[] moves = new int[2];

    for (int i = 0; i < n; i++) {
      count++;

      if (i == n - 1 || pieces[i] != pieces[i + 1]) {
        moves[pieces[i] - 'A'] += Math.max(0, count - 2);
        count = 0;
      }
    }

    // If both Alice and Bob have same moves, Alice will lose since she will become the first one out of move.
    // 0 > 0 in Java return false, we can also write moves[0] - moves[1] >= 1 to ensure 0 > 0 will return false.
    return moves[0] > moves[1];
  }
}
