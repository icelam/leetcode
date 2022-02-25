class Solution {
  class Version {
    private String[] revisions;

    Version(String version) {
      this.revisions = version.split("\\.");
    }

    public int getRevisionInteger(int index) {
      return (
        index < this.revisions.length && this.revisions[index].length() > 0
          ? Integer.parseInt(this.revisions[index])
          : 0
        );
    }

    public int getRevisionCount() {
      return this.revisions.length;
    }
  }

  public int compareVersion(String version1, String version2) {
    Version v1 = new Version(version1);
    Version v2 = new Version(version2);

    int i = 0;
    int j = 0;

    while (i < v1.getRevisionCount()  || j < v2.getRevisionCount()) {
      int revision1 = v1.getRevisionInteger(i);
      int revision2 = v2.getRevisionInteger(j);

      if (revision1 > revision2) {
        return 1;
      }

      if (revision1 < revision2) {
        return -1;
      }

      i++;
      j++;
    }

    return 0;
  }
}
