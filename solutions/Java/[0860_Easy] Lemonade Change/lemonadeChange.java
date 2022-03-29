class Solution {
  public boolean lemonadeChange(int[] bills) {
    int numberOfFiveBills = 0;
    int numberOfTenBills = 0;

    for (int bill: bills) {
      if (bill == 5) {
        numberOfFiveBills++;
      } else if (bill == 10) {
        numberOfTenBills++;

        if (numberOfFiveBills >= 1) {
          numberOfFiveBills--;
        } else {
          return false;
        }
      } else if (bill == 20) {
        if (numberOfTenBills == 0 && numberOfFiveBills >= 3) {
          numberOfFiveBills -= 3;
        } else if (numberOfTenBills >= 1 && numberOfFiveBills >= 1) {
          numberOfFiveBills--;
          numberOfTenBills--;
        } else {
          return false;
        }
      }
    }

    return true;
  }
}
