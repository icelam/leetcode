class Solution {
  public int splitNum(int num) {
    int[] frequency = new int[10];
    int operations = 0;
    int[] result = new int[2];

    while (num > 0) {
      frequency[num % 10]++;
      num /= 10;
    }

    for (int i = 0; i < 10; i++) {
      while (frequency[i] > 0) {
        result[operations % 2] *= 10;
        result[operations % 2] += i;
        operations++;
        frequency[i]--;
      }
    }

    return result[0] + result[1];
  }
}
