class Solution {
  public int countStudents(int[] students, int[] sandwiches) {
    int n = students.length;
    Queue<Integer> queue = new LinkedList<>();

    for (int s: students) {
      queue.add(s);
    }

    int i = 0;

    while (i < n) {
      int remainingStudents = queue.size();
      int requeueCount = 0;

      for (int j = 0; j < remainingStudents; j++) {
        int currentPreference = queue.remove();
        int currentSandwich = sandwiches[i];

        if (currentPreference != currentSandwich) {
          queue.add(currentPreference);
          requeueCount++;
        } else {
          i++;
        }
      }

      if (remainingStudents == requeueCount) {
        break;
      }
    }

    return queue.size();
  }
}
