class Solution {
  public long coloredCells(int n) {
    long longN = n;
    return longN * longN + ((longN - 1) * (longN - 1));
  }
}
