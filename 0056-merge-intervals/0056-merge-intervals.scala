object Solution {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    val sorted = intervals.sortBy(el => el(0))
    val s = collection.mutable.ArrayBuffer.empty[Array[Int]]

    sorted.foreach { interval =>
      println(interval.toList)
      if (s.isEmpty || s.last(1) < interval(0)) {
        s += interval
      } else {
        s.last(1) = Math.max(s.last(1), interval(1))
      }
    }
    

    s.toArray
  }

  def overlap(x1: Int, x2: Int, y1: Int, y2: Int): Boolean = {
    if (y1 <= x2) true else false
  }
}