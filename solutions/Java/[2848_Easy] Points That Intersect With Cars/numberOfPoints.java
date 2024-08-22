class Solution {
  public int numberOfPoints(List<List<Integer>> nums) {
    boolean[] occupied = new boolean[101];

    for (List<Integer> car: nums) {
      for (int i = car.get(0); i <= car.get(1); i++) {
        occupied[i] = true;
      }
    }

    int count = 0;

    for (boolean hasCar: occupied) {
      if (hasCar) {
        count++;
      }
    }

    return count;
  }
}
