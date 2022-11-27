class Solution(_w: Array[Int]) {
  //3 1 1
  //0 0 0 1 2
  val prefixSums = new Array[Int](_w.size)
  val totalFilled = fillPrefixSums()
  println(totalFilled)
  
  def pickIndex(): Int = {
    val randomIdx = Math.random() * totalFilled

    var idx = 0
    for (i <- 0 to totalFilled) {
      if (randomIdx < prefixSums(i)) {
        return i
      }
    }
    -1
  }
  
  private def fillPrefixSums() = {
    var prefixSum = 0
    for (i <- 0 until _w.size) { 
      prefixSum += _w(i)
      prefixSums(i) = prefixSum
    }
    prefixSum
  }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */