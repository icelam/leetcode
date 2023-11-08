class Solution {
  public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    int width = Math.abs(sx - fx);
    int height = Math.abs(sy - fy);

    // Minimum step required is:
    // 1. Walk Diagonally -> diagonalLength = Math.min(width, height)
    // 2. Walk straight -> remainingStep = (longerSide - diagonalLength)
    //
    // Findings:
    // 1. Diagonal Length will always be minimum side
    // 2. The minimum step required defined as (diagonalLength + remainingStep) is actually the same as longer side
    int minSteps = Math.max(width, height);

    if (minSteps == 0 && t == 1) {
      return false;
    }

    return minSteps <= t;
  }
}
