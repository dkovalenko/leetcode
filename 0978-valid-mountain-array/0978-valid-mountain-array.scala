object Solution {
  def validMountainArray(arr: Array[Int]): Boolean = {
    if (arr.size < 3) return false
    //[0,3,2,1]
    //[0,3,5,2,1]
    //[1,3,2]
    var prev = arr(0) //1
    var peakReached = false
    for (i <- 1 until arr.size) {
      if (peakReached) {
        if (prev <= arr(i)) {
          return false
        }
      } else {
        if (prev >= arr(i)) {
          return false
        }
      }
      if (i+1 <= arr.size-1 && arr(i+1) < arr(i)) {
        peakReached = true
      }
      prev = arr(i)
    }
    return peakReached && true
  }
}