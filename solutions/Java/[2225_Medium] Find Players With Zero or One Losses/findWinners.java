class Solution {
  public List<List<Integer>> findWinners(int[][] matches) {
    int[] statistics = new int[100001];

    int minPlayer = 100000;
    int maxPlayer = 1;
    // 0 = no statistics, 1 = win and not losed, 2 == one lose, 3 = more than one lose
    for (int[] match: matches) {
      if (statistics[match[0]] == 0) {
        statistics[match[0]] = 1;
      }

      if (statistics[match[1]] >= 2) {
        statistics[match[1]] = 3;
      } else {
        statistics[match[1]] = 2;
      }

      minPlayer = Math.min(minPlayer, Math.min(match[0], match[1]));
      maxPlayer = Math.max(maxPlayer, Math.max(match[0], match[1]));
    }

    List<Integer> winners = new ArrayList<>();
    List<Integer> losers = new ArrayList<>();

    for (int player = minPlayer; player <= maxPlayer; player++) {
      if (statistics[player] == 1) {
        winners.add(player);
      }

      if (statistics[player] == 2) {
        losers.add(player);
      }
    }

    List<List<Integer>> result = new ArrayList<>();
    result.add(winners);
    result.add(losers);

    return result;
  }
}
