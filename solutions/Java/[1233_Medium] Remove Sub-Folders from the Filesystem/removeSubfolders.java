class Solution {
  public List<String> removeSubfolders(String[] folder) {
    Arrays.sort(folder);

    List<String> result = new ArrayList<>();
    result.add(folder[0]);
    String parentFolder = folder[0] + "/";

    for (int i = 1; i < folder.length; i++) {
      if (!folder[i].startsWith(parentFolder)) {
        result.add(folder[i]);
        parentFolder = folder[i] + "/";
      }
    }

    return result;
  }
}
