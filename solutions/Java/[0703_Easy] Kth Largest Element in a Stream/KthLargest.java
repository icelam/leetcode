class KthLargest {
  class KthLargestHeap extends PriorityQueue<Integer> {
    private int k;

    public KthLargestHeap(int k) {
      this.k = k;
    }

    @Override
    public boolean add(Integer value) {
      boolean isAddSuccess = offer(value);

      if (size() > k) {
        remove();
      }

      return isAddSuccess;
    }
  }

  private KthLargestHeap heap;

  public KthLargest(int k, int[] nums) {
    this.heap = new KthLargestHeap(k);

    for (int n: nums) {
      heap.add(n);
    }
  }

  public int add(int val) {
    heap.add(val);
    return heap.peek();
  }
}
