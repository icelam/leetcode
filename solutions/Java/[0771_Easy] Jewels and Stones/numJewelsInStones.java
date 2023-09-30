class Solution {
  public int numJewelsInStones(String jewels, String stones) {
    HashSet<Character> jewelType = new HashSet<>();
    int count = 0;

    for (char jewel: jewels.toCharArray()) {
      jewelType.add(jewel);
    }

    for (char stone: stones.toCharArray()) {
      if (jewelType.contains(stone)) {
        count++;
      }
    }

    return count;
  }
}
