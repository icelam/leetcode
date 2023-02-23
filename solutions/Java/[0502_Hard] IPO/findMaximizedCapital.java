class Solution {
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int remainingCapital = w;
    int numberOfProjects = profits.length;
    int[][] projectList = new int[numberOfProjects][2];

    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    for (int i = 0; i < numberOfProjects; i++) {
      projectList[i] = new int[]{capital[i], profits[i]};
    }

    Arrays.sort(projectList, (a, b) -> a[0] - b[0]);

    for (int capacity = k, index = 0; capacity > 0; capacity--) {
      while (index < numberOfProjects && projectList[index][0] <= remainingCapital) {
        heap.add(projectList[index]);
        index++;
      }

      if (heap.isEmpty()) {
        break;
      }

      int[] currentProject = heap.remove();
      remainingCapital += currentProject[1];
    }

    return remainingCapital;
  }
}
