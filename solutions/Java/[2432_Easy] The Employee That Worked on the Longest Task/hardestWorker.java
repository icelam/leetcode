class Solution {
  public int hardestWorker(int n, int[][] logs) {
    int previousEndTime = logs[0][1];
    int longestTask = logs[0][1];
    int employeeThatWorkOnLongestTask = logs[0][0];

    for (int i = 1; i < logs.length; i++) {
      int timeRequiredForCurrentTask = logs[i][1] - previousEndTime;

      if (
        timeRequiredForCurrentTask > longestTask
        || (timeRequiredForCurrentTask == longestTask && employeeThatWorkOnLongestTask > logs[i][0])
      ) {
        employeeThatWorkOnLongestTask = logs[i][0];
        longestTask = timeRequiredForCurrentTask;
      }

      previousEndTime = logs[i][1];
    }

    return employeeThatWorkOnLongestTask;
  }
}
