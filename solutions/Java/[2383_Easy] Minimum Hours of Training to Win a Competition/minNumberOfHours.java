class Solution {
  public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
    int n = energy.length;
    int energyNeeded = 1;

    for (int i = 0; i < n; i++) {
      energyNeeded += energy[i];
    }

    int currentExperience = initialExperience;
    int totalTrainingTime = energyNeeded - initialEnergy > 0
      ? energyNeeded - initialEnergy
      : 0;

    for (int i = 0; i < n; i++) {
      if (currentExperience - experience[i] <= 0) {
        int currentTrainingTime = (experience[i] - currentExperience) + 1;
        totalTrainingTime += currentTrainingTime;
        currentExperience += currentTrainingTime;
      }

      currentExperience += experience[i];
    }

    return totalTrainingTime;
  }
}
