class Solution {
  public int numberOfWeakCharacters(int[][] properties) {
    int result = 0;
    int length = properties.length;

    Arrays.sort(properties, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));

    int currentAttackGroup = properties[length - 1][0];
    int currentDefenseMin = properties[length - 1][1];
    int previoisDefenseMin = 0;

    for (int i = length - 1; i >= 0; i--) {
      if (currentAttackGroup != properties[i][0]) {
        previoisDefenseMin = Math.max(previoisDefenseMin, currentDefenseMin);
        currentAttackGroup = properties[i][0];
        currentDefenseMin = properties[i][1];
      }

      if (properties[i][1] < previoisDefenseMin) {
        result++;
      }
    }

    return result;
  }
}
