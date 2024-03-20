class Solution {
  public int distMoney(int money, int children) {
    if (money < children) {
      return -1;
    }

    // How many money is remaining if each children receive $8
    int remainingMoney = money - (children * 8);

    // If there is a remaining money after allocating everyone $8
    // give money to one child. Everyone now has >= $8
    if (remainingMoney > 0) {
      return children - 1;
    }

    // If there is exactly $4 for last child after allocating everyone $8,
    // we need to give 2 children money so that no one receive 4 dollars
    if (remainingMoney == -4) {
      return children - 2;
    }

    // Distrubte $1 to each child then try to allocate another $7
    return (money - children) / 7;
  }
}
