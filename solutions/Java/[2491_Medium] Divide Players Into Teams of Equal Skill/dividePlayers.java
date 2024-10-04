class Solution {
  public long dividePlayers(int[] skill) {
    int n = skill.length;
    int m = n / 2;
    Arrays.sort(skill);

    long result = 0;
    int target = skill[0] + skill[n - 1];

    for (int i = 0; i < m; i++) {
      int left = i;
      int right = n - 1 - i;

      if (skill[left] + skill[right] != target) {
        return -1;
      }

      result += (long) skill[left] * skill[right];
    }

    return result;
  }
}
