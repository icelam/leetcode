class Solution {
  private int result;

  public void backtrack(int[] cookies, int n, int k, int[] distribution, int start) {
    if (start == n) {
      int currentMin = Integer.MIN_VALUE;

      for (int count: distribution) {
        currentMin = Math.max(currentMin, count);
      }

      result = Math.min(result, currentMin);
      return;
    }

    // Pruning 1: If remaining bags of cookie is not enought to distribute to all children without
    // cookies, perform pruning
    int childrenWithoutCookies = 0;
    for (int count: distribution) {
      if (count == 0) {
        childrenWithoutCookies++;
      }
    }

    if (childrenWithoutCookies > (n - 1) - start + 1) {
      return;
    }

    // Pruning 2: If any of the current distrubution is larger that current result, it must not be
    // the most optimial solution. Peroform pruning.
    for (int i = 0; i < k; i++) {
      if (distribution[i] > result) {
        return;
      }
    }

    for (int i = 0; i < k; i++) {
      //  Pruning 3: For the first bag of cookies, no matter distrubuting it to which child
      // will always result in same tree, we can omit generating same trees for k times by pruning.
      if (start == 0 && i > 0) {
        return;
      }

      distribution[i] += cookies[start];
      backtrack(cookies, n, k, distribution, start + 1);
      distribution[i] -= cookies[start];
    }
  }

  public int distributeCookies(int[] cookies, int k) {
    result = Integer.MAX_VALUE;
    backtrack(cookies, cookies.length, k, new int[k], 0);
    return result;
  }
}

