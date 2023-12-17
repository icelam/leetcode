class Solution {
  public boolean isBoomerang(int[][] points) {
    int[] vector1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
    int[] vector2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
    int crossproduct = vector1[0] * vector2[1] - vector1[1] * vector2[0];
    return crossproduct != 0;
  }
}
