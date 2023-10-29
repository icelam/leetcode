class Solution {
  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    // Updates on 2023-10-29:
    // New test case buckets = 125, minutesToDie = 1, minutesToTest = 4 will not pass
    // if using Math.log() instead of Math.log10 due to precision and rounding issues
    return (int) Math.ceil(Math.log10(buckets) / Math.log10(minutesToTest / minutesToDie + 1));
  }
}
