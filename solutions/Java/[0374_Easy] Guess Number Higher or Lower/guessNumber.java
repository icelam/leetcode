/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *            1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int low = 1;
    int high = n;

    while (low <= high) {
      int middle = low + ((high - low) / 2);
      int guessResult = guess(middle);

      if (guessResult == 0) {
        return middle;
      } else if (guessResult == -1) {
        high = middle - 1;
      } else {
        low = middle + 1;
      }
    }

    return -1;
  }
}
