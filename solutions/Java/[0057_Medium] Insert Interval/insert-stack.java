class Solution {
  public void pushAndMerge(Stack<int[]> mergedIntervals, int[] newInterval) {
    if (!mergedIntervals.isEmpty() && newInterval[0] <= mergedIntervals.peek()[1]) {
      int[] previousInterval = mergedIntervals.pop();
      previousInterval[1] = Math.max(previousInterval[1], newInterval[1]);
      mergedIntervals.push(previousInterval);
    } else {
      mergedIntervals.push(newInterval);
    }
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    Stack<int[]> mergedIntervals = new Stack<>();

    boolean isNewIntervalInserted = false;

    for (int[] currentInterval: intervals) {
      if (newInterval[0] < currentInterval[0]) {
        pushAndMerge(mergedIntervals, newInterval);
        isNewIntervalInserted = true;
      }

      pushAndMerge(mergedIntervals, currentInterval);
    }

    if (!isNewIntervalInserted) {
      pushAndMerge(mergedIntervals, newInterval);
    }

    int size = mergedIntervals.size();
    int[][] result = new int[size][2];

    for (int i = size - 1; i >= 0; i--) {
      result[i] = mergedIntervals.pop();
    }

    return result;
  }
}
