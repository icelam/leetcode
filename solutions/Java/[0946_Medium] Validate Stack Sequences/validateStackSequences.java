class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int[] temp = new int[pushed.length];
    int pushedIndex = 0;
    int poppedIndex = 0;

    for (int n: pushed) {
      temp[pushedIndex] = n;
      pushedIndex++;

      while (
        poppedIndex < popped.length
        && pushedIndex > 0
        && temp[pushedIndex - 1] == popped[poppedIndex]
      ) {
        pushedIndex--;
        poppedIndex++;
      }
    }

    return poppedIndex == popped.length;
  }
}
