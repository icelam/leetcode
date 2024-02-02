class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> result  = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      int num = 0;

      for (int j = i + 1; j < 10; j++) {
        num *= 10;
        num += j;

        if (num > high) {
          break;
        }

        if (num >= low && num <= high) {
          result.add(num);
        }
      }
    }

    Collections.sort(result);
    return result;
  }
}
