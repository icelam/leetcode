class Solution {
  public int[] findOriginalArray(int[] changed) {
    int length = changed.length;

    if ((length & 1) == 1) {
      return new int[0];
    }

    int pointer = 0;
    int[] result = new int[length / 2];
    int[] count = new int[100001];

    for (int n: changed) {
      count[n]++;
    }

    for (int i = 0; i <= 100000; i++) {
      if (i == 0) {
        count[i] = count[i] % 2;
      } else if (i <= 50000) {
        int minPairCount = Math.min(count[i], count[i * 2]);
        count[i] -= minPairCount;
        count[i * 2] -= minPairCount;

        for (int j = 0; j < minPairCount; j++) {
          result[pointer] = i;
          pointer++;
        }
      }

      if (count[i] > 0) {
        return new int[0];
      }
    }

    return result;
  }
}
