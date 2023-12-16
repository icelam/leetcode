class Solution {
  public void duplicateZeros(int[] arr) {
    int n = arr.length;
    int slow = 0;
    int fast = 0;

    while (fast < n) {
      if (arr[slow] == 0) {
        fast++;
      }

      slow++;
      fast++;
    }

    slow--;
    fast--;

    if (slow == fast) {
      return;
    }

    while (slow >= 0) {
      if (fast < n) {
        arr[fast] = arr[slow];
      }

      if (arr[slow] == 0) {
        fast--;
        arr[fast] = 0;
      }

      slow--;
      fast--;
    }
  }
}
