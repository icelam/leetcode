class Solution {
  public List<String[]> getFilePathsAndContents(String rawPath) {
    List<String[]> result = new ArrayList<>();
    char[] characters = rawPath.toCharArray();
    int rawPathLength = characters.length;
    StringBuilder directory = new StringBuilder();

    int i = 0;

    while (characters[i] != ' ') {
      directory.append(characters[i]);
      i++;
    }

    while (i < rawPathLength && characters[i] == ' ') {
      StringBuilder fullPath = new StringBuilder(directory);
      StringBuilder fileContent = new StringBuilder();
      fullPath.append('/');
      i++;

      while (characters[i] != '(') {
        fullPath.append(characters[i]);
        i++;
      }

      i++;

      while (characters[i] != ')') {
        fileContent.append(characters[i]);
        i++;
      }

      i++;
      result.add(new String[]{fullPath.toString(), fileContent.toString()});
    }

    return result;
  }

  public List<List<String>> findDuplicate(String[] paths) {
    HashMap<String, List<String>> map = new HashMap<>();

    for (String rawPath: paths) {
      List<String[]> files = getFilePathsAndContents(rawPath);

      for (String[] fileInfo: files) {
        String fullPath = fileInfo[0];
        String fileContent = fileInfo[1];

        if (!map.containsKey(fileContent)) {
          map.put(fileContent, new ArrayList<String>());
        }

        map.get(fileContent).add(fullPath);
      }
    }

    List<List<String>> result = new ArrayList<>();
    Set<String> uniqueFileContents = map.keySet();

    for (String content: uniqueFileContents) {
      List<String> fileList = map.get(content);

      if (fileList.size() > 1) {
        result.add(fileList);
      }
    }

    return result;
  }
}
