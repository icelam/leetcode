class Solution {
  public int[] arrayRankTransform(int[] arr) {
    int n = arr.length;
    int currentRank = 1;
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] ranks = new int[n];
    int[] sortedArr = new int[n];

    for (int i = 0; i < n; i++) {
      sortedArr[i] = arr[i];
    }

    Arrays.sort(sortedArr);

    int start = 0;
    int end = n - 1;

    while (start <= end) {
      int current = start;

      while (current <= end && sortedArr[start] == sortedArr[current]) {
        current++;
      }

      map.put(sortedArr[start], currentRank);
      start = current;
      currentRank++;
    }

    for (int i = 0; i < n; i++) {
      ranks[i] = map.get(arr[i]);
    }

    return ranks;
  }
}
