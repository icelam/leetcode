class Solution {
  public int totalFruit(int[] fruits) {
    int left = 0;
    int right = 0;
    int nextLeft = fruits[0];
    int maxHarvest = 0;
    Set<Integer> harvestedFruits = new HashSet<>();

    while (right < fruits.length) {
      if (harvestedFruits.size() == 2 && !harvestedFruits.contains(fruits[right])) {
        maxHarvest = Math.max(maxHarvest, right - left);
        harvestedFruits.remove(fruits[nextLeft - 1]);
        left = nextLeft;
      }

      harvestedFruits.add(fruits[right]);

      if (right > 0 && fruits[right] != fruits[right - 1]) {
        nextLeft = right;
      }

      right++;
    }

    maxHarvest = Math.max(maxHarvest, right - left);

    return maxHarvest;
  }
}
