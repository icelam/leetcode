class Solution {
  public int getReceptorIndex(int y, int x, int[][] receptors) {
    for (int i = 0; i < receptors.length; i++) {
      if (y == receptors[i][0] && x == receptors[i][1]) {
        return i;
      }
    }

    return -1;
  }

  public int mirrorReflection(int p, int q) {
    int[][] receptors = {{p, p}, {0, p}, {0, 0}};
    int positionY = p;
    int positionX = 0;
    int reachedReceptorIndex = -1;
    boolean rayTowardsUp = true;

    // Calculate next position that sits on a boundary
    //
    // Example 2: p = 4, q = 3
    // Points = [[3, 0], [1, 3], [-1, 0], [-3, 3]]
    // Overflow handled = [[3, 0], [1, 3], [1, 0], [3, 3]]
    //
    // Example 2: p = 4, q = 3
    // Points = [[4, 0], [1, 4], [-2, 0], [-5, 4], [=8, 0]]
    // Overflow handled = [[4, 0], [1, 4], [2, 0], [3, 4], [0, 0]]
    while (reachedReceptorIndex == -1) {
      positionY = rayTowardsUp ? positionY - q : positionY + q;
      positionX = positionX == 0 ? p : 0;

      // change direction of y when it reaches boundary
      if (positionY <= 0 || positionY >= p) {
        rayTowardsUp = !rayTowardsUp;
      }

      // Handles overflow
      if (positionY < 0 || positionY > p) {
        positionY = rayTowardsUp ? p - (positionY % p) : -positionY;
      }

      reachedReceptorIndex = getReceptorIndex(positionY, positionX, receptors);
    }

    return reachedReceptorIndex;
  }
}
