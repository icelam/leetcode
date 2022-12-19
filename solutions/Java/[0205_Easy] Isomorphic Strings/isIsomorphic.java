class Solution {
  public boolean isIsomorphic(String s, String t) {
    int mapSize = 128;
    int[] map1 = new int[mapSize];
    int[] map2 = new int[mapSize];
    Arrays.fill(map1, -1);
    Arrays.fill(map2, -1);

    char[] characters1 = s.toCharArray();
    char[] characters2 = t.toCharArray();

    int length = characters1.length;

    for (int i = 0; i < length; i++) {
      if (map1[characters1[i]] == -1 && map2[characters2[i]] == -1) {
        map1[characters1[i]] = characters2[i];
        map2[characters2[i]] = characters1[i];
      } else if (map1[characters1[i]] != characters2[i] || map2[characters2[i]] != characters1[i]) {
        return false;
      }
    }

    return true;
  }
}
