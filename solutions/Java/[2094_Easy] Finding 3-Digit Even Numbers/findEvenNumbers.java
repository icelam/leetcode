class Solution {
  public int[] findEvenNumbers(int[] digits) {
    int n = digits.length;
    int[] frequency = new int[10];
    List<Integer> threeDigitsEvenNumber = new ArrayList<>();

    for (int d: digits) {
      frequency[d]++;
    }

    for (int i = 1; i <= 9; i++) {
      frequency[i]--;
      if (frequency[i] >= 0) {
        for (int j = 0; j <= 9; j++) {
          frequency[j]--;
          if (frequency[j] >= 0) {
            for (int k = 0; k <= 9; k++) {
              frequency[k]--;
              if (frequency[k] >= 0 && k % 2 == 0) {
                threeDigitsEvenNumber.add((i * 100) + (j * 10) + k);
              }
              frequency[k]++;
            }
          }
          frequency[j]++;
        }
      }
      frequency[i]++;
    }

    int resultSize = threeDigitsEvenNumber.size();
    int[] result = new int[resultSize];

    for (int i = 0; i < resultSize; i++) {
      result[i] = threeDigitsEvenNumber.get(i);
    }

    return result;
  }
}
