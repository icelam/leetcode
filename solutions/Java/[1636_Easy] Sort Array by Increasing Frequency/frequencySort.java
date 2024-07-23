class Solution {
  public int[] frequencySort(int[] nums) {
    int n = nums.length;
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();

    for (int value: nums) {
      frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
    }

    int m = frequencyMap.keySet().size();
    int[][] frequency = new int[m][2];
    int frequencyIndex = 0;

    for (int key: frequencyMap.keySet()) {
      frequency[frequencyIndex][0] = key;
      frequency[frequencyIndex][1] = frequencyMap.get(key);
      frequencyIndex++;
    }

    Arrays.sort(frequency, (a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

    int numIndex = n - 1;
    int[] sortedNums = new int[n];

    for (int[] pair: frequency) {
      if (pair[1] == 0) {
        break;
      }

      for (int i = 0; i < pair[1]; i++) {
        sortedNums[numIndex] = pair[0];
        numIndex--;
      }
    }

    return sortedNums;
  }
}
