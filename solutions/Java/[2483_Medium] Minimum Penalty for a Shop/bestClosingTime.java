class Solution {
  public int bestClosingTime(String customers) {
    char[] customerAtHour = customers.toCharArray();
    int n = customerAtHour.length;
    int earliestCloseHour = 0;
    int minPenalty = 0;

    for (int i = 0; i < n; i++) {
      if (customerAtHour[i] == 'Y') {
        minPenalty++;
      }
    }

    int currentPenalty = minPenalty;

    for (int i = 0; i < n; i++) {
      if (customerAtHour[i] == 'N') {
        currentPenalty++;
        continue;
      }

      currentPenalty--;

      if (currentPenalty < minPenalty) {
        currentPenalty = minPenalty;
        earliestCloseHour = i + 1;
      }
    }

    return earliestCloseHour;
  }
}
