object Solution {
    def climbStairs(n: Int): Int = {
      
      if (n == 1) return 1
      var variants = new Array[Int](n+1)
      variants(1) = 1
      variants(2) = 2
      
      for (i <- 3 to n) {
        variants(i) = variants(i-1) + variants(i-2)
      }
      
      variants(n)
    }
}