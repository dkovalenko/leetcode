object Solution {
  def heightChecker(heights: Array[Int]): Int = {
    var result = 0
    if (heights.size == 1) return result
    val sorted = heights.sorted
    for (i <- 0 until heights.size) {
      if (heights(i) != sorted(i)) {
        result += 1
      }
    }
    result
  }
}