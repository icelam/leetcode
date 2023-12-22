class Solution {
  public int countDigits(int num) {
    int[] frequency = new int[10];

    int temp = num;

    while (temp > 0) {
      frequency[temp % 10]++;
      temp /= 10;
    }

    int result = 0;

    for (int i = 1; i <= 9; i++) {
      if (num % i == 0) {
        result += frequency[i];
      }
    }

    return result;
  }
}
