object Solution {
  //Input: nums = [0,0,1,1,1,2,2,3,3,4]
  //Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
  def removeDuplicates(nums: Array[Int]): Int = {
    var p1 = 1
    for (i <- 1 until nums.size) {
      if (nums(i - 1) != nums(i)) {
        nums(p1) = nums(i)
        p1 += 1
      }
    }
    p1
  }
}