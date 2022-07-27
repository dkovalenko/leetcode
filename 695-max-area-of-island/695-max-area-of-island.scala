object Solution {
    def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
      var maxIsland = 0
      val visited: Array[Array[Boolean]] = Array.fill(grid.size)(Array.fill(grid(0).size)(false))
      
      def dfs(r: Int, c: Int): Int = {
        visited(r)(c) = true
        if (grid(r)(c) == 1) {
          1 + 
          (if (r > 0 && !visited(r-1)(c)) dfs(r-1, c) else 0) + 
          (if (c > 0 && !visited(r)(c-1)) dfs(r, c-1) else 0) + 
          (if (r+1 < grid.size && !visited(r+1)(c)) dfs(r+1, c) else 0) + 
          (if (c+1 < grid(0).size && !visited(r)(c+1)) dfs(r, c+1) else 0)
        } else 0
      }

      //println(visited.map(_.toList).toList)
      
      for (r <- 0 until grid.size) {
        for (c <- 0 until grid(0).size) {
          if (!visited(r)(c)) {
            visited(r)(c) = true
            maxIsland = Math.max(maxIsland, dfs(r, c))
          }
        }
      }
      
      
      maxIsland
    }
}