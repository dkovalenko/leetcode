object Solution {
  def moveZeroes(nums: Array[Int]): Unit = {
    // nums = [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    // nums = [0,0,0,3,12]
    //Output: [3,12,0,0,0]
    var p1 = 0
    var p2 = 0
    while (p1 <= p2) {
      if (p2 < nums.size) {
        if (nums(p2) != 0) {
          nums(p1) = nums(p2)
          p1 += 1
        }
        p2 += 1
      } else {
        if (p1 < nums.size) {
          nums(p1) = 0
        }
        p1 += 1
      }
    }
  }
}