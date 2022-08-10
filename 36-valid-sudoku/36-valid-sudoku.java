class Solution {
    public boolean isValidSudoku(char[][] board) {
      int[] ones = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
      int[][] rowNums = new int[9][9];
      int[][] colNums = new int[9][9];
      int[][] boxesNums = new int[9][9];
      for (int i=0;i<9;i++) {
        for (int n=0;n<9;n++) {
          rowNums[i][n] = 1;
          colNums[i][n] = 1;
          boxesNums[i][n] = 1;
        }
      }
      
      // System.out.println(Arrays.deepToString(rowNums));
      
      for (int i=0;i<9;i++) {
        for (int n=0;n<9;n++) {
          char c = board[i][n];
          if (c != '.') {
            rowNums[i][Character.getNumericValue(c)-1]--;
            boolean rowCheck = rowNums[i][Character.getNumericValue(c)-1] < 0;
            
            colNums[n][Character.getNumericValue(c)-1]--;
            boolean colCheck = colNums[n][Character.getNumericValue(c)-1] < 0;
            
            boxesNums[(i / 3) * 3 + n / 3][Character.getNumericValue(c)-1]--;
            boolean boxCheck = boxesNums[(i / 3) * 3 + n / 3][Character.getNumericValue(c)-1] < 0;
            
            if (rowCheck || colCheck || boxCheck) {
              return false;
            }
            
          }
          
        }
      }
      
      System.out.println(Arrays.deepToString(rowNums));
      
      return true;
    }
}