class SummaryRanges {
  private TreeSet<Integer> set;

  public SummaryRanges() {
    set = new TreeSet<>();
  }

  public void addNum(int value) {
    set.add(value);
  }

  public int[][] getIntervals() {
    if (set.isEmpty()) {
      return new int[0][2];
    }

    List<int[]> result = new ArrayList<>();
    int left = -1;
    int right = -1;

    for (int value: set) {
      if (left < 0) {
        left = value;
        right = value;
      } else if (value == right + 1) {
        right = value;
      } else {
        result.add(new int[]{left, right});
        left = value;
        right = value;
      }
    }

    result.add(new int[]{left, right});
    return result.toArray(new int[0][]);
  }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
