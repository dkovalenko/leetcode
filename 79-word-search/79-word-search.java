class Solution {
    public boolean exist(char[][] board, String word) {
      
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[0].length; col++) {
          char[] path = new char[word.length()];
          if (findSolution(row, col, board, word, 0, path))
            return true;
        }
      }
      
      return false;
    }
  
    boolean findSolution(int m, int n, char[][] board, String word, int level, char[] path) {
      
      if (word.charAt(level) != board[m][n]) {
        return false;
      }
      
      path[level] = board[m][n];
      
      if (level >= word.length() || String.valueOf(path).equals(word)) {
        return true;
      }
      
      
      // System.out.println(word);
      // System.out.println(String.valueOf(path));
      // System.out.println(board[m][n]);
      

      boolean foundNext = false;
      board[m][n] = '$';
      List<Pair<Integer, Integer>> nss = getNeighbours(m, n, board.length, board[0].length);
      for (Pair<Integer, Integer>ns: nss) {
        if (findSolution(ns.getKey(), ns.getValue(), board, word, level+1, path)) {
          return true;
        }
      }
      board[m][n] = word.charAt(level);

      return foundNext;
    }
  
    List<Pair<Integer, Integer>> getNeighbours(int m, int n, int mSize, int nSize) {
      List<Pair<Integer, Integer>> al = new ArrayList<>();
      if (m+1 < mSize) {
        al.add(new Pair<>(m+1, n));
      }
      if (n+1 < nSize) {
        al.add(new Pair<>(m, n+1));
      }
      if (m-1 >= 0) {
        al.add(new Pair<>(m-1, n));
      }
      if (n-1 >= 0) {
        al.add(new Pair<>(m, n-1));
      }
      return al;
    }
}