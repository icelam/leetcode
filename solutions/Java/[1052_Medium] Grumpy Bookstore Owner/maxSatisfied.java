class Solution {
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int n = customers.length;
    int increasedSatisfication = 0;
    int maxIncreasedSatisfication = 0;
    int totalSatisfication = 0;

    for (int i = 0; i < n; i++) {
      if (grumpy[i] == 0) {
        totalSatisfication += customers[i];
      }
    }

    for (int i = 0; i < minutes; i++) {
      increasedSatisfication += grumpy[i] * customers[i];
    }

    maxIncreasedSatisfication = increasedSatisfication;

    for (int i = minutes; i < n; i++) {
      increasedSatisfication -= grumpy[i - minutes] * customers[i - minutes];
      increasedSatisfication += grumpy[i] * customers[i];
      maxIncreasedSatisfication = Math.max(maxIncreasedSatisfication, increasedSatisfication);
    }

    return totalSatisfication + maxIncreasedSatisfication;
  }
}
