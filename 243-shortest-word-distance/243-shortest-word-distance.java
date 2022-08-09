class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int position1 = -1;
        int position2 = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i< wordsDict.length; i++) {
          if (word1.equals(wordsDict[i])) {
              position1 = i;
          }
          if (word2.equals(wordsDict[i])) {
              position2 = i;
          }
          if (position1 != -1 && position2 != -1) {
            minDistance = Math.min(minDistance, Math.abs(position2-position1));
          }
        }
      return minDistance;
    }
}