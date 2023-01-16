class Solution {
  public int pushAndMerge(int[][] mergedIntervals, int[] newInterval, int pointer) {
    if (pointer > 0 && newInterval[0] <= mergedIntervals[pointer - 1][1]) {
      mergedIntervals[pointer - 1][1] = Math.max(mergedIntervals[pointer - 1][1], newInterval[1]);
    } else {
      mergedIntervals[pointer] = newInterval;
      pointer++;
    }

    return pointer;
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int pointer = 0;
    int[][] mergedIntervals = new int[intervals.length + 1][2];

    boolean isNewIntervalInserted = false;

    for (int[] currentInterval: intervals) {
      if (newInterval[0] < currentInterval[0]) {
        pointer = pushAndMerge(mergedIntervals, newInterval, pointer);
        isNewIntervalInserted = true;
      }

      pointer = pushAndMerge(mergedIntervals, currentInterval, pointer);
    }

    if (!isNewIntervalInserted) {
      pointer = pushAndMerge(mergedIntervals, newInterval, pointer);
    }

    return Arrays.copyOfRange(mergedIntervals, 0, pointer);
  }
}
