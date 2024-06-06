class Solution {
  public boolean isNStraightHand(int[] hand, int groupSize) {
    int n = hand.length;
    int currentGroupSize = groupSize;

    if (n % groupSize != 0) {
      return false;
    }

    if (groupSize == 1) {
      return true;
    }

    Arrays.sort(hand);

    for (int i = 0; i < n; i++) {
      if (hand[i] == -1) {
        continue;
      }

      int start = hand[i];
      int j = i + 1;

      while (j < n) {
        if (hand[j] == start + 1) {
          hand[j] = -1;
          currentGroupSize--;
          start++;
        }

        if (currentGroupSize == 1) {
          currentGroupSize = groupSize;
          break;
        }

        j++;
      }

      if (j >= n) {
        return false;
      }
    }

    return true;
  }
}
