object Solution {
  //[7,1,5,3,6,4] 
  // 
  //[7,6,4,3,1,5,3,9]
  //[3,2,6,5,0,3]
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.size == 1) return 0
    if (prices.size == 2) return Math.max(prices(1) - prices(0), 0)
    
    var min = Int.MaxValue
    var max = Int.MinValue
    var maxProfit = 0
    var lIdx = 0
    var rIdx = 1
    
    while (rIdx < prices.size) {
      val currentL = prices(lIdx)
      val currentR = prices(rIdx)
      if (currentL < min) {
        min = currentL
        max = currentR
      }
      
      if (currentR > max) {
        max = currentR
      } 
      maxProfit = Math.max(max - min, maxProfit)
      lIdx += 1
      rIdx += 1
    }
    
    return maxProfit
  }
}