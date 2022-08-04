class Solution {
    public boolean checkValid(int[][] matrix) {
      int n = matrix.length;
      for (int r = 0; r < n; r++) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int c=0; c<n; c++) {
          if (!(rows.add(matrix[r][c]) && cols.add(matrix[c][r]))) {
            return false;
          }
        }
      }
      return true;
    }
}