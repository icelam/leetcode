class Solution {
  public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
    int m = people.size();
    int n = req_skills.length;

    ArrayList<Integer>[] dp = new ArrayList[1 << n];
    Map<String, Integer> skillIndex = new HashMap<>();

    for (int i = 0; i < n; i++) {
      skillIndex.put(req_skills[i], i);
    }

    dp[0] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      int currentSkill = 0;

      for (String skill : people.get(i)) {
        currentSkill |= 1 << skillIndex.get(skill);
      }

      for (int previous = 0; previous < dp.length; previous++) {
        if (dp[previous] == null) {
          continue;
        }

        int current = currentSkill | previous;

        if (dp[current] == null || dp[previous].size() + 1 < dp[current].size()) {
          dp[current] = new ArrayList<>(dp[previous]);
          dp[current].add(i);
        }
      }
    }

    List<Integer> smallestTeam = dp[(1 << n) - 1];
    int[] result = new int[smallestTeam.size()];

    for (int i = 0; i < smallestTeam.size(); i++) {
      result[i] = smallestTeam.get(i);
    }

    return result;
  }
}
