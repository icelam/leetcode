class Solution {
  public long wonderfulSubstrings(String word) {
    int prefixSum = 0;
    long result = 0;

    int[] frequency = new int[1024];
    frequency[0] = 1;

    for (char c: word.toCharArray()) {
      // Map c - 'a' to corresponding position of the bit representation
      // i.e [j, i, h, g, f, e, d, c, b, a]
      // If the i-th bit equals to 1, it means the characters appears ODD number of times.
      prefixSum ^= (1 << (c - 'a'));

      // Case 1：Characters between word[i,j] all appears an even number of times
      // word[0, i]  and word[0, j] will have equal prefix sum
      result += frequency[prefixSum];

      // Enumerate each bit of the current prefix sum
      for (int i = 0; i < 10; i++) {
        // Case 2：There is 1 odd number appearance
        // i.e. there is 1 bit not equal to prefix sum
        result += frequency[prefixSum ^ (1 << i)];
      }

      frequency[prefixSum]++;
    }
    return result;
  }
}
