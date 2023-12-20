class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
    if (numBottles < numExchange) {
      return numBottles;
    }

    int drinkedBottles = 0;

    while (numBottles > 0) {
      numBottles--;
      drinkedBottles++;

      if (drinkedBottles % numExchange == 0) {
        drinkedBottles++;
      }
    }

    return drinkedBottles;
  }
}
