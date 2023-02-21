class Solution {
  public boolean checkRecord(String s) {
    char[] attendance = s.toCharArray();

    int absentCount = 0;
    int lateStreak = 0;
    boolean hasLateForThreeOrMoreConsecutiveDays = false;

    for (int i = 0; i < attendance.length; i++) {
      if (attendance[i] == 'P') {
        lateStreak = 0;
        continue;
      }

      if (attendance[i] == 'A') {
        absentCount++;
        lateStreak = 0;

        if (absentCount == 2) {
          return false;
        }

        continue;
      }

      lateStreak++;

      if (lateStreak == 3) {
        return false;
      }
    }

    return true;
  }
}
