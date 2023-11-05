class Solution {
  public int getWinner(int[] arr, int k) {
    int n = arr.length;
    int max = arr[0];

    for (int num: arr) {
      max = Math.max(max, num);
    }

    int num1 = arr[0];
    int streak = 0;

    for (int i = 1; i < n && num1 < max && streak < k; i++) {
      int num2 = arr[i];

      if (num1 < num2) {
        num1 = num2;
        streak = 0;
      }

      streak++;
    }

    return num1;
  }
}
