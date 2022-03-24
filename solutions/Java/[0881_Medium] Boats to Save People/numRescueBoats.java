class Solution {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);

    int i = 0;
    int j = people.length - 1;
    int result = 0;

    while (j >= i) {
      if (people[i] + people[j] <= limit) {
        i++;
      }
      j--;
      result++;
    }

    return result;
  }
}
