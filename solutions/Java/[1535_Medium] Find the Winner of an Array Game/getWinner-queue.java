class Solution {
  public int getWinner(int[] arr, int k) {
    Queue<Integer> queue = new LinkedList<>();
    int max = arr[0];

    for (int num: arr) {
      queue.add(num);
      max = Math.max(max, num);
    }

    int num1 = queue.remove();
    int streak = 0;

    while (streak < k && num1 < max) {
      if (num1 > queue.peek()) {
        streak++;
        int num2 = queue.remove();
        queue.add(num2);
      } else {
        queue.add(num1);
        num1 = queue.remove();
        streak = 1;
      }
    }

    return num1;
  }
}
