object Solution {
  def sortArray(nums: Array[Int]): Array[Int] = { // 1 2
    if (nums.size == 1) return nums
    
    val pivot = nums.size / 2 
    val isOdd = nums.size % 2 == 1
    val left = new Array[Int](if (isOdd) pivot+1 else pivot )
    val right = new Array[Int](pivot)
    Array.copy(nums, 0, left, 0, if (isOdd) pivot + 1 else pivot)
    Array.copy(nums, if (isOdd) pivot + 1 else pivot, right, 0, pivot)
    
    //println(left.mkString(","))
    //println(right.mkString(","))
    
    val result = if (nums.size == 2) {
      if (nums(0)<nums(1)) Array(nums(0), nums(1)) else Array(nums(1), nums(0))
    } else {
      val sortedL = sortArray(left)
      val sortedR = sortArray(right)
      merge(sortedL, sortedR)
    }
    
    result
  }
  
  def merge(l: Array[Int], r: Array[Int]): Array[Int] = { //1 2 , 3
    var lIdx = 0
    var rIdx = 0
    var resIdx = 0
    val resulting = new Array[Int](l.size+r.size)
    
    while (resIdx < l.size+r.size) { //3
      var left = if (lIdx == l.size) Int.MaxValue else l(lIdx)
      var right = if (rIdx == r.size) Int.MaxValue else r(rIdx)
      if (left < right) {
        resulting(resIdx) = left
        lIdx += 1
      } else {
        resulting(resIdx) = right
        rIdx += 1
      }
      
      
      resIdx += 1
    }
    
    resulting
  }
}