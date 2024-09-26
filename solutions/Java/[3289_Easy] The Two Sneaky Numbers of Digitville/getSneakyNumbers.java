class Solution {
  public int[] getSneakyNumbers(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    int[] result = new int[2];
    int index = 0;

    for (int value: nums) {
      if (seen.contains(value)) {
        result[index] = value;
        index++;

        if (index == 2) {
          break;
        }
      }

      seen.add(value);
    }

    return result;
  }
}
