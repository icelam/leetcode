class Solution {
  public int minimumRounds(int[] tasks) {
    HashMap<Integer, Integer> frequencies = new HashMap<>();

    for (int difficulty: tasks) {
      frequencies.put(difficulty, frequencies.getOrDefault(difficulty, 0) + 1);
    }

    int minmumRounds = 0;
    for (int numberOfTask: frequencies.values()) {
      if (numberOfTask == 1) {
        return -1;
      }

      if (numberOfTask % 3 == 0) {
        minmumRounds += numberOfTask / 3;
      } else {
        minmumRounds += numberOfTask / 3 + 1;
      }
    }

    return minmumRounds;
  }
}
