/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {
  private List<Integer> nums;
  private int size;
  private int index;

  public NestedIterator(List<NestedInteger> nestedList) {
    nums = new ArrayList<Integer>();
    flatternList(nestedList, nums);
    size = nums.size();
    index = 0;
  }

  public final void flatternList(List<NestedInteger> nestedList, List result) {
    for (NestedInteger item: nestedList) {
      if (item.getInteger() == null) {
        flatternList(item.getList(), result);
      } else {
        result.add(item.getInteger());
      }
    }
  }

  @Override
  public Integer next() {
    int next = nums.get(index);
    index++;
    return next;
  }

  @Override
  public boolean hasNext() {
    return index < size;
  }
}
