class Solution {
  private int maxAchievableRequest;

  private void backtrack(int[][] requests, int n, int[] incommingRequests, int index, int handledRequest) {
    if (index == requests.length) {
      for (int count: incommingRequests) {
        if (count != 0) {
          return;
        }
      }

      maxAchievableRequest = Math.max(maxAchievableRequest, handledRequest);
      return;
    }

    int from = requests[index][0];
    int to = requests[index][1];

    backtrack(requests, n, incommingRequests, index + 1, handledRequest);

    incommingRequests[from]--;
    incommingRequests[to]++;

    backtrack(requests, n, incommingRequests, index + 1, handledRequest + 1);

    incommingRequests[from]++;
    incommingRequests[to]--;
  }

  public int maximumRequests(int n, int[][] requests) {
    maxAchievableRequest = 0;
    int[] incommingRequests = new int[n];

    backtrack(requests, n, incommingRequests, 0, 0);

    return maxAchievableRequest;
  }
}
