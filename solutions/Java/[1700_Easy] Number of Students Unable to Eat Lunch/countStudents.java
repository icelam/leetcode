class Solution {
  public int countStudents(int[] students, int[] sandwiches) {
    int[] preferenceCount = new int[2];

    for (int currentPreference: students) {
      preferenceCount[currentPreference]++;
    }

    for (int currentSandwich: sandwiches) {
      if (preferenceCount[currentSandwich] == 0) {
        break;
      }

      preferenceCount[currentSandwich]--;
    }

    return preferenceCount[0] + preferenceCount[1];
  }
}
