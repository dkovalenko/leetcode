object Solution {
  def replaceElements(arr: Array[Int]): Array[Int] = {
    //arr = [17,18,5,4,6,1]
    //arr = [18,6,6,6,1,-1]
    var max = arr(arr.size-1)
    var resulting = new Array[Int](arr.size)
    resulting(arr.size-1) = -1
    
    for (i <- arr.size-1 to (1, -1)) {
      if (arr(i) > max) {
        max = arr(i)
      }
      resulting(i-1) = max
    }

    resulting
  }
}