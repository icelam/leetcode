class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> group = new HashMap<>();
    List<List<String>> result = new ArrayList<>();

    for (String s: strs) {
      char[] sortedChar = s.toCharArray();
      Arrays.sort(sortedChar);

      String key = new String(sortedChar);

      List groupList = group.get(key);
      if (!group.containsKey(key)) {
        groupList = new ArrayList<String>();
        group.put(key, groupList);
      }
      groupList.add(s);
    }

    for (List groupList: group.values()) {
      result.add(groupList);
    }

    return result;
  }
}
