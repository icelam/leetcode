class Solution {
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a, b) -> a[1] - b[1]);
    PriorityQueue<Integer> dayUsed = new PriorityQueue<>((a, b) -> b - a);

    int currentDate = 0;

    for (int[] c: courses) {
      if (c[0] + currentDate <= c[1]) {
        currentDate += c[0];
        dayUsed.add(c[0]);
      } else if (dayUsed.size() > 0 && dayUsed.peek() > c[0]) {
        currentDate -= dayUsed.remove();
        currentDate += c[0];
        dayUsed.add(c[0]);
      }
    }

    return dayUsed.size();
  }
}
