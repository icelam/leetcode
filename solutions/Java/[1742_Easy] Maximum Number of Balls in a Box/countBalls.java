class Solution {
  public int countBalls(int lowLimit, int highLimit) {
    int[] boxes = new int[46];

    for (int i = lowLimit; i <= highLimit; i++) {
      int current = i;
      int digitSum = 0;

      while (current > 0) {
        digitSum += current % 10;
        current /= 10;
      }

      boxes[digitSum]++;
    }

    Arrays.sort(boxes);

    return boxes[boxes.length - 1];
  }
}
