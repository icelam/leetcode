class Solution {
  public int minimumBoxes(int[] apple, int[] capacity) {
    int numberOfApples = 0;

    for (int count: apple) {
      numberOfApples += count;
    }

    Arrays.sort(capacity);

    int m = capacity.length;
    int boxCapacity = 0;
    int numberOfBoxes = 0;

    for (int i = m - 1; i >= 0; i--) {
      boxCapacity += capacity[i];
      numberOfBoxes++;

      if (boxCapacity >= numberOfApples) {
        break;
      }
    }

    return numberOfBoxes;
  }
}
