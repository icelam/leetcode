class Solution {
  private List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');

  public int findTheLongestSubstring(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int result = 0;
    int prefixXOR = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    for (int i = 0; i < n; i++) {
      if (list.contains(characters[i])) {
        int j = 0;

        while (list.get(j) != characters[i]) {
          j++;
        }

        prefixXOR ^= (1 << j);
      }

      if (map.containsKey(prefixXOR)) {
        result = Math.max(result, i - map.get(prefixXOR));
      } else {
        map.put(prefixXOR, i);
      }
    }

    return result;
  }
}
