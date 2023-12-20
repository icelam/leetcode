class Solution {
  public int minTimeToType(String word) {
    int timeUsed = 0;
    int pointer = 0;

    for (char c: word.toCharArray()) {
      int nextPointer = c - 'a';
      int moves = Math.abs(pointer - nextPointer);
      timeUsed += Math.min(moves, 26 - moves) + 1;
      pointer = nextPointer;
    }

    return timeUsed;
  }
}
