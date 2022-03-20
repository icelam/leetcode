class Solution {
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int length = tops.length;
    int[] topCount = new int[6];
    int[] bottomCount = new int[6];
    int[] equalCount = new int[6];

    int result = Integer.MAX_VALUE;
    boolean hasMatch = false;

    for (int i = 0; i < length; i++) {
      if (tops[i] == bottoms[i]) {
        equalCount[tops[i] - 1]++;
      } else {
        topCount[tops[i] - 1]++;
        bottomCount[bottoms[i] - 1]++;
      }
    }

    for (int j = 0; j < 6; j++) {
      if (topCount[j] + bottomCount[j] + equalCount[j] == length) {
        int numberOfFlip = Math.min(topCount[j], bottomCount[j]);
        result = Math.min(result, numberOfFlip);
        hasMatch = true;
      }
    }

    return hasMatch ? result : -1;
  }
}
