class Solution {
  public String predictPartyVictory(String senate) {
    char[] senators = senate.toCharArray();
    int n = senators.length;

    Queue<Integer> radiant = new LinkedList<>();
    Queue<Integer> dire = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      if (senators[i] == 'R') {
        radiant.add(i);
      } else {
        dire.add(i);
      }
    }

    while (!radiant.isEmpty() && !dire.isEmpty()) {
      int radiantIndex = radiant.remove();
      int direIndex = dire.remove();

      if (radiantIndex < direIndex) {
        radiant.add(radiantIndex + n);
      } else {
        dire.add(direIndex + n);
      }
    }

    return radiant.size() > dire.size() ? "Radiant" : "Dire";
  }
}
