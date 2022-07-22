object Solution {
    def orangesRotting(grid: Array[Array[Int]]): Int = {
      var freshTotal = 0
      val rMax = grid.length
      val cMax = grid(0).length

      for (r <- 0 until rMax) {
          for (c <- 0 until cMax) {
            if (grid(r)(c) == 1) freshTotal += 1
          }
      }
      if (freshTotal == 0) return 0
      
      var newlyRotten = 1
      var min = -1
      var rottenBuffer = collection.mutable.ArrayBuffer.empty[(Int, Int)]
      
      while (newlyRotten >= 0) {
        for (r <- 0 until rMax) {
          for (c <- 0 until cMax) {
            if (grid(r)(c) == 2) {
              checkCell(r-1, c)
              checkCell(r+1, c)
              checkCell(r, c+1)
              checkCell(r, c-1)
            }
          }
        }
        newlyRotten = rottenBuffer.size
        if (newlyRotten > 0) min += 1 else newlyRotten = -1
        //print("freshTotal="+freshTotal)
        //println(" min="+min)
        rottenBuffer.foreach {
          case (r, c) => { 
            if (grid(r)(c) != 2) {
              grid(r)(c) = 2
              //println(r->c)
              freshTotal -= 1
            }
          }
        }
        rottenBuffer.clear()
      }
      
      def checkCell(r: Int, c: Int): Unit = {
        if ( (r >= 0 && r < rMax) && (c >=0 && c < cMax) && grid(r)(c) == 1) {
          rottenBuffer += r -> c
        }
      }
      
      if (freshTotal >0) -1 else min +1
    }
}