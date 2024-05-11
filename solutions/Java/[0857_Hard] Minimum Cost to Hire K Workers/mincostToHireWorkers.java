class Worker implements Comparable<Worker> {
  private int quality;
  private int wage;

  public Worker(int quality, int wage) {
    this.quality = quality;
    this.wage = wage;
  }

  public int getQuality() {
    return quality;
  }

  public int getWage() {
    return wage;
  }

  public double getWageToQualityRatio() {
    return (double) wage / quality;
  }

  // Sort workers by wage to quality ratio in ascending order,
  // where worker who receive less wages per quality go first
  @Override public int compareTo(Worker w) {
    return w.quality * wage - quality * w.wage;
  }

  @Override public String toString() {
    return "{ quality: " + quality + ", wage: " + wage + " }";
  }
}

class Solution {
  public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    int n = quality.length;
    double result = Double.MAX_VALUE;
    int totalQuality = 0;

    Worker[] workers = new Worker[n];

    for (int i = 0; i < n; i++) {
      workers[i] = new Worker(quality[i], wage[i]);
    }

    Arrays.sort(workers);

    // Pritorize by worker's quality in decending order
    PriorityQueue<Integer> highestQuality = new PriorityQueue<Integer>((a, b) -> b - a);

    for (Worker currentWorker: workers) {
      totalQuality += currentWorker.getQuality();
      highestQuality.add(currentWorker.getQuality());

      if (highestQuality.size() == k) {
        result = Math.min(result, totalQuality * currentWorker.getWageToQualityRatio());
        totalQuality -= highestQuality.remove();
      }
    }

    return result;
  }
}
