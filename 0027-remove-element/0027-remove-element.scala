object Solution {
  //Input: nums = [0,1,2,2,3,0,4,2], val = 2
  //Output: 5, nums = [0,1,4,0,3,_,_,_]
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var p1 = 0
    var p2 = 0
    var result = 0
    while (p2 < nums.size) {
      if (nums(p2) == `val`) {
        p2 += 1
      } else {
        nums(p1) = nums(p2)
        p1 += 1
        p2 += 1
        result += 1
      }
    }

    result
  }
}