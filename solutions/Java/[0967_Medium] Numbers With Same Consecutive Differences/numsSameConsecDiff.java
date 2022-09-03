class Solution {
  public int[] numsSameConsecDiff(int n, int k) {
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i <= 9; i++) {
      queue.add(i);
    }

    int prefixLength = 1;

    while (prefixLength < n) {
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        int prefix = queue.remove();

        int previousDigit = prefix % 10;

        if (previousDigit - k >= 0) {
          queue.add(prefix * 10 + (previousDigit - k));
        }

        if (k != 0 && previousDigit + k <= 9) {
          queue.add(prefix * 10 + (previousDigit + k));
        }
      }

      prefixLength++;
    }

    int[] result = new int[queue.size()];

    for (int i = 0; i < result.length; i++) {
      result[i] = queue.remove();
    }

    return result;
  }
}
