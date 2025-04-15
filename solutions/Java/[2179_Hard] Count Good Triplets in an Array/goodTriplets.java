class FenwickTree {
  private int[] tree;

  public FenwickTree(int size) {
    tree = new int[size + 1];
  }

  public void update(int index, int delta) {
    index++;

    while (index < tree.length) {
      tree[index] += delta;
      index += index & -index;
    }
  }

  public int query(int index) {
    int result = 0;
    index++;

    while (index > 0) {
      result += tree[index];
      index -= index & -index;
    }

    return result;
  }
}

class Solution {
  public long goodTriplets(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int[] p = new int[n];
    int[] reversedIndexMapping = new int[n];

    for (int i = 0; i < n; i++) {
      p[nums2[i]] = i;
    }

    for (int i = 0; i < n; i++) {
      reversedIndexMapping[p[nums1[i]]] = i;
    }

    FenwickTree tree = new FenwickTree(n);
    long result = 0;

    for (int value = 0; value < n; value++) {
      int pos = reversedIndexMapping[value];
      int left = tree.query(pos);
      tree.update(pos, 1);
      int right = (n - 1 - pos) - (value - left);
      result += (long) left * right;
    }

    return result;
  }
}
