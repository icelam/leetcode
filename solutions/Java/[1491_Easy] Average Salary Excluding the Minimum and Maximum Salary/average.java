class Solution {
  public double average(int[] salary) {
    int min = salary[0];
    int max = salary[0];
    double sum = 0;

    for (int s: salary) {
      min = Math.min(s, min);
      max = Math.max(s, max);
      sum += s;
    }

    return (sum - min - max) / (salary.length - 2);
  }
}
