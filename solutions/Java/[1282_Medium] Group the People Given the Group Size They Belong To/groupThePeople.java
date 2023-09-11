class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    int n = groupSizes.length;
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      map.computeIfAbsent(groupSizes[i], value -> new ArrayList<Integer>()).add(i);
    }

    List<List<Integer>> result = new ArrayList<>();

    for (int size: map.keySet()) {
      List<Integer> peopleWithSameGroupId = map.get(size);
      int numberOfPeople = peopleWithSameGroupId.size();

      for (int i = 0; i < numberOfPeople / size; i++) {
        List<Integer> group = new ArrayList<>();

        for (int j = 0; j < size; j++) {
          group.add(peopleWithSameGroupId.get(i * size + j));
        }

        result.add(group);
      }
    }

    return result;
  }
}
