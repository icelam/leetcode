class Solution {
  public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int areaOfA = (ax2 - ax1) * (ay2 - ay1);
    int areaOfB = (bx2 - bx1) * (by2 - by1);

    int leftmostX = Math.max(ax1, bx1);
    int rightmostX = Math.min(ax2, bx2);
    int overlapOfX = rightmostX - leftmostX;

    int topmostY = Math.min(ay2, by2);
    int bottommostY = Math.max(ay1, by1);
    int overlapOfY = topmostY - bottommostY;

    if (overlapOfX > 0 && overlapOfY > 0) {
      int areaOfOverlap = overlapOfX * overlapOfY;
      return areaOfA + areaOfB - areaOfOverlap;
    }

    return areaOfA + areaOfB;
  }
}
