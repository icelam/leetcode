class Solution {
  public boolean checkInclusion(String s1, String s2) {
      int[] count = new int[26];
      int arrayOffset = "a".charAt(0);
      
      for (int i = 0; i < s1.length(); i++) {
        count[s1.charAt(i) - arrayOffset]++;
      }
      
      for (int j = 0; j < s2.length(); j++) {
          count[s2.charAt(j) - arrayOffset]--;
          
          if (j >= s1.length()) {
            count[s2.charAt(j - s1.length()) - arrayOffset]++;
          }

          if (j >= s1.length() - 1 && isAllZeroArray(count)) {
            return true;
          }
      }
      
      return false;
  }

  public boolean isAllZeroArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        return false;
      }
    }

    return true;
  }
}