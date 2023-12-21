class Solution {
  public boolean isPathCrossing(String path) {
    int x = 0;
    int y = 0;

    HashSet<String> visited = new HashSet<>();
    visited.add("0,0");

    for (char direction: path.toCharArray()) {
      if (direction == 'N') {
        y--;
      } else if (direction == 'E') {
        x++;
      } else if (direction == 'S') {
        y++;
      } else {
        x--;
      }

      StringBuilder locationBuilder = new StringBuilder();
      locationBuilder.append(x);
      locationBuilder.append(',');
      locationBuilder.append(y);
      String newLocation = locationBuilder.toString();

      if (visited.contains(newLocation)) {
        return true;
      } else {
        visited.add(newLocation);
      }
    }

    return false;
  }
}
