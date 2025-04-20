class Solution {
  public int numRabbits(int[] answers) {
    int[] frequency = new int[1001];
    int result = 0;

    for (int currentAnswer: answers) {
      frequency[currentAnswer]++;

      // Let current answer be x
      // When an rabbit answer x,
      // there must be a group of rabbit in the same color that is at most x + 1 rabbit.
      // Rabbits in the same group will also have the same answer,
      // If number of rabbits that answe x is more than x + 1,
      // it means a new group of rabbit appears.
      if (frequency[currentAnswer] > currentAnswer + 1) {
        frequency[currentAnswer] = 1;
      }

      // New rabbit color found, add x + 1 rabbit to result
      if (frequency[currentAnswer] == 1) {
        result += currentAnswer + 1;
      }
    }

    return result;
  }
}
