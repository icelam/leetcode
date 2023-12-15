class Solution {
  public String destCity(List<List<String>> paths) {
    HashSet<String> hasOutdegree = new HashSet<>();

    for (List<String> p: paths) {
      hasOutdegree.add(p.get(0));
    }

    for (List<String> p: paths) {
      String city = p.get(1);

      if (!hasOutdegree.contains(city)) {
        return city;
      }
    }

    return "";
  }
}
