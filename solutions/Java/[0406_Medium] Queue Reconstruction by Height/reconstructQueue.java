class Solution {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);

    List<Integer> orderedIndex = new LinkedList<>();

    for (int i = 0; i < people.length; i++) {
      orderedIndex.add(people[i][1], i);
    }

    int[][] result = new int[people.length][2];

    for (int j = 0; j < people.length; j++) {
      result[j] = people[orderedIndex.get(j)];
    }

    return result;
  }
}

