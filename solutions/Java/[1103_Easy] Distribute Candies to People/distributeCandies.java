class Solution {
  public int[] distributeCandies(int candies, int num_people) {
    int[] distribution = new int[num_people];
    int currentPerson = 0;
    int currentDistribution = 1;

    while (candies > 0) {
      distribution[currentPerson] += Math.min(candies, currentDistribution);
      candies -= currentDistribution;
      currentPerson = (currentPerson + 1) % num_people;
      currentDistribution++;
    }

    return distribution;
  }
}
