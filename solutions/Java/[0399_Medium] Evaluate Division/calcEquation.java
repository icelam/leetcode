class Solution {
  public double evaluateQuery(String start, String end, HashMap<String, HashMap<String, Double>> edges, double product, Set<String> visited) {
    if (!edges.containsKey(start) || !edges.containsKey(end)) {
      return -1;
    }

    visited.add(start);

    if (start.equals(end)) {
      return product;
    }

    HashMap<String, Double> queue = edges.get(start);

    for (String neighbor: queue.keySet()) {
      if (!visited.contains(neighbor)) {
        double result = evaluateQuery(neighbor, end, edges, queue.get(neighbor) * product, visited);
        if (result > -1) {
          return result;
        }
      }
    }

    return -1;
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    HashMap<String, HashMap<String, Double>> edges = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      edges.putIfAbsent(equations.get(i).get(0), new HashMap<String, Double>());
      edges.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);

      edges.putIfAbsent(equations.get(i).get(1), new HashMap<String, Double>());
      edges.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
    }

    double[] results = new double[queries.size()];

    for (int j = 0; j < queries.size(); j++) {
      String vertex1 = queries.get(j).get(0);
      String vertex2 = queries.get(j).get(1);
      results[j] = evaluateQuery(vertex1, vertex2, edges, 1, new HashSet<String>());
    }

    return results;
  }
}
