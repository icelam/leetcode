class SmallestInfiniteSet {
  private SortedSet<Integer> availableNums;
  private int smallestNum;

  public SmallestInfiniteSet() {
    availableNums = new TreeSet<Integer>();
    smallestNum = 1;
  }

  public int popSmallest() {
    if (!availableNums.isEmpty()) {
      int currentSmallestNum = availableNums.first();
      availableNums.remove(currentSmallestNum);
      return currentSmallestNum;
    }

    return smallestNum++;
  }

  public void addBack(int num) {
    if (num > smallestNum || availableNums.contains(num)) {
      return;
    }

    availableNums.add(num);
  }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
