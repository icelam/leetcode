class Solution {
  public boolean isHappy(int n) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int squaresSum = n;

    while (squaresSum != 1) {
      int temp = 0;
      for (int i = squaresSum; i > 0; i /= 10) {
        temp += Math.pow(i % 10, 2);
      }
      squaresSum = temp;

      if (map.containsKey(squaresSum)) {
        return false;
      }

      map.put(squaresSum, 1);
    }

    return true;
  }
}
